package com.springboot.homework.springbootdemo01.redis;

import com.springboot.homework.springbootdemo01.entity.User;

import java.util.List;

/**
 * <p>
 * redis接口
 * </p>
 *
 * @author YANGXUE01@hand-china.com 2019/12/5  20:19
 */

public interface IRedisService<T> {



    /**
     * <p>初始化<p/>
     *
     * @return
     */

    List<T> init();

    /**
     * <p>根据key来取值<p/>
     *
     * @param key 键值
     * @return T 返回的类型
     */
    T get(String key);

    /**
     * <p>根据key来设值<p/>
     *
     * @param object 设置的值
     */
    void set(T object);

    /**
     * <p>刷新缓存<p/>
     *
     */
    void  reload();

    /**
     * <p>删除缓存中的用户<p/>
     *
     */
    void remove(User user);

    /**
     * <p>清除缓存<p/>
     *
     */
    void clear();


    /**
     * <p>查询所有用户信息<p/>
     *
     * @return List<T> 返回所有用户集合
     * @throws RuntimeException exception description
     */
    List<T> getAll();


}
