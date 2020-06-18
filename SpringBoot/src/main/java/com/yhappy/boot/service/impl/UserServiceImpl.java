package com.yhappy.boot.service.impl;

import com.yhappy.boot.domain.UserDO;
import com.yhappy.boot.dao.UserMapper;
import com.yhappy.boot.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author HY
 * @since 2020-06-18
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserDO> implements IUserService {

    @Override
    public  IPage<UserDO> findListByPage(Integer page, Integer pageCount){
        IPage<UserDO> wherePage = new Page<>(page, pageCount);
        UserDO where = new UserDO();
        return baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(UserDO userDO){
        return baseMapper.insert(userDO);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(UserDO userDO){
        return baseMapper.updateById(userDO);
    }

    @Override
    public UserDO findById(Long id){
        return  baseMapper.selectById(id);
    }
}
