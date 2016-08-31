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

public class IoQueryAction 
	extends ActionSupport{
	private int condition;		//��ѯ����
	private String value;			//��ѯ����
	private GetService getService;	//��ȡ����Service
	
	//condition��getter��setter����
	public void setCondition(int condition){
		this.condition=condition;
	}
	
	public int getCondition(){
		return this.condition;
	}
	
	//value��getter��setter����
	public void setValue(String value){
		this.value=value;
	}
	
	public String getValue(){
		return this.value;
	}
	
	//getService��getter��setter����
	public void setGetService(GetService getService){
		this.getService=getService;
	}
	
	public GetService getGetService(){
		return this.getService;
	}
	
	//Action��ִ�з���
	public String execute()
		throws Exception{
		ActionContext ctx=ActionContext.getContext();
		
		List<Io> ios=new ArrayList<Io>();
		//����ԤԼ�Ż�ȡԤԼ��¼
		if(condition==1){
			Io io=getService.getCurrentIoById(Integer.parseInt(value));
			if(io!=null){
				ios.add(io);
			}
		}//���ݿͻ�����֤�Ż�ȡԤԼ��¼
		else if(condition==2){
			Io io=getService.getCurrentIoByIc(value);
			if(io!=null){
				ios.add(io);
			}
		}
		ctx.put("ios",ios);
		
		return "checkOut";
	}
}