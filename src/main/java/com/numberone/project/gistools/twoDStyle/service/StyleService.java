package com.numberone.project.gistools.twoDStyle.service;

import com.numberone.framework.web.domain.AjaxResult;
import org.springframework.web.multipart.MultipartFile;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.util.List;

/**
 * @author hwx
 * @date 2022/4/11 17:29
 */
public interface StyleService {

    List getAllStyleName(String type) throws MalformedURLException, UnsupportedEncodingException;

    boolean existStyle(String styleName);

    AjaxResult pointStyle(MultipartFile file, String styleName);

    boolean existService(String url);

    AjaxResult deleteStyle(String styleName);
}
