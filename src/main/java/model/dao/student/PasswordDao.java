package model.dao.student;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import model.bean.Password;
import model.bean.Student;
import model.dao.Connect;

public class PasswordDao  {
	public Student getPersonalInfo(String maSo) {
		Student student = new Student();
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
				student.setNgaySinh(rs.getString("NgaySinh"));
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
	public boolean checkInfo(Password password) {
		try {
			Connect cnConnect=new Connect();
			Connection conn1 = cnConnect.getConn();
			Statement stmt = conn1.createStatement();
			String queryString = "select * from sinhvien where MaSV='" + password.getMssv() + "' and TenSV='"+password.getHoVaTen()+"'and Lop='"+password.getLop()+"' and Email='"+password.getEmail()+"'";
			ResultSet rs = stmt.executeQuery(queryString);
			if(rs.next()) {
				
				String idPhong=rs.getString("IDPhong");
				System.out.println("idPhong"+idPhong);
				String khuphongString=(String) password.getKhu()+(String) password.getPhong();
				System.out.println("khuphongString"+khuphongString);
				conn1.close();
				if(idPhong.equals(khuphongString)) {
					System.out.println("DDDD"+idPhong);
					return true;
				}else {
					return false;
				}
			}
			else {
			return false;	
			}
			// close connection
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}
	public void resetPassword(String maSo, String mk) {
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
