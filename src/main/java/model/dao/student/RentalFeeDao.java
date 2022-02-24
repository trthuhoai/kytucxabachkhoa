package model.dao.student;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import model.bean.RentalFee;
import model.dao.Connect;

public class RentalFeeDao {
	public RentalFee getRentalFeeInfo(String maSo, String hocKy) {
		RentalFee rentalFee=new RentalFee();
		try {
			Connect cnConnect=new Connect();
			Connection conn1 = cnConnect.getConn();
			Statement stmt = conn1.createStatement();
			String queryString = "select * from phithuephong where MaSV=\'" + maSo + "\'and HocKy='"+hocKy+"'";
			ResultSet rs = stmt.executeQuery(queryString);
			// show data
			if (rs.next()) {
				
				rentalFee.setMaSV(maSo);
				rentalFee.setHocKy(hocKy);
				rentalFee.setPhiMoiThang(rs.getInt("Phi1Thang"));
				rentalFee.setTongPhi(rs.getInt("TongPhi"));
				rentalFee.setThoiHan(rs.getString("ThoiHan"));
				rentalFee.setTrangThai(rs.getString("TrangThai"));
				rentalFee.setHinhThucNop(rs.getString("HinhThucNop"));
				
			}
			// close connection
			conn1.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return rentalFee;

	}
	public void updateRentalFeeInfo(RentalFee rentalFee) {
		try {
			Connect cnConnect=new Connect();
			Connection conn1 = cnConnect.getConn();
			Statement stmt = conn1.createStatement();
			String queryString = "update phithuephong set HinhThucNop='"+rentalFee.getHinhThucNop()+"' where MaSV='"+rentalFee.getMaSV()+"' and HocKy='"+rentalFee.getHocKy()+"'";		
			stmt.executeUpdate(queryString);
			// show data
			// close connection
			conn1.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
}
