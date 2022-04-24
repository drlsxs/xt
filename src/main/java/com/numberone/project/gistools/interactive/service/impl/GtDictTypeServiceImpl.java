package com.numberone.project.gistools.interactive.service.impl;

import com.numberone.common.utils.text.Convert;
import com.numberone.project.gistools.interactive.domain.GtDictType;
import com.numberone.project.gistools.interactive.mapper.GtDictTypeMapper;
import com.numberone.project.gistools.interactive.service.IGtDictTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 字典表Service业务层处理
 *
 * @author hwx
 * @date 2022-04-19
 */
@Service
public class GtDictTypeServiceImpl implements IGtDictTypeService
{
    @Autowired
    private GtDictTypeMapper gtDictTypeMapper;

    /**
     * 查询字典表
     *
     * @param id 字典表ID
     * @return 字典表
     */
    @Override
    public GtDictType selectGtDictTypeById(String id)
    {
        return gtDictTypeMapper.selectGtDictTypeById(id);
    }

    /**
     * 查询字典表列表
     *
     * @param gtDictType 字典表
     * @return 字典表
     */
    @Override
    public List<GtDictType> selectGtDictTypeList(GtDictType gtDictType)
    {
        return gtDictTypeMapper.selectGtDictTypeList(gtDictType);
    }

    /**
     * 新增字典表
     *
     * @param gtDictType 字典表
     * @return 结果
     */
    @Override
    public int insertGtDictType(GtDictType gtDictType)
    {
        return gtDictTypeMapper.insertGtDictType(gtDictType);
    }

    /**
     * 修改字典表
     *
     * @param gtDictType 字典表
     * @return 结果
     */
    @Override
    public int updateGtDictType(GtDictType gtDictType)
    {
        return gtDictTypeMapper.updateGtDictType(gtDictType);
    }

    /**
     * 删除字典表对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteGtDictTypeByIds(String ids)
    {
        return gtDictTypeMapper.deleteGtDictTypeByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除字典表信息
     *
     * @param id 字典表ID
     * @return 结果
     */
    @Override
    public int deleteGtDictTypeById(String id)
    {
        return gtDictTypeMapper.deleteGtDictTypeById(id);
    }

    @Override
    public List<GtDictType> getListByResourceId(String resourceId) {
        return gtDictTypeMapper.getListByResourceId(resourceId);
    }
}
