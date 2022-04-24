package com.numberone.project.gistools.interactive.service;

import com.numberone.project.gistools.interactive.domain.GtMasterSlave;

import java.util.List;

/**
 * 主从表Service接口
 *
 * @author hwx
 * @date 2022-04-20
 */
public interface IGtMasterSlaveService
{
    /**
     * 查询主从表
     *
     * @param id 主从表ID
     * @return 主从表
     */
    public GtMasterSlave selectGtMasterSlaveById(String id);

    /**
     * 查询主从表列表
     *
     * @param gtMasterSlave 主从表
     * @return 主从表集合
     */
    public List<GtMasterSlave> selectGtMasterSlaveList(GtMasterSlave gtMasterSlave);

    /**
     * 新增主从表
     *
     * @param gtMasterSlave 主从表
     * @return 结果
     */
    public int insertGtMasterSlave(GtMasterSlave gtMasterSlave);

    /**
     * 修改主从表
     *
     * @param gtMasterSlave 主从表
     * @return 结果
     */
    public int updateGtMasterSlave(GtMasterSlave gtMasterSlave);

    /**
     * 批量删除主从表
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteGtMasterSlaveByIds(String ids);

    /**
     * 删除主从表信息
     *
     * @param id 主从表ID
     * @return 结果
     */
    public int deleteGtMasterSlaveById(String id);

    List<String> getFieldByTableName(String tableName);

    List<String> getSlaveByTableName(String tableName);
}
