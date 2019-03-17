package com.wine.project.user.dto;

import com.wine.common.message.UserAndDate;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

//用户角色关系表
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class UserRole extends UserAndDate {

    //用户角色主键
    private String userRoleId;

    //用户主键
    private String userId;

    //角色主键
    private String roleId;

}
