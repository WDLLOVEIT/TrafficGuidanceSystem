package pack.dao.impl;

import java.util.List;

import pack.beans.Io;
import pack.beans.Report;
import pack.dao.IoDao;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

//IoDao的实现类
public class IoDaoImpl 
	extends HibernateDaoSupport implements IoDao{
	//根据id获取入住记录
	public Io get(int id){
		return getHibernateTemplate()
				.get(Io.class,id);
	}
	
	//找出当前入住记录
	public List<Io> getCurrentIos(){
		return (List<Io>)getHibernateTemplate()
				.find("from Io where state=0");
	};
	
	//获取所有入住记录
	public List<Io> getAllIos(){
		return (List<Io>)getHibernateTemplate()
				.find("from Io");
	}
	
	//保存入住记录
	public void saveOrUpdate(Io io){
		int id=io.getId();
		Io i=get(id);
		if(i==null){
			getHibernateTemplate().save(io);
		}else{
			getHibernateTemplate().merge(io);
		}
	}
	
	//根据入住id获取未退房的记录
	public Io getCurrentIoById(int id){
		List<Io> ios=(List<Io>)getHibernateTemplate()
				.find("from Io where id=? and state=false",id);
		
		if(ios.size()!=0){
			return ios.get(0);
		}else{
			return null;
		}
	}
		
	//根据客户身份证获取未退房的记录
	public Io getCurrentIoByCustomerId(int id){
		List<Io> ios=(List<Io>)getHibernateTemplate()
				.find("from Io where customerId=? and state=false",id);
		
		if(ios.size()!=0){
			return ios.get(0);
		}else{
			return null;
		}
	}
}
