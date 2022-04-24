package com.numberone.project.gistools.basemap.service;

import com.numberone.project.gistools.basemap.domain.GtBasemap;

import java.util.List;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author xskj
 * @date 2022-03-30
 */
public interface IGtBasemapService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public GtBasemap selectGtBasemapById(String id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param gtBasemap 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<GtBasemap> selectGtBasemapList(GtBasemap gtBasemap);

    /**
     * 新增【请填写功能名称】
     * 
     * @param gtBasemap 【请填写功能名称】
     * @return 结果
     */
    public int insertGtBasemap(GtBasemap gtBasemap);

    /**
     * 修改【请填写功能名称】
     * 
     * @param gtBasemap 【请填写功能名称】
     * @return 结果
     */
    public int updateGtBasemap(GtBasemap gtBasemap);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteGtBasemapByIds(String ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteGtBasemapById(String id);
}
