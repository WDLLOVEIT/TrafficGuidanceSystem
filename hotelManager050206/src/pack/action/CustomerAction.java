package pack.action;

import pack.beans.*;
import pack.service.*;

import java.util.*;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ActionContext;
//客户操作Action
public class CustomerAction 
	extends ActionSupport{
	private GetService getService;		//获取数据Service
	
	//GetService的getter和setter方法
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
		
		//获取客户信息
		List<Customer> customers=getService.getAllCustomers();
		ctx.put("customers",customers);
		
		return "customerInf";
	}
}
