package com.numberone.project.gistools.interactive.mapper;

import com.numberone.project.gistools.interactive.domain.GtDictData;

import java.util.List;

/**
 * 字典详情Mapper接口
 *
 * @author hwx
 * @date 2022-04-19
 */
public interface GtDictDataMapper
{
    /**
     * 查询字典详情
     *
     * @param id 字典详情ID
     * @return 字典详情
     */
    public GtDictData selectGtDictDataById(String id);

    /**
     * 查询字典详情列表
     *
     * @param gtDictData 字典详情
     * @return 字典详情集合
     */
    public List<GtDictData> selectGtDictDataList(GtDictData gtDictData);

    /**
     * 新增字典详情
     *
     * @param gtDictData 字典详情
     * @return 结果
     */
    public int insertGtDictData(GtDictData gtDictData);

    /**
     * 修改字典详情
     *
     * @param gtDictData 字典详情
     * @return 结果
     */
    public int updateGtDictData(GtDictData gtDictData);

    /**
     * 删除字典详情
     *
     * @param id 字典详情ID
     * @return 结果
     */
    public int deleteGtDictDataById(String id);

    /**
     * 批量删除字典详情
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteGtDictDataByIds(String[] ids);

    void deleteGtDictDataByTypeIds(String[] ids);

    List<GtDictData> selectDictDataListByTypeId(String typeId);
}
