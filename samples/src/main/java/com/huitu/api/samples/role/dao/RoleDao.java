package com.huitu.api.samples.role.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by zhw on 2016/12/16.
 */
public interface RoleDao {
    List<Map<String,Object>> selectAll();

    Map<String,Object> selectById(@Param("roleId") String roleId);
}
