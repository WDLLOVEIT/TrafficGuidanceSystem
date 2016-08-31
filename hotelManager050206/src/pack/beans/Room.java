package pack.beans;

import java.io.*;

public class Room
	implements Serializable{
     private int id;
     private int num;
     private int typeId;
     private int state;
     private int floor;
     public void setId(int id){
          this.id=id;
     }

     public int getId(){
          return id;
     }   
     
     public void setNum(int num){
         this.num=num;
    }

    public int getNum(){
         return num;
    }     

     public void setTypeId(int typeId){
          this.typeId=typeId;
     }

     public int getTypeId(){
          return typeId;
     }       

     public void setState(int state){
          this.state=state;
     }

     public int getState(){
          return state;
     }  

    public void setFloor(int floor){
          this.floor=floor;
     }

     public int getFloor(){
          return floor;
     }            
}