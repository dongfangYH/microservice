package com.example.service.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author yuanhang.liu@tcl.com
 * @description
 * @date 2020-11-19 11:21
 **/
@Data
@TableName(value = "t_user")
public class User extends BaseModel<User>{

    private String name;

    private Integer age;

    private String email;
}
