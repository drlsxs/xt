package com.numberone.project.gistools.interactive.service;

import com.numberone.project.gistools.interactive.domain.GtDictData;

import java.util.List;

/**
 * 字典详情Service接口
 *
 * @author hwx
 * @date 2022-04-19
 */
public interface IGtDictDataService
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
     * 批量删除字典详情
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteGtDictDataByIds(String ids);

    /**
     * 删除字典详情信息
     *
     * @param id 字典详情ID
     * @return 结果
     */
    public int deleteGtDictDataById(String id);

    void deleteGtDictDataByTypeIds(String[] strings);

    List<GtDictData> selectDictDataListByTypeId(String typeId);
}
