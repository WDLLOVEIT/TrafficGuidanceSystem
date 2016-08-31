package pack.service;

import java.util.List;

import pack.beans.Admin;

//答案逻辑处理接口
public interface LoginService {
	public boolean check(String userName,String password);
}