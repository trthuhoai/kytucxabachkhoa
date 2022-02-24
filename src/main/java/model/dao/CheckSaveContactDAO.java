package model.dao;
import model.bean.Contact;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CheckSaveContactDAO {
	public boolean saveSuccess(Contact contact)
	{
		try {
			Connect cnConnect=new Connect();
			Connection conn = cnConnect.getConn();
			String query = "INSERT INTO contact(hoten,masv,phone,content)"
					+ "VALUES(?,?,?,?) ";
			PreparedStatement preparedSttm = conn.prepareStatement(query);
			preparedSttm.setString(1, contact.getHoten());
			preparedSttm.setString(2, contact.getMaSV());
			preparedSttm.setString(3, contact.getSDT());
			preparedSttm.setString(4, contact.getContent());
			
			boolean result = preparedSttm.executeUpdate()>0;
			if(result)
			{
				return true;
			}
			else 
			{
				return false;
			}
				
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return false;
		
	}

}
