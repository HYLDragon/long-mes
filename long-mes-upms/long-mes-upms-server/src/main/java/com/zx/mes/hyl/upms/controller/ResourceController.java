package com.zx.mes.hyl.upms.controller;

import com.alibaba.fastjson.JSON;
import com.zx.mes.hyl.controller.BaseController;
import com.zx.mes.hyl.pageModel.Json;

import com.zx.mes.hyl.pageModel.SessionInfo;
import com.zx.mes.hyl.pageModel.Tree;
import com.zx.mes.hyl.upms.pageModel.Resource;
import com.zx.mes.hyl.upms.service.ResourceServiceI;
import com.zx.mes.hyl.upms.service.ResourceTypeServiceI;
import com.zx.mes.hyl.util.ConfigUtil;
import com.zx.mes.hyl.util.PropertiesFileUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.UUID;


/**
 * 资源控制器
 * 
 * @author 
 * 
 */
@Controller
@RequestMapping("/resourceController")
public class ResourceController extends BaseController {

	@Autowired
	private ResourceServiceI resourceService;

	@Autowired
	private ResourceTypeServiceI resourceTypeService;


	private static final Logger logger=Logger.getLogger(ResourceController.class);
	/**
	 * 获得资源树(资源类型为菜单类型)
	 * 
	 * 通过用户ID判断，他能看到的资源
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping("/tree")
	@ResponseBody
	public List<Tree> tree(HttpSession session) {
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(ConfigUtil.getSessionInfoName());
		sessionInfo.setSysId(PropertiesFileUtil.getInstance().get("long-mes-sys-id"));
		logger.info(JSON.toJSONStringWithDateFormat("系统ID:"+sessionInfo.getSysId(),"yyyy-MM-dd HH:mm:ss"));
		return resourceService.treeByTsys(sessionInfo);
	}

	/**
	 * 获得资源树(资源类型为菜单类型)
	 *
	 * 通过用户ID判断，他能看到的资源
	 *
	 * @param session
	 * @return
	 */
	@RequestMapping("/treeByTsys")
	@ResponseBody
	public List<Tree> treeByTsys(HttpSession session) {
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(ConfigUtil.getSessionInfoName());
		sessionInfo.setSysId(PropertiesFileUtil.getInstance().get("long-mes-sys-id"));

		return resourceService.treeByTsys(sessionInfo);
	}

	/**
	 * 获得资源树(包括所有资源类型)
	 * 
	 * 通过用户ID判断，他能看到的资源
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping("/allTree")
	@ResponseBody
	public List<Tree> allTree(HttpSession session) {
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(ConfigUtil.getSessionInfoName());
		return resourceService.allTree(sessionInfo);
	}

	/**
	 * 跳转到资源管理页面
	 * 
	 * @return
	 */
	@RequestMapping("/manager")
	public String manager() {
		return "/admin/resource";
	}

	/**
	 * 跳转到资源添加页面
	 * 
	 * @return
	 */
	@RequestMapping("/addPage")
	public String addPage(HttpServletRequest request) {
		request.setAttribute("resourceTypeList", resourceTypeService.getResourceTypeList());
		Resource r = new Resource();
		r.setId(UUID.randomUUID().toString());
		request.setAttribute("resource", r);
		return "/admin/resourceAdd";
	}

	/**
	 * 添加资源
	 * 
	 * @return
	 */
	@RequestMapping("/add")
	@ResponseBody
	public Json add(Resource resource, HttpSession session) {
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(ConfigUtil.getSessionInfoName());
		Json j = new Json();
		resourceService.add(resource, sessionInfo);
		j.setSuccess(true);
		j.setMsg("添加成功！");
		return j;
	}

	/**
	 * 跳转到资源编辑页面
	 * 
	 * @return
	 */
	@RequestMapping("/editPage")
	public String editPage(HttpServletRequest request, String id) {
		request.setAttribute("resourceTypeList", resourceTypeService.getResourceTypeList());
		Resource r = resourceService.get(id);
		request.setAttribute("resource", r);
		return "/admin/resourceEdit";
	}

	/**
	 * 编辑资源
	 * 
	 * @param resource
	 * @return
	 */
	@RequestMapping("/edit")
	@ResponseBody
	public Json edit(Resource resource) {
		Json j = new Json();
		resourceService.edit(resource);
		j.setSuccess(true);
		j.setMsg("编辑成功！");
		return j;
	}

	/**
	 * 获得资源列表
	 * 
	 * 通过用户ID判断，他能看到的资源
	 * 
	 * @return
	 */
	@RequestMapping("/treeGrid")
	@ResponseBody
	public List<Resource> treeGrid(HttpSession session) {
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(ConfigUtil.getSessionInfoName());
		return resourceService.treeGrid(sessionInfo);
	}

	/**
	 * 删除资源
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public Json delete(String id) {
		Json j = new Json();
		resourceService.delete(id);
		j.setMsg("删除成功！");
		j.setSuccess(true);
		return j;
	}

}
