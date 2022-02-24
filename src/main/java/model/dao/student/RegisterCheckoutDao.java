package model.dao.student;

import java.sql.Connection;
import java.sql.Statement;

import model.bean.RegisterCheckout;
import model.dao.Connect;

public class RegisterCheckoutDao {
	public void AddRegisterCheckout(RegisterCheckout registerCheckout) {
		try {
			Connect cnConnect=new Connect();
			Connection conn1 = cnConnect.getConn();
			Statement stmt = conn1.createStatement();
			String query = "insert into dangkytraphong (MaSV,IDPhong,ThoiGianDK,NgayTraPhong, LyDoTraPhong) values ('"+registerCheckout.getMaSV()+"','"+registerCheckout.getiDPhong()+"','"+registerCheckout.getThoiGianDK()+"','"+registerCheckout.getNgayTraPhong()+"','"+registerCheckout.getLyDoTraPhong()+"')";		
			stmt.executeUpdate(query);
			conn1.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
