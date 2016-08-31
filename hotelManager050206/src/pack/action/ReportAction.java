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
public class ReportAction 
	extends ActionSupport{
	private int state;					//报表类型选项
	private GetService getService;		//获取数据Service
	private SaveService saveService;	//保存数据Service
	
	//state的getter和setter方法
	public void setState(int state){
		this.state=state;
	}
	
	public int getState(){
		return this.state;
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
	
	//Action执行方法：查找可预约房间
	public String execute()
		throws Exception{
		ActionContext ctx=ActionContext.getContext();
		
		List<Report> reports=new ArrayList<Report>();
		//今日报表
		if(state==0){
			Report report=getService.getTodayReport();
			if(report==null){
				report=new Report(new Date());
				saveService.saveReport(report);
			}
			report=getService.getTodayReport();
			reports.add(report);
		}
		ctx.put("reports",reports);
		
		return "report";
	}
}