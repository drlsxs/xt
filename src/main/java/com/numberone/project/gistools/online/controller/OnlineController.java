package com.numberone.project.gistools.online.controller;

import com.numberone.framework.web.domain.AjaxResult;
import com.numberone.project.gistools.online.service.IOnlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther:wly
 * @Date:2022/3/31 10:31
 * @version:1.0
 */
@RestController
@RequestMapping("/gistools/video")
public class OnlineController {
    @Autowired
    private IOnlineService onlineService;

    @GetMapping("/open")
    public AjaxResult openStream(){
        onlineService.openWebTask();
        onlineService.openFfmpegTask();
        return AjaxResult.success();
    }
}
