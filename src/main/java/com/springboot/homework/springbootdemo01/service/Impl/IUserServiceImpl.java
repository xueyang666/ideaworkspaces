package com.springboot.homework.springbootdemo01.service.Impl;


import com.springboot.homework.springbootdemo01.entity.User;
import com.springboot.homework.springbootdemo01.mapper.IUserMapper;
import com.springboot.homework.springbootdemo01.redis.IRedisServiceImpl;
import com.springboot.homework.springbootdemo01.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
/**
 * <p>
 * service实现类
 * </p>
 *
 * @author YANGXUE01@hand-china.com 2019/12/5  19:04
 */
@Service
public class IUserServiceImpl implements IUserService {
   @Autowired
    private IUserMapper userMapper;
   @Autowired
   private com.springboot.homework.springbootdemo01.redis.IRedisServiceImpl IRedisServiceImpl;

   //构造方法
    public IUserServiceImpl(IRedisServiceImpl IRedisServiceImpl) {
        this.IRedisServiceImpl = IRedisServiceImpl;
        IRedisServiceImpl.init();
    }

    @Override
    public User selectUserById(Integer id) {
        User user = IRedisServiceImpl.get(id.toString());
        if(user!=null){
            return user;
        }
        return userMapper.selectUserById(id);
    }

    @Override
    public List<User> selectAll() {
        List<User> list = IRedisServiceImpl.getAll();
        if(list!=null){
            return list;
        }
        return userMapper.selectAll();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int getUser(User user) {
        int result = userMapper.getUser(user);
        if(result > 0 ){
            IRedisServiceImpl.set(user);
            return result;
        }
        return result;

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteUserById(Integer id) {
        int result = userMapper.deleteUserById(id);
        if(result > 0){
            User user =userMapper.selectUserById(id);
            IRedisServiceImpl.remove(user);
            return result;
        }
return result;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateUser(User user) {
        int result = userMapper.updateUser(user);
        if(result > 0){
            IRedisServiceImpl.set(user);
            return result;
        }
        return result;
    }
}
