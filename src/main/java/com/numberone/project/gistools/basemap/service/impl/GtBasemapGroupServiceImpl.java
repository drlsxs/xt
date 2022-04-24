package com.numberone.project.gistools.basemap.service.impl;

import com.numberone.common.utils.text.Convert;
import com.numberone.project.gistools.basemap.domain.GtBasemapGroup;
import com.numberone.project.gistools.basemap.mapper.GtBasemapGroupMapper;
import com.numberone.project.gistools.basemap.service.IGtBasemapGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 底图组Service业务层处理
 *
 * @author hwx
 * @date 2022-04-22
 */
@Service
public class GtBasemapGroupServiceImpl implements IGtBasemapGroupService
{
    @Autowired
    private GtBasemapGroupMapper gtBasemapGroupMapper;

    /**
     * 查询底图组
     *
     * @param id 底图组ID
     * @return 底图组
     */
    @Override
    public GtBasemapGroup selectGtBasemapGroupById(String id)
    {
        return gtBasemapGroupMapper.selectGtBasemapGroupById(id);
    }

    /**
     * 查询底图组列表
     *
     * @param gtBasemapGroup 底图组
     * @return 底图组
     */
    @Override
    public List<GtBasemapGroup> selectGtBasemapGroupList(GtBasemapGroup gtBasemapGroup)
    {
        return gtBasemapGroupMapper.selectGtBasemapGroupList(gtBasemapGroup);
    }

    /**
     * 新增底图组
     *
     * @param gtBasemapGroup 底图组
     * @return 结果
     */
    @Override
    public int insertGtBasemapGroup(GtBasemapGroup gtBasemapGroup)
    {
        return gtBasemapGroupMapper.insertGtBasemapGroup(gtBasemapGroup);
    }

    /**
     * 修改底图组
     *
     * @param gtBasemapGroup 底图组
     * @return 结果
     */
    @Override
    public int updateGtBasemapGroup(GtBasemapGroup gtBasemapGroup)
    {
        return gtBasemapGroupMapper.updateGtBasemapGroup(gtBasemapGroup);
    }

    /**
     * 删除底图组对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteGtBasemapGroupByIds(String ids)
    {
        return gtBasemapGroupMapper.deleteGtBasemapGroupByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除底图组信息
     *
     * @param id 底图组ID
     * @return 结果
     */
    @Override
    public int deleteGtBasemapGroupById(String id)
    {
        return gtBasemapGroupMapper.deleteGtBasemapGroupById(id);
    }
}
