package com.zx.mes.hyl.upms.controller;

import com.alibaba.fastjson.JSON;
import com.zx.mes.hyl.controller.BaseController;
import com.zx.mes.hyl.pageModel.DataGrid;
import com.zx.mes.hyl.pageModel.Json;
import com.zx.mes.hyl.pageModel.PageHelper;
import com.zx.mes.hyl.pageModel.SessionInfo;

import com.zx.mes.hyl.upms.pageModel.User;
import com.zx.mes.hyl.upms.service.ResourceServiceI;
import com.zx.mes.hyl.upms.service.RoleServiceI;
import com.zx.mes.hyl.upms.service.UserServiceI;
import com.zx.mes.hyl.util.ConfigUtil;
import com.zx.mes.hyl.util.IpUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.UUID;

/**
 * 用户控制器
 * 
 * @author 
 * 
 */
@Controller
//@Api(value = "用户管理",description = "用户管理")
@RequestMapping("/userController")
public class UserController extends BaseController {

	private static final Logger logger=Logger.getLogger(UserController.class);

	@Autowired
	private UserServiceI userService;

	@Autowired
	private RoleServiceI roleService;

	@Autowired
	private ResourceServiceI resourceService;

	/**
	 * 用户登录
	 * 
	 * @param user
	 *            用户对象
	 * @param session
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/login")
	public Json login(User user, HttpSession session, HttpServletRequest request) {
		Json j = new Json();
		//User u = userService.login(user);
		User u=userService.getByUserName(request.getRemoteUser());
		if (u != null) {
			j.setSuccess(true);
			j.setMsg("登陆成功！");

			SessionInfo sessionInfo = new SessionInfo();
			BeanUtils.copyProperties(u, sessionInfo);
			sessionInfo.setIp(IpUtil.getIpAddr(request));
			sessionInfo.setResourceList(userService.resourceList(u.getId()));
			session.setAttribute(ConfigUtil.getSessionInfoName(), sessionInfo);

			j.setObj(sessionInfo);
		} else {
			j.setMsg("用户名或密码错误！");
		}
		return j;
	}
	//@ApiOperation(value = "登录")
	//@ResponseBody
	//@RequestMapping("/login")
	//public Json login(User user, HttpSession session, HttpServletRequest request) {
	//	Json j = new Json();
	//	User u = userService.login(user);
	//	if (u != null) {
	//		j.setSuccess(true);
	//		j.setMsg("登陆成功！");
    //
	//		SessionInfo sessionInfo = new SessionInfo();
	//		BeanUtils.copyProperties(u, sessionInfo);
	//		sessionInfo.setIp(IpUtil.getIpAddr(request));
	//		sessionInfo.setResourceList(userService.resourceList(u.getId()));
	//		session.setAttribute(ConfigUtil.getSessionInfoName(), sessionInfo);
	//
	//		j.setObj(sessionInfo);
	//	} else {
	//		j.setMsg("用户名或密码错误！");
	//	}
	//	return j;
	//}

	/**
	 * 用户注册
	 * 
	 * @param user
	 *            用户对象
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/reg")
	public Json reg(User user) {
		Json j = new Json();
		try {
			userService.reg(user);
			j.setSuccess(true);
			j.setMsg("注册成功！新注册的用户没有任何权限，请让管理员赋予权限后再使用本系统！");
			j.setObj(user);
		} catch (Exception e) {
			// e.printStackTrace();
			j.setMsg(e.getMessage());
		}
		return j;
	}

	/**
	 * 退出登录
	 * 
	 * @param session
	 * @return
	 */

	@ResponseBody
	@RequestMapping("/logout")
	//public String logout(HttpSession session) {
	//	//Json j = new Json();
	//	if (session != null) {
	//		session.invalidate();
	//	}
	//	//j.setSuccess(true);
	//	//j.setMsg("注销成功！");
	//	return "redirect:http://10.30.90.68:8080/logout";
	//}
	public Json logout(HttpSession session) {
		Json j = new Json();
		if (session != null) {
			session.invalidate();
		}
		j.setSuccess(true);
		j.setMsg("注销成功！");
		return j;
	}

	/**
	 * 跳转到用户管理页面
	 * 
	 * @return
	 */
	@ApiOperation(value = "用户管理页面")
	@RequestMapping("/manager")
	public String manager() {
		return "/admin/user";
	}

