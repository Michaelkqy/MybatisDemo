package com.mybatis.curd.testEmp;

import com.mybatis.curd.dao.EmployeeDao;
import com.mybatis.curd.entities.Employee;
import com.mybatis.curd.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.Date;
import java.util.List;

/**
 * Created by kqy on 2017/3/13.
 */
public class TestEmpTwo {
    public static void main(String[] args) {
        //获取sqlsession工厂
        SqlSessionFactory ssf= SqlSessionFactoryUtil.getSqlSessionFactory();
        //获取sqlsession
        SqlSession sqlsession= ssf.openSession();
        EmployeeDao empDao=sqlsession.getMapper(EmployeeDao.class);

        Employee emp=new Employee();
        emp.setEname("http");
        emp.setDid(3);
        emp.setComments("test print sql");
        emp.setTs(new Date());

        try {
            int rows =empDao.insert(emp);
            System.out.println("rows:"+rows);
            List<Employee> lista= empDao.selectAll();
            for (Employee emp2: lista) {
                System.out.println(emp2.getEid()+"\t"+emp2.getEname()+"\t"+emp2.getTs());
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
