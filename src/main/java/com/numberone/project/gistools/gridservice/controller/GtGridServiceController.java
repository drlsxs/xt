package com.numberone.project.gistools.gridservice.controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.numberone.common.utils.StringUtils;
import it.geosolutions.geoserver.rest.GeoServerRESTPublisher;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.gdal.gdal.Band;
import org.gdal.gdal.Dataset;
import org.gdal.gdal.Driver;
import org.gdal.gdal.gdal;
import org.gdal.gdalconst.gdalconstConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.numberone.framework.aspectj.lang.annotation.Log;
import com.numberone.framework.aspectj.lang.enums.BusinessType;
import com.numberone.project.gistools.config.domain.GtConfig;
import com.numberone.project.gistools.config.service.IGtConfigService;
import com.numberone.project.gistools.gridservice.domain.GtGridService;
import com.numberone.project.gistools.gridservice.service.IGtGridServiceService;
import com.numberone.project.system.dept.domain.Dept;

import com.numberone.framework.web.controller.BaseController;
import com.numberone.framework.web.domain.AjaxResult;
import com.numberone.framework.web.domain.Ztree;
import com.numberone.framework.web.domain.ZtreeFile;
import com.numberone.common.utils.poi.ExcelUtil;
import com.numberone.framework.web.page.TableDataInfo;
import org.springframework.web.client.RestTemplate;

/**
 * 栅格服务Controller
 *
 * @author wyl
 * @date 2021-10-02
 */
@Controller
@RequestMapping("/gistools/gridservice")
public class GtGridServiceController extends BaseController
{

    public static RestTemplate restTemplate() {
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setConnectTimeout(30000);// 设置连接超时，单位毫秒
        requestFactory.setReadTimeout(30000);  //设置读取超时
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setRequestFactory(requestFactory);
        return restTemplate;
    }

    @Autowired
    private  RestTemplate restTemplate;
    private String prefix = "gistools/gridservice";
    @Autowired
    private IGtGridServiceService gtGridServiceService;

    @Autowired
    private IGtConfigService gtConfigService;

    @RequiresPermissions("gistools:gridservice:view")
    @GetMapping()
    public String gridservice()
    {
        return prefix + "/gridservice";
    }

