package com.shyfay.mybatis;

/**
 * @author mx
 * @since 2019/5/20
 */
public interface UserMapper {
    void insert(User user);
    User get(Integer id);
}
