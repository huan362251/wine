package com.wine.project.user.service.impl;

import com.wine.common.code.CodeMsg;
import com.wine.common.message.ResponseDTO;
import com.wine.common.verify.Verify;
import com.wine.project.user.dao.UserDao;
import com.wine.project.user.dto.*;
import com.wine.project.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

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

    @Override
    public ResponseDTO login(LoginReqDTO dto) {

        ResponseDTO responseDTO = new ResponseDTO();

        return responseDTO;
    }

    @Override
    public ResponseDTO register(RegisterReqDTO dto) {
        ResponseDTO responseDTO = new ResponseDTO();
        try {
            //新增账号
            UserAccount userAccount = new UserAccount();
            BeanUtils.copyProperties(dto, userAccount);
            userDao.insertUserAccount(userAccount);
            //新增角色
            UserRole userRole = new UserRole();
            BeanUtils.copyProperties(dto, userRole);
            userDao.insertUserRole(userRole);
            //新增账号信息
            UserMessageDTO userMessageDTO = new UserMessageDTO();
            BeanUtils.copyProperties(dto, userMessageDTO);
            userDao.insertUserMessage(userMessageDTO);
        }catch (Exception e){
            logger.info(this.getClass().getName(),"注册方法失败");
            CodeMsg.EXCEPTION.setResponse(responseDTO);
        }
        return responseDTO;
    }
}
