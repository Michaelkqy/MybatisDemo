package com.mybatis.curd.testDept;

import com.mybatis.curd.dao.DeptDao;
import com.mybatis.curd.entities.Dept;
import com.mybatis.curd.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.Date;
import java.util.List;

/**
 * Created by kqy on 2017/3/13.
 */
public class TestTwo {
    public static void main(String[] args) {
        //获取sqlsession工厂
        SqlSessionFactory ssf= SqlSessionFactoryUtil.getSqlSessionFactory();
        //获取sqlsession
        SqlSession sqlsession= ssf.openSession();
        DeptDao deptDao=sqlsession.getMapper(DeptDao.class);

        try {
            Dept dept=new Dept();
            dept.setDname("119");
            dept.setComments("消防");
            dept.setTs(new Date());
            int rows=deptDao.insert(dept);
            System.out.println("影响的行数："+rows);

            List<Dept> list= deptDao.selectAll();
            for (Dept  d: list) {
                System.out.println(d.getDid()+"\t"+d.getDname()+"\t"+d.getComments()+"\t"+d.getTs());
            }
            sqlsession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            sqlsession.close();
        }
    }
}
