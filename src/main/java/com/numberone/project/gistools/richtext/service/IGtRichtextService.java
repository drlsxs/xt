package com.numberone.project.gistools.richtext.service;

import com.numberone.project.gistools.richtext.domain.GtRichtext;

import java.util.List;

/**
 * 富文本Service接口
 *
 * @author hwx
 * @date 2022-03-31
 */
public interface IGtRichtextService
{
    /**
     * 查询富文本
     *
     * @param id 富文本ID
     * @return 富文本
     */
    public GtRichtext selectGtRichtextById(String id);

    /**
     * 查询富文本列表
     *
     * @param gtRichtext 富文本
     * @return 富文本集合
     */
    public List<GtRichtext> selectGtRichtextList(GtRichtext gtRichtext);

    /**
     * 新增富文本
     *
     * @param gtRichtext 富文本
     * @return 结果
     */
    public int insertGtRichtext(GtRichtext gtRichtext);

    /**
     * 修改富文本
     *
     * @param gtRichtext 富文本
     * @return 结果
     */
    public int updateGtRichtext(GtRichtext gtRichtext);

    /**
     * 批量删除富文本
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteGtRichtextByIds(String ids);

    /**
     * 删除富文本信息
     *
     * @param id 富文本ID
     * @return 结果
     */
    public int deleteGtRichtextById(String id);

}
