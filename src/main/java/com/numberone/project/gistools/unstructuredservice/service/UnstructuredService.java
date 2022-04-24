package com.numberone.project.gistools.unstructuredservice.service;

import com.numberone.framework.web.domain.AjaxResult;
import com.numberone.project.gistools.resource.domain.Resource;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

/**
 * @author hwx
 * @date 2022/3/29 13:52
 */
public interface UnstructuredService {
    List getFieldByExcel(MultipartFile file);

    List<String> getAllTableName();

    List<Map> getPageByTableName(String tableName);

    List<String> getTableMsgByTableName(String tableName);

    void excelUpload(String tableName, HttpServletResponse response);

    AjaxResult downloadZip(List<String> ids,HttpServletResponse response) throws FileNotFoundException;
}
