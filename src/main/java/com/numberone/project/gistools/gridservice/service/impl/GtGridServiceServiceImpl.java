package com.numberone.project.gistools.gridservice.service.impl;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.numberone.project.gistools.gridservice.mapper.GtGridServiceMapper;
import com.numberone.project.gistools.gridservice.domain.GtGridService;
import com.numberone.project.gistools.gridservice.service.IGtGridServiceService;
import com.numberone.common.utils.text.Convert;

/**
 * 栅格服务Service业务层处理
 *
 * @author numberone
 * @date 2021-10-02
 */
@Service
public class GtGridServiceServiceImpl extends ServiceImpl<GtGridServiceMapper,GtGridService> implements IGtGridServiceService
{
    @Autowired
    private GtGridServiceMapper gtGridServiceMapper;

    /**
     * 查询栅格服务
     *
     * @param id 栅格服务ID
     * @return 栅格服务
     */
    @Override
    public GtGridService selectGtGridServiceById(String id)
    {
        return gtGridServiceMapper.selectGtGridServiceById(id);
    }

    /**
     * 查询栅格服务列表
     *
     * @param gtGridService 栅格服务
     * @return 栅格服务
     */
    @Override
    public List<GtGridService> selectGtGridServiceList(GtGridService gtGridService)
    {
        return gtGridServiceMapper.selectGtGridServiceList(gtGridService);
    }

    /**
     * 新增栅格服务
     *
     * @param gtGridService 栅格服务
     * @return 结果
     */
    @Override
    public int insertGtGridService(GtGridService gtGridService)
    {
        return gtGridServiceMapper.insertGtGridService(gtGridService);
    }

    /**
     * 修改栅格服务
     *
     * @param gtGridService 栅格服务
     * @return 结果
     */
    @Override
    public int updateGtGridService(GtGridService gtGridService)
    {
        return gtGridServiceMapper.updateGtGridService(gtGridService);
    }

    /**
     * 删除栅格服务对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteGtGridServiceByIds(String ids)
    {
        return gtGridServiceMapper.deleteGtGridServiceByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除栅格服务信息
     *
     * @param id 栅格服务ID
     * @return 结果
     */
    @Override
    public int deleteGtGridServiceById(String id)
    {
        return gtGridServiceMapper.deleteGtGridServiceById(id);
    }
}
