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
public class IoOptionAction 
	extends ActionSupport{
	private int option;			//操作类型
	private int ioId;			//预约编号
	private int value;			//续住天数
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
	public void setIoId(int ioId){
		this.ioId=ioId;
	}
	
	public int getIoId(){
		return this.ioId;
	}
	
	//value的getter和setter方法
	public void setValue(int value){
		this.value=value;
	}
	
	public int getValue(){
		return this.value;
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
		Io io=getService.getCurrentIoById(ioId);
		//退房操作
		if(option==0){
			io.setState(true);
			io.setOuttime(new Date());
			
			saveService.saveIo(io);
		}//续住操作
		else{
			io.setLast(io.getLast()+value*24);
		}
		saveService.saveIo(io);
		ctx.put("tip","操作成功");
		//更新预约表
		List<Io> ios=getService.getCurrentIos();
		ctx.put("ios",ios);
		
		return "checkOut";
	}
}
