package org.tartea.note.service;

import org.tartea.note.domain.CosConfig;
import org.tartea.note.dto.CosConfigDTO;

/**
 * cos业务操作
 *
 * @author jiawenhao
 * @date 2022-06-23 10:0
 */
public interface CosConfigService {

    /**
     * 保存配置
     *
     * @param cosConfigDTO
     */
    void saveCosConfig(CosConfigDTO cosConfigDTO);

    /**
     * 设置使用的cos
     *
     * @param cosId
     */
    void useCos(Integer cosId);

    /**
     * 获取已经使用的配置
     *
     * @return
     */
    CosConfig getUsedCosConfig();
}
