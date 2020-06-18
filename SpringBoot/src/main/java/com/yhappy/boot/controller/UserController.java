package com.yhappy.boot.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yhappy.boot.domain.UserDO;
import com.yhappy.boot.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>用户表 前端控制器</p>
 *
 * @author HY
 * @since 2020-06-18
 */
@Api(tags = {"用户表"})
@RestController
@RequestMapping("/user-do")
public class UserController {

    @Autowired
    private IUserService userService;


    @ApiOperation(value = "新增用户表")
    @PostMapping()
    public int add(@RequestBody UserDO userDO){
        return userService.add(userDO);
    }

    @ApiOperation(value = "删除用户表")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return userService.delete(id);
    }

    @ApiOperation(value = "更新用户表")
    @PutMapping()
    public int update(@RequestBody UserDO userDO){
        return userService.updateData(userDO);
    }

    @ApiOperation(value = "查询用户表分页数据")
    @ApiImplicitParams({@ApiImplicitParam(name = "page", value = "页码"), @ApiImplicitParam(name = "pageCount", value = "每页条数")})
    @GetMapping()
    public IPage<UserDO> findListByPage(@RequestParam Integer page, @RequestParam Integer pageCount){
        return userService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询用户表")
    @GetMapping("{id}")
    public UserDO findById(@PathVariable Long id){
        return userService.findById(id);
    }

}
