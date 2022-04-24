package com.numberone.project.gistools.unstructuredservice.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.numberone.common.utils.file.FileUploadUtils;
import com.numberone.framework.config.NumberOneConfig;
import com.numberone.framework.config.ServerConfig;
import com.numberone.framework.web.controller.BaseController;
import com.numberone.framework.web.domain.AjaxResult;
import com.numberone.framework.web.page.TableDataInfo;
import com.numberone.project.gistools.resource.domain.Resource;
import com.numberone.project.gistools.resource.service.IResourceService;
import com.numberone.project.gistools.unstructuredservice.domain.DatabaseInfo;
import com.numberone.project.gistools.unstructuredservice.service.UnstructuredService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author hwx
 * @date 2022/3/29 11:32
 */
@Controller
@RequestMapping("/gistools/unstructured")
public class UnstructuredController extends BaseController {
    @Autowired
    private UnstructuredService unstructuredService;
    @Autowired
    private IResourceService resourceService;
    @Autowired
    private ServerConfig serverConfig;

    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Resource resource)
    {
        startPage();
        List<Resource> list = resourceService.selectUnstructuredList(resource);
        return getDataTable(list);
    }



    @PostMapping("/getlistByType")
    @ResponseBody
    public TableDataInfo fkjjghsj(Resource resource)
    {
        startPage();
        String typeList = resource.getTypeList();
        List<Resource> list = new ArrayList<>();
        //判断查询的list是否为空
        if (StringUtils.isEmpty(typeList)){
            list = resourceService.selectUnstructuredList(resource);
            return getDataTable(list);
        }
        String[] split = typeList.split(",");
        List<String> typelist= Arrays.asList(split);
        List<Integer> intList = typelist.stream().map(Integer::parseInt).collect(Collectors.toList());
        list = resourceService.selectListByTypeList(intList,resource.getFileName());

        return getDataTable(list);
    }


    @DeleteMapping("/delete/{ids}")
    @ResponseBody
    public AjaxResult deleteUnstructured(@PathVariable("ids")String ids)
    {
        String[] idarr = ids.split(",");
        for (String id:idarr) {
            Resource resource = resourceService.selectResourceById(id);
            System.out.println(resource);
            if (resource==null)
                continue;
            String url = resource.getUrl();
            String filePath = NumberOneConfig.getUploadPath();
            if (StringUtils.isNotEmpty(url)){
                String[] profiles = url.split("upload");
                String fileUrl = filePath+profiles[1];
                File file = new File(fileUrl);
                //判断文件是否存在
                if (file.exists()) {
                    //删除文件
                    file.delete();
                }
            }
            resourceService.deleteResourceById(resource.getId());
        }
        return AjaxResult.success("删除成功");
    }


    /**
     * 通用上传请求
     */
    @PostMapping("/upload")
    @ResponseBody
    public AjaxResult uploadFile(@RequestParam("file")MultipartFile file,
                                 @RequestParam("resource")String reString) throws Exception
    {
        //保存存储数据
        JSONObject json = JSONObject.parseObject(reString);
        Resource resource = JSON.toJavaObject(json,Resource.class);
        try
        {
            // 上传文件路径
            String filePath = NumberOneConfig.getUploadPath();
            // 上传并返回新文件名称
            String fileName = FileUploadUtils.upload(filePath, file);
            String[] split = fileName.split("/");
            String url = serverConfig.getUrl() + fileName;
            String uuid = IdWorker.get32UUID();
            resource.setFileName(split[split.length-1]);
            resource.setId(uuid);
            resource.setUrl(url);
            resource.setCreateTime(new Date());
            resourceService.insertResource(resource);

            AjaxResult ajax = AjaxResult.success();
            ajax.put("fileName", fileName);
            ajax.put("url", url);
            ajax.put("id", uuid);
            return ajax;
        }
        catch (Exception e)
        {
            return AjaxResult.error(e.getMessage());
        }
    }


    /**
     * 获取所有数据库表的名称
     * @return
     */
    @GetMapping("/getAllTableName")
    @ResponseBody
    public AjaxResult getAllTableName()
    {
        List<String> allTableName = unstructuredService.getAllTableName();
        return AjaxResult.success(allTableName);
    }

    /**
     * 新增一个数据库表信息到resource表中
     * @return
     */
    @PostMapping("/addDataBaseInfo")
    @ResponseBody
    public AjaxResult addDataBaseInfo(@RequestBody DatabaseInfo databaseInfo)
    {
        Resource resource = new Resource();
        resource.setId(IdWorker.get32UUID());
        resource.setType(8);
        resource.setFileName(databaseInfo.getName());
        resource.setLayerName(databaseInfo.getTableName());
        resource.setCreateTime(new Date());
        resource.setNote(databaseInfo.getNote());
        resourceService.insertResource(resource);
        return AjaxResult.success();
    }


    /**
     * 通过数据库表名称获取分页信息
     * @return
     */
    @PostMapping("/getPageByTableName")
    @ResponseBody
    public TableDataInfo getPageByTableName(String tableName)
    {
        startPage();
        List<Map> pageByTableName = unstructuredService.getPageByTableName(tableName);
        return getDataTable(pageByTableName);
    }

    /**
     * 通过数据库表名称获取表字段信息
     * @return
     */
    @GetMapping("/getTableMsgByTableName/{tableName}")
    @ResponseBody
    public AjaxResult getTableMsgByTableName(@PathVariable("tableName") String tableName)
    {
        List<String> allTableName = unstructuredService.getAllTableName();
        if (allTableName.contains(tableName)){
            List<String> tableMsgByTableName = unstructuredService.getTableMsgByTableName(tableName);
            return AjaxResult.success(tableMsgByTableName);
        }else {
            return AjaxResult.error("数据库中没有该表，请检查数据");
        }

    }

    @GetMapping("/excelDownload/{tableName}")
    @ResponseBody
    public void excelUpload(@PathVariable("tableName") String tableName, HttpServletResponse response){
        unstructuredService.excelUpload(tableName,response);
    }

    @PostMapping("/downloadZip")
    @ResponseBody
    public AjaxResult downloadZip(@RequestBody List<String> ids,HttpServletResponse response) throws FileNotFoundException {
        return unstructuredService.downloadZip(ids,response);
    }


    @PostMapping("/excel/getField")
    @ResponseBody
    public AjaxResult getExcelField(MultipartFile file){
        List list = unstructuredService.getFieldByExcel(file);
        return AjaxResult.success(list);
    }

    @PostMapping("/excel/creatTableByExcel")
    @ResponseBody
    public AjaxResult creatTableByExcel(@RequestPart("file")MultipartFile file,
                                        @RequestPart("map")Map map){
        //unstructuredService.creatTableByExcel(file,map);
        return null;
    }
}
