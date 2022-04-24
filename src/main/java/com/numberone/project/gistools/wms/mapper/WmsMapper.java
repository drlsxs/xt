package com.numberone.project.gistools.wms.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.numberone.project.gistools.wms.domain.Wms;

/**
 * wmsMapper接口
 *
 * @author wly
 * @date 2022-03-29
 */
public interface WmsMapper extends BaseMapper<Wms>
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
     * 删除wms
     *
     * @param wmsId wmsID
     * @return 结果
     */
    public int deleteWmsById(String wmsId);

    /**
     * 批量删除wms
     *
     * @param wmsIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteWmsByIds(String[] wmsIds);

    void styleToNull(String wmsId);
}
