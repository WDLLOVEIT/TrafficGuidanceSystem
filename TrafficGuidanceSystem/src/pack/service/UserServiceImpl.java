package pack.service;

import pack.dao.UserDao;
import pack.entity.User;

public class UserServiceImpl implements UserService {

	private UserDao userDao;

	

	public boolean check(String userName,String password){
		User user=userDao.get(userName);
		return user!=null&&user.getPassWord().equals(password);
	}



	public UserDao getUserDao() {
		return userDao;
	}



	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
}
