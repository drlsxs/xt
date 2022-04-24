package com.numberone.project.gistools.basemap.service.impl;

import java.util.List;
import java.util.UUID;

import com.numberone.common.utils.DateUtils;
import com.numberone.project.gistools.basemap.domain.GtBasemap;
import com.numberone.project.gistools.basemap.mapper.GtBasemapMapper;
import com.numberone.project.gistools.basemap.service.IGtBasemapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.numberone.common.utils.text.Convert;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author xskj
 * @date 2022-03-30
 */
@Service
public class GtBasemapServiceImpl implements IGtBasemapService
{
    @Autowired
    private GtBasemapMapper gtBasemapMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public GtBasemap selectGtBasemapById(String id)
    {
        return gtBasemapMapper.selectGtBasemapById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param gtBasemap 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<GtBasemap> selectGtBasemapList(GtBasemap gtBasemap)
    {
        return gtBasemapMapper.selectGtBasemapList(gtBasemap);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param gtBasemap 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertGtBasemap(GtBasemap gtBasemap)
    {
        gtBasemap.setId(UUID.randomUUID().toString().replace("-", ""));
        return gtBasemapMapper.insertGtBasemap(gtBasemap);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param gtBasemap 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateGtBasemap(GtBasemap gtBasemap)
    {
        gtBasemap.setUpdateTime(DateUtils.getNowDate());
        return gtBasemapMapper.updateGtBasemap(gtBasemap);
    }

    /**
     * 删除【请填写功能名称】对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteGtBasemapByIds(String ids)
    {
        return gtBasemapMapper.deleteGtBasemapByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteGtBasemapById(String id)
    {
        return gtBasemapMapper.deleteGtBasemapById(id);
    }
}
