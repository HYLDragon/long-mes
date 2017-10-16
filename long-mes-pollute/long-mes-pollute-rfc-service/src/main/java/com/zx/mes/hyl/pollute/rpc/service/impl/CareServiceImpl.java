package com.zx.mes.hyl.pollute.rpc.service.impl;

import com.zx.mes.dao.mes.CareMapper;
import com.zx.mes.hyl.pageModel.DataGrid;
import com.zx.mes.hyl.pageModel.PageHelper;
import com.zx.mes.hyl.pageModel.PropertyGrid;
import com.zx.mes.hyl.pollute.service.CareServiceI;
import com.zx.mes.model.mes.Care;
import com.zx.mes.pageModel.mes.pollute.Pcare;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/8/23.
 */
@Service
public class CareServiceImpl implements CareServiceI {

    @Autowired
    private CareMapper careMapper;

    public void add(Pcare pcare) {
        Care care=new Care();
        BeanUtils.copyProperties(pcare,care);
        //添加保养记录的时间
        care.setCreatedatetime(new Date());
        care.setCaretypeId(pcare.getCareTypeId());
        //if (pcare.getCareTypeId()!=null && !pcare.getCareTypeId().equalsIgnoreCase("")){
        //
        //}
        careMapper.insertSelective(care);
    }


    public void edit(Pcare pcare) {
        Care care=new Care();
        BeanUtils.copyProperties(pcare,care);
        care.setCaretypeId(pcare.getCareTypeId());
        care.setModifydatetime(new Date());
        careMapper.updateByPrimaryKeySelective(care);
    }


    public void delete(Pcare pcare) {
        careMapper.deleteByPrimaryKey(pcare.getId());
    }


    public DataGrid datagrid(Pcare pcare, PageHelper ph) {
        DataGrid datagrid=new DataGrid();
        Care care=new Care();
        BeanUtils.copyProperties(pcare,care);
        com.github.pagehelper.PageHelper.startPage(ph.getPage(),ph.getRows());
        care.setCreatedatetime(pcare.getCreatedatetimeStart());
        care.setModifydatetime(pcare.getCreatedatetimeEnd());
        if (pcare.getCareTypeId()!=null){
            care.setCaretypeId(pcare.getCareTypeId());
        }
        List<Care> careList=careMapper.getAllWithCareType(care);

        datagrid.setRows(changeModel(careList));
        datagrid.setTotal(careMapper.getCount(care));

        return datagrid;
    }


    public Pcare get(String id) {
        Care care=new Care();
        Pcare pcare=new Pcare();
        care.setId(id);
        care=careMapper.getAllWithCareType(care).get(0);
        BeanUtils.copyProperties(care,pcare);

        if (care.getCareType()!=null) {
            pcare.setCareTypeId(care.getCareType().getId());
            pcare.setCareTypeName(care.getCareType().getName());
        }
        return pcare;
    }


    public DataGrid propertyGrid() {
        DataGrid datagrid=new DataGrid();
        List<PropertyGrid> propertyGridList=new ArrayList<PropertyGrid>(5);
        PropertyGrid propertyGrid=new PropertyGrid();
        Care care=new Care();
        care.setCaretypeId("0");//VP香片更换
        propertyGrid.setName("上一次更换时间");
        propertyGrid.setValue(careMapper.get(care).getCreatedatetime().toString());
        propertyGrid.setName("下一次更换时间");
        propertyGrid.setValue("等待重设");
        propertyGrid.setGroup("VP香片更换");
        propertyGridList.add(propertyGrid);



        care.setCaretypeId("1");//风机机油添加
        propertyGrid.setName("上一次更换时间");
        propertyGrid.setValue(careMapper.get(care).getCreatedatetime().toString());
        propertyGrid.setName("下一次更换时间");
        propertyGrid.setValue("等待重设");
        propertyGrid.setGroup("风机机油添加");
        propertyGridList.add(propertyGrid);


        care.setCaretypeId("2");//除尘设备滤网更换
        propertyGrid.setName("上一次更换时间");
        propertyGrid.setValue(careMapper.get(care).getCreatedatetime().toString());
        propertyGrid.setName("下一次更换时间");
        propertyGrid.setValue("等待重设");
        propertyGrid.setGroup("除尘设备滤网更换");
        propertyGridList.add(propertyGrid);


        care.setCaretypeId("3");//除尘设备滤网更换
        propertyGrid.setName("上一次更换时间");
        propertyGrid.setValue(careMapper.get(care).getCreatedatetime().toString());
        propertyGrid.setName("下一次更换时间");
        propertyGrid.setValue("等待重设");
        propertyGrid.setGroup("UV前置滤网更换");
        propertyGridList.add(propertyGrid);

        datagrid.setTotal((long) 4);
        datagrid.setRows(propertyGridList);

        return datagrid;
    }

    private List changeModel(List<Care> careList) {
        List<Pcare> pcareList=new ArrayList<Pcare>();
        for (int i=0;i<careList.size();i++){
            Pcare pcare=new Pcare();
            BeanUtils.copyProperties(careList.get(i),pcare);
            if (careList.get(i).getCareType()!=null) {
                pcare.setCareTypeId(careList.get(i).getCareType().getId());
                if (careList.get(i).getCareType().getName()!=null){
                    pcare.setCareTypeName(careList.get(i).getCareType().getName());
                }
            }
            pcareList.add(pcare);
        }
        return pcareList;
    }
}
