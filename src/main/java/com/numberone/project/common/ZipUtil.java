package com.numberone.project.common;

import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipFile;
import org.apache.tools.zip.ZipOutputStream;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipInputStream;

import static org.springframework.util.FileCopyUtils.BUFFER_SIZE;

/**
 * @ClassName ZipUtil
 * @Description 压缩或解压缩zip：由于直接使用java.util.zip工具包下的类，会出现中文乱码问题，所以使用ant.jar中的org.apache.tools.zip下的工具类
 * @Author AlphaJunS
 * @Date 2020/3/8 11:30
 * @Version 1.0
 */
public class ZipUtil {

    /**
     * @Author AlphaJunS
     * @Date 11:32 2020/3/8
     * @Description
      * @param zip 压缩目的地址
     * @param srcFiles 压缩的源文件
     * @return void
     */
    public static void zipFile( String zip , File[] srcFiles ) {
        try {
            if( zip.endsWith(".zip") || zip.endsWith(".ZIP") ){
                FileOutputStream fos = new FileOutputStream(new File(zip));
                ZipOutputStream _zipOut = new ZipOutputStream(fos) ;
                _zipOut.setEncoding("GBK");
                for( File _f : srcFiles ){
                    handlerFile(zip , _zipOut , _f , "");
                }
                fos.close();
                _zipOut.close();
            }else{
                System.out.println("target file[" + zip + "] is not .zip type file");
            }
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        }
    }

    /**
     * @Author AlphaJunS
     * @Date 11:33 2020/3/8
     * @Description
     * @param zip 压缩的目的地址
     * @param zipOut
     * @param srcFile 被压缩的文件信息
     * @param path 在zip中的相对路径
     * @return void
     */
    private static void handlerFile(String zip , ZipOutputStream zipOut , File srcFile , String path) throws IOException {
        System.out.println(" begin to compression file[" + srcFile.getName() + "]");
        if( !"".equals(path) && ! path.endsWith(File.separator)){
            path += File.separator ;
        }
        if( ! srcFile.getPath().equals(zip) ){
            if( srcFile.isDirectory() ){
                File[] _files = srcFile.listFiles() ;
                if( _files.length == 0 ){
                    zipOut.putNextEntry(new ZipEntry( path + srcFile.getName() + File.separator));
                    zipOut.closeEntry();
                }else{
                    for( File _f : _files ){
                        handlerFile( zip ,zipOut , _f , path + srcFile.getName() );
                    }
                }
            }else{
                InputStream _in = new FileInputStream(srcFile) ;
                zipOut.putNextEntry(new ZipEntry(path + srcFile.getName()));
                int len = 0 ;
                byte[] _byte = new byte[1024];
                while( (len = _in.read(_byte)) > 0  ){
                    zipOut.write(_byte, 0, len);
                }
                _in.close();
                zipOut.closeEntry();
            }
        }
    }

    /**
     * @Author AlphaJunS
     * @Date 11:34 2020/3/8
     * @Description 解压缩ZIP文件，将ZIP文件里的内容解压到targetDIR目录下
      * @param zipPath 待解压缩的ZIP文件名
     * @param descDir 目标目录
     * @return java.util.List<java.io.File>
     */
    public static List<File> unzipFile(String zipPath, String descDir) {
        return unzipFile(new File(zipPath) , descDir) ;
    }

