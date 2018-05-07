package com.vole.realm;


import com.vole.entity.Blogger;
import com.vole.service.BloggerService;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;

/**
 * 编写者： Wu
 * Time： 2018/4/13.00:20
 * 内容： 自定义 Realm
 */

public class MyRealm extends AuthorizingRealm {

    @Resource
    private BloggerService bloggerService;

    /**
     * 为当限前登录的用户授予角色和权
     */
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    /**
     * 验证当前登录的用户
     */
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String userName = (String) token.getPrincipal();
        Blogger blogger = bloggerService.getByUserName(userName);
        if (blogger != null) {
            // 把当前用户信息存到 session 中
            SecurityUtils.getSubject().getSession().setAttribute("currentUser", blogger);
            return new SimpleAuthenticationInfo(blogger.getUserName(), blogger.getPassword(), "xxx");
        } else
            return null;
    }
}
