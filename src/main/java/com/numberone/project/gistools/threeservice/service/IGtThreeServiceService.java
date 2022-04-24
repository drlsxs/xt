package com.numberone.project.gistools.threeservice.service;

import java.util.List;
import com.numberone.project.gistools.threeservice.domain.GtThreeService;

/**
 * 三维数据服务Service接口
 * 
 * @author wyl
 * @date 2021-10-04
 */
public interface IGtThreeServiceService 
{
    /**
     * 查询三维数据服务
     * 
     * @param id 三维数据服务ID
     * @return 三维数据服务
     */
    public GtThreeService selectGtThreeServiceById(String id);

    /**
     * 查询三维数据服务列表
     * 
     * @param gtThreeService 三维数据服务
     * @return 三维数据服务集合
     */
    public List<GtThreeService> selectGtThreeServiceList(GtThreeService gtThreeService);

    /**
     * 新增三维数据服务
     * 
     * @param gtThreeService 三维数据服务
     * @return 结果
     */
    public int insertGtThreeService(GtThreeService gtThreeService);

    /**
     * 修改三维数据服务
     * 
     * @param gtThreeService 三维数据服务
     * @return 结果
     */
    public int updateGtThreeService(GtThreeService gtThreeService);

    /**
     * 批量删除三维数据服务
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteGtThreeServiceByIds(String ids);

    /**
     * 删除三维数据服务信息
     * 
     * @param id 三维数据服务ID
     * @return 结果
     */
    public int deleteGtThreeServiceById(String id);
}
