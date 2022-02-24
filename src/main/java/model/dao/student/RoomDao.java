package model.dao.student;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import model.bean.Room;
import model.bean.Student;
import model.dao.Connect;

public class RoomDao {
  public  Room getRoomInfo(String iDPhong) {
	  Room room=new Room();

		try {
			Connect cnConnect=new Connect();
			Connection conn1 = cnConnect.getConn();
			Statement stmt = conn1.createStatement();
			String queryString = "select * from phong where IDPhong=\'" + iDPhong + "\'";
			ResultSet rs = stmt.executeQuery(queryString);
			// show data
			if (rs.next()) {
				room.setiDPhong(iDPhong);
				room.setPhong(rs.getString("Phong"));
				room.setNha(rs.getString("Nha"));
				room.setsLuongSVChoPhep(rs.getString("SLuongSVChoPhep"));
				room.setsLuongSVDangLuuTru(rs.getString("SLuongSVDangLuuTru"));
				room.setGiaMoiThang(rs.getString("GiaMoiThang"));
				room.setNam(rs.getString("Nam"));
				

			}
			// close connection
			conn1.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return room;
  }
}
