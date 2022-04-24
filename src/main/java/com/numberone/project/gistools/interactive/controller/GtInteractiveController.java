package com.numberone.project.gistools.interactive.controller;

import com.numberone.common.utils.poi.ExcelUtil;
import com.numberone.framework.aspectj.lang.enums.BusinessType;
import com.numberone.framework.web.controller.BaseController;
import com.numberone.framework.web.domain.AjaxResult;
import com.numberone.framework.web.page.TableDataInfo;
import com.numberone.project.gistools.interactive.domain.GtInteractive;
import com.numberone.project.gistools.interactive.service.IGtInteractiveService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 数据交互配置Controller
 *
 * @author hwx
 * @date 2022-04-19
 */
@Controller
@RequestMapping("/gistools/interactive")
public class GtInteractiveController extends BaseController
{
    private String prefix = "gistools/interactive";

    @Autowired
    private IGtInteractiveService gtInteractiveService;

    @GetMapping()
    public String interactive()
    {
        return prefix + "/interactive";
    }

    /**
     * 查询数据交互配置列表
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(GtInteractive gtInteractive)
    {
        startPage();
        List<GtInteractive> list = gtInteractiveService.selectGtInteractiveList(gtInteractive);
        return getDataTable(list);
    }

    /**
     * 导出数据交互配置列表
     */
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(GtInteractive gtInteractive)
    {
        List<GtInteractive> list = gtInteractiveService.selectGtInteractiveList(gtInteractive);
        ExcelUtil<GtInteractive> util = new ExcelUtil<GtInteractive>(GtInteractive.class);
        return util.exportExcel(list, "interactive");
    }

    /**
     * 新增数据交互配置
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存数据交互配置
     */
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(GtInteractive gtInteractive)
    {
        return toAjax(gtInteractiveService.insertGtInteractive(gtInteractive));
    }

    /**
     * 修改数据交互配置
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap)
    {
        GtInteractive gtInteractive = gtInteractiveService.selectGtInteractiveById(id);
        mmap.put("gtInteractive", gtInteractive);
        return prefix + "/edit";
    }

    /**
     * 修改保存数据交互配置
     */
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(GtInteractive gtInteractive)
    {
        return toAjax(gtInteractiveService.updateGtInteractive(gtInteractive));
    }

    /**
     * 删除数据交互配置
     */
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(gtInteractiveService.deleteGtInteractiveByIds(ids));
    }

    /**
     * 删除数据交互配置
     */
    @GetMapping( "/getOne/{id}")
    @ResponseBody
    public AjaxResult getOne(@PathVariable("id") String id)
    {
        GtInteractive gtInteractive = gtInteractiveService.selectGtInteractiveById(id);
        return AjaxResult.success(gtInteractive);
    }
}
