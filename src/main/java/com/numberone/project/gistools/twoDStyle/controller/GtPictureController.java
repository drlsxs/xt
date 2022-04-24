package com.numberone.project.gistools.twoDStyle.controller;

import com.numberone.common.utils.poi.ExcelUtil;
import com.numberone.framework.aspectj.lang.enums.BusinessType;
import com.numberone.framework.web.controller.BaseController;
import com.numberone.framework.web.domain.AjaxResult;
import com.numberone.framework.web.page.TableDataInfo;
import com.numberone.project.gistools.twoDStyle.domain.GtPicture;
import com.numberone.project.gistools.twoDStyle.service.IGtPictureService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.net.MalformedURLException;
import java.util.List;

@Controller
@RequestMapping("/gistools/picture")
public class GtPictureController extends BaseController
{
    private String prefix = "system/picture";

    @Autowired
    private IGtPictureService gtPictureService;

    @GetMapping()
    public String picture()
    {
        return prefix + "/picture";
    }

    /**
     * 查询样式图片列表
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(GtPicture gtPicture)
    {
        startPage();
        List<GtPicture> list = gtPictureService.selectGtPictureList(gtPicture);
        return getDataTable(list);
    }


    /**
     * 查询图片表列表
     */
    @PostMapping("/iconList")
    @ResponseBody
    public TableDataInfo iconList(GtPicture gtPicture)
    {
        startPage();
        List<GtPicture> list = gtPictureService.selectIconPictureList(gtPicture);
        return getDataTable(list);
    }


    /**
     * 导出图片表列表
     */
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(GtPicture gtPicture)
    {
        List<GtPicture> list = gtPictureService.selectGtPictureList(gtPicture);
        ExcelUtil<GtPicture> util = new ExcelUtil<GtPicture>(GtPicture.class);
        return util.exportExcel(list, "picture");
    }

    /**
     * 新增图片表
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存图片表
     */
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(GtPicture gtPicture)
    {
        return toAjax(gtPictureService.insertGtPicture(gtPicture));
    }

    /**
     * 修改图片表
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap)
    {
        GtPicture gtPicture = gtPictureService.selectGtPictureById(id);
        mmap.put("gtPicture", gtPicture);
        return prefix + "/edit";
    }

    /**
     * 修改保存图片表
     */
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(GtPicture gtPicture)
    {
        return toAjax(gtPictureService.updateGtPicture(gtPicture));
    }

    /**
     * 删除图片表
     */
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(gtPictureService.deleteGtPictureByIds(ids));
    }


    @PostMapping("/iconPicture")
    @ResponseBody
    public AjaxResult pointStyle(@RequestParam("file") MultipartFile file,
                                 @RequestParam("name")String iconName,
                                 @RequestParam("geometryType")String geometryType) {
        return gtPictureService.insertIconPicture(file,iconName,geometryType);
    }

}
