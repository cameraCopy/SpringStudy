package com.yhappy.boot.bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * <p>自定义属性值</p>
 *  通过@Value("${属性名}")来加载配置文件中的属性值
 *
 * @author liwei
 * @date 2020/6/17 9:33
 **/
@Data
@Component
public class BlogProperties {
    @Value("${mrbird.blog.name}")
    private String name;

    @Value("${mrbird.blog.title}")
    private String title;
}
