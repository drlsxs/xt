package com.numberone.project.gistools.twoDStyle.service.impl;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.numberone.framework.config.NumberOneConfig;
import com.numberone.framework.web.domain.AjaxResult;
import com.numberone.project.common.ZipUtil;
import com.numberone.project.gistools.twoDStyle.domain.GtPicture;
import com.numberone.project.gistools.twoDStyle.mapper.GtPictureMapper;
import com.numberone.project.gistools.twoDStyle.mapper.StyleMapper;
import com.numberone.project.gistools.twoDStyle.service.StyleService;
import it.geosolutions.geoserver.rest.GeoServerRESTManager;
import it.geosolutions.geoserver.rest.GeoServerRESTPublisher;
import it.geosolutions.geoserver.rest.GeoServerRESTReader;
import it.geosolutions.geoserver.rest.HTTPUtils;
import it.geosolutions.geoserver.rest.decoder.RESTStyleList;
import it.geosolutions.geoserver.rest.decoder.utils.NameLinkElem;
import it.geosolutions.geoserver.rest.manager.GeoServerRESTStyleManager;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.xml.bind.DatatypeConverter;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import static org.springframework.util.FileCopyUtils.BUFFER_SIZE;

/**
 * @author hwx
 * @date 2022/4/11 17:29
 */
@Service
public class StyleServiceImpl implements StyleService {
    @Resource
    private StyleMapper styleMapper;
    @Resource
    private GtPictureMapper gtPictureMapper;

    @Override
    public List getAllStyleName(String type) throws MalformedURLException, UnsupportedEncodingException {
        List<Map> workSpace = styleMapper.findWorkSpace();
        Map<String,String> map = workSpace.get(0);
        String url = map.get("url");
        String geoserverUrl = "http://"+url+"/geoserver";
        String geoserverUsername = map.get("username");
        String geoserverPassword = map.get("passwd");
        String workname = map.get("work_space");
        GeoServerRESTPublisher geoServerRESTPublisher = new GeoServerRESTPublisher(geoserverUrl,geoserverUsername,geoserverPassword);
        GeoServerRESTReader geoServerRESTReader = new GeoServerRESTReader(geoserverUrl,geoserverUsername,geoserverPassword);
        URL u = new URL(geoserverUrl);
        GeoServerRESTManager manager = new GeoServerRESTManager(u, geoserverUsername, geoserverPassword);
        GeoServerRESTStyleManager styleManager = manager.getStyleManager();
        RESTStyleList styles1 = styleManager.getStyles(workname);
        List<String> relist = new ArrayList<>();

        for (NameLinkElem style:styles1) {
            String str = style.getName();
            String substring = str.substring(str.length() - 1);
            if (type.equals(substring)){
                relist.add(str.substring(0,str.length()-1));
            }
        }
        return relist;
    }

