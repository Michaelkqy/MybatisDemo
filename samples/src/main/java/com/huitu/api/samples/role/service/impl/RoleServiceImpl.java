package com.huitu.api.samples.role.service.impl;

import com.huitu.annotation.BusinessService;
import com.huitu.api.samples.commons.DataUtils;
import com.huitu.api.samples.exception.InvalidKeyException;
import com.huitu.api.samples.role.dao.RoleDao;
import com.huitu.api.samples.role.service.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

/**
 * Created by zhw on 2016/12/16.
 */
//所有的业务逻辑实现类必须使用@BusinessService
@BusinessService
public class RoleServiceImpl implements RoleService {
    private static final Logger logger = LoggerFactory.getLogger(RoleServiceImpl.class);

    private RoleDao roleDao;
    public RoleDao getRoleDao(){
        return roleDao;
    }
    public void setRoleDao(RoleDao value){
        this.roleDao = value;
    }

    @Override
    public Map<String, Object> getRoles() {
        List<Map<String,Object>> list = roleDao.selectAll();

        try
        {
            return DataUtils.list2Map(list,"ID");
        }catch (InvalidKeyException kex){
            logger.error("list convert map",kex);
        }

        return null;
    }


    @Override
    public Map<String, Object> getById(String roleId) {
        Map<String,Object> one = roleDao.selectById(roleId);

        return one;
    }
}
