package com.zx.mes.hyl.upms.client.shiro.realm;

import com.zx.mes.hyl.upms.pageModel.Role;
import com.zx.mes.hyl.upms.pageModel.User;

import com.zx.mes.hyl.upms.service.RoleServiceI;
import com.zx.mes.hyl.upms.service.UserServiceI;
import com.zx.mes.hyl.util.MD5Util;
import com.zx.mes.hyl.util.PropertiesFileUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 用户认证和授权
 * Created by shuzheng on 2017/1/20.
 */
public class UpmsRealm extends AuthorizingRealm {

    private static Logger _log = LoggerFactory.getLogger(UpmsRealm.class);

    private static final org.apache.log4j.Logger logger= org.apache.log4j.Logger.getLogger(UpmsRealm.class);




    @Autowired
    private UserServiceI userService;

    @Autowired
    private RoleServiceI roleService;

    /**
     * 授权：验证权限时调用
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = (String) principalCollection.getPrimaryPrincipal();
        User user=userService.getByUserName(username);
        // 当前用户所有角色
        List<Role> upmsRoles=roleService.getRoles(user.getId());
        Set<String> roles = new HashSet<String>();
        for (Role role : upmsRoles) {
            if (StringUtils.isNotBlank(role.getName())) {
                roles.add(role.getName());
            }
        }

        // 当前用户所有权限
        List<String> tresourceList =userService.resourceList(user.getId());
        Set<String> permissions = new HashSet<String>();
        for (String upmsPermission : tresourceList) {
            if (StringUtils.isNotBlank(upmsPermission)) {
                permissions.add(upmsPermission);
            }
        }

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.setStringPermissions(permissions);
        simpleAuthorizationInfo.setRoles(roles);
        return simpleAuthorizationInfo;
    }

    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        return null;
    }

//    /**
//     * 认证：登录时调用
//     * @param authenticationToken
//     * @return
//     * @throws AuthenticationException
//     */
//    @Override
//    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
//        String username = (String) authenticationToken.getPrincipal();
//        String password = new String((char[]) authenticationToken.getCredentials());
//        // client无密认证
//        String upmsType = PropertiesFileUtil.getInstance("long-upms-client").get("upms.type");
//        if ("client".equals(upmsType)) {
//            return new SimpleAuthenticationInfo(username, password, getName());
//        }
//
//        // 查询用户信息
//        User upmsUser = userService.getByUserName(username);
//
//        if (null == upmsUser) {
//            throw new UnknownAccountException();
//        }
//        if (!upmsUser.getPwd().equals(MD5Util.md5(password ))) {
//            throw new IncorrectCredentialsException();
//        }
////        if (upmsUser.getLocked() == 1) {
////            throw new LockedAccountException();
////        }
//
//        return new SimpleAuthenticationInfo(username, password, getName());
//    }

}
