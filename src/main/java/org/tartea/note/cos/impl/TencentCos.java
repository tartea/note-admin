package org.tartea.note.cos.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.file.FileNameUtil;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.model.*;
import com.qcloud.cos.region.Region;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tartea.note.cos.AbstractCos;
import org.tartea.note.dto.TencentCosConfig;
import org.tartea.note.exception.BusinessException;

import java.io.File;
import java.util.Date;

/**
 * 腾讯云cos
 *
 * @Author: jiawenhao
 * @Date: 2022-06-21  22:2
 */
public class TencentCos extends AbstractCos {

    private static final Logger logger = LoggerFactory.getLogger(TencentCos.class);

    private COSCredentials cred = null;
    private ClientConfig clientConfig = null;
    //配置
    private TencentCosConfig cosConfig;

    public TencentCos(TencentCosConfig cosConfig) {
        this.cosConfig = cosConfig;
        cred = new BasicCOSCredentials(cosConfig.getAccessKey(), cosConfig.getSecretKey());
        // 设置bucket的区域, COS地域的简称请参照 https://www.qcloud.com/document/product/436/6224
        clientConfig = new ClientConfig(new Region(cosConfig.getRegionName()));
    }

    @Override
    public String upload(String fileName) {
        COSClient cosClient = null;
        try {
            // 生成cos客户端
            cosClient = new COSClient(cred, clientConfig);

            File file = new File(fileName);
            String key = cosConfig.getSavePath() + "/" + DateUtil.format(new Date(), "yyyyMMddHHmmssSSS") + FileNameUtil.extName(file);

            ObjectMetadata objectMetadata = new ObjectMetadata();
//        objectMetadata.setHeader("expires", new Date(1660000000000L));
            PutObjectRequest putObjectRequest = new PutObjectRequest(cosConfig.getBucketName(), key, file);
            putObjectRequest.withMetadata(objectMetadata);

            cosClient.putObject(putObjectRequest);

            GetObjectRequest getObjectRequest = new GetObjectRequest(cosConfig.getBucketName(), key);
            COSObject cosObject = cosClient.getObject(getObjectRequest);
            return cosObject.getObjectContent().getHttpRequest().getURI().toString();
        } catch (Exception e) {
            logger.error("上传文件失败", e);
            throw new BusinessException("上传文件失败");
        } finally {
            cosClient.shutdown();
        }

    }
}
