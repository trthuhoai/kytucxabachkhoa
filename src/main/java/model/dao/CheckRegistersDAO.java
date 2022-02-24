package model.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.bean.Student;
import java.sql.Date;


public class CheckRegistersDAO {
	public boolean isExitUser(Student student) {
		try {
			Connect cnConnect=new Connect();
			String mssv = student.getMaSV();
			Connection conn = cnConnect.getConn();
			Statement stmt = conn.createStatement();
			String queryString = "select * from sinhvien where MaSV=\'" + mssv + "\'";
			ResultSet rs = stmt.executeQuery(queryString);
			if (rs.next()) {
				return true;
			} else {
				creatNewUser(student);
				return false;
			}
				
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return true;
	}
	public void creatNewUser(Student student)
	{
		Connect cnConnect=new Connect();
		Connection conn = cnConnect.getConn();
		try {
			String query = "INSERT INTO dangkyluutru(MaSV,MatKhau,TenSV,GioiTinh,NgaySinh,Lop,Nganh,SoCCCD,Diachi,SDT,Email)"
						+ "VALUES(?,?,?,?,?,?,?,?,?,?,?) ";
			PreparedStatement preparedSttm = conn.prepareStatement(query);
			preparedSttm.setString(1, student.getMaSV());
			preparedSttm.setString(2, student.getMatKhau());
			preparedSttm.setString(3, student.getTenSV());
			preparedSttm.setString(4, student.getGioiTinh());
			preparedSttm.setString(5, student.getNgaySinh());
			preparedSttm.setString(6, student.getLop());
			preparedSttm.setString(7, student.getNganh());
			preparedSttm.setString(8, student.getSoCCCD());
			preparedSttm.setString(9, student.getDiaChi());
			preparedSttm.setString(10,student.getSDT());
			preparedSttm.setString(11,student.getEmail());
			System.out.print(preparedSttm);
			preparedSttm.executeUpdate();

		}
		catch(Exception e)
		{
			e.getMessage();
		}
	}

}
