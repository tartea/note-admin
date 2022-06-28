package org.tartea.note.controller;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tartea.note.dto.CosConfigDTO;
import org.tartea.note.service.CosConfigService;

/**
 * cos配置
 *
 * @author jiawenhao
 * @date 2022-06-23 9:27
 */
@RestController
public class CosConfigController {

    private static final Logger logger = LoggerFactory.getLogger(CosConfigController.class);

    @Autowired
    private CosConfigService cosConfigService;

    /**
     * @param cosConfigDTO
     */
    @RequestMapping("saveCosConfig")
    public void saveCosConfig(@RequestBody CosConfigDTO cosConfigDTO) {
        try {
            cosConfigService.saveCosConfig(cosConfigDTO);
        } catch (Exception e) {
            logger.error("保存cos配置失败", JSON.toJSONString(cosConfigDTO), e);
        }
    }
}
