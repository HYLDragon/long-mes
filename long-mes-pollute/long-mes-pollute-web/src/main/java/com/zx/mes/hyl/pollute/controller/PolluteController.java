package com.zx.mes.hyl.pollute.controller;


import com.zx.mes.hyl.controller.BaseController;
import com.zx.mes.hyl.pollute.service.CareTypeServiceI;
import com.zx.mes.model.mes.CareType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Administrator on 2017/8/3.
 */
@Controller
@RequestMapping("/polluteController")
public class PolluteController extends BaseController {

    @Autowired
    private CareTypeServiceI careTypeService;

    @RequestMapping("/manager")
    public String manager(){
        return "/mes/pollute/pollute";
    }

    @RequestMapping("/pollutePage")
    public String managerPage(){
        return "/mes/pollute/pollutePage";
    }

    @RequestMapping("/polluteElectPage")
    public String managerElectPage(){
        return "/mes/pollute/polluteElectPage";
    }

    @RequestMapping("/polluteVpPage")
    public String managerVpPage(){
        return "/mes/pollute/polluteVpPage";
    }

    //风机机油记录页面  fan(风机)
    @RequestMapping("/polluteFanPage")
    public String managerFanPage(){
        return "/mes/pollute/polluteFanPage";
    }

    //除尘设备滤网更换记录 Strainer(滤网)
    @RequestMapping("/polluteStrainerPage")
    public String managerStrainerPage(){
        return "/mes/pollute/polluteStrainerPage";
    }

    //UV前置滤网更换记录
    @RequestMapping("/polluteUvPage")
    public String managerUvPage(){
        return "/mes/pollute/polluteUvPage";
    }

    //保养记录  care(保养)
    @RequestMapping("/polluteCarePage")
    public String managerCarePage(HttpServletRequest request){
        List<CareType> careTypeList=careTypeService.getCareTypeList();
        request.setAttribute("careTypeList", careTypeList);
        return "/mes/pollute/polluteCarePage";
    }
}
