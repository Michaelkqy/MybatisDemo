package com.mybatis.curd.testDept;

import com.mybatis.curd.dao.DeptDao;
import com.mybatis.curd.entities.Dept;
import com.mybatis.curd.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by kqy on 2017/3/13.
 */
public class TestThree {
    public static void main(String[] args) {
        //获取sqlsession工厂
        SqlSessionFactory ssf= SqlSessionFactoryUtil.getSqlSessionFactory();
        //获取sqlsession
        SqlSession sqlsession= ssf.openSession();
        DeptDao deptDao=sqlsession.getMapper(DeptDao.class);

//        Dept dd=new Dept();
//        dd.setDid(1);
//        dd.setDname("城管");
//        dd.setComments("也怕某些人");
//        dd.setTs(new Date());
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("did",1);
        map.put("ts",new Date());

        try {
//            int rows=deptDao.updateDeptById(dd);
            int rows=deptDao.updateDeptByIdMap(map);

            System.out.println("行数："+rows);

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
