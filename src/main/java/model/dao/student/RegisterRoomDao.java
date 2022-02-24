package model.dao.student;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import model.bean.RegisterRoom;
import model.dao.Connect;

public class RegisterRoomDao {
	public ArrayList<RegisterRoom> searchRoomList(String khu, String phong) {
		ArrayList<RegisterRoom> result = new ArrayList<RegisterRoom>();
		try {
			Connect cnConnect=new Connect();
			Connection conn1 = cnConnect.getConn();
			Connection conn2 = cnConnect.getConn();
			Statement stmt = conn1.createStatement();
			Statement stmt1 = conn2.createStatement();
			String queryString = "";
			if(phong=="") {
				queryString = "select * from phong where Nha='"+khu+"'";
			} else if(khu==""){
				queryString = "select * from phong where Phong='"+phong+"'";
			}else {
				queryString = "select * from phong where Nha='"+khu+"' and Phong='"+phong+"'";
			}
			
			ResultSet rs = stmt.executeQuery(queryString);
			while (rs.next()) {
				RegisterRoom registerRoom = new RegisterRoom();
				registerRoom.setiDPhong(rs.getString("IDPhong"));
				registerRoom.setNha(rs.getString("Nha"));
				registerRoom.setPhong(rs.getString("Phong"));
				registerRoom.setsLuongSVChoPhep(rs.getString("SLuongSVChoPhep"));
				registerRoom.setGiaMoiThang(String.valueOf(rs.getInt("GiaMoiThang"))+".000");
				registerRoom.setGioiTinh(rs.getString("Nam"));
				registerRoom.setTongPhi(String.valueOf((rs.getInt("GiaMoiThang"))*5)+".000");
				String query= "Select COUNT(*) AS total from dangkyphong where IDPhong='"+registerRoom.getiDPhong()+"'";
				ResultSet rs1 = stmt1.executeQuery(query);
				while (rs1.next())
				{
					registerRoom.setsLuongDK(String.valueOf(rs1.getInt("total"))+"/"+rs.getString("SLuongSVChoPhep"));
				}
				result.add(registerRoom);

			}
			conn2.close();
			conn1.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}
	public ArrayList<RegisterRoom> getRoomList() {
		ArrayList<RegisterRoom> result = new ArrayList<RegisterRoom>();
		try {
			Connect cnConnect=new Connect();
			Connection conn1 = cnConnect.getConn();
			Connection conn2 = cnConnect.getConn();
			Statement stmt = conn1.createStatement();
			Statement stmt1 = conn2.createStatement();
			String queryString = "select * from phong ";
			ResultSet rs = stmt.executeQuery(queryString);
			while (rs.next()) {
				RegisterRoom registerRoom = new RegisterRoom();
				registerRoom.setiDPhong(rs.getString("IDPhong"));
				registerRoom.setNha(rs.getString("Nha"));
				registerRoom.setPhong(rs.getString("Phong"));
				registerRoom.setsLuongSVChoPhep(rs.getString("SLuongSVChoPhep"));
				registerRoom.setGiaMoiThang(String.valueOf(rs.getInt("GiaMoiThang"))+".000");
				registerRoom.setGioiTinh(rs.getString("Nam"));
				registerRoom.setTongPhi(String.valueOf((rs.getInt("GiaMoiThang"))*5)+".000");
				String query= "Select COUNT(*) AS total from dangkyphong where IDPhong='"+registerRoom.getiDPhong()+"'";
				ResultSet rs1 = stmt1.executeQuery(query);
				while (rs1.next())
				{
					registerRoom.setsLuongDK(String.valueOf(rs1.getInt("total"))+"/"+rs.getString("SLuongSVChoPhep"));
				}
				result.add(registerRoom);

			}
			conn2.close();
			conn1.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return result;

	}
	public void AddRegisterRoom(RegisterRoom registerRoom) {
		try {
			Connect cnConnect=new Connect();
			Connection conn1 = cnConnect.getConn();
			Statement stmt = conn1.createStatement();
			String query="select * from dangkyphong where MaSV='"+registerRoom.getMsv()+"' and HocKy='"+registerRoom.getHocKy()+"'";
			ResultSet rs = stmt.executeQuery(query);
			if(rs.next()) {
				query = "update dangkyphong set IDPhong='"+registerRoom.getiDPhong()+"', ThoiGianDK='"+registerRoom.getThoiGianDK()+"', ChapNhan='"+0+"' where MaSV='"+rs.getString("MaSV")+"' and HocKy='"+rs.getString("HocKy")+"'";		
			}
			else {
				query = "insert into dangkyphong (MaSV,IDPhong,HocKy,ThoiGianDK,ChapNhan) values ('"+registerRoom.getMsv()+"','"+registerRoom.getiDPhong()+"','"+registerRoom.getHocKy()+"','"+registerRoom.getThoiGianDK()+"','"+0+"')";		
			}
			stmt.executeUpdate(query);
		
			// close connection
			conn1.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
