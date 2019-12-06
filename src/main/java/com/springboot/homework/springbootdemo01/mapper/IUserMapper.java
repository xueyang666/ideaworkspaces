package com.springboot.homework.springbootdemo01.mapper;

import com.springboot.homework.springbootdemo01.entity.User;

import java.util.List;
/**
 * <p>
 * 用户接口
 * </p>
 *
 * @author YANGXUE01@hand-china.com 2019/12/5  19:04
 */
public interface IUserMapper {
    /**
     * 使用用户id来查询用户
     * @param id
     * @return user
     */
    User selectUserById(Integer id);

    /**
     * 查询所有用户
     * @return List<User>
     */
    List<User> selectAll();

    /**
     * 增加用户
     * @param user
     * @return
     */
    int getUser(User user);

    /**
     * 使用用户id删除用户
     * @param id
     * @return
     */
    int deleteUserById(Integer id);

    /**
     * 更新用户
     * @param user
     * @return
     */
    int updateUser(User user);

}
