package pack.action;

import java.io.*;

import pack.beans.Customer;
import pack.service.GetService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ActionContext;

//自动填写表单Action
public class AutoCompleteAction 
	extends ActionSupport{
	private String ic;		//身份证号
	private GetService getService;	//获取数据的Service
	private InputStream inputStream;//封装输出结果的二进制流
	
	//id的setter和getter方法
	public void setIc(String ic){
		this.ic=ic;
	}
	
	public String getIc(){
		return this.ic;
	}
	
	//getService的getter和setter方法
	public void setGetService(GetService getService){
		this.getService=getService;
	}
	
	public GetService getGetService(){
		return this.getService;
	}
	
	//InputStream的getter方法
	public InputStream getResult(){
		return this.inputStream;
	}
	
	//action的执行方法
	public String execute()
		throws Exception{
		Customer customer=getService.getCustomer(ic);
		String s="";
		if(customer!=null){
			s+=customer.getName()+"@";
			s+=customer.getPhone()+"@";
			s+=customer.getSex();
		}
		inputStream=(customer==null)?
				new ByteArrayInputStream(" ".getBytes("UTF-8")):
				new ByteArrayInputStream(s.getBytes("UTF-8"));
				
		return "complete";
	}
}
