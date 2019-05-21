package com.shyfay.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author mx
 * @since 2019/5/20
 */
public class UserMapperTest {

    static SqlSessionFactory sqlSessionFactory = null;
    static {
        sqlSessionFactory = MybatisUtil.getSqlSessionFactory();
    }

    @Test
    public void insert() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try{
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = new User("赵云", new Integer(18), "男");
            userMapper.insert(user);
            sqlSession.commit();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void get() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try{
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = userMapper.get(1);
            System.out.println(user);
        }catch(Exception e){

        }
    }
}