package model.dao.student;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import model.bean.Chat;
import model.dao.Connect;

public class ChatDao {
	public ArrayList<Chat> getChatList(String iDTinNhan) {
		ArrayList<Chat> result = new ArrayList<Chat>();
		try {
			Connect cnConnect=new Connect();
			Connection conn1 = cnConnect.getConn();
			Connection conn2 = cnConnect.getConn();
			Statement stmt = conn1.createStatement();
			String queryString = "select * from chat where MaNV='"+iDTinNhan+"'";
			/* order by ThoiGian */
			ResultSet rs = stmt.executeQuery(queryString);
			while (rs.next()) {
				Chat chat=new Chat();
				chat.setiDTinNhan(rs.getString("IDTinNhan"));
				chat.setNguoiGui(rs.getString("NguoiGui"));
				chat.setNoiDung(rs.getString("NoiDung"));
				chat.setThoiGian(rs.getString("ThoiGian"));
				chat.setMaNV(rs.getString("MaNV"));
				chat.setMaSV(rs.getString("MaSV"));
				chat.setLenNoiDung(rs.getString("NoiDung").length());			
				result.add(chat);

			}
			conn2.close();
			conn1.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return result;

	}
	public void AddMessage(Chat chat) {
		try {
			Connect cnConnect=new Connect();
			Connection conn1 = cnConnect.getConn();
			Statement stmt = conn1.createStatement();
			String 	query = "insert into chat (IDTinNhan,NguoiGui,NoiDung,ThoiGian,MaSV,MaNV) values ('"+chat.getiDTinNhan()+"','"+chat.getNguoiGui()+"','"+chat.getNoiDung()+"','"+chat.getThoiGian()+"','"+chat.getMaSV()+"','"+chat.getMaNV()+"')";		
					
			
			
			stmt.executeUpdate(query);
		
			// close connection
			conn1.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
