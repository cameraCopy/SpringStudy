package com.yhappy.security.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p></p>
 *
 * @author liwei
 * @date 2020/5/25 16:14
 **/
@Api(tags = "用户")
@RestController
@RequestMapping("api/index")
public class IndexController {

    @ApiOperation(value = "home")
    @GetMapping("home")
    public String removeThird() {
        return "home";
    }
}
