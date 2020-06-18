package com.yhappy.boot.service;

import com.yhappy.boot.domain.UserDO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>用户表 服务类</p>
 *
 * @author HY
 * @since 2020-06-18
 */
public interface IUserService extends IService<UserDO> {

    /**
     * <p>查询用户表分页数据</p>
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<UserDO>
     */
    IPage<UserDO> findListByPage(Integer page, Integer pageCount);

    /**
     * <p>添加用户表</p>
     *
     * @param userDO 用户表
     * @return int
     */
    int add(UserDO userDO);

    /**
     * <p>删除用户表</p>
     *
     * @param id 主键
     * @return int
     */
    int delete(Long id);

    /**
     * <p>修改用户表</p>
     *
     * @param userDO 用户表
     * @return int
     */
    int updateData(UserDO userDO);

    /**
     * <p>id查询数据</p>
     *
     * @param id id
     * @return UserDO
     */
    UserDO findById(Long id);
}
