package com.mybatis.curd.testEmp;

import com.mybatis.curd.dao.EmployeeDao;
import com.mybatis.curd.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.*;

/**
 * Created by kqy on 2017/3/13.
 */
public class TestEmpNine {
    public static void main(String[] args) {
        //获取sqlsession工厂
        SqlSessionFactory ssf= SqlSessionFactoryUtil.getSqlSessionFactory();
        //获取sqlsession
        SqlSession sqlsession= ssf.openSession();
        EmployeeDao empDao=sqlsession.getMapper(EmployeeDao.class);

        Map<String,Object> map2=new HashMap<String,Object>();
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("eids",9);


        try {
            int row=empDao.updateBatchByEidsMap(map);
            System.out.println("row:"+row);

            List<Map<String,Object>> listp=empDao.selectAllBy(map2);
            /*for (int i=0;i<listp.size();i++){
                Map<String,Object> map1=listp.get(i);
                System.out.println(map1.get("eid")+"\t"+map1.get("ename"));
            }*/
            sqlsession.commit();
        } catch (Exception e) {
            sqlsession.rollback();
            e.printStackTrace();
        }finally{
            sqlsession.close();
        }
    }
}
