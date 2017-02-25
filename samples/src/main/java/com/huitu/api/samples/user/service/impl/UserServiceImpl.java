package com.huitu.api.samples.user.service.impl;


import com.huitu.annotation.BusinessService;
import com.huitu.api.samples.commons.DataUtils;
import com.huitu.api.samples.user.dao.UserDao;
import com.huitu.api.samples.exception.InvalidKeyException;
import com.huitu.api.samples.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;


/**
 * Created by zhw on 2016/12/16.
 */
//所有的业务逻辑实现类必须使用@BusinessService
@BusinessService
public class UserServiceImpl implements UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    private UserDao userDao;
    public UserDao getUserDao(){
        return userDao;
    }
    public void setUserDao(UserDao value){
        this.userDao = value;
    }

    @Override
    public Map<String, Object> getById(String id) {
        Map<String,Object> one = userDao.selectById(id);

        return one;
    }

    @Override
    public Map<String, Object> getByIds(String[] ids) {
        List<Map<String,Object>> list = userDao.selectByIds(ids);

        try
        {
            return DataUtils.list2Map(list,"ID");
        }catch (InvalidKeyException kex){
            logger.error("list convert map {}",kex);
        }

        return null;
    }

    @Override
    public Map<String, Object> getAll() {
        List<Map<String,Object>> list = userDao.selectAll();

        try
        {
            return DataUtils.list2Map(list,"ID");
        }catch (InvalidKeyException kex){
            logger.error("list convert map {}",kex);
        }

        return null;
    }

    @Override
    public Map<String, Object> getByRoleId(String roleId) {
        List<Map<String,Object>> list = userDao.selectByRoleId(roleId);

        try
        {
            return DataUtils.list2Map(list,"ID");
        }catch (InvalidKeyException kex){
            logger.error("list convert map {}",kex);
        }

        return null;
    }
}
