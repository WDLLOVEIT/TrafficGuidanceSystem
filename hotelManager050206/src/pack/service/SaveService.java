package pack.service;

import pack.dao.*;
import pack.beans.*;

//保存记录的业务逻辑的接口
public interface SaveService {
	//保存客户信息
	void saveCustomer(Customer customer);
	
	//保存预约记录
	void saveBook(Book book);
	
	//保存预约记录
	void saveReport(Report report);
	
	//保存出入记录
	void saveIo(Io io);
}
