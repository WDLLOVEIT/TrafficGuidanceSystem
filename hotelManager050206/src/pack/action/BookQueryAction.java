package pack.action;

import java.util.ArrayList;
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

public class BookQueryAction 
	extends ActionSupport{
	private int condition;		//查询条件
	private String value;			//查询内容
	private GetService getService;	//获取数据Service
	
	//condition的getter和setter方法
	public void setCondition(int condition){
		this.condition=condition;
	}
	
	public int getCondition(){
		return this.condition;
	}
	
	//value的getter和setter方法
	public void setValue(String value){
		this.value=value;
	}
	
	public String getValue(){
		return this.value;
	}
	
	//getService的getter和setter方法
	public void setGetService(GetService getService){
		this.getService=getService;
	}
	
	public GetService getGetService(){
		return this.getService;
	}
	
	//Action的执行方法
	public String execute()
		throws Exception{
		ActionContext ctx=ActionContext.getContext();
		
		List<Book> books=new ArrayList<Book>();
		//根据预约号获取预约记录
		if(condition==1){
			Book book=getService.getCrudeBook(Integer.parseInt(value));
			if(book!=null){
				books.add(book);
			}
		}else if(condition==2){
			books=getService.getCrudeBooksByIc(value);
		}
		ctx.put("books",books);
		
		return "bookIn";
	}
}
