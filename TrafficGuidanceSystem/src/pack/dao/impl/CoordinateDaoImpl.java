package pack.dao.impl;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import pack.dao.CoordinateDao;
import pack.entity.Coordinate;


public class CoordinateDaoImpl extends HibernateDaoSupport implements CoordinateDao {

	@Override
	public Coordinate get(Integer coordinateId) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().get(Coordinate.class, coordinateId);
	}

	@Override
	public Integer save(Coordinate coordinate) {
		// TODO Auto-generated method stub
		return (Integer)getHibernateTemplate().save(coordinate);
	}

	@Override
	public void delete(Integer coordinateId) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(get(coordinateId));
	}

}
