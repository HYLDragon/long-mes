package com.zx.mes.hyl.upms.rpc.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.zx.mes.hyl.pageModel.PageHelper;
import com.zx.mes.hyl.upms.dao.SysDaoI;
import com.zx.mes.hyl.upms.model.Tsys;
import com.zx.mes.hyl.upms.pageModel.Sys;
import com.zx.mes.hyl.upms.service.SysServiceI;
import com.zx.mes.hyl.upms.util.Combobox;
import com.zx.mes.hyl.upms.util.JsonCombo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/7.
 */
@Service
public class SysServiceImpl implements SysServiceI{

    @Autowired
    private SysDaoI sysDao;

    public List<Combobox> combo(Sys sys, PageHelper ph) {
        List<Combobox> list=new ArrayList<Combobox>();
        Map<String,Object> params=new HashMap<String,Object>();
        String hql=" from Tsys t ";
        List<Tsys> tsysList=sysDao.find(hql,params);
        for (int i=0;i<tsysList.size();i++){

            Combobox combobox=new Combobox();

            BeanUtils.copyProperties(tsysList.get(i),combobox);
            combobox.setId(tsysList.get(i).getId());
            combobox.setText(tsysList.get(i).getName());
            list.add(combobox);
        }

        return list;
    }
}
