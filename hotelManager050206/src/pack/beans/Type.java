package pack.beans;

import java.io.*;

public class Type
	implements Serializable{
     private int id;    //房间类型号
     private String name;   //房间类型名
     private int price;		//房间价格
     
     public void setId(int id){
          this.id=id;         
     }
     
     public int getId(){
          return id;
     }
     
     public void setName(String name){
          this.name=name;
     }

     public String getName(){
          return name;     
     }
     
     public void setPrice(int price){
         this.price=price;
     }

     public int getPrice(){
         return price;
     }     
}