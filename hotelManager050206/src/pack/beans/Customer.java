package pack.beans;

import java.io.*;

public class Customer
	implements Serializable{
	 private int id;		//客户id
     private String ic;     //客户身份证号
     private String name;   //客户姓名
     private String phone;  //客户电话
     private boolean sex;   //客户性别
     
     //Customer的构造方法
     public Customer(){}
     
     public Customer(String ic,String name,String phone,boolean sex){
    	 this.ic=ic;
    	 this.name=name;
    	 this.phone=phone;
    	 this.sex=sex;
     }
     
     public void setId(int id){
          this.id=id;
     }
  
     public int getId(){
          return id;
     }
     
     public void setIc(String ic){
    	 this.ic=ic;
     }
     
     public String getIc(){
    	 return this.ic;
     }

     public void setName(String name){
          this.name=name;
     }
  
     public String getName(){
          return name;
     }

     public void setPhone(String phone){
          this.phone=phone;
     }
  
     public String getPhone(){
          return phone;
     }

     public void setSex(boolean sex){
          this.sex=sex;
     }
  
     public boolean getSex(){
          return sex;
     }
}