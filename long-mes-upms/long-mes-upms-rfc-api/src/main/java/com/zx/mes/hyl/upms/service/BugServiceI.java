package com.zx.mes.hyl.upms.service;


import com.zx.mes.hyl.pageModel.DataGrid;
import com.zx.mes.hyl.pageModel.PageHelper;
import com.zx.mes.hyl.upms.pageModel.Bug;

/**
 * 
 * @author 
 * 
 */
public interface BugServiceI {

	/**
	 * 获取BUG数据表格
	 * 
	 * @param bug
	 *            参数
	 * @param ph
	 *            分页帮助类
	 * @return
	 */
	 DataGrid dataGrid(Bug bug, PageHelper ph);

	/**
	 * 添加BUG
	 * 
	 * @param bug
	 */
	void add(Bug bug);

	/**
	 * 获得BUG对象
	 * 
	 * @param id
	 * @return
	 */
	Bug get(String id);

	/**
	 * 修改BUG
	 * 
	 * @param bug
	 */
	void edit(Bug bug);

	/**
	 * 删除BUG
	 * 
	 * @param id
	 */
	public void delete(String id);

}
