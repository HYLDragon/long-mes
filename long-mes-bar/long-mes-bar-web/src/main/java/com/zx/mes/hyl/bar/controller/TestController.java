package com.zx.mes.hyl.bar.controller;

import com.zx.mes.hyl.controller.BaseController;
import com.zx.mes.hyl.pageModel.SessionInfo;
import com.zx.mes.hyl.pageModel.Tree;
import com.zx.mes.hyl.upms.model.Tresource;
import com.zx.mes.hyl.upms.service.ResourceServiceI;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Administrator on 2017/10/25.
 */
@Controller
@RequestMapping("/testController")
public class TestController extends BaseController{

    private static final Logger logger=Logger.getLogger(TestController.class);

    @Autowired
    private ResourceServiceI resourceService;

    @RequestMapping("/homePage")
    public String context(){
        return "/layout/content-wrapper";
    }

    @RequestMapping("/otherPage")
    public String context2(){
        return "/layout/content-other-wrapper";
    }

    @RequestMapping("/menu")
    @ResponseBody
    public List<Tree> menu(){
        //params.put("userId", sessionInfo.getId());// 查自己有权限的资源
        SessionInfo sessionInfo=new SessionInfo();
        sessionInfo.setId("0");
        return  resourceService.tree(sessionInfo);
    }

}
