package com.zx.mes.hyl.pollute.controller;

import com.zx.mes.hyl.controller.BaseController;
import com.zx.mes.hyl.pageModel.Json;
import com.zx.mes.hyl.upms.pageModel.User;
import com.zx.mes.hyl.upms.service.UserServiceI;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2017/10/16.
 */
@Controller
@RequestMapping("/regController")
public class RegController extends BaseController{

    private static final Logger logger=Logger.getLogger(UserController.class);

    @Autowired
    private UserServiceI userService;
    /**
     * 用户注册
     *
     * @param user
     *            用户对象
     * @return
     */
    @ResponseBody
    @RequestMapping("/reg")
    public Json reg(User user) {
        Json j = new Json();
        try {
            userService.reg(user);
            j.setSuccess(true);
            j.setMsg("注册成功！新注册的用户没有任何权限，请让管理员赋予权限后再使用本系统！");
            j.setObj(user);
        } catch (Exception e) {
            // e.printStackTrace();
            j.setMsg(e.getMessage());
        }
        return j;
    }
}
