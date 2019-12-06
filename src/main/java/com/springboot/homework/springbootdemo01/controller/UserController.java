package com.springboot.homework.springbootdemo01.controller;

import com.springboot.homework.springbootdemo01.entity.ErrorMessage;
import com.springboot.homework.springbootdemo01.entity.User;
import com.springboot.homework.springbootdemo01.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.InvalidPropertyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 控制层
 * </p>
 *
 * @author YANGXUE01@hand-china.com 2019/12/5  19:04
 */
@Api(value = "控制操作接口", tags = "{控制操作接口}")
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private IUserService userService;

    /**
     * 使用用户id来查询用户
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "查询单个用户" ,notes = "使用用户id来查询用户信息")
    @GetMapping("/{id}")
    public User getUserByID(@PathVariable("id") Integer id) {
        return userService.selectUserById(id);
    }

    /**
     * 查询所有用户
     *
     * @return
     */
    @ApiOperation(value = "查询所有用户",notes = "查询所有用户信息")
    @GetMapping()
    public List<User> selectAll() {
        return userService.selectAll();
    }

    /**
     * 创建用户
     *
     * @param user
     * @return
     */
    @ApiOperation(value = "创建用户",notes = "创建用户" )
    @PostMapping
    public Object getUser(@RequestBody @Validated User user, BindingResult bs) {
        userService.getUser(user);
        return user;
    }

    /**
     * 更新用户
     *
     * @param user
     * @return
     */
    @ApiOperation(value = "更新用户" ,notes = "更新用户信息")
    @PutMapping
    public Object updateUser(@RequestBody @Validated User user, BindingResult bs) {
        userService.updateUser(user);
        return user;
    }

    /**
     * 使用用户id删除用户
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "删除用户" ,notes = "删除用户")
    @DeleteMapping("/{id}")
    @Transactional(rollbackFor = Exception.class)
    public int deleteUser(@PathVariable("id") Integer id) {
        return userService.deleteUserById(id);
    }

}
