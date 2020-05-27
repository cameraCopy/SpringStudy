package com.yhappy.security.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * <p></p>
 *     自定义数据源来获取数据
 *     这里只要是存在一个自定义的 UserDetailsService ，那么security将会使用该实例进行配置
 * @author liwei
 * @date 2020/5/26 14:43
 **/
@Slf4j
@Component
public class UserServiceImpl implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * <p>可以从任何地方获取数据</p>
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        // 根据用户名查找用户信息
        log.info("登录用户名:{}", username);
        // 写死一个密码，赋予一个admin权限
        String password = "123";
        log.info("密码：{}", password);
        /*
            isEnabled 账户是否启用
            isAccountNonExpired 账户没有过期
            isCredentialsNonExpired 身份认证是否是有效的
            isAccountNonLocked 账户没有被锁定
         */
        User user = new User(username, password, true, true, true, false,
                AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
        return user;
    }

}
