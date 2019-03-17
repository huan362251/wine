package com.wine.project.user.dto;

import com.wine.common.message.UserAndDate;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

//角色表
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Role extends UserAndDate {

    //角色主键
    private String roleId;

    //角色名称
    private String roleName;

    //角色代码
    private String roleCode;

    //角色类型 01-管理员 02-顾客
    private String roleType;

}
