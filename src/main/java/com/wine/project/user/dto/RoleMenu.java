package com.wine.project.user.dto;

import com.wine.common.message.UserAndDate;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class RoleMenu extends UserAndDate {

    //角色菜单主键
    private String roleMenuId;

    //角色主键
    private String roleId;

    //菜单主键
    private String menuId;

}
