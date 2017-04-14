package com.mybatis.curd.testEmp;

import com.mybatis.curd.dao.EmployeeDao;
import com.mybatis.curd.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by kqy on 2017/3/13.
 */
public class TestEmpEight {
    public static void main(String[] args) {
        //获取sqlsession工厂
        SqlSessionFactory ssf= SqlSessionFactoryUtil.getSqlSessionFactory();
        //获取sqlsession
        SqlSession sqlsession= ssf.openSession();
        EmployeeDao empDao=sqlsession.getMapper(EmployeeDao.class);
        List<Integer> eids=new ArrayList<Integer>();
        eids.add(5);
        Map<String,Object> map=new HashMap<String,Object>();

        try {
            int row=empDao.updateBatchByEidsList(eids);
            System.out.println("row:"+row);

            List<Map<String,Object>> listp=empDao.selectAllBy(map);
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
