package model.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.PhiBD;
import model.bean.BGLT;
import model.bean.BGDB;
public class ShowBgDAO {
	public ArrayList<PhiBD> getPBD()
	{
		ArrayList<PhiBD> phibandau = new ArrayList<PhiBD>();
		try {
			Connect cnConnect=new Connect();
			Connection conn = cnConnect.getConn();
			Statement stmt = conn.createStatement();
			String queryString = "select * from phibandau";
			ResultSet rs = stmt.executeQuery(queryString);
			while(rs.next()) {
				System.out.println();
				String name = rs.getString(1);
				String cost=rs.getString(2);
				phibandau.add(new PhiBD(name, cost));
			} 
			System.out.println(phibandau);
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return phibandau;
	}
	
	public ArrayList<BGLT> getBGLT()
	{
		ArrayList<BGLT> bglt = new ArrayList<BGLT>();
		try {
			Connect cnConnect=new Connect();
			Connection conn = cnConnect.getConn();
			Statement stmt = conn.createStatement();
			String queryString = "select * from banggialuutru";
			ResultSet rs = stmt.executeQuery(queryString);
			while(rs.next()) {
				System.out.println();
				String ten = rs.getString(1);
				String gia=rs.getString(2);
				bglt.add(new BGLT(ten, gia));
			} 
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bglt;
	}
	
	public ArrayList<BGDB> getBGDB()
	{
		ArrayList<BGDB> bgdb = new ArrayList<BGDB>();
		try {
			Connect cnConnect=new Connect();
			Connection conn = cnConnect.getConn();
			Statement stmt = conn.createStatement();
			String queryString = "select * from banggiadenbu";
			ResultSet rs = stmt.executeQuery(queryString);
			while(rs.next()) {
				System.out.println();
				String tenvattu = rs.getString(1);
				String chungloai=rs.getString(2);
				String donvitinh=rs.getString(3);
				int soluong=rs.getInt(4);
				int dongia=rs.getInt(5);
				String ghichu=rs.getString(6);
				bgdb.add(new BGDB(tenvattu, chungloai, donvitinh, soluong, dongia, ghichu));
			} 
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bgdb;
	}
}
