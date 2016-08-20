package pack.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import pack.dao.AdminDao;
import pack.entity.Admin;



public class AdminDaoImpl extends HibernateDaoSupport implements AdminDao {

	public Admin get(String userName){
		List<Admin> admins=(List<Admin>)getHibernateTemplate()
				.find("from Admin where userName=?",userName);
		if(admins.size()!=0){
			return admins.get(0);
		}else{
			return null;
		}
	}
}
