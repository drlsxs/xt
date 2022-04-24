package com.numberone.project.gistools.interactive.service.impl;

import com.numberone.common.utils.text.Convert;
import com.numberone.project.gistools.interactive.domain.GtMasterSlave;
import com.numberone.project.gistools.interactive.mapper.GtMasterSlaveMapper;
import com.numberone.project.gistools.interactive.service.IGtMasterSlaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 主从表Service业务层处理
 *
 * @author hwx
 * @date 2022-04-20
 */
@Service
public class GtMasterSlaveServiceImpl implements IGtMasterSlaveService
{
    @Autowired
    private GtMasterSlaveMapper gtMasterSlaveMapper;

    /**
     * 查询主从表
     *
     * @param id 主从表ID
     * @return 主从表
     */
    @Override
    public GtMasterSlave selectGtMasterSlaveById(String id)
    {
        return gtMasterSlaveMapper.selectGtMasterSlaveById(id);
    }

    /**
     * 查询主从表列表
     *
     * @param gtMasterSlave 主从表
     * @return 主从表
     */
    @Override
    public List<GtMasterSlave> selectGtMasterSlaveList(GtMasterSlave gtMasterSlave)
    {
        return gtMasterSlaveMapper.selectGtMasterSlaveList(gtMasterSlave);
    }

    /**
     * 新增主从表
     *
     * @param gtMasterSlave 主从表
     * @return 结果
     */
    @Override
    public int insertGtMasterSlave(GtMasterSlave gtMasterSlave)
    {
        return gtMasterSlaveMapper.insertGtMasterSlave(gtMasterSlave);
    }

    /**
     * 修改主从表
     *
     * @param gtMasterSlave 主从表
     * @return 结果
     */
    @Override
    public int updateGtMasterSlave(GtMasterSlave gtMasterSlave)
    {
        return gtMasterSlaveMapper.updateGtMasterSlave(gtMasterSlave);
    }

    /**
     * 删除主从表对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteGtMasterSlaveByIds(String ids)
    {
        return gtMasterSlaveMapper.deleteGtMasterSlaveByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除主从表信息
     *
     * @param id 主从表ID
     * @return 结果
     */
    @Override
    public int deleteGtMasterSlaveById(String id)
    {
        return gtMasterSlaveMapper.deleteGtMasterSlaveById(id);
    }

    @Override
    public List<String> getFieldByTableName(String tableName) {
        return gtMasterSlaveMapper.getFieldByTableName(tableName);
    }

    @Override
    public List<String> getSlaveByTableName(String tableName) {
        return gtMasterSlaveMapper.getSlaveByTableName(tableName);
    }
}
