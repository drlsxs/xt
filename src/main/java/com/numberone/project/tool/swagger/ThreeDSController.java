package com.numberone.project.tool.swagger;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;

import javax.activation.MimetypesFileTypeMap;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.numberone.common.utils.StringUtils;
import com.numberone.framework.web.controller.BaseController;
import com.numberone.framework.web.domain.AjaxResult;
import com.numberone.project.gistools.threeservice.domain.GtThreeService;
import com.numberone.project.gistools.threeservice.service.IGtThreeServiceService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;

/**
 * swagger 用户测试方法
 * 
 * @author numberone
 */
@Api("三维数据服务")
@CrossOrigin
@RestController
@RequestMapping("/threeds")
public class ThreeDSController extends BaseController
{
	@Autowired
    private IGtThreeServiceService gtThreeServiceService;
	
    private final static Map<Integer, UserEntity> users = new LinkedHashMap<Integer, UserEntity>();
    {
        users.put(1, new UserEntity(1, "admin", "admin123", "15888888888"));
        users.put(2, new UserEntity(2, "ry", "admin123", "15666666666"));
    }
    
    @ApiOperation("获取三维数据服务")
    @GetMapping("/tileset/{pro}/{ptype}")
    public void tileset(@PathVariable("pro") String pro,@PathVariable("ptype") String ptype,HttpServletResponse response)
    {
    	Connection c = null;
        Statement stmt = null;
        GtThreeService gtThreeService = gtThreeServiceService.selectGtThreeServiceById(pro);
        String dbpath=gtThreeService.getFilePath();
        try {
          Class.forName("org.sqlite.JDBC");//加载驱动程序
          c = DriverManager.getConnection("jdbc:sqlite:"+dbpath);//获得数据库连接
          c.setAutoCommit(false);
          stmt = c.createStatement();//操作数据库
          
          if(ptype.contains(".json")){
        	  response.setContentType("application/json");
              ResultSet rs = stmt.executeQuery( "select tile from tiles where path='tileset.json';" );
              while ( rs.next() ) {
            	  InputStream input = rs.getBinaryStream("tile") ;
                  OutputStream out = response.getOutputStream();
                  deCompress(input,out);
                  input.close() ;
                  out.close();
                  break;
              }
              rs.close();
              stmt.close();
              c.close();
          }
          else{
        	  // 设置信息给客户端不解析
              String type = new MimetypesFileTypeMap().getContentType(ptype);
              // 设置contenttype，即告诉客户端所发送的数据属于什么类型
              response.setHeader("Content-type",type);
              // 设置编码
              //String hehe = new String(filename.getBytes("utf-8"), "iso-8859-1");
              // 设置扩展头，当Content-Type 的类型为要下载的类型时 , 这个信息头会告诉浏览器这个文件的名字和类型。
              response.setHeader("Content-Disposition", "attachment;filename=" + ptype);
              ResultSet rs = stmt.executeQuery( "select tile from tiles where path='"+ptype+"';" );
              while ( rs.next() ) {
            	  InputStream input = rs.getBinaryStream("tile") ;
            	  // 发送给客户端的数据
                  OutputStream out = response.getOutputStream();
                  deCompress(input,out);
                  input.close() ;
                  out.close() ;
                  break;
              }
              rs.close();
              stmt.close();
              c.close();
          }
        } catch ( Exception e ) {
          System.err.println( e.getClass().getName() + ": " + e.getMessage() );
          System.exit(0);
        }
    }
    
    public static void deCompress(InputStream is, OutputStream os) throws IOException {
        GZIPInputStream gis = new GZIPInputStream(is);
        int len = 0;
        byte[] buffer = new byte[1024];
        while ((len = gis.read(buffer)) != -1) {
            os.write(buffer, 0, len);
        }
        os.flush();
        gis.close();
    }
    
    public static String uncompress(String str) throws IOException {   
        if (str == null || str.length() == 0) {   
          return str;   
      }   
       ByteArrayOutputStream out = new ByteArrayOutputStream();   
       ByteArrayInputStream in = new ByteArrayInputStream(str   
            .getBytes("ISO-8859-1"));   
        GZIPInputStream gunzip = new GZIPInputStream(in);   
        byte[] buffer = new byte[256];   
        int n;   
       while ((n = gunzip.read(buffer))>= 0) {   
        out.write(buffer, 0, n);   
        }   
        // toString()使用平台默认编码，也可以显式的指定如toString(&quot;GBK&quot;)   
        return out.toString();   
      }
    
    public static byte[] uncompress(byte[] bytes) {
        if (bytes == null || bytes.length == 0) {
            return null;
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayInputStream in = new ByteArrayInputStream(bytes);
        try {
            GZIPInputStream ungzip = new GZIPInputStream(in);
            byte[] buffer = new byte[256];
            int n;
            while ((n = ungzip.read(buffer)) >= 0) {
                out.write(buffer, 0, n);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out.toByteArray();
    }
    
    @ApiOperation("获取用户列表")
    @GetMapping("/list")
    public AjaxResult userList()
    {
        List<UserEntity> userList = new ArrayList<UserEntity>(users.values());
        return AjaxResult.success(userList);
    }

    @ApiOperation("获取用户详细")
    @ApiImplicitParam(name = "userId", value = "用户ID", required = true, dataType = "int", paramType = "path")
    @GetMapping("/{userId}")
    public AjaxResult getUser(@PathVariable Integer userId)
    {
        if (!users.isEmpty() && users.containsKey(userId))
        {
            return AjaxResult.success(users.get(userId));
        }
        else
        {
            return error("用户不存在");
        }
    }

    @ApiOperation("新增用户")
    @ApiImplicitParam(name = "userEntity", value = "新增用户信息", dataType = "UserEntity")
    @PostMapping("/save")
    public AjaxResult save(UserEntity user)
    {
        if (StringUtils.isNull(user) || StringUtils.isNull(user.getUserId()))
        {
            return error("用户ID不能为空");
        }
        return AjaxResult.success(users.put(user.getUserId(), user));
    }

    @ApiOperation("更新用户")
    @ApiImplicitParam(name = "userEntity", value = "新增用户信息", dataType = "UserEntity")
    @PutMapping("/update")
    public AjaxResult update(UserEntity user)
    {
        if (StringUtils.isNull(user) || StringUtils.isNull(user.getUserId()))
        {
            return error("用户ID不能为空");
        }
        if (users.isEmpty() || !users.containsKey(user.getUserId()))
        {
            return error("用户不存在");
        }
        users.remove(user.getUserId());
        return AjaxResult.success(users.put(user.getUserId(), user));
    }

    @ApiOperation("删除用户信息")
    @ApiImplicitParam(name = "userId", value = "用户ID", required = true, dataType = "int", paramType = "path")
    @DeleteMapping("/{userId}")
    public AjaxResult delete(@PathVariable Integer userId)
    {
        if (!users.isEmpty() && users.containsKey(userId))
        {
            users.remove(userId);
            return success();
        }
        else
        {
            return error("用户不存在");
        }
    }
}
