package com.shyfay.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * @author mx
 * @since 2019/5/20
 */
public class MybatisUtil {
    private final static SqlSessionFactory sqlSessionFactory;
    static {
        String resource = "config.xml";
        Reader reader = null;
        try{
            reader = Resources.getResourceAsReader(resource);
        }catch(IOException e){
            e.printStackTrace();
        }
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
    }
    public static SqlSessionFactory getSqlSessionFactory(){
        return sqlSessionFactory;
    }
}
