package com.numberone.project.gistools.twoDData.service;

import com.numberone.project.gistools.twoDData.domain.GtTwodData;

import java.util.List;

/**
 * GtTwodDataService接口
 *
 * @author hwx
 * @date 2022-04-21
 */
public interface IGtTwodDataService
{
    /**
     * 查询GtTwodData
     *
     * @param id GtTwodDataID
     * @return GtTwodData
     */
    public GtTwodData selectGtTwodDataById(String id);

    /**
     * 查询GtTwodData列表
     *
     * @param gtTwodData GtTwodData
     * @return GtTwodData集合
     */
    public List<GtTwodData> selectGtTwodDataList(GtTwodData gtTwodData);

    /**
     * 新增GtTwodData
     *
     * @param gtTwodData GtTwodData
     * @return 结果
     */
    public int insertGtTwodData(GtTwodData gtTwodData);

    /**
     * 修改GtTwodData
     *
     * @param gtTwodData GtTwodData
     * @return 结果
     */
    public int updateGtTwodData(GtTwodData gtTwodData);

    /**
     * 批量删除GtTwodData
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteGtTwodDataByIds(String ids);

    /**
     * 删除GtTwodData信息
     *
     * @param id GtTwodDataID
     * @return 结果
     */
    public int deleteGtTwodDataById(String id);
}
