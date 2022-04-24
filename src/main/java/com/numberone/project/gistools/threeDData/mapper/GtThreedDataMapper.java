package com.numberone.project.gistools.threeDData.mapper;

import com.numberone.project.gistools.threeDData.domain.GtThreedData;

import java.util.List;

/**
 * 三维点位数据Mapper接口
 *
 * @author hwx
 * @date 2022-04-18
 */
public interface GtThreedDataMapper
{
    /**
     * 查询三维点位数据
     *
     * @param id 三维点位数据ID
     * @return 三维点位数据
     */
    public GtThreedData selectGt3dDataById(String id);

    /**
     * 查询三维点位数据列表
     *
     * @param gt3dData 三维点位数据
     * @return 三维点位数据集合
     */
    public List<GtThreedData> selectGt3dDataList(GtThreedData gt3dData);

    /**
     * 新增三维点位数据
     *
     * @param gt3dData 三维点位数据
     * @return 结果
     */
    public int insertGt3dData(GtThreedData gt3dData);

    /**
     * 修改三维点位数据
     *
     * @param gt3dData 三维点位数据
     * @return 结果
     */
    public int updateGt3dData(GtThreedData gt3dData);

    /**
     * 删除三维点位数据
     *
     * @param id 三维点位数据ID
     * @return 结果
     */
    public int deleteGt3dDataById(String id);

    /**
     * 批量删除三维点位数据
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteGt3dDataByIds(String[] ids);
}
