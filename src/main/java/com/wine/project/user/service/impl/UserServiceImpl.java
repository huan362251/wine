package com.wine.project.user.service.impl;

import com.wine.common.code.CodeMsg;
import com.wine.common.verify.Verify;
import com.wine.project.user.dao.UserDao;
import com.wine.project.user.dto.Menu;
import com.wine.project.user.dto.MenuResDTO;
import com.wine.project.user.dto.Role;
import com.wine.project.user.dto.RoleResDTO;
import com.wine.project.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public RoleResDTO queryRoleByUser(String userAccount) {
        RoleResDTO roleResDTO = new RoleResDTO();
        //参数校验
        if(StringUtils.isEmpty(userAccount)){
            CodeMsg.PARAM_IS_NULL.setResponse(roleResDTO);
            return roleResDTO;
        }

        List<Role> roles = userDao.queryRoleByUser(userAccount);

        if(Verify.isNull(roles)){
            CodeMsg.ROLE_IS_NULL.setResponse(roleResDTO);
            return roleResDTO;
        }

        roleResDTO.setList(roles);

        return roleResDTO;
    }

    @Override
    public MenuResDTO queryMenuByRole(String roleType) {
        MenuResDTO menuResDTO = new MenuResDTO();
        //参数校验
        if(StringUtils.isEmpty(roleType)){
            CodeMsg.PARAM_IS_NULL.setResponse(menuResDTO);
            return menuResDTO;
        }

        List<Menu> menus = userDao.queryMenuByRole(roleType);
        if(Verify.isNull(menus)){
            CodeMsg.MENU_IS_NULL.setResponse(menuResDTO);
            return menuResDTO;
        }

        menuResDTO.setMenus(menus);

        return menuResDTO;
    }
}
