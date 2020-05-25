package com.yhappy.security.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p></p>
 *
 * @author liwei
 * @date 2020/5/20 15:55
 **/
@Api(tags = "用户")
@RestController
@RequestMapping("api/user")
public class UserController {

    @ApiOperation(value = "登录")
    @PostMapping("login")
    public ResponseEntity<?> removeThird() {
        return null;
    }

}
