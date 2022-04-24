package com.numberone.project.gistools.basemap.controller;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.numberone.common.utils.poi.ExcelUtil;
import com.numberone.framework.aspectj.lang.enums.BusinessType;
import com.numberone.framework.web.controller.BaseController;
import com.numberone.framework.web.domain.AjaxResult;
import com.numberone.framework.web.page.TableDataInfo;
import com.numberone.project.gistools.basemap.domain.GtBasemap;
import com.numberone.project.gistools.basemap.domain.GtBasemapGroup;
import com.numberone.project.gistools.basemap.service.IGtBasemapGroupService;
import com.numberone.project.gistools.basemap.service.IGtBasemapService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 底图组Controller
 *
 * @author hwx
 * @date 2022-04-22
 */
@Controller
@RequestMapping("/gistools/basemapGroup")
public class GtBasemapGroupController extends BaseController
{
    private String prefix = "gistools/basemapGroup";

    @Autowired
    private IGtBasemapGroupService gtBasemapGroupService;
    @Autowired
    private IGtBasemapService gtBasemapService;

    @GetMapping()
    public String group()
    {
        return prefix + "/group";
    }

    /**
     * 查询底图组列表
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(GtBasemapGroup gtBasemapGroup)
    {
        startPage();
        List<GtBasemapGroup> list = gtBasemapGroupService.selectGtBasemapGroupList(gtBasemapGroup);
        for (GtBasemapGroup g:list) {
            List<GtBasemap> basemapList = new ArrayList<>();
            String baseIds = g.getBaseIds();
            if (StringUtils.isNotEmpty(baseIds)){
                String[] ids = baseIds.split(",");
                for (String id:ids) {
                    basemapList.add(gtBasemapService.selectGtBasemapById(id));
                }
                g.setBasemapList(basemapList);
            }
        }
        return getDataTable(list);
    }

    /**
     * 导出底图组列表
     */
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(GtBasemapGroup gtBasemapGroup)
    {
        List<GtBasemapGroup> list = gtBasemapGroupService.selectGtBasemapGroupList(gtBasemapGroup);
        ExcelUtil<GtBasemapGroup> util = new ExcelUtil<GtBasemapGroup>(GtBasemapGroup.class);
        return util.exportExcel(list, "group");
    }

    /**
     * 新增底图组
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存底图组
     */
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(GtBasemapGroup gtBasemapGroup)
    {
        gtBasemapGroup.setId(IdWorker.get32UUID());
        return toAjax(gtBasemapGroupService.insertGtBasemapGroup(gtBasemapGroup));
    }

    /**
     * 修改底图组
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap)
    {
        GtBasemapGroup gtBasemapGroup = gtBasemapGroupService.selectGtBasemapGroupById(id);
        mmap.put("gtBasemapGroup", gtBasemapGroup);
        return prefix + "/edit";
    }

    /**
     * 修改保存底图组
     */
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(GtBasemapGroup gtBasemapGroup)
    {
        return toAjax(gtBasemapGroupService.updateGtBasemapGroup(gtBasemapGroup));
    }

    /**
     * 删除底图组
     */
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(gtBasemapGroupService.deleteGtBasemapGroupByIds(ids));
    }
}
