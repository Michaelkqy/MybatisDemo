package com.huitu.api.samples.user.service;


import java.util.Map;

/**
 * Created by 3119 on 2015/9/15.
 */
public interface UserService {
    Map<String,Object> getById( String id);
    Map<String,Object> getByIds( String[] ids);
    Map<String,Object> getAll();
    Map<String,Object> getByRoleId( String roleId);
}
