package com.zx.mes.hyl.pollute.controller;

import com.zx.mes.hyl.controller.BaseController;
import com.zx.mes.hyl.pageModel.Json;
import com.zx.mes.hyl.pageModel.SessionInfo;
import com.zx.mes.hyl.upms.pageModel.User;
import com.zx.mes.hyl.upms.service.UserServiceI;
import com.zx.mes.hyl.util.ConfigUtil;
import com.zx.mes.hyl.util.IpUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


/**
 * Created by Administrator on 2017/10/16.
 */
@Controller
@RequestMapping("/loginController")
public class LoginController extends BaseController {
    private static final Logger logger=Logger.getLogger(LoginController.class);

    @Autowired
    private UserServiceI userService;

    /**
     * 用户登录
     *
     * @param user
     *            用户对象
     * @param session
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping("/login")
    public Json login(User user, HttpSession session, HttpServletRequest request) {
        Json j = new Json();
        //User u = userService.login(user);
        User u=userService.getByUserName(request.getRemoteUser());
        if (u != null) {
            j.setSuccess(true);
            j.setMsg("登陆成功！");

            SessionInfo sessionInfo = new SessionInfo();
            BeanUtils.copyProperties(u, sessionInfo);
            sessionInfo.setIp(IpUtil.getIpAddr(request));
            sessionInfo.setResourceList(userService.resourceList(u.getId()));
            session.setAttribute(ConfigUtil.getSessionInfoName(), sessionInfo);

            j.setObj(sessionInfo);
        } else {
            j.setMsg("用户名或密码错误！");
        }
        return j;
    }


    /**
     * 退出登录
     *
     * @param session
     * @return
     */

    @ResponseBody
    @RequestMapping("/logout")

    public Json logout(HttpSession session) {
        Json j = new Json();
        if (session != null) {
            session.invalidate();
        }
        j.setSuccess(true);
        j.setMsg("注销成功！");
        return j;
    }

}
