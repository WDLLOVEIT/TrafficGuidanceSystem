package pack.dao.impl;

import java.util.*;
import java.text.*;

import pack.beans.Book;
import pack.dao.BookDao;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
//预约记录DAO接口的实现类
public class BookDaoImpl 
	extends HibernateDaoSupport implements BookDao{
	//根据预约id得到预约记录
	public Book get(int id){
		return getHibernateTemplate().get(Book.class,id);
	};
	
	//根据客户id得到预约记录
	public Book getCrudeById(int id){
		List<Book> books=(List<Book>)getHibernateTemplate()
				.find("from Book where id=? and flag=0",id);
		
		if(books.size()!=0){
			return books.get(0);
		}else{
			return null;
		}
	}
	
	//根据客户id得到预约记录
	public List<Book> getByCustomerId(int customerId){
		return (List<Book>)getHibernateTemplate()
				.find("from Book where customerId=?",customerId);
	}
	
	//根据客户id得到未完成的预约记录
	public List<Book> getCrudeByCustomerId(int customerId){
		return (List<Book>)getHibernateTemplate()
				.find("from Book where customerId=? and flag=0",customerId);
	}
	
	//根据房间id得到预约记录
	public List<Book> getByRoomId(int roomId){
		return (List<Book>)getHibernateTemplate()
				.find("from Book where roomId=?",roomId);
	}
	
	//根据预约时间得到预约记录
	public List<Book> getByTime(String time){
		Date t=null;
		try{
			DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
			t=df.parse(time);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return (List<Book>)getHibernateTemplate()
				.find("from Book where time=?",t);
	}
	
	//根据预约入住时间得到预约记录
	public List<Book> getByStart(String start){
		Date t=null;
		try{
			DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
			t=df.parse(start);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return (List<Book>)getHibernateTemplate()
				.find("from Book where start=?",t);
	}
		
	//根据预约退房时间得到预约记录
	public List<Book> getByLeave(String leave){
		Date t=null;
		try{
			DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
			t=df.parse(leave);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return (List<Book>)getHibernateTemplate()
				.find("from Book where leave=?",t);
	}
		
	//得到所有未完成预约
	public List<Book> getCrudeBooks(){
		return (List<Book>)getHibernateTemplate()
				.find("from Book where flag=0 order by roomId");
	};
		
	//得到所有预约
	public List<Book> getAllBooks(){
		return (List<Book>)getHibernateTemplate()
				.find("from Book");
	};
	
	//保存预约
	public void saveOrUpdate(Book book){
		try{
			getHibernateTemplate().saveOrUpdate(book);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
