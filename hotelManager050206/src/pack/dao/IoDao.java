package pack.dao;

import pack.beans.Io;
import java.util.*;

public interface IoDao {
	//根据id获取入住记录
	Io get(int id);
	
	//获取现有入住记录
	List<Io> getCurrentIos();
	
	//获取所有入住记录
	List<Io> getAllIos();
	
	//根据入住id获取未退房的记录
	Io getCurrentIoById(int id);
	
	//根据客户身份证获取未退房的记录
	Io getCurrentIoByCustomerId(int id);
	
	//保存入住记录
	void saveOrUpdate(Io io);
}
