package com.yhappy.security.service;

import org.springframework.security.core.userdetails.UserDetails;

/**
 * <p></p>
 *
 * @author liwei
 * @date 2020/5/26 14:42
 **/
public interface UserService {

    /**
     * <p></p>
     * @param username
     * @return
     */
    UserDetails loadUserByUsername(String username);
}
