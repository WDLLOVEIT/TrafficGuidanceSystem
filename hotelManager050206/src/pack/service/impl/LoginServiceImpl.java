package pack.service.impl;

import java.util.*;

import pack.beans.Admin;
import pack.dao.AdminDao;
import pack.service.LoginService;

//答案逻辑处理接口的实现类
public class LoginServiceImpl 
	implements LoginService{
	private AdminDao adminDao;

	public void setAdminDao(AdminDao adminDao){
		this.adminDao=adminDao;
	}

	public AdminDao getAdminDao(){
		return adminDao;
	}

	public boolean check(String userName,String password){
		Admin admin=adminDao.get(userName);
		return admin!=null&&admin.getPassword().equals(password);
	}
}