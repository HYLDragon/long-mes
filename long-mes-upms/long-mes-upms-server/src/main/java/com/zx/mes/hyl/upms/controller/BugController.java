package com.zx.mes.hyl.upms.controller;

import com.zx.mes.hyl.controller.BaseController;

import com.zx.mes.hyl.pageModel.DataGrid;
import com.zx.mes.hyl.pageModel.Json;
import com.zx.mes.hyl.pageModel.PageHelper;
import com.zx.mes.hyl.upms.pageModel.Bug;
import com.zx.mes.hyl.upms.service.BugServiceI;
import com.zx.mes.hyl.upms.service.BugTypeServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;


/**
 * BUG管理控制器
 * 
 * @author 
 * 
 */
@Controller
@RequestMapping("/bugController")
public class BugController extends BaseController {

	@Autowired
	private BugServiceI bugService;

	@Autowired
	private BugTypeServiceI bugTypeService;

	/**
	 * 跳转到BUG管理页面
	 * 
	 * @return
	 */
	@RequestMapping("/manager")
	public String manager(HttpServletRequest request) {
		request.setAttribute("bugTypeList", bugTypeService.getBugTypeList());
		return "/admin/bug";
	}

	/**
	 * 获取BUG数据表格
	 * 
	 * @param  bug
	 * @return
	 */
	@RequestMapping("/dataGrid")
	@ResponseBody
	public DataGrid dataGrid(Bug bug, PageHelper ph) {
		return bugService.dataGrid(bug, ph);
	}

	/**
	 * 跳转到添加BUG页面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/addPage")
	public String addPage(HttpServletRequest request) {
		Bug b = new Bug();
		b.setId(UUID.randomUUID().toString());
		request.setAttribute("bug", b);
		request.setAttribute("bugTypeList", bugTypeService.getBugTypeList());
		return "/admin/bugAdd";
	}

	/**
	 * 添加BUG
	 * 
	 * @return
	 */
	@RequestMapping("/add")
	@ResponseBody
	public Json add(Bug bug) {
		Json j = new Json();
		try {
			bugService.add(bug);
			j.setSuccess(true);
			j.setMsg("添加成功！");
		} catch (Exception e) {
			// e.printStackTrace();
			j.setMsg(e.getMessage());
		}
		return j;
	}

	/**
	 * 跳转到BUG查看页面
	 * 
	 * @return
	 */
	@RequestMapping("/view")
	public String view(HttpServletRequest request, String id) {
		Bug b = bugService.get(id);
		request.setAttribute("bug", b);
		return "/admin/bugView";
	}

	/**
	 * 跳转到BUG修改页面
	 * 
	 * @return
	 */
	@RequestMapping("/editPage")
	public String editPage(HttpServletRequest request, String id) {
		Bug b = bugService.get(id);
		request.setAttribute("bug", b);
		request.setAttribute("bugTypeList", bugTypeService.getBugTypeList());
		return "/admin/bugEdit";
	}

	/**
	 * 修改BUG
	 * 
	 * @param bug
	 * @return
	 */
	@RequestMapping("/edit")
	@ResponseBody
	public Json edit(Bug bug) {
		Json j = new Json();
		try {
			bugService.edit(bug);
			j.setSuccess(true);
			j.setMsg("编辑成功！");
		} catch (Exception e) {
			// e.printStackTrace();
			j.setMsg(e.getMessage());
		}
		return j;
	}

	/**
	 * 删除BUG
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public Json delete(String id) {
		Json j = new Json();
		bugService.delete(id);
		j.setMsg("删除成功！");
		j.setSuccess(true);
		return j;
	}

}
