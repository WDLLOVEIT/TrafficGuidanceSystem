package pack.dao.impl;

import java.util.List;

import pack.beans.Customer;
import pack.dao.CustomerDao;

import java.util.*;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
//客户类Dao的实现类
public class CustomerDaoImpl 
	extends HibernateDaoSupport implements CustomerDao{
	//根据客户id得到指定客户
	public Customer getById(int id){
		return getHibernateTemplate().get(Customer.class,id);
	}
	
	//根据客户身份证号得到指定客户
	public Customer getByIc(String ic){
		List<Customer> customers=(List<Customer>)getHibernateTemplate()
				.find("from Customer where ic=?",ic);
				
		if(customers.size()!=0){
			return customers.get(0);
		}else{
			return null;
		}		
	}
		
	//根据客户姓名得到指定客户
	public List<Customer> getByName(String name){
		return (List<Customer>)getHibernateTemplate()
				.find("from Customer where name=?",name);
	}
		
	//根据客户电话得到指定客户
	public Customer getByPhone(String phone){
		List<Customer> customers=(List<Customer>)getHibernateTemplate()
				.find("from Customer where phone=?",phone);
			
		if(customers.size()!=0){
			return customers.get(0);
		}else{
			return null;
		}
	}
		
	//获取数据库中的所有客户
	public List<Customer> getAllCustomers(){
		return (List<Customer>)getHibernateTemplate()
				.find("from Customer");
	}
		
	//保存客户类
	public void saveOrUpdate(Customer customer){
		try{
			String ic=customer.getIc();
			Customer c=getByIc(ic);
			
			if(c==null){
				getHibernateTemplate().save(customer);
			}else{
				customer.setId(c.getId());
				getHibernateTemplate().merge(customer);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
