package com.numberone.project.gistools.twoDData.controller;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.numberone.common.utils.poi.ExcelUtil;
import com.numberone.framework.aspectj.lang.enums.BusinessType;
import com.numberone.framework.web.controller.BaseController;
import com.numberone.framework.web.domain.AjaxResult;
import com.numberone.framework.web.page.TableDataInfo;
import com.numberone.project.gistools.resource.domain.Resource;
import com.numberone.project.gistools.resource.service.IResourceService;
import com.numberone.project.gistools.twoDData.domain.GtTwodData;
import com.numberone.project.gistools.twoDData.service.IGtTwodDataService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * GtTwodDataController
 *
 * @author hwx
 * @date 2022-04-21
 */
@Controller
@RequestMapping("/gistools/twoData")
public class GtTwodDataController extends BaseController
{
    private String prefix = "gistools/data";

    @Autowired
    private IGtTwodDataService gtTwodDataService;
    @Autowired
    private IResourceService resourceService;

    @GetMapping()
    public String data()
    {
        return prefix + "/data";
    }

    /**
     * 查询GtTwodData列表
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(GtTwodData gtTwodData)
    {
        startPage();
        List<GtTwodData> list = gtTwodDataService.selectGtTwodDataList(gtTwodData);
        for (GtTwodData g:list) {
            String dataId = g.getDataId();
            if (StringUtils.isNotEmpty(dataId)){
                Resource resource = resourceService.selectResourceById(dataId);
                String url = resource.getUrl();
                g.setUrl(url);
            }
        }
        return getDataTable(list);
    }

    /**
     * 导出GtTwodData列表
     */
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(GtTwodData gtTwodData)
    {
        List<GtTwodData> list = gtTwodDataService.selectGtTwodDataList(gtTwodData);
        ExcelUtil<GtTwodData> util = new ExcelUtil<GtTwodData>(GtTwodData.class);
        return util.exportExcel(list, "data");
    }

    /**
     * 新增GtTwodData
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存GtTwodData
     */
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(GtTwodData gtTwodData)
    {
        gtTwodData.setId(IdWorker.get32UUID());
        return toAjax(gtTwodDataService.insertGtTwodData(gtTwodData));
    }

    /**
     * 修改GtTwodData
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap)
    {
        GtTwodData gtTwodData = gtTwodDataService.selectGtTwodDataById(id);
        mmap.put("gtTwodData", gtTwodData);
        return prefix + "/edit";
    }

    /**
     * 修改保存GtTwodData
     */
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(GtTwodData gtTwodData)
    {
        return toAjax(gtTwodDataService.updateGtTwodData(gtTwodData));
    }

    /**
     * 删除GtTwodData
     */
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(gtTwodDataService.deleteGtTwodDataByIds(ids));
    }
}
