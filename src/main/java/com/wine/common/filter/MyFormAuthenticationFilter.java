package com.wine.common.filter;

import com.wine.project.user.dto.UserAccount;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @Author LIUHUAN
 * @Description
 * @Date Created by  2019/3/17 19:47
 **/
public class MyFormAuthenticationFilter extends FormAuthenticationFilter {

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {

        if( isLoginRequest(request,response) ){
            if( isLoginSubmission( request, response)){
                String account = this.getName();
                Subject subject = this.getSubject(request,response);
                UserAccount principal = (UserAccount) subject.getPrincipal();
                if(account != null && !account.equalsIgnoreCase(principal.getUserAccount())){
                    subject.logout();
                    return false;
                }
            }
        }

        return super.isAccessAllowed(request, response, mappedValue);
    }
}
