package model.dao.student;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import model.bean.*;
import model.dao.Connect;

public class NotificationDao {
	public ArrayList<Notification> getNotificationList() {
		ArrayList<Notification> result = new ArrayList<Notification>();
		DateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		try {
			Connect cnConnect=new Connect();
			Connection conn1 = cnConnect.getConn();
			Statement stmt = conn1.createStatement();
			String queryString = "select * from thongbao order by ngay DESC";
			ResultSet rs = stmt.executeQuery(queryString);
			while (rs.next()) {
				Notification notification = new Notification();
				notification.setiDThongBao(rs.getString("IDThongBao"));
				notification.setTieuDe(rs.getString("TieuDe"));
				notification.setNgay(simpleDateFormat.format(rs.getDate("Ngay")));
				notification.setNoiDung(rs.getString("NoiDung"));
			
				result.add(notification);

			}
			conn1.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return result;

	}
}
