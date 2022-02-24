package model.bo.student;

import java.util.ArrayList;

import model.bean.RegisterRoom;
import model.dao.student.RegisterRoomDao;

public class RegisterRoomBO {
	RegisterRoomDao registerRoomDao=new RegisterRoomDao();
	public ArrayList<RegisterRoom> getRoomList() {
	return	registerRoomDao.getRoomList();
	}
	public void AddRegisterRoom(RegisterRoom registerRoom) {
		registerRoomDao.AddRegisterRoom(registerRoom);
	}
	public ArrayList<RegisterRoom> searchRoomList(String khu, String phong) {
		return registerRoomDao.searchRoomList(khu, phong);
	}
}
