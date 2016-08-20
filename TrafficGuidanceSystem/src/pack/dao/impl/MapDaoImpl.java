package pack.dao.impl;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import pack.dao.MapDao;
import pack.entity.Map;


public class MapDaoImpl extends HibernateDaoSupport implements MapDao {

	@Override
	public Map get(Integer mapId) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().get(Map.class, mapId);
	}

	@Override
	public Integer save(Map map) {
		// TODO Auto-generated method stub
		return (Integer)getHibernateTemplate().save(map);
	}

	@Override
	public void delete(Integer mapId) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(get(mapId));
	}

}
