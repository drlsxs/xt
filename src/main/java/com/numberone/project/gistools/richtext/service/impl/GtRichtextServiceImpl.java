package com.numberone.project.gistools.richtext.service.impl;

import com.numberone.common.utils.DateUtils;
import com.numberone.common.utils.text.Convert;
import com.numberone.project.gistools.richtext.domain.GtRichtext;
import com.numberone.project.gistools.richtext.mapper.GtRichtextMapper;
import com.numberone.project.gistools.richtext.service.IGtRichtextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 富文本Service业务层处理
 *
 * @author hwx
 * @date 2022-03-31
 */
@Service
public class GtRichtextServiceImpl implements IGtRichtextService
{
    @Autowired
    private GtRichtextMapper gtRichtextMapper;

    /**
     * 查询富文本
     *
     * @param id 富文本ID
     * @return 富文本
     */
    @Override
    public GtRichtext selectGtRichtextById(String id)
    {
        return gtRichtextMapper.selectGtRichtextById(id);
    }

    /**
     * 查询富文本列表
     *
     * @param gtRichtext 富文本
     * @return 富文本
     */
    @Override
    public List<GtRichtext> selectGtRichtextList(GtRichtext gtRichtext)
    {
        return gtRichtextMapper.selectGtRichtextList(gtRichtext);
    }

    /**
     * 新增富文本
     *
     * @param gtRichtext 富文本
     * @return 结果
     */
    @Override
    public int insertGtRichtext(GtRichtext gtRichtext)
    {
        gtRichtext.setCreateTime(DateUtils.getNowDate());
        return gtRichtextMapper.insertGtRichtext(gtRichtext);
    }

    /**
     * 修改富文本
     *
     * @param gtRichtext 富文本
     * @return 结果
     */
    @Override
    public int updateGtRichtext(GtRichtext gtRichtext)
    {
        gtRichtext.setUpdateTime(DateUtils.getNowDate());
        return gtRichtextMapper.updateGtRichtext(gtRichtext);
    }

    /**
     * 删除富文本对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteGtRichtextByIds(String ids)
    {
        return gtRichtextMapper.deleteGtRichtextByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除富文本信息
     *
     * @param id 富文本ID
     * @return 结果
     */
    @Override
    public int deleteGtRichtextById(String id)
    {
        return gtRichtextMapper.deleteGtRichtextById(id);
    }
}
