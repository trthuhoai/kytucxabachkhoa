package model.dao.student;

import java.sql.Connection;
import java.sql.Statement;
import model.bean.SuggestedRepair;
import model.dao.Connect;

public class SuggestedRepairDao {
	public void AddSuggestedRepair(SuggestedRepair suggestedRepair) {
		try {
			Connect cnConnect=new Connect();
			Connection conn1 = cnConnect.getConn();
			Statement stmt = conn1.createStatement();
			String query = "insert into suachua (MaSV,IDPhong,NoiDung,DeXuat,GhiChu,ThoiGianDK, ChapNhan) values ('"+suggestedRepair.getMaSV()+"','"+suggestedRepair.getiDPhong()+"','"+suggestedRepair.getNoiDung()+"','"+suggestedRepair.getDeXuat()+"','"+suggestedRepair.getGhiChu()+"','"+suggestedRepair.getThoiGianDK()+"','"+suggestedRepair.getChapNhan()+"')";		
			stmt.executeUpdate(query);
			conn1.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
