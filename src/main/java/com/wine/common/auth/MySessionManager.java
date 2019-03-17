package com.wine.common.auth;

import org.apache.shiro.session.mgt.SessionKey;
import org.apache.shiro.web.servlet.ShiroHttpServletRequest;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.util.StringUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.Serializable;

/**
 * 重新获取session的值
 */
public class MySessionManager extends DefaultWebSessionManager {

    private static final String AUTHORIZATION = "Authorization";

    private static final String REFERENCED_SESSION_ID_SOURCE = "Stateless request";

    @Override
    public Serializable getSessionId(ServletRequest request, ServletResponse response) {
        System.out.println("进入方法：getSessionId");
        String id = WebUtils.toHttp(request).getHeader(AUTHORIZATION);

        if(StringUtils.isEmpty(id)){
            //默认规则从cookie中取sessionId
            System.out.println("出去方法：getSessionId");
            return super.getSessionId(request,response);
        }else{
            //请求头中有值id，设置它为sessionId
            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_SOURCE,REFERENCED_SESSION_ID_SOURCE);
            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID,id);
            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_IS_VALID,Boolean.TRUE);
            System.out.println("出去方法：getSessionId");
            return id;
        }

    }
}
