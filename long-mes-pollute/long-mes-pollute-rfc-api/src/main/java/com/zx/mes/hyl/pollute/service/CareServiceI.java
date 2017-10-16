package com.zx.mes.hyl.pollute.service;

import com.zx.mes.hyl.pageModel.DataGrid;
import com.zx.mes.hyl.pageModel.PageHelper;
import com.zx.mes.pageModel.mes.pollute.Pcare;


/**
 * Created by Administrator on 2017/8/23.
 */
public interface CareServiceI {

    public void add(Pcare pcare);

    public void edit(Pcare pcare);

    public void delete(Pcare pcare);

    public DataGrid datagrid(Pcare pcare, PageHelper ph);

    public Pcare get(String id);

    DataGrid propertyGrid();
}
