package model.dao;

import java.sql.SQLException;

import model.bean.Admin;

public class AdminDAO extends AbstractDAO {

	public AdminDAO() {
		connectDB = new Connect1();
	}

	public Admin checkLogin(String maAdmin, String matKhau) {
		Admin admin = null;
		conn = connectDB.getConnection();
		String sql = "SELECT * FROM admin WHERE BINARY MaAdmin = ? AND BINARY MatKhau = ?";
		try {
			pstate = conn.prepareStatement(sql);
			pstate.setString(1, maAdmin);
			pstate.setString(2, matKhau);
			result = pstate.executeQuery();
			if (result.next()) {
				admin = new Admin(result.getString("MaAdmin"), result.getString("MatKhau"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectDB.close(result, pstate, conn);
		}
		return admin;
	}

	public Admin findByMaAdmin(String maAdmin) {
		Admin admin = null;
		conn = connectDB.getConnection();
		String sql = "SELECT * FROM admin WHERE BINARY MaAdmin = ?";
		try {
			pstate = conn.prepareStatement(sql);
			pstate.setString(1, maAdmin);
			result = pstate.executeQuery();
			if (result.next()) {
				admin = new Admin(result.getString("MaAdmin"), result.getString("MatKhau"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectDB.close(result, pstate, conn);
		}
		return admin;
	}

	public int updatePassword(Admin admin) {
		int rs = 0;
		conn = connectDB.getConnection();
		String sql = "UPDATE admin SET MatKhau = ? WHERE MaAdmin = ?";
		try {
			pstate = conn.prepareStatement(sql);
			pstate.setString(1, admin.getMatKhau());
			pstate.setString(2, admin.getMaAdmin());
			rs = pstate.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectDB.close(pstate, conn);
		}
		return rs;
	}

}
