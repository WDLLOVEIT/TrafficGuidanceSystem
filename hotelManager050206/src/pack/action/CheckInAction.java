package pack.action;

import java.util.Date;
import java.util.List;
import java.text.*;

import pack.beans.*;
import pack.service.*;

import java.util.*;
import java.io.*;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ActionContext;

//用户登录的控制器Action
public class CheckInAction 
	extends ActionSupport{	
	private int last=0;					//入住持续时间
	private String intime;				//入住时间
	private int roomId;					//房间id
	private Customer customer;			//客户类
	private GetService getService;		//获取Service
	private SaveService saveService;	//保存Service
	private SortService sortService;	//筛选Service
	
	//last的getter和setter方法
	public void setLast(int last){
		this.last=last;
	}
	
	public int getLast(){
		return this.last;
	}
	
	//last的getter和setter方法
	public void setIntime(String intime){
		this.intime=intime;
	}
	
	public String getIntime(){
		return this.intime;
	}
	
	//roomId的getter和setter方法
	public void setRoomId(int roomId){
		this.roomId=roomId;
	}
	
	public int getRoomId(){
		return this.roomId;
	}
	
	//customer的getter和setter方法
	public void setCustomer(Customer customer){
		this.customer=customer;
	}
	
	public Customer getCustomer(){
		return this.customer;
	}
	
	//sortService的getter和setter方法
	public void setSortService(SortService sortService){
		this.sortService=sortService;
	}
	
	public SortService getSortService(){
		return this.sortService;
	}
	
	//getService的getter和setter方法
	public void setGetService(GetService getService){
		this.getService=getService;
	}
	
	public GetService getGetService(){
		return this.getService;
	}
	
	//saveService的getter和setter方法
	public void setSaveService(SaveService saveService){
		this.saveService=saveService;
	}
	
	public SaveService getSaveService(){
		return this.saveService;
	}
	
	//Action执行方法：直接入住
	public String execute()
		throws Exception{
		if(last!=0){
			ActionContext ctx=ActionContext.getContext();
			//获取可预约客房
			DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
			Date start=new Date();
			List<Room> rooms=sortService.checkInSort(df.format(start),last);
			ctx.put("rooms",rooms);
			//保存用户预约日期
			ctx.put("checkIn_last",last);
		}
		return "checkIn";
	}
	
	//入住表单的提交
	public String registCheckIn()
		throws Exception{
		ActionContext ctx=ActionContext.getContext();
		//保存客户信息
		saveService.saveCustomer(customer);
		
		//保存预约记录
		Room room=getService.getRoomByNum(roomId);
		DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
		Customer c=getService.getCustomer(customer.getIc());
		Io io=new Io(c.getId(),room.getId(),df.parse(intime),last);
		saveService.saveIo(io);
		
		//获取所有客户
		List<Customer> customers=getService.getAllCustomers();
		ctx.getSession().put("customers",customers);
		
		ctx.put("tip","入住成功！");
		
		return "checkIn";
	}
	
	//Action执行方法
	public String bookIn()
		throws Exception{
		ActionContext ctx=ActionContext.getContext();
		List<Book> books=getService.getCrudeBooks();
		ctx.put("books",books);
		return "bookIn";
	}
}