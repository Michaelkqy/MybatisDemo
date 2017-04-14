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
public class TestEmpThree {
    public static void main(String[] args) {
        //获取sqlsession工厂
        SqlSessionFactory ssf= SqlSessionFactoryUtil.getSqlSessionFactory();
        //获取sqlsession
        SqlSession sqlsession= ssf.openSession();
        EmployeeDao empDao=sqlsession.getMapper(EmployeeDao.class);
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("ename","a");

        Map<String,Object> map2=new HashMap<String,Object>();
        map2.put("comments","abc");

        try {
            List<Map<String,Object>> listp=empDao.selectAllBy(map);
            for (int i=0;i<listp.size();i++){
                Map<String,Object> map1=listp.get(i);
                System.out.println(map1.get("eid")+"\t"+map1.get("ename"));
            }
            System.out.println("********************************************************************");
            List<Map<String,Object>> listp2=empDao.getEmpList_if_trim(map2);
            for (int i=0;i<listp2.size();i++){
                Map<String,Object> map3=listp2.get(i);
                System.out.println(map3.get("eid")+"\t"+map3.get("ename"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            sqlsession.close();
        }
    }
}
