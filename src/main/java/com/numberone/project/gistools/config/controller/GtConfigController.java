package com.numberone.project.gistools.config.controller;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.numberone.framework.aspectj.lang.annotation.Log;
import com.numberone.framework.aspectj.lang.enums.BusinessType;
import com.numberone.project.gistools.config.domain.GtConfig;
import com.numberone.project.gistools.config.service.IGtConfigService;
import com.numberone.framework.web.controller.BaseController;
import com.numberone.framework.web.domain.AjaxResult;
import com.numberone.common.utils.poi.ExcelUtil;
import com.numberone.framework.web.page.TableDataInfo;

/**
 * 配置Controller
 * 
 * @author wyl
 * @date 2021-10-07
 */
@Controller
@RequestMapping("/gistools/config")
public class GtConfigController extends BaseController
{
    private String prefix = "gistools/config";

    @Autowired
    private IGtConfigService gtConfigService;

    @RequiresPermissions("gistools:config:view")
    @GetMapping()
    public String config()
    {
        return prefix + "/config";
    }

    /**
     * 查询配置列表
     */
    @RequiresPermissions("gistools:config:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(GtConfig gtConfig)
    {
        startPage();
        List<GtConfig> list = gtConfigService.selectGtConfigList(gtConfig);
        return getDataTable(list);
    }

    /**
     * 导出配置列表
     */
    @RequiresPermissions("gistools:config:export")
    @Log(title = "配置", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(GtConfig gtConfig)
    {
        List<GtConfig> list = gtConfigService.selectGtConfigList(gtConfig);
        ExcelUtil<GtConfig> util = new ExcelUtil<GtConfig>(GtConfig.class);
        return util.exportExcel(list, "config");
    }

    /**
     * 新增配置
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存配置
     */
    @RequiresPermissions("gistools:config:add")
    @Log(title = "配置", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(GtConfig gtConfig)
    {
    	gtConfig.setId(get32UUID());
        return toAjax(gtConfigService.insertGtConfig(gtConfig));
    }

    /**
     * 修改配置
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap)
    {
        GtConfig gtConfig = gtConfigService.selectGtConfigById(id);
        mmap.put("gtConfig", gtConfig);
        return prefix + "/edit";
    }

    /**
     * 修改保存配置
     */
    @RequiresPermissions("gistools:config:edit")
    @Log(title = "配置", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(GtConfig gtConfig)
    {
        return toAjax(gtConfigService.updateGtConfig(gtConfig));
    }

    /**
     * 删除配置
     */
    @RequiresPermissions("gistools:config:remove")
    @Log(title = "配置", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(gtConfigService.deleteGtConfigByIds(ids));
    }
}
