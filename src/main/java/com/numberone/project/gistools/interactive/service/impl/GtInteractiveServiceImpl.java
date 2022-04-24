package com.numberone.project.gistools.interactive.service.impl;

import com.numberone.common.utils.text.Convert;
import com.numberone.project.gistools.interactive.domain.GtInteractive;
import com.numberone.project.gistools.interactive.mapper.GtInteractiveMapper;
import com.numberone.project.gistools.interactive.service.IGtInteractiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 数据交互配置Service业务层处理
 *
 * @author hwx
 * @date 2022-04-19
 */
@Service
public class GtInteractiveServiceImpl implements IGtInteractiveService
{
    @Autowired
    private GtInteractiveMapper gtInteractiveMapper;

    /**
     * 查询数据交互配置
     *
     * @param id 数据交互配置ID
     * @return 数据交互配置
     */
    @Override
    public GtInteractive selectGtInteractiveById(String id)
    {
        return gtInteractiveMapper.selectGtInteractiveById(id);
    }

    /**
     * 查询数据交互配置列表
     *
     * @param gtInteractive 数据交互配置
     * @return 数据交互配置
     */
    @Override
    public List<GtInteractive> selectGtInteractiveList(GtInteractive gtInteractive)
    {
        return gtInteractiveMapper.selectGtInteractiveList(gtInteractive);
    }

    /**
     * 新增数据交互配置
     *
     * @param gtInteractive 数据交互配置
     * @return 结果
     */
    @Override
    public int insertGtInteractive(GtInteractive gtInteractive)
    {
        return gtInteractiveMapper.insertGtInteractive(gtInteractive);
    }

    /**
     * 修改数据交互配置
     *
     * @param gtInteractive 数据交互配置
     * @return 结果
     */
    @Override
    public int updateGtInteractive(GtInteractive gtInteractive)
    {
        return gtInteractiveMapper.updateGtInteractive(gtInteractive);
    }

    /**
     * 删除数据交互配置对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteGtInteractiveByIds(String ids)
    {
        return gtInteractiveMapper.deleteGtInteractiveByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除数据交互配置信息
     *
     * @param id 数据交互配置ID
     * @return 结果
     */
    @Override
    public int deleteGtInteractiveById(String id)
    {
        return gtInteractiveMapper.deleteGtInteractiveById(id);
    }
}
