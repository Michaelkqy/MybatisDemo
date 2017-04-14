package com.mybatis.curd.testDept;

import com.mybatis.curd.dao.DeptDao;
import com.mybatis.curd.entities.Dept;
import com.mybatis.curd.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by kqy on 2017/3/13.
 */
public class TestOne {
    public static void main(String[] args) {
        //获取sqlsession工厂
        SqlSessionFactory ssf= SqlSessionFactoryUtil.getSqlSessionFactory();
        //获取sqlsession
        SqlSession sqlsession= ssf.openSession();
        DeptDao deptDao=sqlsession.getMapper(DeptDao.class);
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("dname","110");

        try {
            List<Dept> lista= deptDao.selectAll();
            for (Dept d: lista) {
                System.out.println(d.getDid()+"\t"+d.getDname()+"\t"+d.getComments()+"\t"+d.getTs());
            }
            System.out.println("============================================");
            List<Map<String,Object>> list= deptDao.findAll(map);
            for (int i=0;i<list.size();i++){
                Map<String,Object> mp=list.get(i);
                System.out.println(mp.get("did")+"\t"+mp.get("dname"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            sqlsession.close();
        }
    }
}
