package org.tartea.note.service.factory;

import com.alibaba.fastjson.JSON;
import org.tartea.note.common.CosEnum;
import org.tartea.note.cos.AbstractCos;
import org.tartea.note.cos.impl.TencentCos;
import org.tartea.note.domain.CosConfig;
import org.tartea.note.dto.TencentCosConfig;

import java.util.Objects;

public class CosFactory {

    public AbstractCos getCos(CosConfig cosConfig) {
        if (Objects.equals(cosConfig.getUsedCos(), CosEnum.tencent.getCode())) {
            new TencentCos(convertToTencentCosConfig(cosConfig));
        }

        return null;
    }

    private TencentCosConfig convertToTencentCosConfig(CosConfig cosConfig){
        return JSON.parseObject(cosConfig.getConfig(),TencentCosConfig.class);
    }
}
