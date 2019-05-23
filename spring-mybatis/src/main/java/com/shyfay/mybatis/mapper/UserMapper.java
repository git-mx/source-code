package com.shyfay.mybatis.mapper;

import com.shyfay.mybatis.User;

/**
 * @author mx
 * @since 2019/5/20
 */
public interface UserMapper {
    void insert(User user);
    User get(Integer id);
}
