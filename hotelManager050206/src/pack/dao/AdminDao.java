package pack.dao;

import pack.beans.Admin;

//管理员DAO接口
public interface AdminDao {
	//根据adminId得到管理员类
	Admin get(String userName);
}
