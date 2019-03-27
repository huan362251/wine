package com.wine.project.user.dao;

import com.wine.project.user.dto.*;

import java.util.List;

public interface UserDao {

    /**
     * 通过账号查询用户角色
     * @param userAccount
     * @return
     */
    List<Role> queryRoleByUser(String userAccount);

    /**
     * 通过角色类型查询菜单
     * @param roleType
     * @return
     */
    List<Menu> queryMenuByRole(String roleType);

    /**
     * 通过账号查询账号信息
     * @param userAccount
     * @return
     */
    UserAccount queryUserAccountByAccount(String userAccount);

    /**
     * 新增账号
     * @param userAccount
     */
    void insertUserAccount(UserAccount userAccount);

    /**
     * 新增角色
     * @param role
     */
    void insertUserRole(UserRole role);

    /**
     * 新增用户信息
     * @param userMessageDTO
     */
    void insertUserMessage(UserMessageDTO userMessageDTO);
}
