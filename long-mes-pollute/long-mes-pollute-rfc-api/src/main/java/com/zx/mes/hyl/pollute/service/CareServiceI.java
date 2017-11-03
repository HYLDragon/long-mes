package com.zx.mes.hyl.pollute.service;

import com.zx.mes.hyl.pageModel.DataGrid;
import com.zx.mes.hyl.pageModel.DataTable;
import com.zx.mes.hyl.pageModel.DataTablePageHelper;
import com.zx.mes.hyl.pageModel.PageHelper;
import com.zx.mes.pageModel.mes.pollute.Pcare;


/**
 * Created by Administrator on 2017/8/23.
 */
public interface CareServiceI {

     void add(Pcare pcare);

     void edit(Pcare pcare);

     void delete(Pcare pcare);

     DataGrid datagrid(Pcare pcare, PageHelper ph);

     DataTable dataTable(Pcare pcare,DataTablePageHelper ph);

     Pcare get(String id);

    DataGrid propertyGrid();
}
