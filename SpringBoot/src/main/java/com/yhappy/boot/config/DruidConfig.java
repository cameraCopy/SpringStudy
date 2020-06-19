package com.yhappy.boot.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <p></p>
 *
 * @author liwei
 * @date 2020/6/18 17:52
 **/
@Configuration
public class DruidConfig {
    /**
     * 把配置文件中自己配置的数据源值注入到druid
     *
     * @return 数据库资源
     */
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource druid() {
        return new DruidDataSource();
    }

    /**
     * 配置Druid的监控，如果不配置这个类，将连接不上druid后台。http://localhost:8080/druid/
     * 配置一个管理后台的Servlet
     *
     * @return Servlet
     */
    @Bean
    public ServletRegistrationBean<StatViewServlet> statViewServlet() {
        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");
        Map<String, String> params = new HashMap<>(4);
        //设置后台登录名、密码
        params.put("loginUsername", "admin");
        params.put("loginPassword", "666");
        //设置默认就是允许所有访问、设置黑名单
        params.put("allow", "");
        // params.put("deny", "");
        bean.setInitParameters(params);
        return bean;
    }

    /**
     * 配置一个web监控的filter,如果不配置这个类，在页面的Web模块功能不会开启
     *
     * @return 过滤器
     */
    @Bean
    public FilterRegistrationBean<WebStatFilter> webStatFilter() {
        FilterRegistrationBean<WebStatFilter> frb = new FilterRegistrationBean<>();
        frb.setFilter(new WebStatFilter());
        Map<String, String> params = new HashMap<>();
        //设置不拦截请求
        params.put("exclusions", "*.js,*.css,/druid/*");
        frb.setInitParameters(params);
        //拦截请求
        frb.setUrlPatterns(Arrays.asList("/*"));
        return frb;
    }
}
