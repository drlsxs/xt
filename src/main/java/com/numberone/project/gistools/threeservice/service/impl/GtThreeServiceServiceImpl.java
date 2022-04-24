package com.numberone.project.gistools.threeservice.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.numberone.project.gistools.threeservice.mapper.GtThreeServiceMapper;
import com.numberone.project.gistools.threeservice.domain.GtThreeService;
import com.numberone.project.gistools.threeservice.service.IGtThreeServiceService;
import com.numberone.common.utils.text.Convert;

/**
 * 三维数据服务Service业务层处理
 * 
 * @author wyl
 * @date 2021-10-04
 */
@Service
public class GtThreeServiceServiceImpl implements IGtThreeServiceService 
{
    @Autowired
    private GtThreeServiceMapper gtThreeServiceMapper;

    /**
     * 查询三维数据服务
     * 
     * @param id 三维数据服务ID
     * @return 三维数据服务
     */
    @Override
    public GtThreeService selectGtThreeServiceById(String id)
    {
        return gtThreeServiceMapper.selectGtThreeServiceById(id);
    }

    /**
     * 查询三维数据服务列表
     * 
     * @param gtThreeService 三维数据服务
     * @return 三维数据服务
     */
    @Override
    public List<GtThreeService> selectGtThreeServiceList(GtThreeService gtThreeService)
    {
        return gtThreeServiceMapper.selectGtThreeServiceList(gtThreeService);
    }

    /**
     * 新增三维数据服务
     * 
     * @param gtThreeService 三维数据服务
     * @return 结果
     */
    @Override
    public int insertGtThreeService(GtThreeService gtThreeService)
    {
        return gtThreeServiceMapper.insertGtThreeService(gtThreeService);
    }

    /**
     * 修改三维数据服务
     * 
     * @param gtThreeService 三维数据服务
     * @return 结果
     */
    @Override
    public int updateGtThreeService(GtThreeService gtThreeService)
    {
        return gtThreeServiceMapper.updateGtThreeService(gtThreeService);
    }

    /**
     * 删除三维数据服务对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteGtThreeServiceByIds(String ids)
    {
        return gtThreeServiceMapper.deleteGtThreeServiceByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除三维数据服务信息
     * 
     * @param id 三维数据服务ID
     * @return 结果
     */
    @Override
    public int deleteGtThreeServiceById(String id)
    {
        return gtThreeServiceMapper.deleteGtThreeServiceById(id);
    }
}
