package com.huitu.api.samples.user.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by zhw on 2015/8/19.
 */
public interface UserDao {
    Map<String,Object> selectById(@Param("id") String id);

    List<Map<String,Object>>  selectByIds(@Param("ids") String[] ids);

    List<Map<String,Object>> selectAll();
    List<Map<String,Object>> selectByRoleId(@Param("roleId") String roleId);
}
