package com.springboot.homework.springbootdemo01.redis;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.homework.springbootdemo01.entity.User;
import com.springboot.homework.springbootdemo01.mapper.IUserMapper;
import com.springboot.homework.springbootdemo01.redis.IRedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 * description
 * </p>
 *
 * @author YANGXUE01@hand-china.com 2019/12/5  20:19
 */
@Component
//日志信息
@Slf4j
public class IRedisServiceImpl implements IRedisService<User> {
    @Autowired
    private IUserMapper IUserMapper;

    @Autowired
    private  RedisTemplate<String,User> redisTemplate;

    public final String USER_DB_NAME = "user_redis_db";

    @Override
    public List<User> init() {
        List<User> listUser = IUserMapper.selectAll();
        if (listUser != null) {
            for (User user : listUser) {
                set(user);
            }
        }
        return listUser;
    }

    @Override
    public User get(String key) {
        String str = (String) redisTemplate.opsForHash().get(USER_DB_NAME,key);
        log.error(str);
        if(str != null){
            try {
                return new ObjectMapper().readValue(str,User.class);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }

        }
        return null;
    }

    @Override
    public void set(User object) {
        if(object.getUserId()!=null){
            try {
                redisTemplate.opsForHash().put(USER_DB_NAME,object.getUserId().toString(),new ObjectMapper().writeValueAsString(object));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void reload() {
        clear();
        init();

    }

    @Override
    public void remove(User user) {
        redisTemplate.opsForHash().delete(USER_DB_NAME,user.getUserId().toString());

    }

    @Override
    public void clear() {
        redisTemplate.delete(USER_DB_NAME);

    }

    @Override
    public List<User> getAll() {
        clear();
        return init();
    }
}
