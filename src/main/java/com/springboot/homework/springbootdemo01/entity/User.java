package com.springboot.homework.springbootdemo01.entity;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Value;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * <p>
 * 用户类
 * </p>
 *
 * @author YANGXUE01@hand-china.com 2019/12/5  19:04
 */

@Data
@ApiModel(value = "用户类",description = "用户类，返回响应数据")
public class User {
    @NotNull(message = "用户名id不为空")
    @ApiModelProperty("用户学号")
    private  Integer userId;//学号

    @NotNull(message = "用户名不为空")
    @Size(min = 2, max = 30 ,message = "用户名长度应该大于2，小于30")

    @ApiModelProperty("用户姓名")
    private String userName;//姓名

    @Max(value = 150 , message = "age应该<150")
    @Min(value =  18 ,message = "age应该>18")
    @ApiModelProperty("用户年龄")
    private Integer age;//年龄

    @ApiModelProperty("创建时间")
    private Date createTime;//创建时间

}
