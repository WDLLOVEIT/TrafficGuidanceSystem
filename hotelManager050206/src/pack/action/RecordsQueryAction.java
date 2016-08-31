package pack.action;

import pack.beans.*;
import pack.service.*;

import java.util.*;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ActionContext;

//记录查询Action
public class RecordsQueryAction 
	extends ActionSupport{
	private int state;					//设置查询内容
	private int condition=0;			//设置查询标准
	private String value;				//设置具体查询条件
	private GetService getService;		//获取数据库Service
	
	//state的getter和setter方法
	public void setState(int state){
		this.state=state;
	}
	
	public int getState(){
		return this.state;
	}
	
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
		//state=0:获取预约记录
		if(state==0){
			List<Book> books=new ArrayList<Book>();
			if(condition==0){
				books=getService.getAllBooks();
			}else{
				//预约号查找
				if(condition==1){
					books.add(getService.getBook(Integer.parseInt(value)));
				}//客户姓名查找
				else if(condition==2){
					books=getService.getBooksByName(value);
				}//客户身份证查找
				else if(condition==3){
					books=getService.getBooksByIc(value);
				}//客户手机号查找
				else if(condition==4){
					books=getService.getBooksByPhone(value);
				}//预约时间查找
				else if(condition==5){
					books=getService.getBooksByTime(value);
				}//预约入住时间查找
				else if(condition==6){
					books=getService.getBooksByStart(value);
				}//预约退房时间查找
				else if(condition==7){
					books=getService.getBooksByLeave(value);
				}
				//房间id查找
				else if(condition==8){
					books=getService.getBooksByRoomNum(Integer.parseInt(value));
				}
			}
			ctx.put("books",books);
			return "bookRecords";
		}//state=1:获取入住记录
		else{
			//获取所有入住记录
			List<Io> ios=getService.getAllIos();
			ctx.put("ios",ios);
			
			return "ioRecords";
		}
	}
}