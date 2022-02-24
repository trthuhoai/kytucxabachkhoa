package model.dao.student;

import java.sql.Connection;
import java.sql.Statement;

import model.bean.RegisterChangeRoom;
import model.dao.Connect;

public class RegisterChangeRoomDao {
	public void AddRegisterChangeRoom(RegisterChangeRoom registerChangeRoom) {
		try {
			Connect cnConnect=new Connect();
			Connection conn1 = cnConnect.getConn();
			Statement stmt = conn1.createStatement();
			String query = "insert into dangkychuyenphong (MaSV,IDPhong,HocKy,LyDoChuyen,ThoiGianDK,ChapNhan, NgayChuyen) values ('"+registerChangeRoom.getMaSV()+"','"+registerChangeRoom.getiDPhong()+"','"+registerChangeRoom.getHocKy()+"','"+registerChangeRoom.getLyDoChuyen()+"','"+registerChangeRoom.getThoiGianDK()+"','"+0+"','"+registerChangeRoom.getNgayChuyen()+"')";		
			stmt.executeUpdate(query);
		
			// close connection
			conn1.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
