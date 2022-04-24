package com.numberone.project.gistools.unstructuredservice.service.impl;

import com.numberone.common.utils.StringUtils;
import com.numberone.framework.config.NumberOneConfig;
import com.numberone.framework.web.domain.AjaxResult;
import com.numberone.project.common.ZipUtil;
import com.numberone.project.gistools.resource.service.IResourceService;
import com.numberone.project.gistools.unstructuredservice.mapper.UnstructuredMapper;
import com.numberone.project.gistools.unstructuredservice.service.UnstructuredService;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import static com.alibaba.fastjson.util.IOUtils.close;
import static org.springframework.util.FileCopyUtils.BUFFER_SIZE;

/**
 * @author hwx
 * @date 2022/3/29 13:53
 */
@Service
public class UnstructuredServiceImpl implements UnstructuredService {
    @Resource
    private UnstructuredMapper unstructuredMapper;
    @Resource
    private IResourceService resourceService;

    @Override
    public List getFieldByExcel(MultipartFile file) {
        try {
            //返回的消息对象
            Map<String, Object> reMap = new HashMap<>();
            String fileName = file.getName();
            if(file.isEmpty()){
                throw new Exception(StringUtils.format("文件({})为空",fileName));
            }
            InputStream inputStream = file.getInputStream();
            //通过工厂类创建工作簿
            Workbook workbook = WorkbookFactory.create(inputStream);
            //通过获取工作簿表判断表中数据行数
            Sheet sheet = workbook.getSheetAt(0);//获取表1
            //获取表名称
            String sheetName = sheet.getSheetName();
            //获取标题行
            Row row = sheet.getRow(0);
            ArrayList relist = new ArrayList();
            for (Cell cell:row) {
                String field = cell.getStringCellValue();
                relist.add(field);
            }
            //获取第二行的数据
            //Row row1 = sheet.getRow(1);
            //遍历标题行的每一列
            /*for (int i = 0; i < row.getLastCellNum(); i++) {
                Cell cell = row.getCell(i);
                String field = cell.getStringCellValue();

                Cell cell1 = row1.getCell(i);
                if (cell1 == null || cell1.getCellType() == Cell.CELL_TYPE_BLANK){
                    reMap.put(field,"varchar");
                }else {
                    int cellType = cell1.getCellType();
                    switch (cellType){
                        case 0:
                            reMap.put(field,"int4");
                            break;
                        default:
                            reMap.put(field,"varchar");
                            break;
                    }
                }
            }*/
            return relist;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<String> getAllTableName() {
        return unstructuredMapper.getAllTableName();
    }

    @Override
    public List<Map> getPageByTableName(String tableName) {
        return unstructuredMapper.getPageByTableName(tableName);
    }

    @Override
    public List<String> getTableMsgByTableName(String tableName) {
        return unstructuredMapper.getTableMsgByTableName(tableName);
    }

    @Override
    public void excelUpload(String tableName, HttpServletResponse response) {
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        BufferedOutputStream outputStream = null;
        try {
            outputStream = new BufferedOutputStream(response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        //获取字段名
        List<String> tableMsgByTableName = unstructuredMapper.getTableMsgByTableName(tableName);
        //获取数据
        List<Map> pageByTableName = unstructuredMapper.getPageByTableName(tableName);
        //创建excel表格
        Workbook wb = new XSSFWorkbook();;
        Sheet sheet;
        sheet = wb.createSheet("第一页");
        //创建标题行
        Row row1 = sheet.createRow(0);
        //设置样式
        CellStyle style = wb.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER);
        //创建单元格
        Cell cell = null;
        int i = 0;
        //创建标头
        for (String field:tableMsgByTableName) {
            cell = row1.createCell(i);
            cell.setCellValue(field);                  //设定值
            cell.setCellStyle(style);
            i++;
        }
        //存入数据
        // 1)获取每一条数据
        i = 0;
        for (Map map:pageByTableName) {
            //生成一行数据
            Row row = sheet.createRow(i+1);
            int j = 0;
            // 2)通过字段名称获取每个字段的数据（循环输出列数据）
            for (String field:tableMsgByTableName) {
                //如果某字段名有数据
                if (map.containsKey(field)){
                    row.createCell(j).setCellValue(map.get(field).toString());
                }else {
                    row.createCell(j).setCellValue("");
                }
                j++;
            }
            i++;
        }
        try {
            wb.write(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            close(wb);
        }
    }


    @Override
    public AjaxResult downloadZip(List<String> ids,HttpServletResponse response) throws FileNotFoundException {
        List<String> strings = resourceService.selectUrlByIds(ids);
        List<File> files = new ArrayList<>();
        //通过ids获取文件url
        for (String url:strings) {
            String filePath = NumberOneConfig.getUploadPath();
            String[] profiles = url.split("upload");
            String fileUrl = filePath+profiles[1];
            File file = new File(fileUrl);
            //判断文件是否存在
            boolean exists = file.exists();
            if (!exists){
                return AjaxResult.error("有文件不存在，压缩失败");
            }
            files.add(file);
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String filePrefix = sdf.format(new Date());
        String zip = NumberOneConfig.getUploadPath() + "\\" + filePrefix + ".zip";
        ZipUtil.zipFile(zip,files.toArray(new File[files.size()]));
        ZipUtil.createZip(zip,files);
        ZipUtil.downZipFile(response,zip);
        File file1 = new File(zip);
        deleteTempFile(file1);
        return AjaxResult.success();
    }

    //通过file删除文件
    public static void deleteTempFile(File file) {
        if (file != null) {
            File del = new File(file.toURI());
            del.delete();
        }
    }


    protected final void close(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
