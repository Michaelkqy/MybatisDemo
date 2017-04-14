package com.mybatis.curd.dao;

import com.mybatis.curd.entities.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface EmployeeDao {

    int deleteByPrimaryKey(Integer eid);
    int insert(Employee record);
    Employee selectByPrimaryKey(Integer eid);
    List<Employee> selectAll();
    int updateByPrimaryKey(Employee record);




    List<Map<String,Object>> getByEidList(List<Integer> eidList);
    List<Map<String,Object>> getEmpListByEid_foreach_array(Integer[] eids);
    List<Map<String,Object>> selectAllBy(Map<String,Object> map);
    List<Map<String,Object>> getEmpList_if_trim(Map<String,Object> map);
    int updateEmp_if_set(Map<String,Object> map);
    int batchDeleteByPriKey(List<Integer> eids);
    int batchDeleteByPriKeyArr(Integer[] eids);
    int updateBatchByEids(Integer[] eids);
    int updateBatchByEidsList(List<Integer> eids);
    int updateBatchByEidsMap(@Param("params") Map<String,Object> params);
    List<Map<String,Object>> selectInnerJoin(Map<String,Object> map);
    Integer batchInsert(List<Employee> item);
}