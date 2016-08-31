package pack.beans;

import java.util.*;

public class Book{
   private int id;
   private int roomId;
   private int customerId;
   private Date start;
   private Date time;
   private Date leave;
   private int flag;
   
   //Book类的构造方法
   public Book(){}
   
   public Book(int roomId,int customerId,Date start,Date leave){
	   this.roomId=roomId;
	   this.customerId=customerId;
	   this.start=start;
	   this.time=new Date();
	   this.leave=leave;
	   this.flag=0;
   }
   
   //id的getter和setter方法
   public int getId(){
        return id;
   }
   public void setId(int id){
        this.id=id;
   }
   public int getRoomId(){
        return roomId;
   }
   public void setRoomId(int roomId){
        this.roomId=roomId;
   }
   public int getCustomerId(){
        return customerId;
   }
   public void setCustomerId(int customerId){
        this.customerId=customerId;
   }
   public Date getStart(){
        return start;
   }
   public void setStart(Date start){
        this.start=start;
   }
   public Date getTime(){
        return time;
   }
   public void setTime(Date time){
        this.time=time;
   }
   public Date getLeave(){
        return leave;
   }
   public void setLeave(Date leave){
        this.leave=leave;
   }
   public int getFlag(){
        return flag;
   }
   public void setFlag(int flag){
        this.flag=flag;
   }
} 
