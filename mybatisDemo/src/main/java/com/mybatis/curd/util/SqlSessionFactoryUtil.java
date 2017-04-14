package com.mybatis.curd.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * Created by kqy on 2017/3/12.
 */
public class SqlSessionFactoryUtil {
    private SqlSessionFactoryUtil(){}
    public static SqlSessionFactory ssf=null;
    public static SqlSessionFactory getSqlSessionFactory(){
        try {
            if(ssf==null){
                String resource = "mybatis-config.xml";
                InputStream inputStream = Resources.getResourceAsStream(resource);
                ssf = new SqlSessionFactoryBuilder().build(inputStream);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ssf;
    }
}
