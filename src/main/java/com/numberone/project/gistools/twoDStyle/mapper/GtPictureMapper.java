package com.numberone.project.gistools.twoDStyle.mapper;

import com.numberone.project.gistools.twoDStyle.domain.GtPicture;

import java.util.List;

public interface GtPictureMapper
{
    /**
     * 查询图片表
     *
     * @param id 图片表ID
     * @return 图片表
     */
    public GtPicture selectGtPictureById(String id);

    /**
     * 查询图片表列表
     *
     * @param gtPicture 图片表
     * @return 图片表集合
     */
    public List<GtPicture> selectGtPictureList(GtPicture gtPicture);

    /**
     * 新增图片表
     *
     * @param gtPicture 图片表
     * @return 结果
     */
    public int insertGtPicture(GtPicture gtPicture);

    /**
     * 修改图片表
     *
     * @param gtPicture 图片表
     * @return 结果
     */
    public int updateGtPicture(GtPicture gtPicture);

    /**
     * 删除图片表
     *
     * @param id 图片表ID
     * @return 结果
     */
    public int deleteGtPictureById(String id);

    /**
     * 批量删除图片表
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteGtPictureByIds(String[] ids);

    void deleteGtPictureByName(String styleName);

    List<String> getAllName();

    List<GtPicture> selectIconPictureList(GtPicture gtPicture);

    List<String> selectAllIconPictureName();
}
