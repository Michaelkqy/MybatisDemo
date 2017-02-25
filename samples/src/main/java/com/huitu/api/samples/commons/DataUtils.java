package com.huitu.api.samples.commons;

import com.huitu.api.samples.exception.InvalidKeyException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * Created by kc on 2016/4/11.
 */
public class DataUtils {
    private static final Logger logger = LoggerFactory.getLogger(DataUtils.class);

    private final static Map<String ,Object> EMPTY_MAP = new HashMap<>(0);

    /**
     * 将list按key转换成map
     * @param list
     * @param key
     * @return 如果list中对象存在__index，则返回LinkedHashMap,否则返回HashMap
     * @exception InvalidKeyException list集合元素不存在key属性
     */
    public static Map<String ,Object> list2Map(List<Map<String, Object>> list,String key) throws InvalidKeyException{

        if(null==list || list.isEmpty()){
            return EMPTY_MAP;
        }

        if(!list.get(0).containsKey(key)){
            throw new InvalidKeyException( String.format("%s does not exists in list.",key));
        }

        Map<String,Object> result;

        if(list.get(0).containsKey("__index")){//有序集合
            result =  new LinkedHashMap<>(list.size());
        } else{
            result = new HashMap<>(list.size());
        }

        for(Map<String,Object> item : list){
            String value = item.get(key).toString();
            if(!result.containsKey(value)){
                result.put(value,item);
            }
        }

        return result;
    }

}
