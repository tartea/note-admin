package org.tartea.note.controller;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tartea.note.common.BaseApiCode;
import org.tartea.note.common.Result;
import org.tartea.note.dto.CosConfigDTO;
import org.tartea.note.service.CosConfigService;

import java.util.Objects;

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
    public Result saveCosConfig(@RequestBody CosConfigDTO cosConfigDTO) {
        try {
            cosConfigService.saveCosConfig(cosConfigDTO);
            return new Result().success();
        } catch (Exception e) {
            logger.error("保存cos配置失败", JSON.toJSONString(cosConfigDTO), e);
        }
        return new Result().fail();
    }

    /**
     * @param cosType cos类型
     */
    @RequestMapping("getCosConfig")
    public Result getCosConfig(String cosType) {
        try {
            CosConfigDTO cosConfig = cosConfigService.getCosConfig(cosType);
            if (Objects.isNull(cosConfig)) {
                return new Result().fail();
            }
            return new Result().success(cosConfig);
        } catch (Exception e) {
            logger.error("获取cos配置失败", cosType, e);
        }
        return new Result().fail();
    }

    @RequestMapping("updateCosConfig")
    public Result updateCosConfig(@RequestBody CosConfigDTO cosConfigDTO) {
        try {
            if (Objects.isNull(cosConfigDTO.getId())) {
                return new Result().fail(BaseApiCode.INVALID_FORMAT.getCode(), BaseApiCode.INVALID_FORMAT.getMsg());
            }
            cosConfigService.updateCosConfig(cosConfigDTO);
            return new Result().success();
        } catch (Exception e) {
            logger.error("更新cos配置失败", JSON.toJSONString(cosConfigDTO), e);
        }
        return new Result().fail();
    }

    @RequestMapping("ensureUseConfig")
    public Result ensureUseConfig(Integer configId){
        try {
            if (Objects.isNull(configId)) {
                return new Result().fail(BaseApiCode.INVALID_FORMAT.getCode(), BaseApiCode.INVALID_FORMAT.getMsg());
            }
            cosConfigService.useCos(configId);
            return new Result().success();
        } catch (Exception e) {
            logger.error("确认使用cos配置失败", configId, e);
        }
        return new Result().fail();
    }
}
