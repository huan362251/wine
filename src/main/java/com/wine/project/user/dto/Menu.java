package com.wine.project.user.dto;

import com.wine.common.message.UserAndDate;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

//菜单表
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Menu extends UserAndDate {

    //菜单主键
    private String menuId;

    //菜单名称
    private String menuName;

    //菜单代码
    private String menuCode;

    //父菜单
    private String parentsMenu;
}
