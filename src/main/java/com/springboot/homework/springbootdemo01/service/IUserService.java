package com.springboot.homework.springbootdemo01.service;

import com.springboot.homework.springbootdemo01.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * service接口
 * </p>
 *
 * @author YANGXUE01@hand-china.com 2019/12/5  19:04
 */
@Service
public interface IUserService {

    /**
     * <p>使用用户id查询一个用户<p/>
     *
     * @param id 用户id
     * @return user用户
     * @throws RuntimeException exception description
     */
    User selectUserById(Integer id);

    /**
     * <p>查询所有用户的信息<p/>
     *
     * @return  List<User> 用户集合
     * @throws RuntimeException exception description
     */
    List<User> selectAll();

  /**
   * <p>创建用户<p/>
   *
   * @param user 用户
   * @return int
   * @throws RuntimeException exception description
   */
    int getUser(User user);

   /**
    * <p>删除用户<p/>
    *
    * @param id 用户id
    * @return int
    * @throws RuntimeException exception description
    */
    int deleteUserById(Integer id);

  /**
   * <p>更新用户信息<p/>
   *
   * @param user 用户
   * @return int
   * @throws RuntimeException exception description
   */
    int updateUser(User user);


}
