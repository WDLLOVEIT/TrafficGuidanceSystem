package pack.service.impl;

import pack.beans.*;
import pack.dao.*;
import pack.service.GetService;

import java.util.*;
import java.text.*;

public class GetServiceImpl 
	implements GetService{
	private BookDao bookDao;		//预约记录Dao
	private RoomDao roomDao;		//房间Dao
	private CustomerDao customerDao;		//客户Dao
	private TypeDao typeDao;		//房间类型Dao
	private IoDao ioDao;			//出入记录Dao
	private ReportDao reportDao;	//报表Dao
	
	//bookDao的getter和setter方法
	public void setBookDao(BookDao bookDao){
		this.bookDao=bookDao;
	}
	
	public BookDao getBookDao(){
		return this.bookDao;
	}
	
	//bookDao的getter和setter方法
	public void setRoomDao(RoomDao roomDao){
		this.roomDao=roomDao;
	}
	
	public RoomDao getRoomDao(){
		return this.roomDao;
	}
	
	//adminDao的getter和setter方法
	public void setCustomerDao(CustomerDao customerDao){
		this.customerDao=customerDao;
	}
		
	public CustomerDao getCustomerDao(){
		return this.customerDao;
	}
	
	//typeDao的getter和setter方法
	public void setTypeDao(TypeDao typeDao){
		this.typeDao=typeDao;
	}
	
	public TypeDao getTypeDao(){
		return this.typeDao;
	}
	
	//IoDao的getter和setter方法
	public void setIoDao(IoDao ioDao){
		this.ioDao=ioDao;
	}
	
	public IoDao getIoDao(){
		return this.ioDao;
	}
	
	//reportDao的getter和setter方法
	public void setReportDao(ReportDao reportDao){
		this.reportDao=reportDao;
	}
	
	public ReportDao getReportDao(){
		return this.reportDao;
	}
	
	//获取预约记录
	public Book getBook(int id){
		return bookDao.get(id);
	}
	
	//获取指定id,未入住的预约记录
	public Book getCrudeBook(int id){
		return bookDao.getCrudeById(id);
	}
	
	//根据客户姓名获取预约记录
	public List<Book> getBooksByName(String name){
		List<Customer> customers=customerDao.getByName(name);
		List<Book> results=new ArrayList<Book>();
		for(int i=0;i<customers.size();i++){
			Customer customer=customers.get(i);
			List<Book> books=bookDao.getByCustomerId(customer.getId());
			if(books.size()!=0){
				results.addAll(books);
			}
		}
		
		return results;
	}
	
	//获取指定客户身份证的预约记录
	public List<Book> getBooksByIc(String ic){
		Customer customer=customerDao.getByIc(ic);
		List<Book> books=new ArrayList<Book>();
		if(customer!=null){
			books=bookDao.getByCustomerId(customer.getId());
		}
		
		return books;
	}
	
	//获取指定客户身份证的预约记录
	public List<Book> getCrudeBooksByIc(String ic){
		Customer customer=customerDao.getByIc(ic);
		List<Book> books=new ArrayList<Book>();
		if(customer!=null){
			books=bookDao.getCrudeByCustomerId(customer.getId());
		}
		
		return books;
	}
	
	//获取指定客户手机号的预约记录
	public List<Book> getBooksByPhone(String phone){
		Customer customer=customerDao.getByPhone(phone);
		List<Book> books=new ArrayList<Book>();
		if(customer!=null){
			books=bookDao.getByCustomerId(customer.getId());
		}
		
		return books;
	}
	
	//获取指定预约时间的预约记录
	public List<Book> getBooksByTime(String time){
		return bookDao.getByTime(time);
	}
	
	//获取指定预约入住时间的预约记录
	public List<Book> getBooksByStart(String start){
		return bookDao.getByStart(start);
	}
	
	//获取指定预约退房时间的预约记录
	public List<Book> getBooksByLeave(String leave){
		return bookDao.getByLeave(leave);
	}
	
	//获取指定房间号的预约记录
	public List<Book> getBooksByRoomNum(int roomNum){
		Room room=roomDao.getByNum(roomNum);
		List<Book> books=new ArrayList<Book>();
		if(room!=null){
			books=bookDao.getByRoomId(room.getId());
		}
		
		return books;
	}
	
	//获取所有未完成记录
	public List<Book> getCrudeBooks(){
		return bookDao.getCrudeBooks();
	}
	
	//获取所有预约记录
	public List<Book> getAllBooks(){
		return bookDao.getAllBooks();
	}
	
	//获取所有未退房的入住记录
	public List<Io> getCurrentIos(){
		return ioDao.getCurrentIos();
	}
	
	//获取所有入住记录
	public List<Io> getAllIos(){
		return ioDao.getAllIos();
	}
	
	//根据入住id获取未退房的入住记录
	public Io getCurrentIoById(int id){
		return ioDao.getCurrentIoById(id);
	}
	
	//根据客户身份证号获取未退房的入住记录
	public Io getCurrentIoByIc(String ic){
		Customer customer=customerDao.getByIc(ic);
		return ioDao.getCurrentIoByCustomerId(customer.getId());
	}
	
	//获取房间类
	public Room getRoomByNum(int num){
		return roomDao.getByNum(num);
	}
	
	//获取所有房间
	public List<Room> getAllRooms(){
		return roomDao.getAllRooms();
	}
	
	//获取所有房间类型
	public List<Type> getAllTypes(){
		return typeDao.getAllTypes();
	}
	
	//获取指定ic的用户类
	public Customer getCustomer(String ic){
		return customerDao.getByIc(ic);
	}
	
	//获取所有用户类
	public List<Customer> getAllCustomers(){
		return customerDao.getAllCustomers();
	}
	
	//获取今日报表
	public Report getTodayReport(){
		Date date=new Date();
		Report report=reportDao.getByDate(date);
		
		return report;
	}
}
