package com.mybatis.curd.service.impl;

import com.mybatis.curd.dao.DeptDao;
import com.mybatis.curd.entities.Dept;
import com.mybatis.curd.service.DeptService;

import java.util.List;

/**
 * Created by kqy on 2017/3/13.
 */
public class DeptServiceImpl implements DeptService {
    private DeptDao deptDao;

    public DeptDao getDeptDao() {
        return deptDao;
    }
    public void setDeptDao(DeptDao deptDao) {
        this.deptDao = deptDao;
    }

    @Override
    public List<Dept> getAllDept() {
        return deptDao.selectAll();
    }
}
