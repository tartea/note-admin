package org.tartea.note.cos.factory;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.tartea.note.common.CosEnum;
import org.tartea.note.cos.AbstractCos;
import org.tartea.note.cos.impl.TencentCos;
import org.tartea.note.domain.CosConfig;
import org.tartea.note.dto.TencentCosConfig;
import org.tartea.note.service.CosConfigService;

import javax.annotation.Resource;
import java.util.Objects;

@Component
public class CosFactory implements ApplicationContextAware {

    private static final Logger logger = LoggerFactory.getLogger(CosFactory.class);


    @Resource
    private CosConfigService cosConfigService;
    private AbstractCos abstractCos;

    /**
     * 获取可以上传的方法
     *
     * @return
     */
    public AbstractCos getCos() {
        return abstractCos;
    }

    /**
     * 更新配置
     *
     * @param cosConfig
     */
    public void updateCos(CosConfig cosConfig) {
        if (Objects.equals(cosConfig.getUseType(), CosEnum.tencent.getCode())) {
            abstractCos = new TencentCos(convertToTencentCosConfig(cosConfig));
        } else {
            abstractCos = null;
        }
    }

    /**
     * 转换成腾讯云cos
     *
     * @param cosConfig
     * @return
     */
    private TencentCosConfig convertToTencentCosConfig(CosConfig cosConfig) {
        return JSON.parseObject(cosConfig.getConfig(), TencentCosConfig.class);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        CosConfig usedCosConfig = cosConfigService.getUsedCosConfig();
        updateCos(usedCosConfig);
    }
}
