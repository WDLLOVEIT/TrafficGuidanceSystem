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

//报表的控制器Action
public class CheckOutAction 
	extends ActionSupport{
	private GetService getService;		//获取Service
	
	//getService的getter和setter方法
	public void setGetService(GetService getService){
		this.getService=getService;
	}
	
	public GetService getGetService(){
		return this.getService;
	}
	
	//Action执行方法：查找可预约房间
	public String execute()
		throws Exception{
		ActionContext ctx=ActionContext.getContext();
		
		//获取未退房的入住记录
		List<Io> ios=getService.getCurrentIos();
		ctx.put("ios",ios);
		
		return "checkOut";
	}
}