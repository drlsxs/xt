package com.numberone.common.gispublish;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.Objects;

import it.geosolutions.geoserver.rest.GeoServerRESTManager;
import it.geosolutions.geoserver.rest.GeoServerRESTReader;

public class GeoServerManager {
	//  加强geoserver publisher
	private final ImproveGeoServerPublisher geoServerRESTPublisher;
	//  geoserver REST 管理者
	private final GeoServerRESTManager geoServerRESTManager;
	//  geoserver REST 阅读者
	private final GeoServerRESTReader reader;
	
	/**
	   * 直接提供 geoserver 地址，用户名，密码为默认的： admin/geoserver
	   *
	   * @param restUrl geoserver 服务地址
	   * @throws MalformedURLException 服务地址错误
	   */
	public GeoServerManager(String restUrl) throws MalformedURLException {
	    this(restUrl, "admin", "geoserver");
	}

	/**
	   * 提供 geoserver 服务地址和用户名、密码
	   *
	   * @param restUrl  geoserver 服务地址
	   * @param userName geoserver登录用户名
	   * @param password geoserver 密码
	   * @throws MalformedURLException 服务地址或登录失败错误
	   */
	public GeoServerManager(String restUrl, String userName, String password) throws MalformedURLException {
	    geoServerRESTPublisher = new ImproveGeoServerPublisher(restUrl, userName, password);
	    geoServerRESTManager = new GeoServerRESTManager(new URL(restUrl), userName, password);
	    reader = new GeoServerRESTReader(restUrl, userName, password);
	}
	
	/**
	   * 创建工作空间
	   *
	   * @param workspaceName 工作空间名称
	   * @return 是否创建成功
	   * @throws ExistedException 工作空间已存在
	   */
	public Boolean createWorkspace(String workspaceName) throws Exception {
	    if (reader.existsWorkspace(workspaceName)) {
	        throw new Exception("工作空间；" + workspaceName);
	    }

	    return geoServerRESTPublisher.createWorkspace(workspaceName);
	}

	/**
	   * 通过名称 和 URI 创建工作空间
	   *
	   * @param workspaceName 工作空间名称
	   * @param uri           URI名称
	   * @return 是否创建成功
	   * @throws WorkSpaceNotFoundException 工作空间不存在
	   * @throws URISyntaxException URI 格式或链接错误
	   */
	public Boolean createWorkspace(String workspaceName, String uri) throws Exception {
	    if (!reader.existsWorkspace(workspaceName)) {
	        throw new Exception(workspaceName);
	    }

	    return geoServerRESTPublisher.createWorkspace(workspaceName, new URI(uri));
	}

	/**
	   * 删除工作空间
	   *
	   * @param workspaceName 要删除的工作空间名称
	   * @return 删除工作空间是否成功
	   * @throws WorkSpaceNotFoundException 工作空间不存在
	   */
	public Boolean removeWorkspace(String workspaceName) throws Exception {
	    if (!reader.existsWorkspace(workspaceName)) {
	        throw new Exception(workspaceName);
	    }

	    return geoServerRESTPublisher.removeWorkspace(workspaceName, true);
	}
	
	/**
	   * 创建 Style 服务
	   * 不能将同一 SLD 文件创建多个style 服务，这将会导致删除异常
	   *
	   * @param sldFile sld文件对象
	   * @return 返回是否创建成功
	   * @throws StyleServiceNotFoundException style 样式服务不存在
	   * @throws IOException 读取 SLD 文件错误
	   */
	public Boolean createStyle(File sldFile) throws Exception {
	    String sldFileName = sldFile.getName();

	    String[] split = sldFileName.split(".sld");
	    String styleName = split[0];

	    reader.existsStyle(styleName);

	    return this.createStyle(sldFile, styleName);
	}

	/**
	   * 创建 Style 服务，并提供style 服务名称
	   * 不能将同一 SLD 文件创建多个style 服务，这将会导致删除异常
	   *
	   * @param sldFile   sld 文件对象
	   * @param styleName style 服务名称
	   * @return 返回是否创建成功
	   * @throws StyleServiceNotFoundException style 样式服务不存在
	   * @throws IOException 读取 SLD 文件错误
	   */
	public Boolean createStyle(File sldFile, String styleName) throws Exception {
	    if (!reader.existsStyle(styleName)) {
	        throw new Exception(styleName);
	    }

	    //     请求路径
	    String url = String.format("%s/rest/styles?name=%s&raw=true", geoServerRESTPublisher.getRestURL(), styleName);
	    //     登录名、密码字符串
	    String logInStr = geoServerRESTPublisher.getUsername()+":"+geoServerRESTPublisher.getPassword();
	    //     获取sld文件内容
	    String file = ComTools.readFile(sldFile);

	    //     格式化 sld xml 文件
	    String sldInfo = file.replaceAll(" {4}", "").replaceAll(" {2}", "").replaceAll("\"", "\\\\\"");

	    String[] cmds = {
	        "curl", "-u", logInStr,
	        "-X", HttpConstant.POST, url,
	        "-H", AcceptType.JSON,
	        "-H", ContentType.SLD,
	        "-d", "\"" + sldInfo + "\""
	    };

	    String curlPostResult = ComTools.curlPost(cmds);

	    /*
	     * ================================================ 创建完需要put一下
	     * */

	    //     请求路径
	    String urlPUT = String.format("%s/rest/styles/%s?raw=true", geoServerRESTPublisher.getRestURL(), styleName);

	    String[] cmdsPUT = {
	        "curl", "-u", logInStr,
	        "-X", HttpConstant.PUT, urlPUT,
	        "-H", AcceptType.JSON,
	        "-H", ContentType.SLD,
	        "-d", "\"" + sldInfo + "\""
	    };

	    ComTools.curlPUT(cmdsPUT);

	    return Objects.equals(curlPostResult, styleName);
	}

