package com.mybatis.curd.dao;

import com.mybatis.curd.entities.Dept;

import java.util.List;
import java.util.Map;

public interface DeptDao {

    int deleteByPrimaryKey(Integer did);
    int insert(Dept record);
    Dept selectByPrimaryKey(Integer did);
    List<Dept> selectAll();
    int updateByPrimaryKey(Dept record);




    List<Map<String,Object>> findAll(Map<String,Object> map);

    int updateDeptById(Dept dd);

    int updateDeptByIdMap(Map<String,Object> map);
}