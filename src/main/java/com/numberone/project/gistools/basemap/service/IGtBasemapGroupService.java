package com.numberone.project.gistools.basemap.service;

import com.numberone.project.gistools.basemap.domain.GtBasemapGroup;

import java.util.List;

/**
 * 底图组Service接口
 *
 * @author hwx
 * @date 2022-04-22
 */
public interface IGtBasemapGroupService
{
    /**
     * 查询底图组
     *
     * @param id 底图组ID
     * @return 底图组
     */
    public GtBasemapGroup selectGtBasemapGroupById(String id);

    /**
     * 查询底图组列表
     *
     * @param gtBasemapGroup 底图组
     * @return 底图组集合
     */
    public List<GtBasemapGroup> selectGtBasemapGroupList(GtBasemapGroup gtBasemapGroup);

    /**
     * 新增底图组
     *
     * @param gtBasemapGroup 底图组
     * @return 结果
     */
    public int insertGtBasemapGroup(GtBasemapGroup gtBasemapGroup);

    /**
     * 修改底图组
     *
     * @param gtBasemapGroup 底图组
     * @return 结果
     */
    public int updateGtBasemapGroup(GtBasemapGroup gtBasemapGroup);

    /**
     * 批量删除底图组
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteGtBasemapGroupByIds(String ids);

    /**
     * 删除底图组信息
     *
     * @param id 底图组ID
     * @return 结果
     */
    public int deleteGtBasemapGroupById(String id);
}
