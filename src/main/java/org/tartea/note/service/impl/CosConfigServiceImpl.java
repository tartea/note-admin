package org.tartea.note.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;
import org.tartea.note.common.CosUsedEnum;
import org.tartea.note.convert.CosConfigConvert;
import org.tartea.note.domain.CosConfig;
import org.tartea.note.dto.CosConfigDTO;
import org.tartea.note.exception.BusinessException;
import org.tartea.note.mapper.CosConfigMapper;
import org.tartea.note.service.CosConfigService;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class CosConfigServiceImpl implements CosConfigService {


    @Resource
    private CosConfigMapper cosConfigMapper;

    @Override
    public void saveCosConfig(CosConfigDTO cosConfigDTO) {
        CosConfig cosConfig = CosConfigConvert.convertToCosConfig(cosConfigDTO);
        Date date = new Date();
        cosConfig.setCreateTime(date);
        cosConfig.setUpdateTime(date);
        cosConfigMapper.insert(cosConfig);
    }

    @Override
    public void useCos(Integer cosId) {
        CosConfig cosConfig = cosConfigMapper.selectById(cosId);
        if (Objects.isNull(cosConfig)) {
            throw new BusinessException("cos配置不存在");
        }
        updateUsedCos();
        cosConfig.setUsedCos(CosUsedEnum.USED.getCode());
        cosConfig.setUpdateTime(new Date());
        cosConfigMapper.updateById(cosConfig);
    }

    @Override
    public CosConfig getUsedCosConfig() {
        QueryWrapper<CosConfig> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("used_cos", CosUsedEnum.USED.getCode());
        List<CosConfig> cosConfigs = cosConfigMapper.selectList(queryWrapper);
        if (CollectionUtil.isEmpty(cosConfigs)) {
            return null;
        }
        return cosConfigs.get(0);
    }

    @Override
    public CosConfigDTO getCosConfig(String cosType) {
        QueryWrapper<CosConfig> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("use_type", cosType);
        List<CosConfig> cosConfigs = cosConfigMapper.selectList(queryWrapper);
        if (CollectionUtil.isEmpty(cosConfigs)) {
            return null;
        }
        return CosConfigConvert.convertToCosConfigDTO(cosConfigs.get(0));
    }

    @Override
    public void updateCosConfig(CosConfigDTO cosConfigDTO) {
        cosConfigMapper.updateById(CosConfigConvert.convertToCosConfig(cosConfigDTO));
    }

    private void updateUsedCos() {
        QueryWrapper<CosConfig> wrapper = new QueryWrapper<>();
        wrapper.eq("used_cos", CosUsedEnum.USED.getCode());
        CosConfig cosConfig = new CosConfig();
        cosConfig.setUsedCos(CosUsedEnum.NOT_USED.getCode());
        cosConfigMapper.update(cosConfig, wrapper);
    }
}
