package com.numberone.project.gistools.online.service;

import org.springframework.scheduling.annotation.Async;

/**
 * @Auther:wly
 * @Date:2022/3/31 10:32
 * @version:1.0
 */public interface IOnlineService {
     @Async
     boolean openWebTask();
     @Async
     boolean openFfmpegTask();
}