	/**
	   * 删除style服务
	   *
	   * @param styleName 要删除的style 名称
	   * @return 是否删除成功
	   * @throws StyleServiceNotFoundException 样式服务不存在
	   */
	public Boolean removeStyle(String styleName) throws Exception {
	    if (!reader.existsStyle(styleName)) {
	        throw new Exception(styleName);
	    }

	    return geoServerRESTPublisher.removeStyle(styleName, true);
	}

	/**
	   * 创建 Style 服务到指定的工作空间下
	   * 不能将同一 SLD 文件创建多个style 服务，这将会导致删除异常
	   *
	   * @param workspaceName 工作空间名称
	   * @param sldFile       sld文件对象
	   * @return 返回是否创建成功
	   * @throws WorkSpaceNotFoundException 工作空间不存在
	   * @throws ExistedException           style服务已存在
	   * @throws IOException                文件错误
	   */
	public Boolean createStyleToWorkspace(String workspaceName, File sldFile) throws Exception {
	    reader.existsWorkspace(workspaceName);

	    String sldFileName = sldFile.getName();
	    String styleName = sldFileName.split(".sld")[0];

	    return this.createStyleToWorkspace(workspaceName, sldFile, styleName);
	}

	/**
	   * 创建 Style 服务到指定的工作空间下，并提供style 服务名称
	   * 不能将同一 SLD 文件创建多个style 服务，这将会导致删除异常
	   *
	   * @param workspaceName 工作空间名称
	   * @param sldFile       sld 文件对象
	   * @param styleName     style 服务名称
	   * @return 返回是否创建成功
	   * @throws WorkSpaceNotFoundException 工作空间不存在
	   * @throws ExistedException           style样式服务已存在
	   * @throws IOException                文件错误
	   */
	public Boolean createStyleToWorkspace(String workspaceName, File sldFile, String styleName) throws Exception {
	    if (reader.existsStyle(workspaceName, styleName)) {
	        throw new Exception("style 样式服务：" + styleName);
	    }

	    //     请求路径
	    String url = String.format("%s/rest/workspaces/%s/styles?name=%s&raw=true", geoServerRESTPublisher.getRestURL(), workspaceName, styleName);
	    //     登录名、密码字符串
	    String logInStr = geoServerRESTPublisher.getUsername()+":"+geoServerRESTPublisher.getPassword();
	    //     获取sld文件内容
	    String file = ComTools.readFile(sldFile);

	    //     格式化 sld xml 文件
	    String sldInfo = file.replaceAll(" {4}", "").replaceAll(" {2}", "").replaceAll("\"", "\\\\\"");

	    String[] cmds = {
	        "curl", "-u", logInStr,
	        "-X", HttpConstant.POST, url,
	        "-H", AcceptType.JSON,
	        "-H", ContentType.SLD,
	        "-d", "\"" + sldInfo + "\""
	    };

	    String curlPostResult = ComTools.curlPost(cmds);

	    /*
	     * ================================================ 创建完需要put一下
	     * */

	    //     请求路径
	    String urlPUT = String.format("%s/rest/workspaces/%s/styles/%s?raw=true", geoServerRESTPublisher.getRestURL(), workspaceName, styleName);

	    String[] cmdsPUT = {
	        "curl", "-u", logInStr,
	        "-X", HttpConstant.PUT, urlPUT,
	        "-H", AcceptType.JSON,
	        "-H", ContentType.SLD,
	        "-d", "\"" + sldInfo + "\""
	    };

	    ComTools.curlPUT(cmdsPUT);

	    return Objects.equals(curlPostResult, styleName);
	}

	/**
	   * 删除工作空间下的style服务
	   *
	   * @param workspaceName 工作空间名称
	   * @param styleName     要删除的style 名称
	   * @return 是否删除成功
	   * @throws WorkSpaceNotFoundException    工作空间不存在
	   * @throws StyleServiceNotFoundException 样式服务不存在
	   */
	public Boolean removeStyleFromWorkspace(String workspaceName, String styleName) throws Exception {
	    if (!reader.existsStyle(workspaceName, styleName)) {
	        throw new Exception(styleName);
	    }

	    return geoServerRESTPublisher.removeStyleInWorkspace(workspaceName, styleName, true);
	}
	
	/**
	   * 发布Tiff 服务（wms）
	   *
	   * @param workspaceName 工作空间名称
	   * @param layerName     图层名称
	   * @param tifFile       tif 文件对象
	   * @return 是否发布成功
	   * @throws FileNotFoundException      没有找到文件
	   * @throws WorkSpaceNotFoundException 工作空间不存在
	   * @throws ExistedException           图层已存在
	   */
	public Boolean createGeoTIFFLayer(String workspaceName, String layerName, File tifFile) throws Exception {
	    if (reader.existsLayer(workspaceName, layerName)) {
	        throw new Exception("图层：" + layerName);
	    }

	    return geoServerRESTPublisher.publishGeoTIFF(workspaceName, layerName, tifFile);
	}
}
