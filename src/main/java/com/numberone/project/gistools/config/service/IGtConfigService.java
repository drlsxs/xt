package com.numberone.project.gistools.config.service;

import java.util.List;
import com.numberone.project.gistools.config.domain.GtConfig;

/**
 * 配置Service接口
 * 
 * @author wyl
 * @date 2021-10-07
 */
public interface IGtConfigService 
{
    /**
     * 查询配置
     * 
     * @param id 配置ID
     * @return 配置
     */
    public GtConfig selectGtConfigById(String id);
    
    public GtConfig selectGtConfigNow();
    /**
     * 查询配置列表
     * 
     * @param gtConfig 配置
     * @return 配置集合
     */
    public List<GtConfig> selectGtConfigList(GtConfig gtConfig);

    /**
     * 新增配置
     * 
     * @param gtConfig 配置
     * @return 结果
     */
    public int insertGtConfig(GtConfig gtConfig);

    /**
     * 修改配置
     * 
     * @param gtConfig 配置
     * @return 结果
     */
    public int updateGtConfig(GtConfig gtConfig);

    /**
     * 批量删除配置
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteGtConfigByIds(String ids);

    /**
     * 删除配置信息
     * 
     * @param id 配置ID
     * @return 结果
     */
    public int deleteGtConfigById(String id);
}
