package com.zx.mes.hyl.bar.controller;

import com.zx.mes.hyl.controller.BaseController;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2017/10/25.
 */
@Controller
@RequestMapping("/testController")
public class TestController extends BaseController{

    private static final Logger logger=Logger.getLogger(TestController.class);

    @RequestMapping("/homePage")
    public String context(){
        return "/layout/content-wrapper";
    }

    @RequestMapping("/otherPage")
    public String context2(){
        return "/layout/content-other-wrapper";
    }

}
