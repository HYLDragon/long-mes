package com.zx.mes.hyl.pollute.controller;

import com.alibaba.fastjson.JSON;
import com.zx.mes.hyl.controller.BaseController;
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
import javax.servlet.http.HttpSession;
import java.util.List;



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



}
