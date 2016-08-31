package pack.beans;

import java.util.*;

public class Io{
     private int id;    
     private int customerId;
     private int roomId;
     private Date intime;
     private Date outtime;
     private int last; 
     private boolean state;
    
     public Io(){}
     
     public Io(int customerId,int roomId,Date intime,int last){
    	 this.customerId=customerId;
    	 this.roomId=roomId;
    	 this.intime=intime;
    	 this.outtime=null;
    	 this.last=last;
    	 this.state=false;
     }
     
     public void setId(int id){
          this.id=id;
     }

     public int getId(){
          return id;
     }

     public void setCustomerId(int customerId){
          this.customerId=customerId;
     }

     public int getCustomerId(){
          return customerId;
     }

     public void setRoomId(int roomId){
          this.roomId=roomId;
     }

     public int getRoomId(){
          return roomId;
     }

     public void setIntime(Date intime){
          this.intime=intime;
     }

     public Date getIntime(){
          return intime;
     }

     public void setOuttime(Date outtime){
          this.outtime=outtime;
     }

     public Date getOuttime(){
          return outtime;
     }
     
     public void setLast(int last){
          this.last=last;
     }

     public int getLast(){
          return last;
     }
 
     public void setState(boolean state){
          this.state=state;
     }

     public boolean isState(){
          return state;
     }
}

