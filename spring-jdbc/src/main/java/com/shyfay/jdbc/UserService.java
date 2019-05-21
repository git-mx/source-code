package com.shyfay.jdbc;

import java.util.List;

/**
 * @author mx
 * @since 2019/5/17
 */
public interface UserService {
    void save(User user);
    List<User> geuAll();
}
