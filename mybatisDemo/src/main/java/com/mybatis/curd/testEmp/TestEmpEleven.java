package com.mybatis.curd.testEmp;

import com.mybatis.curd.dao.EmployeeDao;
import com.mybatis.curd.entities.Employee;
import com.mybatis.curd.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by kqy on 2017/3/13.
 */
public class TestEmpEleven {
    public static void main(String[] args) {
        //获取sqlsession工厂
        SqlSessionFactory ssf= SqlSessionFactoryUtil.getSqlSessionFactory();
        //获取sqlsession
        SqlSession sqlsession= ssf.openSession();
        EmployeeDao empDao=sqlsession.getMapper(EmployeeDao.class);

        List<Employee> list =new ArrayList<Employee>();

        Employee emp1=new Employee();
        emp1.setEname("测试批量insert1");
        emp1.setDid(5);
        emp1.setComments("test");
        emp1.setTs(new Date());
        list.add(emp1);

        Employee emp2=new Employee();
        emp2.setEname("测试批量insert2");
        emp2.setDid(7);
        emp2.setComments("test");
        emp2.setTs(new Date());
        list.add(emp2);

        try {
            int rows =empDao.batchInsert(list);
            System.out.println("rows:"+rows);
            List<Employee> lista= empDao.selectAll();
            for (Employee emp3: lista) {
                System.out.println(emp3.getEid()+"\t"+emp3.getEname()+"\t"+emp3.getTs());
            }
            sqlsession.commit();
        } catch (Exception e) {
            sqlsession.rollback();
            e.printStackTrace();
        }finally{
            sqlsession.close();
        }
    }
}
