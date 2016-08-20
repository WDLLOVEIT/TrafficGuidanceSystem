package pack.service;

import pack.entity.User;

public interface UserRegister {
	public void register(User user);

	public boolean check(String userName,String passWord);
}
