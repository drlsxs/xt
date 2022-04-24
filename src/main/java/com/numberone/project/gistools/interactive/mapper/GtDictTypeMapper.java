package com.numberone.project.gistools.interactive.mapper;

import com.numberone.project.gistools.interactive.domain.GtDictType;

import java.util.List;

/**
 * 字典表Mapper接口
 *
 * @author hwx
 * @date 2022-04-19
 */
public interface GtDictTypeMapper
{
    /**
     * 查询字典表
     *
     * @param id 字典表ID
     * @return 字典表
     */
    public GtDictType selectGtDictTypeById(String id);

    /**
     * 查询字典表列表
     *
     * @param gtDictType 字典表
     * @return 字典表集合
     */
    public List<GtDictType> selectGtDictTypeList(GtDictType gtDictType);

    /**
     * 新增字典表
     *
     * @param gtDictType 字典表
     * @return 结果
     */
    public int insertGtDictType(GtDictType gtDictType);

    /**
     * 修改字典表
     *
     * @param gtDictType 字典表
     * @return 结果
     */
    public int updateGtDictType(GtDictType gtDictType);

    /**
     * 删除字典表
     *
     * @param id 字典表ID
     * @return 结果
     */
    public int deleteGtDictTypeById(String id);

    /**
     * 批量删除字典表
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteGtDictTypeByIds(String[] ids);

    List<GtDictType> getListByResourceId(String resourceId);
}
