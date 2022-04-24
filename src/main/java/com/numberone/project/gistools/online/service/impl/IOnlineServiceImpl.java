package com.numberone.project.gistools.online.service.impl;

import com.numberone.project.gistools.online.service.IOnlineService;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * @Auther:wly
 * @Date:2022/3/31 10:32
 * @version:1.0
*/
@Service
public class IOnlineServiceImpl implements IOnlineService {

//     private static final ExecutorService fixedThreadPool = Executors.newFixedThreadPool(2);
     private static Process ffmProcess;

     private static Process webProcess;



     private static  void webTask(){
          String webpath = "D:\\worklibrary\\jsmpeg-master";
          Runtime run= null;
          System.out.println(new File(webpath).getAbsolutePath());
          try{
               run = Runtime.getRuntime();
               long start = System.currentTimeMillis();
               //File diretory = new File("");
               System.out.println("开始");
               webProcess = run.exec("node websocket-relay.js supersecret 8081 8082",null,new File(webpath));
               System.out.println("结束");
               long end = System.currentTimeMillis();
               System.out.println("转化结束"+(end-start));
               webProcess.waitFor();
          }catch (Exception e){
               e.printStackTrace();
          }finally {
               run.freeMemory();
          }
     };

     private static void ffmpegTask(){
          String webroot = "D:\\worklibrary\\ffmpeg-2022-03-17-git-242c07982a-essentials_build\\bin";
          Runtime run= null;
          System.out.println(new File(webroot).getAbsolutePath());
          try{
               run = Runtime.getRuntime();
               long start = System.currentTimeMillis();
               System.out.println("开始");
               System.out.println("结束");
               ffmProcess = run.exec(new File(webroot).getAbsolutePath()+"/ffmpeg -i "+"rtsp://localhost:8554/a"+" -q 0 -f mpegts -codec:v mpeg1video -s 1366x768 http://127.0.0.1:8081/supersecret ");
               long end = System.currentTimeMillis();
               System.out.println("转化结束"+(end-start));
               ffmProcess.getOutputStream().close();
               ffmProcess.getInputStream().close();
               ffmProcess.getErrorStream().close();
               ffmProcess.waitFor();
          }catch (Exception e){
               e.printStackTrace();
          }finally {
               run.freeMemory();
          }
     };

     @Override
     public boolean openWebTask() {
          try {
               if (webProcess==null){
                    webTask();
               }
          } catch (Exception e) {
               e.printStackTrace();
               return false;
          }
          return true;
     }

     @Override
     public boolean openFfmpegTask() {
          try {
               if (ffmProcess==null){
                    ffmpegTask();
               }
          } catch (Exception e) {
               e.printStackTrace();
               return false;
          }
          return true;
     }
}
