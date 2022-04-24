package com.numberone.project.gistools.interactive.controller;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.numberone.common.utils.poi.ExcelUtil;
import com.numberone.framework.aspectj.lang.enums.BusinessType;
import com.numberone.framework.web.controller.BaseController;
import com.numberone.framework.web.domain.AjaxResult;
import com.numberone.framework.web.page.TableDataInfo;
import com.numberone.project.gistools.interactive.domain.GtMasterSlave;
import com.numberone.project.gistools.interactive.service.IGtMasterSlaveService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 主从表Controller
 *
 * @author hwx
 * @date 2022-04-20
 */
@Controller
@RequestMapping("/gistools/slave")
public class GtMasterSlaveController extends BaseController
{
    private String prefix = "gistools/slave";

    @Autowired
    private IGtMasterSlaveService gtMasterSlaveService;

    @GetMapping()
    public String slave()
    {
        return prefix + "/slave";
    }

    /**
     * 查询主从表列表
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(GtMasterSlave gtMasterSlave)
    {
        startPage();
        List<GtMasterSlave> list = gtMasterSlaveService.selectGtMasterSlaveList(gtMasterSlave);
        return getDataTable(list);
    }

    /**
     * 导出主从表列表
     */
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(GtMasterSlave gtMasterSlave)
    {
        List<GtMasterSlave> list = gtMasterSlaveService.selectGtMasterSlaveList(gtMasterSlave);
        ExcelUtil<GtMasterSlave> util = new ExcelUtil<GtMasterSlave>(GtMasterSlave.class);
        return util.exportExcel(list, "slave");
    }

    /**
     * 新增主从表
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存主从表
     */
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(GtMasterSlave gtMasterSlave)
    {
        gtMasterSlave.setId(IdWorker.get32UUID());
        return toAjax(gtMasterSlaveService.insertGtMasterSlave(gtMasterSlave));
    }

    /**
     * 修改主从表
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap)
    {
        GtMasterSlave gtMasterSlave = gtMasterSlaveService.selectGtMasterSlaveById(id);
        mmap.put("gtMasterSlave", gtMasterSlave);
        return prefix + "/edit";
    }

    /**
     * 修改保存主从表
     */
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(GtMasterSlave gtMasterSlave)
    {
        return toAjax(gtMasterSlaveService.updateGtMasterSlave(gtMasterSlave));
    }

    /**
     * 删除主从表
     */
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(gtMasterSlaveService.deleteGtMasterSlaveByIds(ids));
    }

    /**
     * 通过表名获取字段信息
     */
    @GetMapping( "/getFieldByTableName/{tableName}")
    @ResponseBody
    public AjaxResult getFieldByTableName(@PathVariable("tableName") String tableName)
    {
        List<String> fieldByTableName = gtMasterSlaveService.getFieldByTableName(tableName);
        return AjaxResult.success(fieldByTableName);
    }


    /**
     * 通过表名从表表名
     */
    @GetMapping( "/getSlaveByTableName/{tableName}")
    @ResponseBody
    public AjaxResult getSlaveByTableName(@PathVariable("tableName") String tableName)
    {
        List<String> fieldByTableName = gtMasterSlaveService.getSlaveByTableName(tableName);
        return AjaxResult.success(fieldByTableName);
    }
}
