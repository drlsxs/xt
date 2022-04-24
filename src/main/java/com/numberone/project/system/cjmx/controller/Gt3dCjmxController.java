package com.numberone.project.system.cjmx.controller;

import java.util.List;

import com.numberone.project.gistools.threeDData.domain.GtThreedData;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.numberone.framework.aspectj.lang.annotation.Log;
import com.numberone.framework.aspectj.lang.enums.BusinessType;
import com.numberone.project.system.cjmx.domain.Gt3dCjmx;
import com.numberone.project.system.cjmx.service.IGt3dCjmxService;
import com.numberone.framework.web.controller.BaseController;
import com.numberone.framework.web.domain.AjaxResult;
import com.numberone.common.utils.poi.ExcelUtil;
import com.numberone.framework.web.page.TableDataInfo;

/**
 * 场景模型Controller
 *
 * @author xskj
 * @date 2022-03-31
 */
@Controller
@RequestMapping("/system/cjmx")
public class Gt3dCjmxController extends BaseController
{
    private String prefix = "system/cjmx";

    @Autowired
    private IGt3dCjmxService gt3dCjmxService;

    @RequiresPermissions("system:cjmx:view")
    @GetMapping()
    public String cjmx()
    {
        return prefix + "/cjmx";
    }

    /**
     * 查询场景模型列表
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Gt3dCjmx gt3dCjmx)
    {
        startPage();
        List<Gt3dCjmx> list = gt3dCjmxService.selectGt3dCjmxList(gt3dCjmx);
        return getDataTable(list);
    }

    /**
     * 导出场景模型列表
     */
    @RequiresPermissions("system:cjmx:export")
    @Log(title = "场景模型", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Gt3dCjmx gt3dCjmx)
    {
        List<Gt3dCjmx> list = gt3dCjmxService.selectGt3dCjmxList(gt3dCjmx);
        ExcelUtil<Gt3dCjmx> util = new ExcelUtil<Gt3dCjmx>(Gt3dCjmx.class);
        return util.exportExcel(list, "cjmx");
    }

    /**
     * 新增场景模型
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存场景模型
     */
    @Log(title = "场景模型", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@RequestBody Gt3dCjmx gt3dCjmx)
    {
    	gt3dCjmx.setId(get32UUID());
        return toAjax(gt3dCjmxService.insertGt3dCjmx(gt3dCjmx));
    }

    /**
     * 修改场景模型
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap)
    {
        Gt3dCjmx gt3dCjmx = gt3dCjmxService.selectGt3dCjmxById(id);
        mmap.put("gt3dCjmx", gt3dCjmx);
        return prefix + "/edit";
    }

    /**
     * 修改保存场景模型
     */
    @Log(title = "场景模型", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@RequestBody Gt3dCjmx gt3dCjmx)
    {
        return toAjax(gt3dCjmxService.updateGt3dCjmx(gt3dCjmx));
    }

    /**
     * 删除场景模型
     */
    @Log(title = "场景模型", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(@RequestBody Gt3dCjmx gt3dCjmx)
    {
        return toAjax(gt3dCjmxService.deleteGt3dCjmxByIds(gt3dCjmx.getId()));
    }

    /**
     * 通过ID获取单个三维点位数据
     */
    @GetMapping( "/getOne/{id}")
    @ResponseBody
    public AjaxResult getOne(@PathVariable("id") String id)
    {
        Gt3dCjmx gt3dCjmx = gt3dCjmxService.selectGt3dCjmxById(id);
        return AjaxResult.success(gt3dCjmx);
    }
}
