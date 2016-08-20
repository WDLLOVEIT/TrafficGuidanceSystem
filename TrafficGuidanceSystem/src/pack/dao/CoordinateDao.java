package pack.dao;

import pack.entity.Coordinate;

public interface CoordinateDao {
	Coordinate get(Integer coordinateId);
	Integer save(Coordinate coordinate);
	void delete(Integer coordinateId);
}
