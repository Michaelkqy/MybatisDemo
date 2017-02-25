package com.huitu.api.samples.role.service;

import java.util.Map;

/**
 * Created by zhw on 2016/12/16.
 */
public interface RoleService {
    Map<String,Object> getRoles();
    Map<String, Object> getById(String roleId);
}
