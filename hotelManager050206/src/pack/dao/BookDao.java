package pack.dao;

import pack.beans.Book;

import java.util.*;

//预约记录DAO接口
public interface BookDao {
	//根据预约id得到预约记录
	Book get(int id);
	
	//根据预约id得到未完成预约记录
	Book getCrudeById(int id);
	
	//根据客户id得到预约记录
	List<Book> getByCustomerId(int id);
	
	//根据客户id得到未完成的预约记录
	List<Book> getCrudeByCustomerId(int id);
	
	//根据预约时间得到预约记录
	List<Book> getByTime(String time);
	
	//根据预约入住时间得到预约记录
	List<Book> getByStart(String start);
	
	//根据预约退房时间得到预约记录
	List<Book> getByLeave(String leave);
	
	//根据房间id得到预约记录
	List<Book> getByRoomId(int roomId);
	
	//得到所有未完成预约
	List<Book> getCrudeBooks();
	
	//得到所有预约
	List<Book> getAllBooks();
	
	//保存预约
	void saveOrUpdate(Book book);
}
