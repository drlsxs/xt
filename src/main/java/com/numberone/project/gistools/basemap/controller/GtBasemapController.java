package com.numberone.project.gistools.basemap.controller;

import java.util.List;

import com.numberone.framework.web.page.TableDataInfo;
import com.numberone.project.gistools.basemap.domain.GtBasemap;
import com.numberone.project.gistools.basemap.service.IGtBasemapService;
import com.numberone.project.gistools.config.domain.GtConfig;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.numberone.framework.aspectj.lang.annotation.Log;
import com.numberone.framework.aspectj.lang.enums.BusinessType;
import com.numberone.framework.web.controller.BaseController;
import com.numberone.framework.web.domain.AjaxResult;
import com.numberone.common.utils.poi.ExcelUtil;

/**
 * Controller
 * 
 * @author xskj
 * @date 2022-03-30
 */
@Controller
@RequestMapping("/gistools/basemap")
public class GtBasemapController extends BaseController
{
    private String prefix = "gistools/basemap";

    @Autowired
    private IGtBasemapService gtBasemapService;

    @RequiresPermissions("gistools:basemap:view")
    @GetMapping()
    public String basemap()
    {
        return prefix + "/basemap";
    }

    /**
     * 查询配置列表
     */
//    @RequiresPermissions("gistools:basemap:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(@RequestBody GtBasemap gtBasemap)
    {
        startPage();
        //System.out.println(gtBasemap);
        List<GtBasemap> list = gtBasemapService.selectGtBasemapList(gtBasemap);
        return getDataTable(list);
    }

    /**
     * 导出列表
     */
    @RequiresPermissions("gistools:basemap:export")
    @Log(title = "导出", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(GtBasemap gtBasemap)
    {
        List<GtBasemap> list = gtBasemapService.selectGtBasemapList(gtBasemap);
        ExcelUtil<GtBasemap> util = new ExcelUtil<GtBasemap>(GtBasemap.class);
        return util.exportExcel(list, "basemap");
    }


    /**
     * 新增保存
     */
//    @RequiresPermissions("gistools:basemap:add")
    @Log(title = "新增", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@RequestBody GtBasemap gtBasemap)
    {
        return toAjax(gtBasemapService.insertGtBasemap(gtBasemap));
    }

    /**
     * 修改
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap)
    {
        GtBasemap gtBasemap = gtBasemapService.selectGtBasemapById(id);
        mmap.put("gtBasemap", gtBasemap);
        return prefix + "/edit";
    }

    /**
     * 修改保存
     */
    //@RequiresPermissions("gistools:basemap:edit")
    @Log(title = "修改保存", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@RequestBody GtBasemap gtBasemap)
    {
        return toAjax(gtBasemapService.updateGtBasemap(gtBasemap));
    }

    /**
     * 删除配置
     */
    //@RequiresPermissions("gistools:basemap:remove")
    @Log(title = "配置", businessType = BusinessType.DELETE)
    @GetMapping( "/remove/{ids}")
    @ResponseBody
    public AjaxResult remove(@PathVariable("ids") String ids)
    {
        System.out.println(ids);
        return toAjax(gtBasemapService.deleteGtBasemapByIds(ids));
    }

}
