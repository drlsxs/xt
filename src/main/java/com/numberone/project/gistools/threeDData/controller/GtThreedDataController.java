package com.numberone.project.gistools.threeDData.controller;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.numberone.common.utils.poi.ExcelUtil;
import com.numberone.framework.web.controller.BaseController;
import com.numberone.framework.web.domain.AjaxResult;
import com.numberone.framework.web.page.TableDataInfo;
import com.numberone.project.gistools.threeDData.domain.GtThreedData;
import com.numberone.project.gistools.threeDData.service.IGtThreedDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 三维点位数据Controller
 *
 * @author hwx
 * @date 2022-04-18
 */
@Controller
@RequestMapping("/gistools/threeData")
public class GtThreedDataController extends BaseController
{
    private String prefix = "system/data";


    @Autowired
    private IGtThreedDataService gt3dDataService;


    public String data()
    {
        return prefix + "/data";
    }


    /**
     * 查询三维点位数据列表
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(GtThreedData gt3dData)
    {
        startPage();
        List<GtThreedData> list = gt3dDataService.selectGt3dDataList(gt3dData);
        return getDataTable(list);
    }

    /**
     * 导出三维点位数据列表
     */
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(GtThreedData gt3dData)
    {
        List<GtThreedData> list = gt3dDataService.selectGt3dDataList(gt3dData);
        ExcelUtil<GtThreedData> util = new ExcelUtil<GtThreedData>(GtThreedData.class);
        return util.exportExcel(list, "data");
    }

    /**
     * 新增三维点位数据
     *
     */




    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存三维点位数据
     */
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(GtThreedData gt3dData)
    {
        gt3dData.setId(IdWorker.get32UUID());
        return toAjax(gt3dDataService.insertGt3dData(gt3dData));
    }

    /**
     * 修改三维点位数据
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap)
    {
        GtThreedData gt3dData = gt3dDataService.selectGt3dDataById(id);
        mmap.put("gt3dData", gt3dData);
        return prefix + "/edit";
    }

    /**
     * 修改保存三维点位数据
     */
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(GtThreedData gt3dData)
    {
        return toAjax(gt3dDataService.updateGt3dData(gt3dData));
    }

    /**
     * 删除三维点位数据
     */
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(gt3dDataService.deleteGt3dDataByIds(ids));
    }

    /**
     * 通过ID获取单个三维点位数据
     */
    @GetMapping( "/getOne/{id}")
    @ResponseBody
    public AjaxResult getOne(@PathVariable("id") String id)
    {
        GtThreedData gtThreedData = gt3dDataService.selectGt3dDataById(id);
        return AjaxResult.success(gtThreedData);
    }
}
