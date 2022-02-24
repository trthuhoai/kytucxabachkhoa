package model.dao.student;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import model.bean.ElectricityWaterCharge;
import model.dao.Connect;

public class ElectricityWaterChargeDao {
	public ElectricityWaterCharge getRentalFeeInfo(String iDPhong, String thoiGian) {
		ElectricityWaterCharge electricityWaterCharge=new ElectricityWaterCharge();
		try {
			Connect cnConnect=new Connect();
			Connection conn1 = cnConnect.getConn();
			Statement stmt = conn1.createStatement();
			String queryString = "select * from tiendiennuoc where IDPhong=\'" + iDPhong + "\'and ThoiGian='"+thoiGian+"'";
			ResultSet rs = stmt.executeQuery(queryString);
			if (rs.next()) {
				electricityWaterCharge.setiDPhiDienNuoc(rs.getString("IDPhiDienNuoc"));
				electricityWaterCharge.setThoiGian(rs.getString("ThoiGian"));
				electricityWaterCharge.setiDPhong(rs.getString("IDPhong"));
				electricityWaterCharge.setTongTien(rs.getInt("TongTien"));
				electricityWaterCharge.setTrangThai(rs.getString("TrangThai"));
				electricityWaterCharge.setNguoiNop(rs.getString("NguoiNop"));
				electricityWaterCharge.setHinhThucNop(rs.getString("HinhThucNop"));
				electricityWaterCharge.setThoiHan(rs.getString("ThoiHan"));
				
			}
			// close connection
			conn1.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return electricityWaterCharge;
	}
	public void updateElectricityWaterCharge(ElectricityWaterCharge electricityWaterCharge) {
		try {
			Connect cnConnect=new Connect();
			Connection conn1 = cnConnect.getConn();
			Statement stmt = conn1.createStatement();
			String queryString = "update tiendiennuoc set HinhThucNop='"+electricityWaterCharge.getHinhThucNop()+"',NguoiNop='"+electricityWaterCharge.getNguoiNop()+"'where IDPhong='"+electricityWaterCharge.getiDPhong()+"'";		
			stmt.executeUpdate(queryString);
			// show data
			// close connection
			conn1.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
}
