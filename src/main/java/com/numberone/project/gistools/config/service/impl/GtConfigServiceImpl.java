package com.numberone.project.gistools.config.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.numberone.project.gistools.config.mapper.GtConfigMapper;
import com.numberone.project.gistools.config.domain.GtConfig;
import com.numberone.project.gistools.config.service.IGtConfigService;
import com.numberone.common.utils.text.Convert;

/**
 * 配置Service业务层处理
 * 
 * @author wyl
 * @date 2021-10-07
 */
@Service
public class GtConfigServiceImpl implements IGtConfigService 
{
    @Autowired
    private GtConfigMapper gtConfigMapper;

    /**
     * 查询配置
     * 
     * @param id 配置ID
     * @return 配置
     */
    @Override
    public GtConfig selectGtConfigById(String id)
    {
        return gtConfigMapper.selectGtConfigById(id);
    }
    
    @Override
    public GtConfig selectGtConfigNow()
    {
        return gtConfigMapper.selectGtConfigNow();
    }
    

    /**
     * 查询配置列表
     * 
     * @param gtConfig 配置
     * @return 配置
     */
    @Override
    public List<GtConfig> selectGtConfigList(GtConfig gtConfig)
    {
        return gtConfigMapper.selectGtConfigList(gtConfig);
    }

    /**
     * 新增配置
     * 
     * @param gtConfig 配置
     * @return 结果
     */
    @Override
    public int insertGtConfig(GtConfig gtConfig)
    {
        return gtConfigMapper.insertGtConfig(gtConfig);
    }

    /**
     * 修改配置
     * 
     * @param gtConfig 配置
     * @return 结果
     */
    @Override
    public int updateGtConfig(GtConfig gtConfig)
    {
        return gtConfigMapper.updateGtConfig(gtConfig);
    }

    /**
     * 删除配置对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteGtConfigByIds(String ids)
    {
        return gtConfigMapper.deleteGtConfigByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除配置信息
     * 
     * @param id 配置ID
     * @return 结果
     */
    @Override
    public int deleteGtConfigById(String id)
    {
        return gtConfigMapper.deleteGtConfigById(id);
    }
}