    /**
     * 查询栅格服务列表
     */
    @RequiresPermissions("gistools:gridservice:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(GtGridService gtGridService)
    {
        startPage();
        List<GtGridService> list = gtGridServiceService.selectGtGridServiceList(gtGridService);
        return getDataTable(list);
    }

    /**
     * 导出栅格服务列表
     */
    @RequiresPermissions("gistools:gridservice:export")
    @Log(title = "栅格服务", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(GtGridService gtGridService)
    {
        List<GtGridService> list = gtGridServiceService.selectGtGridServiceList(gtGridService);
        ExcelUtil<GtGridService> util = new ExcelUtil<GtGridService>(GtGridService.class);
        return util.exportExcel(list, "gridservice");
    }

    /**
     * 新增栅格服务
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存栅格服务
     */
    @RequiresPermissions("gistools:gridservice:add")
    @Log(title = "栅格服务", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(GtGridService gtGridService) throws IOException {

        gdal.AllRegister();
        int i=0;
    	if (StringUtils.isNotEmpty(gtGridService.getFolderPath())){
            String[] list = new File(gtGridService.getFolderPath()).list();
            String name = gtGridService.getName();
            for (String s : list) {
                if (s.endsWith(".tif")){
                    gtGridService.setId(get32UUID());
                    gtGridService.setName(name+"_"+s.replaceAll(".tif",""));
                    gtGridService.setStatu("00");
                    gtGridService.setFilePath(null);
                    gtGridService.setFilePath(gtGridService.getFolderPath()+"\\"+s);
                    Dataset dataset = gdal.Open(gtGridService.getFilePath(), gdalconstConstants.GA_ReadOnly);
                    if (dataset == null) {
                        System.out.println(gdal.GetLastErrorMsg());
                    }
                    Driver driver = dataset.GetDriver();
                    String proj = dataset.GetProjection();
                    String authorityName = dataset.GetSpatialRef().GetAuthorityName(null);
                    String authorityCode = dataset.GetSpatialRef().GetAuthorityCode(null);
                    Band band = dataset.GetRasterBand(1);
                    System.out.println(authorityName+':'+authorityCode);
                    if (StringUtils.isNull(authorityName)||StringUtils.isNull(authorityCode)){
                        gtGridService.setSrid(null);
                    }else {
                        gtGridService.setSrid(authorityName+':'+authorityCode);
                    }

                    gtGridServiceService.insertGtGridService(gtGridService);
                    i++;
                }
            }
        }else {
            gtGridService.setId(get32UUID());
            gtGridService.setStatu("00");
            i=gtGridServiceService.insertGtGridService(gtGridService);
        }
        return toAjax(i);
    }

    /**
     * 修改栅格服务
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap)
    {
        GtGridService gtGridService = gtGridServiceService.selectGtGridServiceById(id);
        mmap.put("gtGridService", gtGridService);
        return prefix + "/edit";
    }

    /**
     * 修改保存栅格服务
     */
    @RequiresPermissions("gistools:gridservice:edit")
    @Log(title = "栅格服务", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(GtGridService gtGridService)
    {
        return toAjax(gtGridServiceService.updateGtGridService(gtGridService));
    }

    /**
     * 删除栅格服务
     */
    @RequiresPermissions("gistools:gridservice:remove")
    @Log(title = "栅格服务", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(gtGridServiceService.deleteGtGridServiceByIds(ids));
    }

    /**
     * 新增栅格服务
     */
    @GetMapping("/seleFile")
    public String seleFile()
    {
        return prefix + "/fileTree";
    }

    @GetMapping("/seleFiles")
    public String seleFiles()
    {
        return prefix + "/filesTree";
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
    	String path = config.getGridPath();
    	findChildFile(ztrees,path);
        return ztrees;
    }

    /**
     * 加载部门列表树
     */
    @GetMapping("/treesData")
    @ResponseBody
    public List<ZtreeFile> treesData()
    {
        GtConfig config = gtConfigService.selectGtConfigNow();
        List<ZtreeFile> ztrees =new ArrayList<ZtreeFile>();
        String path = config.getGridPath();
        findChildFiles(ztrees,path);
        return ztrees;
    }
    /**
     * 返回epsg
     */
    @GetMapping("/getEpsg")
    @ResponseBody
    public String getEPSG(String path) throws IOException {

        gdal.AllRegister();
        System.out.println(path);
        Dataset dataset = gdal.Open(path, gdalconstConstants.GA_ReadOnly);
        if (dataset == null) {
            System.out.println(gdal.GetLastErrorMsg());
        }
        Driver driver = dataset.GetDriver();
        String proj = dataset.GetProjection();
        String authorityName = dataset.GetSpatialRef().GetAuthorityName(null);
        String authorityCode = dataset.GetSpatialRef().GetAuthorityCode(null);
        Band band = dataset.GetRasterBand(1);
        String s=authorityName+':'+authorityCode;
        System.out.println(authorityName+':'+authorityCode);
        if (StringUtils.isNull(authorityCode)||StringUtils.isNull(authorityName)){
            return null;
        }
        return s;
    }
    /**
     * 构建pyramid
     */
    @GetMapping("/bulidPyramid")
    @ResponseBody
    public String bulidPyramid(String path)
    {
        path=path.replaceAll("/","\\\\");
        System.out.println(path);
        gdal.AllRegister();
        Dataset dataset = gdal.Open(path, gdalconstConstants.GA_ReadOnly);
        if (dataset == null) {
            System.out.println(gdal.GetLastErrorMsg());
            return null;
        }
        int i = dataset.BuildOverviews(new int[]{2, 4,8,16,32});
        System.out.println(i);
        return "构建成功";
    }



    private void findChildFile(List<ZtreeFile> ztrees,String path){
    	File dir = new File(path);
    	File[] fs = dir.listFiles();
    	for (int i = 0; i < fs.length; i++) {
    		ZtreeFile ztree = new ZtreeFile();
    		if (fs[i].getName().endsWith(".tif")||fs[i].isDirectory()) {
                ztree.setId(fs[i].getPath());
                ztree.setpId(path);
                ztree.setName(fs[i].getName());
                ztrees.add(ztree);
            }
            if (fs[i].isDirectory()) {
                findChildFile(ztrees,fs[i].getPath());
            }
    	}
    }
    private void findChildFiles(List<ZtreeFile> ztrees,String path){
        File dir = new File(path);
        File[] fs = dir.listFiles();
        for (int i = 0; i < fs.length; i++) {
            File f = fs[i];
            if (!f.isDirectory()){
                fs = delElement(fs, i);
            }else {
                ZtreeFile ztree = new ZtreeFile();
                ztree.setId(fs[i].getPath());
                ztree.setpId(path);
                ztree.setName(fs[i].getName());
                ztrees.add(ztree);
                findChildFiles(ztrees,fs[i].getPath());
            }
        }
    }
    private static File[] delElement(File[] arrays, int index) {
        int length = arrays.length;
        //判断数据合理性
        if (index >= 0 && index < length) {
            File[] arrays_result = new File[arrays.length - 1];
            //将arrays数组在index前的元素都复制到新数组arrays_result中
            System.arraycopy(arrays, 0, arrays_result, 0, index);
            //判断index之后是否还有元素，有则将index后的元素从index位置复制到新数组中
            if (index < length - 1) {
                System.arraycopy(arrays, index + 1, arrays_result, index, arrays_result.length - index);
            }
            return arrays_result;
        } else {
            //不合理，抛越界异常
            throw new IndexOutOfBoundsException("index :" + index + ", length: " + length);
        }
    }

    /**
     * 发布服务
     */
    /*@RequiresPermissions("gistools:gridservice:edit")
    @Log(title = "发布服务", businessType = BusinessType.UPDATE)
    @PostMapping("/publish")
    @ResponseBody
    public AjaxResult publish(GtGridService vo)
    {
    	GtConfig config = gtConfigService.selectGtConfigNow();
    	GtGridService gtGridService = gtGridServiceService.selectGtGridServiceById(vo.getId());
    	String gurl = config.getMsUrl();
        String ws = config.getItem1();
        if (StringUtils.isNull(gtGridService.getSrid())){
            return toAjax(0);
        }
        String store_name="sg_"+gtGridService.getId();
    	try {
            URL u = new URL(gurl);
            GeoServerRESTManager manager = new GeoServerRESTManager(u, config.getMsUname(), config.getMsPwd());
            RESTDataStore restStore = manager.getReader().getDatastore(ws, store_name);
            if (restStore == null) {
                GSGeoTIFFDatastoreEncoder gsGeoTIFFDatastoreEncoder = new GSGeoTIFFDatastoreEncoder(store_name);
                gsGeoTIFFDatastoreEncoder.setWorkspaceName(ws);
                gsGeoTIFFDatastoreEncoder.setUrl(new URL("file:" + gtGridService.getFilePath()));
                boolean createStore = manager.getStoreManager().create(ws, gsGeoTIFFDatastoreEncoder);
                System.out.println("create store (TIFF文件创建状态) : " + createStore);
                boolean publish = manager.getPublisher().publishExternalGeoTIFF(ws, store_name, new File(gtGridService.getFilePath()), store_name, gtGridService.getSrid(), ProjectionPolicy.FORCE_DECLARED, "raster");
                System.out.println("publish (TIFF文件发布状态) : " + publish);
            } else {
                System.out.println("数据存储已经存在了,store:" + store_name);
            }
	        *//*GeoServerRESTPublisher publisher = manager.getPublisher() ;
	        List<String> workspaces = manager.getReader().getWorkspaceNames();
	        if(workspaces.contains(work_space)){
	        	String store_name="sg_"+gtGridService.getId();
	        	String coverageName = "sg_"+gtGridService.getId();
	            File geotiff = new File(gtGridService.getFilePath());
	        	RESTDataStore restStore = manager.getReader().getDatastore(work_space, store_name);
	            if(restStore == null){
	            	boolean publish = publisher.publishGeoTIFF(work_space,store_name,coverageName,geotiff);
                    System.out.println("publish : " + publish);
                    if(publish){
                    	gtGridService.setStatu("01");
                    }
	                else System.out.println("发布失败:" + gtGridService.getFilePath());
	            }
                else {
    	            System.out.println("数据存储已存在,store :" + store_name);
    	        }
	        }else {
	            System.out.println("workspace不存在,ws :" + work_space);
	        }*//*
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
    	gtGridService.setStatu("01");
    	gtGridService.setSurl(config.getDefUrl());
    	gtGridService.setSparams(ws+":"+store_name);
    	gtGridService.setFtype("WMS");
        return toAjax(gtGridServiceService.updateGtGridService(gtGridService));
    }*/

    /*@PostMapping("/publishSome")
    @ResponseBody
    public AjaxResult publishSome(String ids)
    {
        GtConfig config = gtConfigService.selectGtConfigNow();
        String gurl = config.getMsUrl();
        String ws = config.getItem1();
        int i=0;
        if (ids.contains(",")){
            String[] strings = ids.split(",");
            for (String string : strings) {
                GtGridService gtGridService = gtGridServiceService.getById(string);
                System.out.println(gtGridService);
                if (!"00".equals(gtGridService.getStatu())){
                    continue;
                }
                if (StringUtils.isNull(gtGridService.getSrid())){
                    continue;
                }
                if (StringUtils.isNull(gtGridService.getFilePath())){
                    continue;
                }
                String store_name="sg_"+gtGridService.getId();
                try {
                    URL u = new URL(gurl);
                    GeoServerRESTManager manager = new GeoServerRESTManager(u, config.getMsUname(), config.getMsPwd());
                    RESTDataStore restStore = manager.getReader().getDatastore(ws, store_name);
                    if (restStore == null) {
                        GSGeoTIFFDatastoreEncoder gsGeoTIFFDatastoreEncoder = new GSGeoTIFFDatastoreEncoder(store_name);
                        gsGeoTIFFDatastoreEncoder.setWorkspaceName(ws);
                        gsGeoTIFFDatastoreEncoder.setUrl(new URL("file:" + gtGridService.getFilePath()));
                        boolean createStore = manager.getStoreManager().create(ws, gsGeoTIFFDatastoreEncoder);
                        System.out.println("create store (TIFF文件创建状态) : " + createStore);
                        boolean publish = manager.getPublisher().publishExternalGeoTIFF(ws, store_name, new File(gtGridService.getFilePath()), store_name, gtGridService.getSrid(), ProjectionPolicy.FORCE_DECLARED, "raster");
                        System.out.println("publish (TIFF文件发布状态) : " + publish);
                    } else {
                        System.out.println("数据存储已经存在了,store:" + store_name);
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                gtGridService.setStatu("01");
                gtGridService.setSurl(config.getDefUrl());
                gtGridService.setSparams(ws+":"+store_name);
                gtGridService.setFtype("WMS");
                gtGridServiceService.updateGtGridService(gtGridService);
                i++;
            }
        }else {
            GtGridService gtGridService = gtGridServiceService.getById(ids);
            System.out.println(gtGridService);
            if (gtGridService.getStatu()!="00"){
                return AjaxResult.warn("当前服务不能发布");
            }
            if (StringUtils.isNull(gtGridService.getSrid())){
                return AjaxResult.warn("当前服务无坐标系，不能发布");
            }
            if (StringUtils.isNull(gtGridService.getFilePath())){
                return AjaxResult.warn("当前服务不能发布");
            }
            String store_name="sg_"+gtGridService.getId();
            try {
                URL u = new URL(gurl);
                GeoServerRESTManager manager = new GeoServerRESTManager(u, config.getMsUname(), config.getMsPwd());
                RESTDataStore restStore = manager.getReader().getDatastore(ws, store_name);
                if (restStore == null) {
                    GSGeoTIFFDatastoreEncoder gsGeoTIFFDatastoreEncoder = new GSGeoTIFFDatastoreEncoder(store_name);
                    gsGeoTIFFDatastoreEncoder.setWorkspaceName(ws);
                    gsGeoTIFFDatastoreEncoder.setUrl(new URL("file:" + gtGridService.getFilePath()));
                    boolean createStore = manager.getStoreManager().create(ws, gsGeoTIFFDatastoreEncoder);
                    System.out.println("create store (TIFF文件创建状态) : " + createStore);
                    boolean publish = manager.getPublisher().publishExternalGeoTIFF(ws, store_name, new File(gtGridService.getFilePath()), store_name, gtGridService.getSrid(), ProjectionPolicy.FORCE_DECLARED, "raster");
                    System.out.println("publish (TIFF文件发布状态) : " + publish);
                } else {
                    System.out.println("数据存储已经存在了,store:" + store_name);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            gtGridService.setStatu("01");
            gtGridService.setSurl(config.getDefUrl());
            gtGridService.setSparams(ws+":"+store_name);
            gtGridService.setFtype("WMS");
            gtGridServiceService.updateGtGridService(gtGridService);
            i++;
        }
        if (i>0){
            return AjaxResult.success("此次共发布"+i+"条服务");
        }else {
            return AjaxResult.error("无可发布服务");
        }


    }*/

    /**
     * 批量注册服务
     */
    @PostMapping("/registerSome")
    @ResponseBody
    public AjaxResult registerSome(String ids)
    {
        List<Map<String, Object>> list = new ArrayList<>();
        int i=0;
        if (ids.contains(",")) {
            String[] strings = ids.split(",");
            for (String string : strings) {
                GtGridService gtGridService = gtGridServiceService.getById(string);
                Map<String, Object> map = new HashMap<>();
                map.put("service_url",gtGridService.getSurl());
                map.put("service_parameter",gtGridService.getSparams());
                map.put("service_name",gtGridService.getName());
                list.add(map);
            }
            ResponseEntity<Integer> responseEntity = restTemplate.postForEntity("http://localhost:8088/xsgis/webgis/register/registerExternalServices", JSON.toJSON(list), int.class);
            i = responseEntity.getBody();
            System.out.println(i);
        }else {
            GtGridService gtGridService = gtGridServiceService.getById(ids);
            Map<String, Object> map = new HashMap<>();
            map.put("service_url",gtGridService.getSurl());
            map.put("service_parameter",gtGridService.getSparams());
            map.put("service_name",gtGridService.getName());
            list.add(map);
            ResponseEntity<Integer> responseEntity = restTemplate.postForEntity("http://localhost:8088/xsgis/webgis/register/registerExternalServices", JSON.toJSON(list), int.class);
            i = responseEntity.getBody();
            System.out.println(i);
        }
        if (i>0){
            return AjaxResult.success("注册成功，本次共注册"+i+"条数据");
        }else {
            return AjaxResult.error();
        }
    }
    /**
     * 停止服务
     */
    /*@RequiresPermissions("gistools:gridservice:edit")
    @Log(title = "停止服务", businessType = BusinessType.UPDATE)
    @PostMapping("/unpublish")
    @ResponseBody
    public AjaxResult unpublish(GtGridService vo)
    {
    	GtConfig config = gtConfigService.selectGtConfigNow();
    	GtGridService gtGridService = gtGridServiceService.selectGtGridServiceById(vo.getId());
    	String gurl = config.getMsUrl();
        String ws = config.getItem1();
        String store_name="sg_"+gtGridService.getId();
    	try {
			URL u = new URL(gurl);
			GSGeoTIFFDatastoreEncoder gsGeoTIFFDatastoreEncoder = new GSGeoTIFFDatastoreEncoder(store_name);
            gsGeoTIFFDatastoreEncoder.setWorkspaceName(ws);
	        GeoServerRESTManager manager = new GeoServerRESTManager(u, config.getMsUname(), config.getMsPwd());
	        boolean unpublish = manager.getStoreManager().remove(ws, gsGeoTIFFDatastoreEncoder, true);
            System.out.println("删除store : " + unpublish);
	        GeoServerRESTPublisher publisher = manager.getPublisher() ;
	        List<String> workspaces = manager.getReader().getWorkspaceNames();
	        *//*if(workspaces.contains(ws)){
	        	String store_name="sg_"+gtGridService.getId();
	        	String coverageName = "sg_"+gtGridService.getId();
	            File geotiff = new File(gtGridService.getFilePath());
	        	RESTDataStore restStore = manager.getReader().getDatastore(ws, store_name);
	            if(restStore == null){
	            	boolean publish = publisher.publishGeoTIFF(ws,store_name,coverageName,geotiff);
                    System.out.println("publish : " + publish);
                    if(publish){
                    	gtGridService.setStatu("01");
                    }
	                else System.out.println("发布失败:" + gtGridService.getFilePath());
	            }
                else {
    	            System.out.println("数据存储已存在,store :" + store_name);
    	        }
	        }else {
	            System.out.println("workspace不存在,ws :" + ws);
	        }*//*
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
    	gtGridService.setStatu("00");
        return toAjax(gtGridServiceService.updateGtGridService(gtGridService));
    }*/
}
