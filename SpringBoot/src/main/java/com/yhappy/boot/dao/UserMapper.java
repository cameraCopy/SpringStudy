package com.yhappy.boot.dao;

import com.yhappy.boot.domain.UserDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>用户表 Mapper 接口</p>
 *
 * @author HY
 * @since 2020-06-18
 */
@Mapper
public interface UserMapper extends BaseMapper<UserDO> {

}
