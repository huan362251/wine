package com.wine.project.user.dto;

import lombok.Data;

/**
 * @Author LIUHUAN
 * @Description
 * @Date Created by  2019/3/18 21:30
 **/
@Data
public class RegisterReqDTO {

    //用户名称
    private String userName;

    //用户账号
    private String userAccount;

    //用户密码
    private String userPassword;

    //用户角色主键
    private String userRoleId;

    //用户主键
    private String userId;

    //角色主键
    private String roleId;

    //手机号
    private String iphone;

    //身份证号
    private String idNumber;
}
