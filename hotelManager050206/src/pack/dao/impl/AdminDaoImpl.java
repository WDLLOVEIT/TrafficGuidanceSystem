package pack.dao.impl;

import pack.beans.Admin;
import pack.dao.AdminDao;

import java.util.*;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

public class AdminDaoImpl 
	extends HibernateDaoSupport implements AdminDao{
	//根据adminId得到管理员类
	public Admin get(String userName){
		List<Admin> admins=(List<Admin>)getHibernateTemplate()
				.find("from Admin where userName=?",userName);
		if(admins.size()!=0){
			return admins.get(0);
		}else{
			return null;
		}
	};
}
