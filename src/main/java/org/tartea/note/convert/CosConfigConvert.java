package org.tartea.note.convert;

import org.tartea.note.domain.CosConfig;
import org.tartea.note.dto.CosConfigDTO;

import java.util.Objects;

public class CosConfigConvert {

    public static CosConfig convertToCosConfig(CosConfigDTO cosConfigDTO){
        if(Objects.isNull(cosConfigDTO)){
            return null;
        }
        CosConfig cosConfig = new CosConfig();
        cosConfig.setId(cosConfigDTO.getId());
        cosConfig.setConfig(cosConfigDTO.getConfig());

        return cosConfig;
    }
}
