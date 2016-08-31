package pack.dao.impl;

import pack.beans.*;
import pack.dao.ReportDao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

public class ReportDaoImpl 
	extends HibernateDaoSupport implements ReportDao{
	//保存今日统计报表
	public void saveOrUpdate(Report report){
		int id=report.getId();
		Report r=get(id);
		if(r==null){
			getHibernateTemplate().save(report);
		}else{
			getHibernateTemplate().merge(report);
		}
	}
	//根据id获取统计报表
	public Report get(int id){
		return getHibernateTemplate()
				.get(Report.class,id);
	}
	
	//根据日期得到统计报表
	public Report getByDate(Date date){
		Calendar cal_1=Calendar.getInstance();
		cal_1.setTime(date);
		
		Calendar cal_2=Calendar.getInstance();
		cal_2.clear();
		cal_2.set(cal_1.get(Calendar.YEAR), cal_1.get(Calendar.MONTH), cal_1.get(Calendar.DAY_OF_MONTH));
		
		cal_1.setTime(cal_2.getTime());
		cal_1.add(Calendar.DAY_OF_MONTH, 1);
		
		
		List<Report> reports=(List<Report>)getHibernateTemplate()
				.find("from Report where date >=? and date<?",cal_2.getTime(),cal_1.getTime());
		if(reports.size()==0){
			return null;
		}else{
			return reports.get(0);
		}
	}
}
