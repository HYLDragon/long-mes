package com.zx.mes.hyl.pollute.controller;


import com.zx.mes.hyl.controller.BaseController;
import com.zx.mes.hyl.pageModel.*;
import com.zx.mes.hyl.pollute.service.CareServiceI;
import com.zx.mes.hyl.pollute.service.CareTypeServiceI;
import com.zx.mes.model.mes.Care;

import com.zx.mes.pageModel.mes.pollute.Pcare;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.UUID;

/**
 * Created by Administrator on 2017/8/23.
 */
@Controller
@RequestMapping("/careController")
public class CareController extends BaseController {

    @Autowired
    private CareServiceI careService;

    @Autowired
    private CareTypeServiceI careTypeService;

    @RequestMapping("/dataTable")
    @ResponseBody
    public DataTable dataTable(HttpServletRequest request, Pcare pcare, DataTablePageHelper ph){
        return careService.dataTable(pcare,ph);
    }

    @RequestMapping("/addPage")
    public String addPage(HttpServletRequest request){
        Care care=new Care();
        care.setId(UUID.randomUUID().toString());
        request.setAttribute("care", care);
        request.setAttribute("careTypeList", careTypeService.getCareTypeList());
        return "/mes/pollute/addCarePage";
    }

    @RequestMapping("/editPage")
    public String editPage(HttpServletRequest request,String id){
        Pcare pcare =careService.get(id);
        request.setAttribute("care", pcare);
        request.setAttribute("careTypeList", careTypeService.getCareTypeList());
        return "/mes/pollute/editCarePage";
    }

    @RequestMapping("/messagePage")
    public String messagePage(){
        return "/mes/pollute/careMessage";
    }

    @RequestMapping("/add")
    @ResponseBody
    public Json add(Pcare pcare){
        Json json=new Json();
        try {
            careService.add(pcare);
            json.setMsg("添加成功!");
            json.setSuccess(true);
        }catch (Exception e){
            json.setMsg("添加失败!");
            json.setSuccess(false);
     }
        return json;

    }

    @RequestMapping("/delete")
    @ResponseBody
    public Json delete(Pcare pcare){
        Json json=new Json();
        try {
            careService.delete(pcare);
            json.setMsg("删除成功!");
            json.setSuccess(true);
        }catch (Exception e){
            json.setMsg("删除失败!");
            json.setSuccess(false);
        }
        return json;
    }

    @RequestMapping("/edit")
    @ResponseBody
    public Json edit(Pcare pcare){
        Json json=new Json();
        try {
            careService.edit(pcare);
            json.setMsg("编辑成功!");
            json.setSuccess(true);
        }catch (Exception e){
            json.setMsg("编辑失败!");
            json.setSuccess(false);
        }
        return json;
    }

    @ResponseBody
    @RequestMapping("/propertyGrid")
    public DataGrid propertyGrid(){
        return careService.propertyGrid();
    }

}