	/**
	 * 获取用户数据表格
	 * 
	 * @param user
	 * @return
	 */
	@ApiOperation(value = "用户显示页面")
	@RequiresPermissions("/userController/dataGrid")
	@RequestMapping("/dataGrid")
	@ResponseBody
	public DataGrid dataGrid(User user, PageHelper ph) {
		return userService.dataGrid(user, ph);
	}

	/**
	 * 跳转到添加用户页面
	 * 
	 * @param request
	 * @return
	 */
	@ApiOperation(value = "添加用户页面")
	@RequiresPermissions("/userController/addPage")
	@RequestMapping("/addPage")
	public String addPage(HttpServletRequest request) {
		User u = new User();
		u.setId(UUID.randomUUID().toString());
		request.setAttribute("src/main/webapp/user", u);
		return "/admin/userAdd";
	}

	/**
	 * 添加用户
	 * 
	 * @return
	 */
	@ApiOperation(value = "添加用户功能")
	@RequiresPermissions("/userController/add")
	@RequestMapping("/add")
	@ResponseBody
	public Json add(User user) {
		Json j = new Json();
		try {
			userService.add(user);
			j.setSuccess(true);
			j.setMsg("添加成功！");
			j.setObj(user);
		} catch (Exception e) {
			// e.printStackTrace();
			j.setMsg(e.getMessage());
		}
		return j;
	}

	/**
	 * 跳转到用户修改页面
	 * 
	 * @return
	 */
	@ApiOperation(value = "编辑用户页面")
	@RequiresPermissions("/userController/editPage")
	@RequestMapping("/editPage")
	public String editPage(HttpServletRequest request, String id) {
		User u = userService.get(id);
		request.setAttribute("src/main/webapp/user", u);
		return "/admin/userEdit";
	}

	/**
	 * 修改用户
	 * 
	 * @param user
	 * @return
	 */
	@ApiOperation(value = "编辑用户功能")
	@RequiresPermissions("/userController/edit")
	@RequestMapping("/edit")
	@ResponseBody
	public Json edit(User user) {
		Json j = new Json();
		try {
			userService.edit(user);
			j.setSuccess(true);
			j.setMsg("编辑成功！");
			j.setObj(user);
		} catch (Exception e) {
			// e.printStackTrace();
			j.setMsg(e.getMessage());
		}
		return j;
	}

	/**
	 * 删除用户
	 * 
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "删除用户功能")
	@RequiresPermissions("/userController/delete")
	@RequestMapping("/delete")
	@ResponseBody
	public Json delete(String id, HttpSession session) {
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(ConfigUtil.getSessionInfoName());
		Json j = new Json();
		if (id != null && !id.equalsIgnoreCase(sessionInfo.getId())) {// 不能删除自己
			userService.delete(id);
		}
		j.setMsg("删除成功！");
		j.setSuccess(true);
		return j;
	}

	/**
	 * 批量删除用户
	 * 
	 * @param ids
	 *            ('0','1','2')
	 * @return
	 */
	@ApiOperation(value = "批量删除用户功能")
	@RequiresPermissions("/userController/batchDelete")
	@RequestMapping("/batchDelete")
	@ResponseBody
	public Json batchDelete(String ids, HttpSession session) {
		Json j = new Json();
		if (ids != null && ids.length() > 0) {
			for (String id : ids.split(",")) {
				if (id != null) {
					this.delete(id, session);
				}
			}
		}
		j.setMsg("批量删除成功！");
		j.setSuccess(true);
		return j;
	}

	/**
	 * 跳转到用户授权页面
	 * 
	 * @return
	 */
	@ApiOperation(value = "用户授权页面")
	@RequiresPermissions("/userController/grantPage")
	@RequestMapping("/grantPage")
	public String grantPage(String ids, HttpServletRequest request) {
		request.setAttribute("ids", ids);
		if (ids != null && !ids.equalsIgnoreCase("") && ids.indexOf(",") == -1) {
			User u = userService.get(ids);
			request.setAttribute("src/main/webapp/user", u);
		}
		return "/admin/userGrant";
	}

