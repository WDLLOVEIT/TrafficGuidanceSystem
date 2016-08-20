package pack.service;

import pack.dao.UserDao;
import pack.entity.User;

public class UserRegisterImpl implements UserRegister {
	private UserDao userDao;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void register(User user) {
		
		userDao.saveOrUpdate(user);
	}

	@Override
	public boolean check(String userName, String passWord) {
		// TODO Auto-generated method stub
		User user=userDao.get(userName);
		return user!=null&&user.getPassWord().equals(passWord);
	}

}
