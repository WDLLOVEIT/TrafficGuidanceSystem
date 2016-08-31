package pack.action;

import java.util.List;
import java.text.*;

import pack.beans.*;
import pack.dao.TypeDao;
import pack.service.*;

import java.util.*;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ActionContext;

//用户登录的控制器Action
public class LoginAction 
	extends ActionSupport{
	private String userName;		//管理员用户名
	private String password;		//管理员密码
	private GetService getService;		//获取Service
	private LoginService loginService;	//登录Service
	
	//typeDao的getter和setter方法
	public void setGetService(GetService getService){
		this.getService=getService;
	}
	
	public GetService getGetService(){
		return this.getService;
	}
	
	//登录Service的getter和setter方法
	public void setLoginService(LoginService loginService){
		this.loginService=loginService;
	}
	
	public LoginService getLoginService(){
		return this.loginService;
	}
	
	//userName的getter和setter方法
	public void setUserName(String userName){
		this.userName=userName;
	}
	
	public String getUserName(){
		return this.userName;
	}
	
	//password的getter和setter方法
	public void setPassword(String password){
		this.password=password;
	}
	
	public String getPassword(){
		return this.password;
	}
	
	//action执行方法
	public String execute()
		throws Exception{
		ActionContext ctx=ActionContext.getContext();
		//根据参数获取管理员密码
		boolean flag=loginService.check(userName, password);
		if(!flag){
			ctx.put("tip","用户名与密码不匹配！");
			return "loginPage";
		}else{
			//保存管理员
			Admin admin=new Admin(userName,password);
			ctx.getSession().put("admin",admin);
			
			//获取房间类型列表
			List<Type> types=getService.getAllTypes();
			ctx.getSession().put("types",types);
			
			//获取所有房间
			List<Room> rooms=getService.getAllRooms();
			ctx.getSession().put("rooms",rooms);
			
			//获取所有客户
			List<Customer> customers=getService.getAllCustomers();
			ctx.getSession().put("customers",customers);
			return "book";
		}
	}
}
