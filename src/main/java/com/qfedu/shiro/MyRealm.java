package com.qfedu.shiro;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;

/**
 * @author Administrator
 * @version 1.0
 * @date 2019/10/22 15:46
 */
@Component
public class MyRealm extends AuthorizingRealm {
    //1、授权  查询登录用户的角色或者权限
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }
    //2、认证 生成凭证 登录成功
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        if (token.getUsername()!=null){
            SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(token.getPrincipal(), token.getUsername(), token.getUsername());
            return info;
        }

        return null;
    }
}
