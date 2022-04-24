package com.numberone.project.gistools.twoDData.service.impl;

import com.numberone.common.utils.text.Convert;
import com.numberone.project.gistools.twoDData.domain.GtTwodData;
import com.numberone.project.gistools.twoDData.mapper.GtTwodDataMapper;
import com.numberone.project.gistools.twoDData.service.IGtTwodDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * GtTwodDataService业务层处理
 *
 * @author hwx
 * @date 2022-04-21
 */
@Service
public class GtTwodDataServiceImpl implements IGtTwodDataService
{
    @Autowired
    private GtTwodDataMapper gtTwodDataMapper;

    /**
     * 查询GtTwodData
     *
     * @param id GtTwodDataID
     * @return GtTwodData
     */
    @Override
    public GtTwodData selectGtTwodDataById(String id)
    {
        return gtTwodDataMapper.selectGtTwodDataById(id);
    }

    /**
     * 查询GtTwodData列表
     *
     * @param gtTwodData GtTwodData
     * @return GtTwodData
     */
    @Override
    public List<GtTwodData> selectGtTwodDataList(GtTwodData gtTwodData)
    {
        return gtTwodDataMapper.selectGtTwodDataList(gtTwodData);
    }

    /**
     * 新增GtTwodData
     *
     * @param gtTwodData GtTwodData
     * @return 结果
     */
    @Override
    public int insertGtTwodData(GtTwodData gtTwodData)
    {
        return gtTwodDataMapper.insertGtTwodData(gtTwodData);
    }

    /**
     * 修改GtTwodData
     *
     * @param gtTwodData GtTwodData
     * @return 结果
     */
    @Override
    public int updateGtTwodData(GtTwodData gtTwodData)
    {
        return gtTwodDataMapper.updateGtTwodData(gtTwodData);
    }

    /**
     * 删除GtTwodData对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteGtTwodDataByIds(String ids)
    {
        return gtTwodDataMapper.deleteGtTwodDataByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除GtTwodData信息
     *
     * @param id GtTwodDataID
     * @return 结果
     */
    @Override
    public int deleteGtTwodDataById(String id)
    {
        return gtTwodDataMapper.deleteGtTwodDataById(id);
    }
}
