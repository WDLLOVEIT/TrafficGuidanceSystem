package pack.dao.impl;

import java.util.List;

import pack.beans.Room;
import pack.dao.RoomDao;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
//房间类Dao接口的实现类
public class RoomDaoImpl 
	extends HibernateDaoSupport implements RoomDao{
	//根据RoomId得到房间类
	public Room getById(int id){
		return getHibernateTemplate().get(Room.class,id);
	};
	
	//根据RoomNum得到房间类
	public Room getByNum(int num){
		List<Room> rooms=(List<Room>)getHibernateTemplate()
				.find("from Room where num=?", num);
		if(rooms.size()==0){
			return null;
		}else{
			return rooms.get(0);
		}
	};
		
	//得到所有房间Room类
	public List<Room> getAllRooms(){
		return (List<Room>)getHibernateTemplate()
				.find("from Room");
	};
}
