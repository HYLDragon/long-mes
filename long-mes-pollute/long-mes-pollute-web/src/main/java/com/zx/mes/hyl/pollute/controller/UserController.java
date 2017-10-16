package com.zx.mes.hyl.pollute.controller;

import com.alibaba.fastjson.JSON;
import com.zx.mes.hyl.controller.BaseController;
import com.zx.mes.hyl.pageModel.Json;
import com.zx.mes.hyl.pageModel.SessionInfo;
import com.zx.mes.hyl.upms.pageModel.User;
import com.zx.mes.hyl.upms.service.ResourceServiceI;
import com.zx.mes.hyl.upms.service.RoleServiceI;
import com.zx.mes.hyl.upms.service.UserServiceI;
import com.zx.mes.hyl.util.ConfigUtil;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


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

}
