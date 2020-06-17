package com.yhappy.boot;

import com.yhappy.boot.bean.ConfigBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

@SpringBootApplication
/*@EnableConfigurationProperties：使使用 @ConfigurationProperties 注解的类生效。
如果一个配置类只配置@ConfigurationProperties注解，而没有使用@Component，那么在IOC容器中是获取不到properties 配置文件转化的bean。*/
//@EnableConfigurationProperties({ConfigBean.class})
@MapperScan("com.baomidou.mybatisplus.samples.quickstart.mapper")
public class BootApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(BootApplication.class);
//        app.setBannerMode(Banner.Mode.OFF);  //关闭启动图案
        app.run(args);
    }

}
