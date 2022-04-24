package com.numberone.project.gistools.twoDStyle.controller;

import com.numberone.framework.web.domain.AjaxResult;
import com.numberone.project.gistools.twoDStyle.service.StyleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.Map;

/**
 * @author hwx
 * @date 2022/4/11 17:28
 */
@Controller
@RequestMapping("/gistools/style")
public class StyleController {
    @Autowired
    private StyleService styleService;


    @GetMapping("/getAllStyleName/{type}")
    @ResponseBody
    public AjaxResult getAllStyleName(@PathVariable("type")String type) throws MalformedURLException, UnsupportedEncodingException {
        List allStyleName = styleService.getAllStyleName(type);
        return AjaxResult.success(allStyleName);
    }

    @GetMapping("/existStyle/{styleName}")
    @ResponseBody
    public AjaxResult existStyle(@PathVariable("styleName")String styleName) throws MalformedURLException {
        styleName = styleName + "1";
        boolean b = styleService.existStyle(styleName);
        return AjaxResult.success(b);
    }

    @PostMapping("/pointStyle")
    @ResponseBody
    public AjaxResult pointStyle(@RequestParam("file") MultipartFile file,
                                 @RequestParam("name")String styleName) throws MalformedURLException {
        styleName = styleName + "1";
        return styleService.pointStyle(file,styleName);
    }


    @PostMapping("/existService")
    @ResponseBody
    public AjaxResult existService(@RequestBody String url){
        boolean b = styleService.existService(url);
        return AjaxResult.success(b);
    }

    @PostMapping("/deleteStyle")
    @ResponseBody
    public AjaxResult deleteStyle(@RequestBody String styleName){
        return styleService.deleteStyle(styleName);
    }

}
