package com.numberone.project.gistools.wms.controller;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.numberone.framework.aspectj.lang.annotation.Log;
import com.numberone.framework.aspectj.lang.enums.BusinessType;
import com.numberone.project.gistools.wms.domain.Wms;
import com.numberone.project.gistools.wms.service.IWmsService;
import com.numberone.framework.web.controller.BaseController;
import com.numberone.framework.web.domain.AjaxResult;
import com.numberone.common.utils.poi.ExcelUtil;
import com.numberone.framework.web.page.TableDataInfo;

/**
 * wmsController
 *
 * @author wly
 * @date 2022-03-29
 */
@Controller
@RequestMapping("/gistools/wms")
public class WmsController extends BaseController
{
    private String prefix = "gistools/wms";

    @Autowired
    private IWmsService wmsService;

//    @RequiresPermissions("gistools:wms:view")
    @GetMapping()
    public String wms()
    {
        return prefix + "/wms";
    }

    /**
     * 查询wms列表
     */
//    @RequiresPermissions("gistools:wms:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Wms wms)
    {
        startPage();
        List<Wms> list = wmsService.selectWmsList(wms);
        return getDataTable(list);
    }

    /**
     * 导出wms列表
     */
//    @RequiresPermissions("gistools:wms:export")
    @Log(title = "wms", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Wms wms)
    {
        List<Wms> list = wmsService.selectWmsList(wms);
        ExcelUtil<Wms> util = new ExcelUtil<Wms>(Wms.class);
        return util.exportExcel(list, "wms");
    }

    /**
     * 新增wms
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存wms
     */
//    @RequiresPermissions("gistools:wms:add")
    @Log(title = "wms", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@RequestBody Wms wms)
    {
        wms.setWmsId(get32UUID());
        return toAjax(wmsService.insertWms(wms));
    }

    /**
     * 修改wms
     */
    @GetMapping("/edit/{wmsId}")
    public String edit(@PathVariable("wmsId") String wmsId, ModelMap mmap)
    {
        Wms wms = wmsService.selectWmsById(wmsId);
        mmap.put("wms", wms);
        return prefix + "/edit";
    }

    /**
     * 修改保存wms
     */
//    @RequiresPermissions("gistools:wms:edit")
    @Log(title = "wms", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@RequestBody Wms wms)
    {
        return toAjax(wmsService.updateWms(wms));
    }

    /**
     * 删除wms
     */
//    @RequiresPermissions("gistools:wms:remove")
    @Log(title = "wms", businessType = BusinessType.DELETE)
    @GetMapping( "/remove/{ids}")
    @ResponseBody
    public AjaxResult remove(@PathVariable String ids)
    {
        System.out.println(ids);
        return toAjax(wmsService.deleteWmsByIds(ids));
    }

    @PostMapping("/styleToNull")
    @ResponseBody
    public AjaxResult styleToNull(@RequestBody Wms wms){
        wmsService.styleToNull(wms.getWmsId());
        return AjaxResult.success();
    }
}
