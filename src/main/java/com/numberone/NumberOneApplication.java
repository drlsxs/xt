package com.numberone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.io.IOException;

/**
 * 启动程序
 *
 * @author numberone
 */
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class NumberOneApplication
{
    public static void main(String[] args) throws IOException {
        // System.setProperty("spring.devtools.restart.enabled", "false");

        SpringApplication.run(NumberOneApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  xsgistools启动成功   ლ(´ڡ`ლ)ﾞ  \n");
    }
}
