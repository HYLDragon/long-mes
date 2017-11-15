package com.zx.mes.hyl.upms.controller;

import com.zx.mes.hyl.controller.BaseController;
import com.zx.mes.hyl.pageModel.PageHelper;
import com.zx.mes.hyl.upms.pageModel.Sys;
import com.zx.mes.hyl.upms.service.SysServiceI;
import com.zx.mes.hyl.upms.util.Combobox;
import com.zx.mes.hyl.upms.util.JsonCombo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Administrator on 2017/11/7.
 */
@Controller
@RequestMapping("/sysController")
public class SysController extends BaseController{

    @Autowired
    private SysServiceI sysService;
    //easyui combobox id text
    @RequestMapping("/getAll")
    @ResponseBody
    public List<Combobox> getAll(Sys sys, PageHelper ph){
        return sysService.combo(sys,ph);
    }
}
