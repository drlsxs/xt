package com.numberone.project.gistools.resource.controller;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.numberone.framework.aspectj.lang.annotation.Log;
import com.numberone.framework.aspectj.lang.enums.BusinessType;
import com.numberone.project.gistools.resource.domain.Resource;
import com.numberone.project.gistools.resource.service.IResourceService;
import com.numberone.framework.web.controller.BaseController;
import com.numberone.framework.web.domain.AjaxResult;
import com.numberone.common.utils.poi.ExcelUtil;
import com.numberone.framework.web.page.TableDataInfo;

/**
 * resourceController
 *
 * @author wly
 * @date 2022-03-30
 */
@Controller
@RequestMapping("/gistools/resource")
public class ResourceController extends BaseController
{
    private String prefix = "resource/resource";

    @Autowired
    private IResourceService resourceService;

//    @RequiresPermissions("resource:resource:view")
    @GetMapping()
    public String resource()
    {
        return prefix + "/resource";
    }

    /**
     * 查询resource列表
     */
//    @RequiresPermissions("resource:resource:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Resource resource)
    {
        startPage();
        List<Resource> list = resourceService.selectResourceList(resource);
        return getDataTable(list);
    }

    /**
     * 导出resource列表
     */
//    @RequiresPermissions("resource:resource:export")
    @Log(title = "resource", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Resource resource)
    {
        List<Resource> list = resourceService.selectResourceList(resource);
        ExcelUtil<Resource> util = new ExcelUtil<Resource>(Resource.class);
        return util.exportExcel(list, "resource");
    }

    /**
     * 新增resource
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存resource
     */
//    @RequiresPermissions("resource:resource:add")
    @Log(title = "resource", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@RequestBody Resource resource)
    {
        resource.setId(get32UUID());
        return toAjax(resourceService.insertResource(resource));
    }

    /**
     * 修改resource
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap)
    {
        Resource resource = resourceService.selectResourceById(id);
        mmap.put("resource", resource);
        return prefix + "/edit";
    }

    /**
     * 修改保存resource
     */
//    @RequiresPermissions("resource:resource:edit")
    @Log(title = "resource", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@RequestBody Resource resource)
    {
        return toAjax(resourceService.updateResource(resource));
    }

    /**
     * 删除resource
     */
//    @RequiresPermissions("resource:resource:remove")
    @Log(title = "resource", businessType = BusinessType.DELETE)
    @GetMapping( "/remove/{ids}")
    @ResponseBody
    public AjaxResult remove(@PathVariable String ids)
    {
        return toAjax(resourceService.deleteResourceByIds(ids));
    }
}
