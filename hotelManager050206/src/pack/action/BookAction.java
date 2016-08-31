package pack.action;

import java.util.Date;
import java.util.List;
import java.text.*;

import pack.dao.*;
import pack.beans.*;
import pack.service.*;

import java.util.*;
import java.io.*;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ActionContext;

//用户登录的控制器Action
public class BookAction 
	extends ActionSupport{
	private String start;			//用户预约开始时间
	private String leave;			//用户预约离开时间
	private Customer customer;		//客户类
	private int roomId;		//预约房间号
	private SaveService saveService;			//保存Service
	private GetService getService;				//获取Service
	private SortService sortService;	//筛选Service
	private InputStream inputStream;	//封装输出结果的二进制流
	
	//start的getter和setter方法
	public void setStart(String start){
		this.start=start;
	}
	
	public String getStart(){
		return this.start;
	}
	
	//leave的getter和setter方法
	public void setLeave(String leave){
		this.leave=leave;
	}
	
	public String getLeave(){
		return this.leave;
	}
	
	//user的getter和setter方法
	public void setCustomer(Customer customer){
		this.customer=customer;
	}
	
	public Customer getCustomer(){
		return this.customer;
	}
	
	//roomId的getter和setter方法
	public void setRoomId(int roomId){
		this.roomId=roomId;
	}
	
	public int getRoomId(){
		return this.roomId;
	}
	
	//saveService的getter和setter方法
	public void setSaveService(SaveService saveService){
		this.saveService=saveService;
	}
	
	public SaveService getSaveService(){
		return this.saveService;
	}
	
	//getService的getter和setter方法
	public void setGetService(GetService getService){
		this.getService=getService;
	}
	
	public GetService getGetService(){
		return this.getService;
	}
	
	//sortService的getter和setter方法
	public void setSortService(SortService sortService){
		this.sortService=sortService;
	}
	
	public SortService getSortService(){
		return this.sortService;
	}
	
	//InputStream的getter方法
	public InputStream getResult(){
		return this.inputStream;
	}
	
	//Action执行方法：查找可预约房间
	public String execute()
		throws Exception{
		ActionContext ctx=ActionContext.getContext();
		if(start!=null){
			//获取可预约客房
			List<Room> rooms=sortService.bookSort(start,leave);
			ctx.put("rooms",rooms);
			//保存用户预约日期
			ctx.put("book_start",start);
			ctx.put("book_leave",leave);
		}
		return "book";
	}
	
	//预约表单的提交
	public String regist()
		throws Exception{
		ActionContext ctx=ActionContext.getContext();
		//保存客户信息
		saveService.saveCustomer(customer);
		
		//保存预约记录
		Room room=getService.getRoomByNum(roomId);
		DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
		Customer c=getService.getCustomer(customer.getIc());
		Book book=new Book(room.getId(),c.getId(),df.parse(start),df.parse(leave));
		saveService.saveBook(book);
		
		//获取所有客户
		List<Customer> customers=getService.getAllCustomers();
		ctx.getSession().put("customers",customers);
		ctx.put("tip","预约成功！");
		
		return "book";
	}
}