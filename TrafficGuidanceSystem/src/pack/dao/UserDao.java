package pack.dao;

import java.util.List;

import pack.entity.User;

public interface UserDao{
	User get(String userName);
	void saveOrUpdate(User user);
	void delete(User user);
	List<User> findAll();
	
}
