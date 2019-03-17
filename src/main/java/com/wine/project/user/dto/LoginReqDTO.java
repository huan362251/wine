package com.wine.project.user.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @Author LIUHUAN
 * @Description
 * @Date Created by  2019/3/17 17:26
 **/
@Data
public class LoginReqDTO {

    @NotNull
    @Length(min = 1,max = 100,message = "账号不能为空")
    private String userAccount;

    @NotNull
    @Length(min = 1,max = 100,message = "角色不能为空")
    private String roleId;

    @NotNull
    @Length(min = 1,max = 200,message = "密码不能为空")
    private String password;
}
