package com.wine.project.user.service;

import com.wine.project.user.dto.MenuResDTO;
import com.wine.project.user.dto.RoleResDTO;

public interface UserService {

    /**
     * 通过账号查询用户角色
     * @param userAccount
     * @return
     */
    RoleResDTO queryRoleByUser(String userAccount);

    /**
     * 通过角色类型查询菜单
     * @param roleType
     * @return
     */
    MenuResDTO queryMenuByRole(String roleType);
}
