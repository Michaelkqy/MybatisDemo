package com.mybatis.curd.testEmp;

import com.mybatis.curd.dao.EmployeeDao;
import com.mybatis.curd.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by kqy on 2017/3/13.
 */
public class TestEmpTen {
    public static void main(String[] args) {
        //获取sqlsession工厂
        SqlSessionFactory ssf= SqlSessionFactoryUtil.getSqlSessionFactory();
        //获取sqlsession
        SqlSession sqlsession= ssf.openSession();
        EmployeeDao empDao=sqlsession.getMapper(EmployeeDao.class);

        Map<String,Object> map=new HashMap<String,Object>();
        map.put("bgts","2017-03-13 22:01:40");
        map.put("edts","2017-03-11 18:29:30");

        try {

            List<Map<String,Object>> listp=empDao.selectInnerJoin(map);

//            sqlsession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            sqlsession.close();
        }
    }
}
