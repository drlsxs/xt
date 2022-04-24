package com.numberone.project.gistools.wms.service.impl;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.numberone.project.gistools.gridservice.domain.GtGridService;
import com.numberone.project.gistools.gridservice.mapper.GtGridServiceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.numberone.project.gistools.wms.mapper.WmsMapper;
import com.numberone.project.gistools.wms.domain.Wms;
import com.numberone.project.gistools.wms.service.IWmsService;
import com.numberone.common.utils.text.Convert;

/**
 * wmsService业务层处理
 *
 * @author wly
 * @date 2022-03-29
 */
@Service
public class WmsServiceImpl extends ServiceImpl<WmsMapper, Wms> implements IWmsService
{
    @Autowired
    private WmsMapper wmsMapper;

    /**
     * 查询wms
     *
     * @param wmsId wmsID
     * @return wms
     */
    @Override
    public Wms selectWmsById(String wmsId)
    {
        return wmsMapper.selectWmsById(wmsId);
    }

    /**
     * 查询wms列表
     *
     * @param wms wms
     * @return wms
     */
    @Override
    public List<Wms> selectWmsList(Wms wms)
    {
        return wmsMapper.selectWmsList(wms);
    }

    /**
     * 新增wms
     *
     * @param wms wms
     * @return 结果
     */
    @Override
    public int insertWms(Wms wms)
    {
        return wmsMapper.insertWms(wms);
    }

    /**
     * 修改wms
     *
     * @param wms wms
     * @return 结果
     */
    @Override
    public int updateWms(Wms wms)
    {
        return wmsMapper.updateWms(wms);
    }

    /**
     * 删除wms对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteWmsByIds(String ids)
    {
        return wmsMapper.deleteWmsByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除wms信息
     *
     * @param wmsId wmsID
     * @return 结果
     */
    @Override
    public int deleteWmsById(String wmsId)
    {
        return wmsMapper.deleteWmsById(wmsId);
    }

    @Override
    public void styleToNull(String wmsId) {
        wmsMapper.styleToNull(wmsId);
    }
}
