package com.numberone.project.gistools.richtext.controller;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.numberone.common.utils.poi.ExcelUtil;
import com.numberone.framework.aspectj.lang.annotation.Log;
import com.numberone.framework.aspectj.lang.enums.BusinessType;
import com.numberone.framework.web.controller.BaseController;
import com.numberone.framework.web.domain.AjaxResult;
import com.numberone.framework.web.page.TableDataInfo;
import com.numberone.project.gistools.richtext.domain.GtRichtext;
import com.numberone.project.gistools.richtext.service.IGtRichtextService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * 富文本Controller
 *
 * @author hwx
 * @date 2022-03-31
 */
@Controller
@RequestMapping("/gistools/richtext")
public class GtRichtextController extends BaseController
{
    private String prefix = "system/richtext";

    @Autowired
    private IGtRichtextService gtRichtextService;

//    @RequiresPermissions("system:richtext:view")
    @GetMapping()
    public String richtext()
    {
        return prefix + "/richtext";
    }

    /**
     * 查询富文本列表
     */
//    @RequiresPermissions("system:richtext:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(@RequestBody GtRichtext gtRichtext)
    {
        startPage();
        List<GtRichtext> list = gtRichtextService.selectGtRichtextList(gtRichtext);
        return getDataTable(list);
    }

    /**
     * 通过id查询富文本信息
     */
    @GetMapping("/selectById/{id}")
    @ResponseBody
    public AjaxResult selectById(@PathVariable("id")String id)
    {
        GtRichtext richtext = gtRichtextService.selectGtRichtextById(id);
        return AjaxResult.success(richtext);
    }


    /**
     * 导出富文本列表
     */
//    @RequiresPermissions("system:richtext:export")
    @Log(title = "富文本", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(@RequestBody GtRichtext gtRichtext)
    {
        List<GtRichtext> list = gtRichtextService.selectGtRichtextList(gtRichtext);
        ExcelUtil<GtRichtext> util = new ExcelUtil<GtRichtext>(GtRichtext.class);
        return util.exportExcel(list, "richtext");
    }

    /**
     * 新增富文本
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存富文本
     */
//    @RequiresPermissions("system:richtext:add")
    @Log(title = "富文本", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@RequestBody GtRichtext gtRichtext)
    {
        System.out.println(gtRichtext);
        gtRichtext.setId(IdWorker.get32UUID());
        return toAjax(gtRichtextService.insertGtRichtext(gtRichtext));
    }

    /**
     * 修改富文本
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap)
    {
        GtRichtext gtRichtext = gtRichtextService.selectGtRichtextById(id);
        mmap.put("gtRichtext", gtRichtext);
        return prefix + "/edit";
    }

    /**
     * 修改保存富文本
     */
//    @RequiresPermissions("system:richtext:edit")
    @Log(title = "富文本", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@RequestBody GtRichtext gtRichtext)
    {
        gtRichtext.setUpdateTime(new Date());
        return toAjax(gtRichtextService.updateGtRichtext(gtRichtext));
    }

    /**
     * 删除富文本
     */
//    @RequiresPermissions("system:richtext:remove")
    @Log(title = "富文本", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(gtRichtextService.deleteGtRichtextByIds(ids));
    }
}
