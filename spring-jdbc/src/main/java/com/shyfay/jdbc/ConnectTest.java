package com.shyfay.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author mx
 * @since 2019/5/17
 */
public class ConnectTest {
    public static void main(String[] args) {
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shyfay-test", "root", "root");
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO user(name, age, sex)VALUES('张飞', 18, '男')");
            ResultSet resultSet = statement.executeQuery("SELECT * FROM user");
            List<User> all = new ArrayList<User>();
            while(resultSet.next()){
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setAge(resultSet.getInt("age"));
                user.setSex(resultSet.getString("sex"));
                all.add(user);
            }
            System.out.println(all);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
