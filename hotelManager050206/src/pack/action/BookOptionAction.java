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
public class BookOptionAction 
	extends ActionSupport{
	private int option;			//操作类型
	private int bookId;			//预约编号
	private GetService getService;		//获取数据Service
	private SaveService saveService;	//保存数据Service
	
	//option的getter和setter方法
	public void setOption(int option){
		this.option=option;
	}
	
	public int getOption(){
		return this.option;
	}
	
	//bookId的getter和setter方法
	public void setBookId(int bookId){
		this.bookId=bookId;
	}
	
	public int getBookId(){
		return this.bookId;
	}
	
	//saveService的getter和setter的方法
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
	
	public String execute()
		throws Exception{
		ActionContext ctx=ActionContext.getContext();
		Book book=getService.getBook(bookId);
		//入住操作
		if(option==0){
			book.setFlag(1);
			//插入入住记录
			int last=(int)(book.getLeave().getTime()-book.getStart().getTime())/3600000;
			Io io=new Io(book.getCustomerId(),book.getRoomId(),new Date(),
					last);
			saveService.saveIo(io);
		}//取消操作
		else{
			book.setFlag(2);
		}
		saveService.saveBook(book);
		ctx.put("tip","操作成功");
		//更新预约表
		List<Book> books=getService.getCrudeBooks();
		ctx.put("books",books);
		
		return "bookIn";
	}
}
