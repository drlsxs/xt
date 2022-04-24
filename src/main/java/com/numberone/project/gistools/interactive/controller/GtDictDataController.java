package com.numberone.project.gistools.interactive.controller;

import com.numberone.common.utils.poi.ExcelUtil;
import com.numberone.framework.aspectj.lang.enums.BusinessType;
import com.numberone.framework.web.controller.BaseController;
import com.numberone.framework.web.domain.AjaxResult;
import com.numberone.framework.web.page.TableDataInfo;
import com.numberone.project.gistools.interactive.domain.GtDictData;
import com.numberone.project.gistools.interactive.service.IGtDictDataService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 字典详情Controller
 *
 * @author hwx
 * @date 2022-04-19
 */
@Controller
@RequestMapping("/gistools/dictdata")
public class GtDictDataController extends BaseController
{
    private String prefix = "gistools/data";

    @Autowired
    private IGtDictDataService gtDictDataService;

    @GetMapping()
    public String data()
    {
        return prefix + "/data";
    }

    /**
     * 查询字典详情列表
     */
    @ResponseBody
    public TableDataInfo list(GtDictData gtDictData)
    {
        startPage();
        List<GtDictData> list = gtDictDataService.selectGtDictDataList(gtDictData);
        return getDataTable(list);
    }

    /**
     * 导出字典详情列表
     */
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(GtDictData gtDictData)
    {
        List<GtDictData> list = gtDictDataService.selectGtDictDataList(gtDictData);
        ExcelUtil<GtDictData> util = new ExcelUtil<GtDictData>(GtDictData.class);
        return util.exportExcel(list, "data");
    }

    /**
     * 新增字典详情
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存字典详情
     */
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(GtDictData gtDictData)
    {
        return toAjax(gtDictDataService.insertGtDictData(gtDictData));
    }

    /**
     * 修改字典详情
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap)
    {
        GtDictData gtDictData = gtDictDataService.selectGtDictDataById(id);
        mmap.put("gtDictData", gtDictData);
        return prefix + "/edit";
    }

    /**
     * 修改保存字典详情
     */
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(GtDictData gtDictData)
    {
        return toAjax(gtDictDataService.updateGtDictData(gtDictData));
    }

    /**
     * 删除字典详情
     */
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(gtDictDataService.deleteGtDictDataByIds(ids));
    }
}
