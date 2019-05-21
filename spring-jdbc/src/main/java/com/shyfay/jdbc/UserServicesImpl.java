package com.shyfay.jdbc;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

/**
 * @author mx
 * @since 2019/5/17
 */
public class UserServicesImpl implements UserService {

    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void save(User user) {
        jdbcTemplate.update("insert into user(name, age, sex) values (?, ?, ?)",
            new Object[] {user.getName(), user.getAge(), user.getSex(),},
            new int[] {java.sql.Types.VARCHAR, java.sql.Types.INTEGER, java.sql.Types.VARCHAR}
        );
    }
    @SuppressWarnings("unckecked")
    public List<User> geuAll() {
        List<User> list = jdbcTemplate.query("select * from user", new UserRowMapper());
        return list;
    }
}
