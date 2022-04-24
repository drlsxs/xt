package com.numberone.project.gistools.wms.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.numberone.framework.web.domain.AjaxResult;
import com.numberone.project.gistools.gridservice.domain.GtGridService;
import com.numberone.project.gistools.wms.domain.Wms;

/**
 * wmsService接口
 *
 * @author wly
 * @date 2022-03-29
 */
public interface IWmsService extends IService<Wms>
{
    /**
     * 查询wms
     *
     * @param wmsId wmsID
     * @return wms
     */
    public Wms selectWmsById(String wmsId);

    /**
     * 查询wms列表
     *
     * @param wms wms
     * @return wms集合
     */
    public List<Wms> selectWmsList(Wms wms);

    /**
     * 新增wms
     *
     * @param wms wms
     * @return 结果
     */
    public int insertWms(Wms wms);

    /**
     * 修改wms
     *
     * @param wms wms
     * @return 结果
     */
    public int updateWms(Wms wms);

    /**
     * 批量删除wms
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteWmsByIds(String ids);

    /**
     * 删除wms信息
     *
     * @param wmsId wmsID
     * @return 结果
     */
    public int deleteWmsById(String wmsId);

    void styleToNull(String wmsId);
}
