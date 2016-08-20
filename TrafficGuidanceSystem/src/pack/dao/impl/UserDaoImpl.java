package pack.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import pack.entity.User;
import pack.dao.UserDao;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao {


	public void saveOrUpdate(User user){
		try{
			Integer userid=user.getUserId();
			if(userid==null){
			getHibernateTemplate().save(user);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void delete(User user) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(user);
	}


	public List<User> findAll() {
		// TODO Auto-generated method stub
		return (List<User>)getHibernateTemplate().find("from User");
	}

		// TODO Auto-generated method stub
		public User get(String userName){
			List<User> users=(List<User>)getHibernateTemplate()
					.find("from User where userName=?",userName);
			if(users.size()!=0){
				return users.get(0);
			}else{
				return null;
			}
		}
	}

