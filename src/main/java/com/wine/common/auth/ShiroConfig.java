package com.wine.common.auth;


import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.apache.shiro.mgt.SecurityManager;
import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    //权限管理，配置主要是Realm的管理认证
    @Bean
    public SecurityManager securityManager() {
        System.out.println("进入方法：securityManager");
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(myShiroRealm());
        System.out.println("出去方法：securityManager");

        return securityManager;
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager){
        System.out.println("进入方法：shiroFilter");
        System.out.println("ShiroConfiguration.shirFilter()");

        ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
        shiroFilter.setSecurityManager(securityManager);

        //没有看懂，加这些，是需要过滤那些数据，为什么后面用anon?
        //这个顺序很重要，是按照顺序来过滤的
        Map<String,String> filterChain = new LinkedHashMap<String,String>();
        filterChain.put("/login.do", "anon");
        filterChain.put("/**", "authc");

        //配置默认登录界面
//        shiroFilter.setLoginUrl("/login.do");

        shiroFilter.setFilterChainDefinitionMap(filterChain);
        System.out.println("出去方法：shiroFilter");

        return shiroFilter;
    }

    //密码凭证器，密码校验由这个方法负责
    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher(){
        System.out.println("进入方法：hashedCredentialsMatcher");
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("md5");
        hashedCredentialsMatcher.setHashIterations(2);
        System.out.println("出去方法：hashedCredentialsMatcher");

        return hashedCredentialsMatcher;
    }


    @Bean
    public MyShiroRealm myShiroRealm(){
        System.out.println("进入方法：myShiroRealm");
        MyShiroRealm myShiroRealm = new MyShiroRealm();
        myShiroRealm.setCredentialsMatcher(hashedCredentialsMatcher());
        System.out.println("出去方法：myShiroRealm");

        return myShiroRealm;
    }

    @Bean
    public SessionManager sessionManager(){
        System.out.println("进入方法：sessionManager");
        MySessionManager mySessionManager = new MySessionManager();
//        mySessionManager.setSessionDAO();
        System.out.println("出去方法：sessionManager");

        return mySessionManager;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager){
        System.out.println("进入方法：authorizationAttributeSourceAdvisor");
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        System.out.println("出去方法：authorizationAttributeSourceAdvisor");

        return authorizationAttributeSourceAdvisor;
    }
}