    /**
     * @Author AlphaJunS
     * @Date 11:36 2020/3/8
     * @Description 对.zip文件进行解压缩
     * @param zipFile 解压缩文件
     * @param descDir 压缩的目标地址，如：D:\\测试 或 /mnt/d/测试
     * @return java.util.List<java.io.File>
     */
    @SuppressWarnings("rawtypes")
    public static List<File> unzipFile(File zipFile, String descDir) {
        List<File> _list = new ArrayList<File>() ;
        try {
            ZipFile _zipFile = new ZipFile(zipFile , "GBK") ;
            for( Enumeration entries = _zipFile.getEntries() ; entries.hasMoreElements() ; ){
                ZipEntry entry = (ZipEntry)entries.nextElement() ;
                File _file = new File(descDir + File.separator + entry.getName()) ;
                if( entry.isDirectory() ){
                    _file.mkdirs() ;
                }else{
                    File _parent = _file.getParentFile() ;
                    if( !_parent.exists() ){
                        _parent.mkdirs() ;
                    }
                    InputStream _in = _zipFile.getInputStream(entry);
                    OutputStream _out = new FileOutputStream(_file) ;
                    int len = 0 ;
                    byte[] _byte = new byte[1024];
                    while( (len = _in.read(_byte)) > 0){
                        _out.write(_byte, 0, len);
                    }
                    _in.close();
                    _out.flush();
                    _out.close();
                    _list.add(_file) ;
                }
            }
        } catch (IOException e) {
        }
        return _list ;
    }

    /**
     * @Author AlphaJunS
     * @Date 11:36 2020/3/8
     * @Description 对临时生成的文件夹和文件夹下的文件进行删除
     * @param delpath
     * @return void
     */
    public static void deletefile(String delpath) {
        try {
            File file = new File(delpath);
            if (!file.isDirectory()) {
                file.delete();
            } else if (file.isDirectory()) {
                String[] fileList = file.list();
                for (int i = 0; i < fileList.length; i++) {
                    File delfile = new File(delpath + File.separator + fileList[i]);
                    if (!delfile.isDirectory()) {
                        delfile.delete();
                    } else if (delfile.isDirectory()) {
                        deletefile(delpath + File.separator + fileList[i]);
                    }
                }
                file.delete();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * @Author Jan
     * @Description 生成具体的zip文件
     * @param zip   生成的压缩包的路径（包含文件名）
     * @param files 被压缩文件的集合
     * @return void
     */
    public static void createZip(String zip,List<File> files) throws FileNotFoundException {
        java.util.zip.ZipOutputStream zos=null;
        FileInputStream fileInputStream = null;
        fileInputStream = new FileInputStream(zip);
        Charset gbk = Charset.forName("gbk");
        ZipInputStream zin = new ZipInputStream(fileInputStream,gbk);
        File file1 = new File(zip);
        try {
            FileOutputStream out = new FileOutputStream(file1);
            zos = new java.util.zip.ZipOutputStream(out);
            for (File srcFile : files) {
                byte[] buf = new byte[BUFFER_SIZE];
                zos.putNextEntry(new java.util.zip.ZipEntry(srcFile.getName()));
                int len;
                FileInputStream in = new FileInputStream(srcFile);
                while ((len = in.read(buf)) != -1){
                    zos.write(buf, 0, len);
                }
                zos.closeEntry();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (zos != null) {
                try {
                    zos.close();
                    zin.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void downZipFile(HttpServletResponse response, String path) {
        try {
            File file = new File(path);
            if (file.exists()) {
                InputStream ins = new FileInputStream(path);
                BufferedInputStream bins = new BufferedInputStream(ins);// 放到缓冲流里面
                OutputStream outs = response.getOutputStream();// 获取文件输出IO流
                BufferedOutputStream bouts = new BufferedOutputStream(outs);
                //response.setContentType("application/zip");// 设置response内容的类型
                /*response.setHeader(
                        "Content-disposition",
                        "attachment;filename="
                                + URLEncoder.encode(str, "GBK"));// 设置头部信息*/
                int bytesRead = 0;
                byte[] buffer = new byte[8192];
                //开始向网络传输文件流
                while ((bytesRead = bins.read(buffer, 0, 8192)) != -1) {
                    bouts.write(buffer, 0, bytesRead);
                }
                bouts.flush();// 这里一定要调用flush()方法
                ins.close();
                bins.close();
                outs.close();
                bouts.close();
            } else {
                response.sendRedirect("../error.jsp");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
