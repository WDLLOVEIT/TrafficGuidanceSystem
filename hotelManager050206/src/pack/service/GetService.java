package pack.service;

import pack.beans.*;

import java.util.*;

//获取数据库数据的接口
public interface GetService {
	//获取指定id的预约记录
	Book getBook(int id);
	//获取指定id,未入住的预约记录
	Book getCrudeBook(int id);
	//获取指定客户姓名的预约记录
	List<Book> getBooksByName(String name);
	//获取指定客户身份证的预约记录
	List<Book> getBooksByIc(String ic);
	//获取指定客户身份证,未入住的预约记录
	List<Book> getCrudeBooksByIc(String ic);
	//获取指定客户手机号的预约记录
	List<Book> getBooksByPhone(String phone);
	//获取指定预约时间的预约记录
	List<Book> getBooksByTime(String time);
	//获取指定预约入住时间的预约记录
	List<Book> getBooksByStart(String start);
	//获取指定预约退房时间的预约记录
	List<Book> getBooksByLeave(String leave);
	//获取指定房间号的预约记录
	List<Book> getBooksByRoomNum(int roomNum);
	//获取所有未完成预约记录
	List<Book> getCrudeBooks();
	//获取所有预约记录
	List<Book> getAllBooks();
	//获取所有入住记录
	List<Io> getAllIos();
	//获取所有未退房的入住记录
	List<Io> getCurrentIos();
	//根据入住id获取未退房的入住记录
	Io getCurrentIoById(int id);
	//根据客户身份证号获取未退房的入住记录
	Io getCurrentIoByIc(String ic);
	//获取客房
	Room getRoomByNum(int num);
	//获取所有客房
	List<Room> getAllRooms();
	//获取房间类型
	List<Type> getAllTypes();
	//获取指定id的客户
	Customer getCustomer(String ic);
	//获取所有用户
	List<Customer> getAllCustomers();
	//获取今日报表
	Report getTodayReport();
}