    @Override
    public boolean existStyle(String styleName) {
        boolean exist = false;
        List<Map> workSpace = styleMapper.findWorkSpace();
        Map<String,String> map = workSpace.get(0);
        String url = map.get("url");
        String geoserverUrl = "http://"+url+"/geoserver";
        String geoserverUsername = map.get("username");
        String geoserverPassword = map.get("passwd");
        String workname = map.get("work_space");
        try {
            String encode = URLEncoder.encode(styleName);
            System.out.println(encode);
            GeoServerRESTReader geoServerRESTReader = new GeoServerRESTReader(geoserverUrl,geoserverUsername,geoserverPassword);

            exist = geoServerRESTReader.existsStyle(workname, styleName);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return exist;
    }

    @Override
    public AjaxResult pointStyle(MultipartFile multipartFile, String styleName) {
        boolean re = false;
        List<Map> workSpace = styleMapper.findWorkSpace();
        Map<String,String> map = workSpace.get(0);
        String url = map.get("url");
        String geoserverUrl = "http://"+url+"/geoserver";
        String geoserverUsername = map.get("username");
        String geoserverPassword = map.get("passwd");
        String workname = map.get("work_space");
        URL u = null;
        try {
            u = new URL(geoserverUrl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        GeoServerRESTManager manager = new GeoServerRESTManager(u, geoserverUsername, geoserverPassword);
        //判断Geoserver中样式名称是否重复
        GeoServerRESTStyleManager styleManager = manager.getStyleManager();
        RESTStyleList xstoolsdian = styleManager.getStyles("xstools");
        List<String> styleNames = new ArrayList<>();
        for (NameLinkElem style:xstoolsdian) {
            styleNames.add(style.getName());
        }
        if (styleNames.contains(styleName)){
            return AjaxResult.error("样式名称重复");
        }
        //判断数据库中样式名是否重复
        List<String> allName = gtPictureMapper.getAllName();
        if (allName.contains(styleName)){
            return AjaxResult.error("样式名称重复");
        }

        String originalFilename = multipartFile.getOriginalFilename();
        String uuid = IdWorker.get32UUID();
        String[] split = originalFilename.split("\\.");
        String fileName = split[0];
        String sld = getSLD(uuid);
        List<File> files = new ArrayList<>();
        //将file转为byte数组
        String pictureBase64=null;
        byte[] fileByte = null;
        try {
            fileByte = multipartFile.getBytes();
        } catch (IOException e) {
            e.printStackTrace();
        }
        pictureBase64 = Base64.getEncoder().encodeToString(fileByte);

        File file0 = base64ToFile(pictureBase64);
        String path = NumberOneConfig.getUploadPath();
        File file2 = new File(path + "\\" + uuid+ ".png");
        file0.renameTo(file2);
        files.add(file2);
        try {
            Document document = DocumentHelper.parseText(sld);
            File file = new File(path+"\\"+fileName+".sld");
            OutputFormat format = new OutputFormat();
            format.setEncoding("GBK");
            XMLWriter xmlWriter = new XMLWriter(new FileOutputStream(file.getPath()),
                    format);
            xmlWriter.write(document);
            xmlWriter.flush();
            xmlWriter.close();
            files.add(file);

            String zip=path+"\\"+styleName+".zip";
            ZipUtil.zipFile(zip,files.toArray(new File[files.size()]));
            ZipOutputStream zos=null;
            FileInputStream fileInputStream = new FileInputStream(zip);
            Charset gbk = Charset.forName("gbk");
            ZipInputStream zin = new ZipInputStream(fileInputStream,gbk);
            ZipEntry entry = zin.getNextEntry();
            File file1 = new File(zip);
            try {
                FileOutputStream out = new FileOutputStream(file1);
                zos = new ZipOutputStream(out);
                for (File srcFile : files) {
                    byte[] buf = new byte[BUFFER_SIZE];
                    zos.putNextEntry(new ZipEntry(srcFile.getName()));
                    int len;
                    FileInputStream in = new FileInputStream(srcFile);
                    while ((len = in.read(buf)) != -1){
                        zos.write(buf, 0, len);
                    }
                    zos.closeEntry();
                    in.close();
                }
            }catch (Exception e) {
                throw new RuntimeException("zip error from ZipUtils", e);
            } finally {
                if (zos != null) {
                    try {
                        fileInputStream.close();
                        zos.close();
                        zin.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            re = publishStyleZippedInWorkspace("xstools", new File(zip), styleName,geoserverUrl,geoserverUsername,geoserverPassword);
            if (re){
                String base = "data:image/png;base64,"+pictureBase64;
                GtPicture gtPicture = new GtPicture();
                gtPicture.setId(IdWorker.get32UUID());
                gtPicture.setBase(base);
                gtPicture.setName(styleName);
                gtPicture.setType("1");
                gtPictureMapper.insertGtPicture(gtPicture);
            }
            delteTempFile(new File(zip));
            delteTempFile(file2);
            delteTempFile(file);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (re){
            return AjaxResult.success();
        }else {
            return AjaxResult.error("样式新增失败");
        }

    }

    @Override
    public boolean existService(String serviceUrl) {
        List<Map> workSpace = styleMapper.findWorkSpace();
        Map<String,String> map = workSpace.get(0);
        String url = map.get("url");
        String geoserverUrl = "http://"+url+"/geoserver";
        if (serviceUrl.contains(geoserverUrl)){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public AjaxResult deleteStyle(String styleName) {
        List<Map> workSpace = styleMapper.findWorkSpace();
        Map<String,String> map = workSpace.get(0);
        String url = map.get("url");
        String geoserverUrl = "http://"+url+"/geoserver";
        String geoserverUsername = map.get("username");
        String geoserverPassword = map.get("passwd");
        //样式是否存在
        String enc = enc(styleName);
        String composed = geoserverUrl + "/rest/workspaces/xstools/styles/"+ enc +".xml";
        boolean exists = HTTPUtils.exists(composed, geoserverUsername, geoserverPassword);
        if (exists){
            String deleteUrl = geoserverUrl + "/rest/workspaces/xstools/styles/" + enc + "?purge=true";
            boolean b = HTTPUtils.delete(deleteUrl, geoserverUsername, geoserverPassword);
            if (b){
                gtPictureMapper.deleteGtPictureByName(styleName);
                return AjaxResult.success();
            }else {
                return AjaxResult.error("样式删除失败");
            }
        }else {
            return AjaxResult.error("样式不存在，请联系管理人员");
        }

    }

    public static File base64ToFile(String base64) {
        if(base64==null||"".equals(base64)) {
            return null;
        }
        byte[] buff = DatatypeConverter.parseBase64Binary(base64);
       // byte[] buff=org.geotools.data.Base64.decode(base64);;
        File file=null;
        FileOutputStream fout=null;
        try {
            file = File.createTempFile("tmp", null);
            fout=new FileOutputStream(file);
            fout.write(buff);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fout!=null) {
                try {
                    fout.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return file;
    }

    private String getSLD(String fileName){
        String SLD = "<?xml version=\"1.0\" encoding=\"GBK\"?>\n" +
                "<sld:StyledLayerDescriptor xmlns:sld=\"http://www.opengis.net/sld\" xmlns=\"http://www.opengis.net/sld\" xmlns:gml=\"http://www.opengis.net/gml\" xmlns:ogc=\"http://www.opengis.net/ogc\" version=\"1.0.0\">\n" +
                "    <sld:UserLayer>\n" +
                "        <sld:LayerFeatureConstraints>\n" +
                "            <sld:FeatureTypeConstraint/>\n" +
                "        </sld:LayerFeatureConstraints>\n" +
                "        <sld:UserStyle>\n" +
                "            <sld:Name>10m geography regions points</sld:Name>\n" +
                "            <sld:FeatureTypeStyle>\n" +
                "                <sld:Name>group0</sld:Name>\n" +
                "                <sld:FeatureTypeName>Feature</sld:FeatureTypeName>\n" +
                "                <sld:Rule>\n" +
                "                    <sld:Name>default rule</sld:Name>\n" +
                "                    <sld:PointSymbolizer>\n" +
                "                        <sld:Graphic>\n" +
                "                            <sld:ExternalGraphic>\n" +
                "                                <sld:OnlineResource xmlns:xlink=\"http://www.w3.org/1999/xlink\" xlink:type=\"simple\" xlink:href=\""+ fileName +".png\"></sld:OnlineResource>\n" +
                "                                <sld:Format>image/png</sld:Format>\n" +
                "                            </sld:ExternalGraphic>\n" +
                "                            <sld:Size>20</sld:Size>\n" +
                "                        </sld:Graphic>\n" +
                "                    </sld:PointSymbolizer>\n" +
                "                </sld:Rule>\n" +
                "            </sld:FeatureTypeStyle>\n" +
                "        </sld:UserStyle>\n" +
                "    </sld:UserLayer>\n" +
                "</sld:StyledLayerDescriptor>\n";

        return SLD;
    }

    public static void delteTempFile(File file) {
        if (file != null) {
            File del = new File(file.toURI());
            del.delete();
        }
    }

    public static boolean publishStyleZippedInWorkspace(String workspace,
                                                     File zipFile,
                                                     String name,
                                                     String geoserverUrl,
                                                     String gsuser,
                                                     String gspass) {
        String sUrl = buildPostUrl(workspace, name,geoserverUrl);
        String result = HTTPUtils.post(sUrl, zipFile, "application/zip", gsuser, gspass);
        return result != null;
    }

    protected static String buildPostUrl(String workspace, String name,String geoserverUrl) {
        StringBuilder sUrl = (new StringBuilder(geoserverUrl).append("/rest"));
        if (workspace != null) {
            sUrl.append("/workspaces/").append(enc(workspace));
        }

        sUrl.append("/styles");
        if (name != null && !name.isEmpty()) {
            sUrl.append("?name=").append(enc(name));
        }

        return sUrl.toString();
    }

    public static String enc(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException var2) {
            return str;
        }
    }
}
