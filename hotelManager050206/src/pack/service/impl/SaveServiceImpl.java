package pack.service.impl;

import pack.beans.*;
import pack.dao.*;
import pack.service.SaveService;

import java.util.*;

//保存业务逻辑接口的实现类
public class SaveServiceImpl 
	implements SaveService{
	private CustomerDao customerDao;
	private BookDao bookDao;
	private ReportDao reportDao;
	private IoDao ioDao;
	private RoomDao roomDao;
	private TypeDao typeDao;
	
	//customerDao的getter和setter方法
	public void setCustomerDao(CustomerDao customerDao){
		this.customerDao=customerDao;
	}
	
	public CustomerDao getCustomerDao(){
		return this.customerDao;
	}
	
	//bookDao的getter和setter方法
	public void setBookDao(BookDao bookDao){
		this.bookDao=bookDao;
	}
	
	public BookDao getBookDao(){
		return this.bookDao;
	}
	
	//reportDao的getter和setter方法
	public void setReportDao(ReportDao reportDao){
		this.reportDao=reportDao;
	}
	
	public ReportDao getReportDao(){
		return this.reportDao;
	}
	
	//reportDao的getter和setter方法
	public void setIoDao(IoDao ioDao){
		this.ioDao=ioDao;
	}
	
	public IoDao getIoDao(){
		return this.ioDao;
	}
	
	//roomDao的getter和setter方法
	public void setRoomDao(RoomDao roomDao){
		this.roomDao=roomDao;
	}
	
	public RoomDao getRoomDao(){
		return this.roomDao;
	}
	
	//typeDao的getter和setter方法
	public void setTypeDao(TypeDao typeDao){
		this.typeDao=typeDao;
	}
	
	public TypeDao getTypeDao(){
		return this.typeDao;
	}
	
	//保存客户信息
	public void saveCustomer(Customer customer){
		customerDao.saveOrUpdate(customer);
	}
		
	//保存预约记录
	public void saveBook(Book book){
		bookDao.saveOrUpdate(book);
		Report report=reportDao.getByDate(new Date());
		if(report==null){
			report=new Report(new Date());
			reportDao.saveOrUpdate(report);
			report=reportDao.getByDate(new Date());
		}
		report.setOrdersum(report.getOrdersum()+1);
		saveReport(report);
	}
	
	//保存出入记录
	public void saveIo(Io io){
		ioDao.saveOrUpdate(io);
		Report report=reportDao.getByDate(new Date());
		if(report==null){
			report=new Report(new Date());
			reportDao.saveOrUpdate(report);
			report=reportDao.getByDate(new Date());
		}
		report.setCheckin(report.getCheckin()+1);
		Room room=roomDao.getById(io.getRoomId());
		Type type=typeDao.get(room.getTypeId());
		report.setIncome(report.getIncome()+type.getPrice());
		saveReport(report);
	}
	
	//保存报表记录
	public void saveReport(Report report){
		reportDao.saveOrUpdate(report);
	}
}
