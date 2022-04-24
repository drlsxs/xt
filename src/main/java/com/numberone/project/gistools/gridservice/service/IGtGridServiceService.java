package com.numberone.project.gistools.gridservice.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.numberone.project.gistools.gridservice.domain.GtGridService;

/**
 * 栅格服务Service接口
 *
 * @author numberone
 * @date 2021-10-02
 */
public interface IGtGridServiceService extends IService<GtGridService>
{
    /**
     * 查询栅格服务
     *
     * @param id 栅格服务ID
     * @return 栅格服务
     */
    public GtGridService selectGtGridServiceById(String id);

    /**
     * 查询栅格服务列表
     *
     * @param gtGridService 栅格服务
     * @return 栅格服务集合
     */
    public List<GtGridService> selectGtGridServiceList(GtGridService gtGridService);

    /**
     * 新增栅格服务
     *
     * @param gtGridService 栅格服务
     * @return 结果
     */
    public int insertGtGridService(GtGridService gtGridService);

    /**
     * 修改栅格服务
     *
     * @param gtGridService 栅格服务
     * @return 结果
     */
    public int updateGtGridService(GtGridService gtGridService);

    /**
     * 批量删除栅格服务
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteGtGridServiceByIds(String ids);

    /**
     * 删除栅格服务信息
     *
     * @param id 栅格服务ID
     * @return 结果
     */
    public int deleteGtGridServiceById(String id);
}
