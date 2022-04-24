package com.numberone.project.gistools.threeDData.service.impl;

import com.numberone.common.utils.text.Convert;
import com.numberone.project.gistools.threeDData.domain.GtThreedData;
import com.numberone.project.gistools.threeDData.mapper.GtThreedDataMapper;
import com.numberone.project.gistools.threeDData.service.IGtThreedDataService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 三维点位数据Service业务层处理
 *
 * @author hwx
 * @date 2022-04-18
 */
@Service
public class GtThreedDataServiceImpl implements IGtThreedDataService
{
    @Resource
    private GtThreedDataMapper gt3dDataMapper;

    /**
     * 查询三维点位数据
     *
     * @param id 三维点位数据ID
     * @return 三维点位数据
     */
    @Override
    public GtThreedData selectGt3dDataById(String id)
    {
        return gt3dDataMapper.selectGt3dDataById(id);
    }

    /**
     * 查询三维点位数据列表
     *
     * @param gt3dData 三维点位数据
     * @return 三维点位数据
     */
    @Override
    public List<GtThreedData> selectGt3dDataList(GtThreedData gt3dData)
    {
        return gt3dDataMapper.selectGt3dDataList(gt3dData);
    }

    /**
     * 新增三维点位数据
     *
     * @param gt3dData 三维点位数据
     * @return 结果
     */
    @Override
    public int insertGt3dData(GtThreedData gt3dData)
    {
        return gt3dDataMapper.insertGt3dData(gt3dData);
    }

    /**
     * 修改三维点位数据
     *
     * @param gt3dData 三维点位数据
     * @return 结果
     */
    @Override
    public int updateGt3dData(GtThreedData gt3dData)
    {
        return gt3dDataMapper.updateGt3dData(gt3dData);
    }

    /**
     * 删除三维点位数据对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteGt3dDataByIds(String ids)
    {
        return gt3dDataMapper.deleteGt3dDataByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除三维点位数据信息
     *
     * @param id 三维点位数据ID
     * @return 结果
     */
    @Override
    public int deleteGt3dDataById(String id)
    {
        return gt3dDataMapper.deleteGt3dDataById(id);
    }
}
