package com.numberone.project.gistools.twoDStyle.service;

import com.numberone.framework.web.domain.AjaxResult;
import com.numberone.project.gistools.twoDStyle.domain.GtPicture;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IGtPictureService
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
     * 批量删除图片表
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteGtPictureByIds(String ids);

    /**
     * 删除图片表信息
     *
     * @param id 图片表ID
     * @return 结果
     */
    public int deleteGtPictureById(String id);

    AjaxResult insertIconPicture(MultipartFile file,String iconName,String geometryType);

    List<GtPicture> selectIconPictureList(GtPicture gtPicture);

}
