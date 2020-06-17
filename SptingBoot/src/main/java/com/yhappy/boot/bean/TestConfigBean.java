package com.yhappy.boot.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * <p>自定义配置文件</p>
 *
 * @author liwei
 * @date 2020/6/17 9:37
 **/
@Data
@Configuration
@PropertySource("classpath:test.properties")//指明了使用哪个配置文件
@ConfigurationProperties(prefix="test")
public class TestConfigBean {
    private String name;
    private String age;
}
