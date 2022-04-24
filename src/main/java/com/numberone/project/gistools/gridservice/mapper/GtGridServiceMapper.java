package com.numberone.project.gistools.gridservice.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.numberone.project.gistools.gridservice.domain.GtGridService;

/**
 * 栅格服务Mapper接口
 *
 * @author numberone
 * @date 2021-10-02
 */
public interface GtGridServiceMapper extends BaseMapper<GtGridService>
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
     * 删除栅格服务
     *
     * @param id 栅格服务ID
     * @return 结果
     */
    public int deleteGtGridServiceById(String id);

    /**
     * 批量删除栅格服务
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteGtGridServiceByIds(String[] ids);
}
