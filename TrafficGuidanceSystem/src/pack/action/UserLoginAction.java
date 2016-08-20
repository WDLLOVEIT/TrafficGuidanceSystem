package pack.action;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import pack.entity.Admin;
import pack.entity.User;
import pack.service.AdminService;
import pack.service.UserRegister;
import pack.service.UserService;


public class UserLoginAction extends ActionSupport {

	private User user;

	private UserService userService;
	
	public String execute()
			throws Exception{
			ActionContext ctx=ActionContext.getContext();
			//根据参数获取管理员密码
		
			boolean userflag=userService.check(user.getUserName(),user.getPassWord());
			if(!userflag){
				ctx.put("tip","用户名与密码不匹配！");
				return "loginPage";
			}else{
				return "success";
			}
		}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	
}
