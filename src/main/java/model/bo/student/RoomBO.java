package model.bo.student;

import model.bean.Room;
import model.dao.student.RoomDao;

public class RoomBO {
	 public  Room getRoomInfo(String iDPhong) {
		 RoomDao roomDao=new RoomDao();
			return roomDao.getRoomInfo(iDPhong);
	 }
	
}
