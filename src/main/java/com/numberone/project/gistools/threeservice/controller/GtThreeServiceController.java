package com.numberone.project.gistools.threeservice.controller;

import java.io.File;
import java.util.ArrayList;
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
import com.numberone.project.gistools.threeservice.domain.GtThreeService;
import com.numberone.project.gistools.threeservice.service.IGtThreeServiceService;

import com.numberone.framework.web.controller.BaseController;
import com.numberone.framework.web.domain.AjaxResult;
import com.numberone.framework.web.domain.ZtreeFile;
import com.numberone.common.utils.poi.ExcelUtil;
import com.numberone.framework.web.page.TableDataInfo;

/**
 * 三维数据服务Controller
 * 
 * @author wyl
 * @date 2021-10-04
 */
@Controller
@RequestMapping("/gistools/threeservice")
public class GtThreeServiceController extends BaseController
{
    private String prefix = "gistools/threeservice";

    @Autowired
    private IGtThreeServiceService gtThreeServiceService;    

    @Autowired
    private IGtConfigService gtConfigService;

    @RequiresPermissions("gistools:threeservice:view")
    @GetMapping()
    public String threeservice()
    {
        return prefix + "/threeservice";
    }

    /**
     * 查询三维数据服务列表
     */
    @RequiresPermissions("gistools:threeservice:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(GtThreeService gtThreeService)
    {
        startPage();
        List<GtThreeService> list = gtThreeServiceService.selectGtThreeServiceList(gtThreeService);
        return getDataTable(list);
    }

    /**
     * 导出三维数据服务列表
     */
    @RequiresPermissions("gistools:threeservice:export")
    @Log(title = "三维数据服务", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(GtThreeService gtThreeService)
    {
        List<GtThreeService> list = gtThreeServiceService.selectGtThreeServiceList(gtThreeService);
        ExcelUtil<GtThreeService> util = new ExcelUtil<GtThreeService>(GtThreeService.class);
        return util.exportExcel(list, "threeservice");
    }

    /**
     * 新增三维数据服务
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存三维数据服务
     */
    @RequiresPermissions("gistools:threeservice:add")
    @Log(title = "三维数据服务", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(GtThreeService gtThreeService)
    {
    	gtThreeService.setId(get32UUID());
    	gtThreeService.setStatu("00");
        return toAjax(gtThreeServiceService.insertGtThreeService(gtThreeService));
    }

    /**
     * 修改三维数据服务
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap)
    {
        GtThreeService gtThreeService = gtThreeServiceService.selectGtThreeServiceById(id);
        mmap.put("gtThreeService", gtThreeService);
        return prefix + "/edit";
    }

    /**
     * 修改保存三维数据服务
     */
    @RequiresPermissions("gistools:threeservice:edit")
    @Log(title = "三维数据服务", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(GtThreeService gtThreeService)
    {
        return toAjax(gtThreeServiceService.updateGtThreeService(gtThreeService));
    }

    /**
     * 删除三维数据服务
     */
    @RequiresPermissions("gistools:threeservice:remove")
    @Log(title = "三维数据服务", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(gtThreeServiceService.deleteGtThreeServiceByIds(ids));
    }
    
    /**
     * 发布服务
     */
    @RequiresPermissions("gistools:threeservice:edit")
    @Log(title = "发布服务", businessType = BusinessType.UPDATE)
    @PostMapping("/publish")
    @ResponseBody
    public AjaxResult publish(GtThreeService gt)
    {
    	GtConfig config = gtConfigService.selectGtConfigNow();
    	GtThreeService gtThreeService = gtThreeServiceService.selectGtThreeServiceById(gt.getId());
    	String gurl=config.getItem2()+"/threeds/tileset/"+gtThreeService.getId()+"/tile.json";   	
    	gtThreeService.setStatu("01");
    	gtThreeService.setSurl(gurl);
    	gtThreeService.setFtype("3DTiles");
        return toAjax(gtThreeServiceService.updateGtThreeService(gtThreeService));
    }
    
    /**
     * 停止服务
     */
    @RequiresPermissions("gistools:threeservice:edit")
    @Log(title = "停止服务", businessType = BusinessType.UPDATE)
    @PostMapping("/unpublish")
    @ResponseBody
    public AjaxResult unpublish(GtThreeService gt)
    {
    	GtThreeService gtThreeService = gtThreeServiceService.selectGtThreeServiceById(gt.getId());
    	gtThreeService.setStatu("00");
        return toAjax(gtThreeServiceService.updateGtThreeService(gtThreeService));
    }
    /**
     * 新增栅格服务
     */
    @GetMapping("/seleFile")
    public String seleFile()
    {
        return prefix + "/fileTree";
    }
    /**
     * 加载部门列表树
     */
    @GetMapping("/treeData")
    @ResponseBody
    public List<ZtreeFile> treeData()
    {
    	GtConfig config = gtConfigService.selectGtConfigNow();
    	List<ZtreeFile> ztrees =new ArrayList<ZtreeFile>();
    	String path = config.getThreePath();
    	findChildFile(ztrees,path);
        return ztrees;
    }
    
    private void findChildFile(List<ZtreeFile> ztrees,String path){
    	File dir = new File(path);
    	File[] fs = dir.listFiles();
    	for (int i = 0; i < fs.length; i++) {
    		ZtreeFile ztree = new ZtreeFile();
    		ztree.setId(fs[i].getPath());
    		ztree.setpId(path);
    		ztree.setName(fs[i].getName());
    		ztrees.add(ztree);
	    	if (fs[i].isDirectory()) {
	    		findChildFile(ztrees,fs[i].getPath());
	    	}
    	}
    }
}
