package pack.beans;

import java.util.*;

public class Report{
     private int id;    
     private Date date;
     private int ordersum;
     private int checkin;
     private int income;
     
     public Report(){}
     
     public Report(Date date){
    	 this.date=date;
    	 this.ordersum=0;
    	 this.checkin=0;
    	 this.income=0;
     }
     
     public void setId(int id){
          this.id=id;
     }
     public int getId(){
          return id;
     }

     public void setDate(Date date){
          this.date=date;
     }
     public Date getDate(){
          return date;
     }
     
     public void setOrdersum(int ordersum){
         this.ordersum=ordersum;
     }

     public int getOrdersum(){
         	return ordersum;
     }  
    
     public void setCheckin(int checkin){
    	 this.checkin=checkin;
     }

     public int getCheckin(){
    	 return checkin;
     }
  
     public void setIncome(int income){
    	 this.income=income;
     }

     public int getIncome(){
    	 return income;
     }
}