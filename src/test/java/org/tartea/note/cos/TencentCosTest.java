package org.tartea.note.cos;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.model.*;
import com.qcloud.cos.region.Region;
import org.junit.Test;

import java.io.File;
import java.util.Date;

public class TencentCosTest {


    @Test
    public void test1() {
        // 初始化用户身份信息(secretId, secretKey)
        COSCredentials cred = new BasicCOSCredentials("", "");
        // 设置bucket的区域, COS地域的简称请参照 https://www.qcloud.com/document/product/436/6224
        ClientConfig clientConfig = new ClientConfig(new Region("ap-nanjing"));
        // 生成cos客户端
        COSClient cosClient = new COSClient(cred, clientConfig);

        String bucketName = "images-1258301517";
        String key = "file/note.sql";

        String localPath = "/Users/jiaxiansheng/Github/note-admin/note.sql";

        ObjectMetadata objectMetadata = new ObjectMetadata();
//        objectMetadata.setHeader("expires", new Date(1660000000000L));

        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, new File(localPath));
        putObjectRequest.withMetadata(objectMetadata);

        PutObjectResult putObjectResult = cosClient.putObject(putObjectRequest);

        System.out.println(putObjectResult.getRequestId());

        GetObjectRequest getObjectRequest = new GetObjectRequest(bucketName, key);
        COSObject cosObject = cosClient.getObject(getObjectRequest);
        System.out.println(cosObject.getObjectContent().getHttpRequest().getURI().toString());

        cosClient.shutdown();
    }
}
