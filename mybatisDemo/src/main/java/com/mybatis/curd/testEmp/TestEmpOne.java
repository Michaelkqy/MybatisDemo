package com.mybatis.curd.testEmp;

import com.mybatis.curd.dao.EmployeeDao;
import com.mybatis.curd.entities.Employee;
import com.mybatis.curd.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by kqy on 2017/3/13.
 */
public class TestEmpOne {
    public static void main(String[] args) {
        //获取sqlsession工厂
        SqlSessionFactory ssf= SqlSessionFactoryUtil.getSqlSessionFactory();
        //获取sqlsession
        SqlSession sqlsession= ssf.openSession();
        EmployeeDao empDao=sqlsession.getMapper(EmployeeDao.class);
//        Map<String,Object> map=new HashMap<String,Object>();
//        map.put("","");
        List<Integer> eidList=new ArrayList<Integer>();
        eidList.add(1);
        eidList.add(5);
        eidList.add(8);
        eidList.add(9);

        Integer[] eids={2,3,6,10,11};

        try {
            List<Employee> lista= empDao.selectAll();
            for (Employee emp: lista) {
                System.out.println(emp.getEid()+"\t"+emp.getEname()+"\t"+emp.getTs());
            }
            System.out.println("***============================================***");
            System.out.println("List传参方式：");
            List<Map<String,Object>> list1= empDao.getByEidList(eidList);
            for (int i=0;i<list1.size();i++){
                Map<String,Object> mp=list1.get(i);
                System.out.println(mp.get("eid")+"\t"+mp.get("ename"));
            }
            System.out.println("***============================================***");
            System.out.println("数组传参方式：");
            List<Map<String,Object>> list2= empDao.getEmpListByEid_foreach_array(eids);
            for (int i=0;i<list2.size();i++){
                Map<String,Object> mp=list2.get(i);
                System.out.println(mp.get("eid")+"\t"+mp.get("ename"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            sqlsession.close();
        }
    }
}
