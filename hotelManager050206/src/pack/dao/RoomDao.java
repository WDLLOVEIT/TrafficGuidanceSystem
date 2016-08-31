package pack.dao;

import pack.beans.Room;

import java.util.*;

//房间Room接口
public interface RoomDao {
	//根据RoomId得到房间类
	Room getById(int id);
	
	//根据RoomNum得到房间类
	Room getByNum(int num);
	
	//得到所有房间Room类
	List<Room> getAllRooms();
}
