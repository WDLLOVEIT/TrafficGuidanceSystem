package pack.service;

import pack.dao.AdminDao;
import pack.entity.Admin;

public class AdminServiceImpl implements AdminService {

	private AdminDao adminDao;

	public void setAdminDao(AdminDao adminDao){
		this.adminDao=adminDao;
	}

	public AdminDao getAdminDao(){
		return adminDao;
	}

	public boolean check(String userName,String password){
		Admin admin=adminDao.get(userName);
		return admin!=null&&admin.getPassWord().equals(password);
	}
}
