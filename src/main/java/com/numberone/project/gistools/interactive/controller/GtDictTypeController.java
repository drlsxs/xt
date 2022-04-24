package com.numberone.project.gistools.interactive.controller;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.numberone.common.utils.poi.ExcelUtil;
import com.numberone.common.utils.text.Convert;
import com.numberone.framework.aspectj.lang.enums.BusinessType;
import com.numberone.framework.web.controller.BaseController;
import com.numberone.framework.web.domain.AjaxResult;
import com.numberone.framework.web.page.TableDataInfo;
import com.numberone.project.gistools.interactive.domain.GtDictData;
import com.numberone.project.gistools.interactive.domain.GtDictType;
import com.numberone.project.gistools.interactive.service.IGtDictDataService;
import com.numberone.project.gistools.interactive.service.IGtDictTypeService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 字典表Controller
 *
 * @author hwx
 * @date 2022-04-19
 */
@Controller
@RequestMapping("/gistools/dicttype")
public class GtDictTypeController extends BaseController
{
    private String prefix = "gistools/type";

    @Autowired
    private IGtDictTypeService gtDictTypeService;
    @Autowired
    private IGtDictDataService gtDictDataService;

    @GetMapping()
    public String type()
    {
        return prefix + "/type";
    }

    /**
     * 查询字典表列表
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(GtDictType gtDictType)
    {
        startPage();
        List<GtDictType> list = gtDictTypeService.selectGtDictTypeList(gtDictType);
        return getDataTable(list);
    }

    /**
     * 导出字典表列表
     */
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(GtDictType gtDictType)
    {
        List<GtDictType> list = gtDictTypeService.selectGtDictTypeList(gtDictType);
        ExcelUtil<GtDictType> util = new ExcelUtil<GtDictType>(GtDictType.class);
        return util.exportExcel(list, "type");
    }

    /**
     * 新增字典表
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存字典表
     */
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(GtDictType gtDictType)
    {
        return toAjax(gtDictTypeService.insertGtDictType(gtDictType));
    }

    /**
     * 修改字典表
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap)
    {
        GtDictType gtDictType = gtDictTypeService.selectGtDictTypeById(id);
        mmap.put("gtDictType", gtDictType);
        return prefix + "/edit";
    }

    /**
     * 修改保存字典表
     */
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@RequestBody GtDictType gtDictType)
    {
        gtDictTypeService.updateGtDictType(gtDictType);
        //通过id删除子表中的数据
        String id = gtDictType.getId();
        String[] s = new String[1];
        s[0] = id;
        gtDictDataService.deleteGtDictDataByTypeIds(s);

        List<GtDictData> dictDataList = gtDictType.getDictDataList();
        if (dictDataList!=null && dictDataList.size()>0){
            for (GtDictData g:dictDataList) {
                g.setDictTypeId(gtDictType.getId());
                g.setId(IdWorker.get32UUID());
                gtDictDataService.insertGtDictData(g);
            }
        }

        return AjaxResult.success();
    }

    /**
     * 删除字典表
     */
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        String[] strings = Convert.toStrArray(ids);
        gtDictDataService.deleteGtDictDataByTypeIds(strings);
        return toAjax(gtDictTypeService.deleteGtDictTypeByIds(ids));
    }

    /**
     * 新增数据
     */
    @PostMapping( "/addDict")
    @ResponseBody
    public AjaxResult addDict(@RequestBody GtDictType gtDictType)
    {
        String resourceId = gtDictType.getResourceId();
        if (StringUtils.isNotEmpty(resourceId)){
            List<GtDictType> listByResourceId = gtDictTypeService.getListByResourceId(resourceId);
            for (GtDictType g:listByResourceId) {
                if (gtDictType.getFieldName().equals(g.getFieldName())){
                    return AjaxResult.error("数据重复，添加失败");
                }
            }
        }
        List<GtDictData> dictDataList = gtDictType.getDictDataList();
        String uuid = IdWorker.get32UUID();
        gtDictType.setId(uuid);
        gtDictTypeService.insertGtDictType(gtDictType);
        if (dictDataList!=null && dictDataList.size()>0){
            for (GtDictData g :dictDataList) {
                g.setId(IdWorker.get32UUID());
                g.setDictTypeId(uuid);
                gtDictDataService.insertGtDictData(g);
            }
        }
        return AjaxResult.success();
    }

    /**
     * 获取单个字典数据
     */
    @GetMapping( "/getOne/{id}")
    @ResponseBody
    public AjaxResult getOne(@PathVariable("id") String id)
    {
        GtDictType gtDictType = gtDictTypeService.selectGtDictTypeById(id);
        List<GtDictData> gtDictData = gtDictDataService.selectDictDataListByTypeId(id);
        if (gtDictData!=null && gtDictData.size()>0){
            gtDictType.setDictDataList(gtDictData);
        }
        return AjaxResult.success(gtDictType);
    }

    /**
     * 获取存储的别名数据
     */
    @GetMapping( "/getListByResourceId/{resourceId}")
    @ResponseBody
    public AjaxResult getListByResourceId(@PathVariable("resourceId") String resourceId)
    {
        List<GtDictType> listByResourceId = gtDictTypeService.getListByResourceId(resourceId);
        return AjaxResult.success(listByResourceId);
    }
}
