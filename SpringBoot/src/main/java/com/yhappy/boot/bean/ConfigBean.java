package com.yhappy.boot.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * <p>自定义属性值</p>
 *  在属性非常多的情况下，也可以定义一个和配置文件对应的Bean
 * @author liwei
 * @date 2020/6/17 9:37
 **/
@Data
@ConfigurationProperties(prefix="mrbird.blog")//指明了属性的通用前缀，通用前缀加属性名和配置文件的属性名一一对应。
@Component
public class ConfigBean {
    private String name;
    private String title;
}
