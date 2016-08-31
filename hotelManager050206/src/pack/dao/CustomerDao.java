package pack.dao;

import pack.beans.Customer;

import java.util.*;

//客户类Dao
public interface CustomerDao {
	//根据用户id得到指定用户
	Customer getById(int id);
	
	//根据客户身份证号得到指定客户
	Customer getByIc(String ic);
	
	//根据客户姓名得到指定客户
	List<Customer> getByName(String name);
	
	//根据客户电话得到指定客户
	Customer getByPhone(String phone);
	
	//获取数据库中的所有客户
	List<Customer> getAllCustomers();
	
	//保存客户类
	void saveOrUpdate(Customer customer);
}
