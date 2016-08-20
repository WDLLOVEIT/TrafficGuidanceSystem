package pack.dao;

import pack.entity.Map;

public interface MapDao {
	Map get(Integer mapId);
	Integer save(Map map);
	void delete(Integer mapId);
}
