package model.dao.student;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import model.bean.Student;
import model.dao.Connect;

public class PersonalInformationDao {
	public Student getPersonalInfo(String maSo) {
		Student student = new Student();
		DateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		try {
			Connect cnConnect=new Connect();
			Connection conn1 = cnConnect.getConn();
			Statement stmt = conn1.createStatement();
			String queryString = "select * from sinhvien where MaSV=\'" + maSo + "\'";
			ResultSet rs = stmt.executeQuery(queryString);
			// show data
			if (rs.next()) {
				
				student.setMaSV(rs.getString("MaSV"));
				student.setTenSV(rs.getString("TenSV"));
				student.setMatKhau(rs.getString("MatKhau"));
				student.setGioiTinh(rs.getString("GioiTinh"));
				student.setNgaySinh(simpleDateFormat.format(rs.getDate("NgaySinh")));
				student.setLop(rs.getString("Lop"));
				student.setNganh(rs.getString("Nganh"));
				student.setSoCCCD(rs.getString("SoCCCD"));
				student.setDiaChi(rs.getString("DiaChi"));
				student.setSDT(rs.getString("SDT"));
				student.setSoTaiKhoan(rs.getString("SoTaiKhoan"));
				student.setNganHang(rs.getString("NganHang"));
				student.setTenCha(rs.getString("TenCha"));
			    student.setNgaySinhCha(rs.getString("NgaySinhCha"));
				student.setTenMe(rs.getString("TenMe"));
				student.setNgaySinhMe(rs.getString("NgaySinhMe"));
				student.setTenNguoiBaoTin(rs.getString("TenNguoiBaoTin"));
				student.setQuanHeNguoiBaoTin(rs.getString("QuanHeNguoiBaoTin"));
				student.setSDTNguoiBaoTin(rs.getString("SDTNguoiBaoTin"));
				student.setThanhPho_TinhNBT(rs.getString("ThanhPho_TinhNBT"));
				student.setQuan_HuyenNBT(rs.getString("Quan_HuyenNBT"));
				student.setDiaChiNguoiBaoTin(rs.getString("DiaChiNguoiBaoTin"));
				student.setEmail(rs.getString("Email"));
				student.setIDPhong(rs.getString("IDPhong"));

			}
			// close connection
			conn1.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return student;

	}
	public void updatePersonalInfo(String maSo, Student student) {
		try {
			Connect cnConnect=new Connect();
			Connection conn1 = cnConnect.getConn();
			Statement stmt = conn1.createStatement();
			String queryString = "update sinhvien set Email='"+student.getEmail()+"', SDT='"+student.getSDT()+"', SoTaiKhoan='"+student.getSoTaiKhoan()+"', NganHang='"+student.getNganHang()+"', TenCha='"+student.getTenCha()+"', NgaySinhCha='"+student.getNgaySinhCha()+"', NgaySinhMe='"+student.getNgaySinhMe()+"', TenMe='"+student.getTenMe()+"', TenNguoiBaoTin='"+student.getTenNguoiBaoTin()+"', QuanHeNguoiBaoTin='"+student.getQuanHeNguoiBaoTin()+"', ThanhPho_TinhNBT='"+student.getThanhPho_TinhNBT()+"', Quan_HuyenNBT='"+student.getQuan_HuyenNBT()+"', SDTNguoiBaoTin='"+student.getSDTNguoiBaoTin()+"', DiaChiNguoiBaoTin='"+student.getDiaChiNguoiBaoTin()+"' where MaSV='"+maSo+"'";
			stmt.executeUpdate(queryString);
			// close connection
			conn1.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	public void changePassword(String maSo, String mk) {
		try {
			Connect cnConnect=new Connect();
			Connection conn1 = cnConnect.getConn();
			Statement stmt = conn1.createStatement();
			String queryString = "update sinhvien set MatKhau='"+mk+"' where MaSV='"+maSo+"'";		
			stmt.executeUpdate(queryString);
		
			// close connection
			conn1.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
