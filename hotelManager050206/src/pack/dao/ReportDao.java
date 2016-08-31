package pack.dao;

import pack.beans.Report;

import java.util.*;

public interface ReportDao {
	//保存今日统计报表
	void saveOrUpdate(Report report);
	//根据日期得到统计报表
	Report getByDate(Date date);
	//根据id获取统计报表
	Report get(int id);
}
