package pack.dao;

import pack.beans.Type;

import java.util.*;

//Type类的Dao接口
public interface TypeDao {
	//根据ID得到Type类
	Type get(int id);
	
	//获取所有Type类
	List<Type> getAllTypes();
}
