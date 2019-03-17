package com.wine.common.auth;

import com.wine.project.user.dao.UserDao;
import com.wine.project.user.dto.*;
import com.wine.project.user.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 自定义 权限匹配 和 账号、密码 匹配
 */
public class MyShiroRealm extends AuthorizingRealm {

    @Autowired
    private UserService service;

    @Autowired
    private UserDao dao;

    /**
     * 此方法是用来授权的
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        UserAccount userAccount = (UserAccount)principals.getPrimaryPrincipal();
        RoleResDTO roleResDTO = service.queryRoleByUser(userAccount.getUserAccount());
        for(Role role : roleResDTO.getList()){
            simpleAuthorizationInfo.addRole(role.getRoleCode());
            MenuResDTO menuResDTO = service.queryMenuByRole(role.getRoleType());
            for(Menu menu : menuResDTO.getMenus()){
                simpleAuthorizationInfo.addStringPermission(menu.getMenuCode());
            }
        }

        return simpleAuthorizationInfo;
    }

    /**
     * 此方法是用来身份验证的
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String userAccount = (String)token.getPrincipal();
        UserAccount user = dao.queryUserAccountByAccount(userAccount);
        if(null == user){
            return null;
        }

        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(user,user.getUserPassword(),getName());

        return simpleAuthenticationInfo;
    }
}
