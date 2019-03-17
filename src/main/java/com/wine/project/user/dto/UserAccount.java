package com.wine.project.user.dto;

import com.wine.common.message.UserAndDate;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

//用户表
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class UserAccount extends UserAndDate {

    private String userId;

    private String userName;

    private String userAccount;

    private String userPassword;
}
