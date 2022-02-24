package model.bo.student;

import model.bean.RegisterChangeRoom;
import model.dao.student.RegisterChangeRoomDao;

public class RegisterChangeRoomBO {
	RegisterChangeRoomDao registerChangeRoomDao=new RegisterChangeRoomDao();
	public void AddRegisterChangeRoom(RegisterChangeRoom registerChangeRoom) {
		registerChangeRoomDao.AddRegisterChangeRoom(registerChangeRoom);
	}
}
