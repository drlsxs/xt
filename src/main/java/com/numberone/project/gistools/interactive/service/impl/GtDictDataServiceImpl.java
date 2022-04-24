package com.numberone.project.gistools.interactive.service.impl;

import com.numberone.common.utils.text.Convert;
import com.numberone.project.gistools.interactive.domain.GtDictData;
import com.numberone.project.gistools.interactive.mapper.GtDictDataMapper;
import com.numberone.project.gistools.interactive.service.IGtDictDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 字典详情Service业务层处理
 *
 * @author hwx
 * @date 2022-04-19
 */
@Service
public class GtDictDataServiceImpl implements IGtDictDataService
{
    @Autowired
    private GtDictDataMapper gtDictDataMapper;

    /**
     * 查询字典详情
     *
     * @param id 字典详情ID
     * @return 字典详情
     */
    @Override
    public GtDictData selectGtDictDataById(String id)
    {
        return gtDictDataMapper.selectGtDictDataById(id);
    }

    /**
     * 查询字典详情列表
     *
     * @param gtDictData 字典详情
     * @return 字典详情
     */
    @Override
    public List<GtDictData> selectGtDictDataList(GtDictData gtDictData)
    {
        return gtDictDataMapper.selectGtDictDataList(gtDictData);
    }

    /**
     * 新增字典详情
     *
     * @param gtDictData 字典详情
     * @return 结果
     */
    @Override
    public int insertGtDictData(GtDictData gtDictData)
    {
        return gtDictDataMapper.insertGtDictData(gtDictData);
    }

    /**
     * 修改字典详情
     *
     * @param gtDictData 字典详情
     * @return 结果
     */
    @Override
    public int updateGtDictData(GtDictData gtDictData)
    {
        return gtDictDataMapper.updateGtDictData(gtDictData);
    }

    /**
     * 删除字典详情对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteGtDictDataByIds(String ids)
    {
        return gtDictDataMapper.deleteGtDictDataByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除字典详情信息
     *
     * @param id 字典详情ID
     * @return 结果
     */
    @Override
    public int deleteGtDictDataById(String id)
    {
        return gtDictDataMapper.deleteGtDictDataById(id);
    }

    @Override
    public void deleteGtDictDataByTypeIds(String[] strings) {
        gtDictDataMapper.deleteGtDictDataByTypeIds(strings);
    }

    @Override
    public List<GtDictData> selectDictDataListByTypeId(String typeId) {
        return gtDictDataMapper.selectDictDataListByTypeId(typeId);
    }
}
