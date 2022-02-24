package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class CheckLoginAdminDAO {

	public boolean isExistUser(String userName, String password) {
		try {
			Connect cnConnect=new Connect();
			Connection conn = cnConnect.getConn();
			Statement stmt = conn.createStatement();
			String queryString = "select * from admin where MaAdmin=\'" + userName + "\'and MatKhau=\'" + password + "\'";
			ResultSet rs = stmt.executeQuery(queryString);
			if (rs.next()) {
				conn.close();
				return true;
			} else {
				conn.close();
				return false;
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

}


