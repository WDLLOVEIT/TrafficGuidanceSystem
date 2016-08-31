package pack.dao.impl;

import pack.beans.Type;
import pack.dao.TypeDao;

import java.util.*;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

//Type类Dao的实现类
public class TypeDaoImpl 
	extends HibernateDaoSupport implements TypeDao{
	//根据ID得到Type类名称
	public Type get(int id){
		return getHibernateTemplate().get(Type.class,id);
	}
	
	//获取所有类型
	public List<Type> getAllTypes(){
		return (List<Type>)getHibernateTemplate().
				find("from Type");
	}
}
