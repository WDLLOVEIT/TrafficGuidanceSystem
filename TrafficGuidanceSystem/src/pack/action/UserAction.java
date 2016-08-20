package pack.action;


import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import pack.entity.User;
import pack.service.UserRegister;


public class UserAction extends ActionSupport implements RequestAware,SessionAware{
	UserRegister userRegister;
	public void setUserRegister(UserRegister userRegister){
		this.userRegister=userRegister;
	}
	Map<String, Object>request;
	Map<String, Object>session;
	private User user;
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	public String execute(){
		userRegister.register(user);
		
		return "success";
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		this.session=session;
	}

	@Override
	public void setRequest(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		this.request=request;
	}

}
