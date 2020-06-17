package com.yhappy.boot.controller;

import com.yhappy.boot.bean.BlogProperties;
import com.yhappy.boot.bean.ConfigBean;
import com.yhappy.boot.bean.TestConfigBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author liwei
 * @date 2020/6/17 9:34
 **/
@RestController
public class IndexController {
    private final ConfigBean configBean;
    private final BlogProperties blogProperties;
    private final TestConfigBean testConfigBean;

    @Autowired
    public IndexController(BlogProperties blogProperties, ConfigBean configBean, TestConfigBean testConfigBean) {
        this.blogProperties = blogProperties;
        this.configBean = configBean;
        this.testConfigBean = testConfigBean;
    }

    @RequestMapping("/blogProperties")
    String blogProperties() {
        return blogProperties.getName()+"——"+blogProperties.getTitle();
    }

    @RequestMapping("/configBean")
    String configBean() {
        return configBean.getName()+"——"+configBean.getTitle();
    }

    @RequestMapping("/TestConfigBean")
    String TestConfigBean() {
        return testConfigBean.getName()+"——"+testConfigBean.getAge();
    }
}
