package com.numberone.project.gistools.twoDStyle.service.impl;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.numberone.common.utils.file.FileUploadUtils;
import com.numberone.common.utils.text.Convert;
import com.numberone.framework.config.NumberOneConfig;
import com.numberone.framework.config.ServerConfig;
import com.numberone.framework.web.domain.AjaxResult;
import com.numberone.project.gistools.twoDStyle.domain.GtPicture;
import com.numberone.project.gistools.twoDStyle.mapper.GtPictureMapper;
import com.numberone.project.gistools.twoDStyle.service.IGtPictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Base64;
import java.util.List;

@Service
public class GtPictureServiceImpl implements IGtPictureService
{
    @Resource
    private GtPictureMapper gtPictureMapper;
    @Autowired
    private ServerConfig serverConfig;

    /**
     * 查询图片表
     *
     * @param id 图片表ID
     * @return 图片表
     */
    @Override
    public GtPicture selectGtPictureById(String id)
    {
        return gtPictureMapper.selectGtPictureById(id);
    }

    /**
     * 查询样式图片列表
     *
     * @param gtPicture 图片表
     * @return 图片表
     */
    @Override
    public List<GtPicture> selectGtPictureList(GtPicture gtPicture)
    {
        return gtPictureMapper.selectGtPictureList(gtPicture);
    }

    /**
     * 新增图片表
     *
     * @param gtPicture 图片表
     * @return 结果
     */
    @Override
    public int insertGtPicture(GtPicture gtPicture)
    {
        return gtPictureMapper.insertGtPicture(gtPicture);
    }

    /**
     * 修改图片表
     *
     * @param gtPicture 图片表
     * @return 结果
     */
    @Override
    public int updateGtPicture(GtPicture gtPicture)
    {
        return gtPictureMapper.updateGtPicture(gtPicture);
    }

    /**
     * 删除图片表对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteGtPictureByIds(String ids)
    {
        return gtPictureMapper.deleteGtPictureByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除图片表信息
     *
     * @param id 图片表ID
     * @return 结果
     */
    @Override
    public int deleteGtPictureById(String id)
    {
        return gtPictureMapper.deleteGtPictureById(id);
    }

    @Override
    public AjaxResult insertIconPicture(MultipartFile file, String iconName,String geometryType) {
        //先判断数据样式名称是否重复
        List<String> names = gtPictureMapper.selectAllIconPictureName();
        if (names.contains(iconName)){
            return AjaxResult.error("样式名称重复，添加失败");
        }

        // 上传文件路径
        String filePath = NumberOneConfig.getUploadPath();
        // 上传并返回新文件名称
        String fileName = null;
        try {
            fileName = FileUploadUtils.upload(filePath, file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] split = fileName.split("/");
        String url = serverConfig.getUrl() + fileName;

        byte[] fileByte = null;
        try {
            fileByte = file.getBytes();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String pictureBase64 = Base64.getEncoder().encodeToString(fileByte);
        String base = "data:image/png;base64,"+pictureBase64;
        GtPicture gtPicture = new GtPicture();
        gtPicture.setId(IdWorker.get32UUID());
        gtPicture.setBase(base);
        gtPicture.setName(iconName);
        gtPicture.setType("2");
        gtPicture.setUrl(url);
        gtPicture.setGeometryType(geometryType);
        gtPictureMapper.insertGtPicture(gtPicture);
        return AjaxResult.success();
    }

    @Override
    public List<GtPicture> selectIconPictureList(GtPicture gtPicture) {
        return gtPictureMapper.selectIconPictureList(gtPicture);
    }

}