	/**
	 * 用户授权
	 * 
	 * @param ids
	 * @return
	 */
	@ApiOperation(value = "用户授权功能")
	@RequiresPermissions("/userController/grant")
	@RequestMapping("/grant")
	@ResponseBody
	public Json grant(String ids, User user) {
		Json j = new Json();
		userService.grant(ids, user);
		j.setSuccess(true);
		j.setMsg("授权成功！");
		return j;
	}

	/**
	 * 跳转到编辑用户密码页面
	 * 
	 * @param id
	 * @param request
	 * @return
	 */
	@ApiOperation(value = "编辑密码页面")
	@RequiresPermissions("/userController/editPwdPage")
	@RequestMapping("/editPwdPage")
	public String editPwdPage(String id, HttpServletRequest request) {
		User u = userService.get(id);
		request.setAttribute("src/main/webapp/user", u);
		return "/admin/userEditPwd";
	}

	/**
	 * 编辑用户密码
	 * 
	 * @param user
	 * @return
	 */
	@ApiOperation(value = "编辑密码功能")
	@RequiresPermissions("/userController/editPwd")
	@RequestMapping("/editPwd")
	@ResponseBody
	public Json editPwd(User user) {
		Json j = new Json();
		userService.editPwd(user);
		j.setSuccess(true);
		j.setMsg("编辑成功！");
		return j;
	}

	/**
	 * 跳转到编辑自己的密码页面
	 * 
	 * @return
	 */
	@ApiOperation(value = "编辑自己密码页面")
//	@RequiresPermissions("/userController/editPwdPage")
	@RequestMapping("/editCurrentUserPwdPage")
	public String editCurrentUserPwdPage() {
		return "/src/main/webapp/user/userEditPwd";
	}

	/**
	 * 修改自己的密码
	 * 
	 * @param session
	 * @param pwd
	 * @return
	 */
	@ApiOperation(value = "编辑自己密码功能")
	@RequestMapping("/editCurrentUserPwd")
	@ResponseBody
	public Json editCurrentUserPwd(HttpSession session, String oldPwd, String pwd) {
		Json j = new Json();
		if (session != null) {
			SessionInfo sessionInfo = (SessionInfo) session.getAttribute(ConfigUtil.getSessionInfoName());
			if (sessionInfo != null) {
				if (userService.editCurrentUserPwd(sessionInfo, oldPwd, pwd)) {
					j.setSuccess(true);
					j.setMsg("编辑密码成功，下次登录生效！");
				} else {
					j.setMsg("原密码错误！");
				}
			} else {
				j.setMsg("登录超时，请重新登录！");
			}
		} else {
			j.setMsg("登录超时，请重新登录！");
		}
		return j;
	}

	/**
	 * 跳转到显示用户角色页面
	 * 
	 * @return
	 */
	@ApiOperation(value = "显示用户角色页面")
//	@RequiresPermissions("/userController/editPwdPage")
	@RequestMapping("/currentUserRolePage")
	public String currentUserRolePage(HttpServletRequest request, HttpSession session) {
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(ConfigUtil.getSessionInfoName());
		request.setAttribute("userRoles", JSON.toJSONString(roleService.tree(sessionInfo)));
		return "/src/main/webapp/user/userRole";
	}

	/**
	 * 跳转到显示用户权限页面
	 * 
	 * @return
	 */
	@ApiOperation(value = "显示用户权限页面")
	@RequestMapping("/currentUserResourcePage")
	public String currentUserResourcePage(HttpServletRequest request, HttpSession session) {
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(ConfigUtil.getSessionInfoName());
		request.setAttribute("userResources", JSON.toJSONString(resourceService.allTree(sessionInfo)));
		return "/src/main/webapp/user/userResource";
	}

	/**
	 * 用户登录时的autocomplete
	 * 
	 * @param q
	 *            参数
	 * @return
	 */
	//@ApiOperation(value = "登录 loginCombobox")
	@RequestMapping("/loginCombobox")
	@ResponseBody
	public List<User> loginCombobox(String q) {
		return userService.loginCombobox(q);
	}

	/**
	 * 用户登录时的combogrid
	 * 
	 * @param q
	 * @param ph
	 * @return
	 */
	//@ApiOperation(value = "登录 loginCombogrid")
	@RequestMapping("/loginCombogrid")
	@ResponseBody
	public DataGrid loginCombogrid(String q, PageHelper ph) {
		return userService.loginCombogrid(q, ph);
	}

}
