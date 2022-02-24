package model.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.bean.DangKyLuuTru;

public class DangKyLuuTruDAO extends AbstractDAO {

	public DangKyLuuTruDAO() {
		connectDB = new Connect1();
	}

	public List<DangKyLuuTru> getAll() {
		List<DangKyLuuTru> list = new ArrayList<DangKyLuuTru>();
		conn = connectDB.getConnection();
		String sql = "SELECT * FROM dangkyluutru";
		try {
			state = conn.createStatement();
			result = state.executeQuery(sql);
			while (result.next()) {
				list.add(
						new DangKyLuuTru(result.getInt("IDDKLT"), result.getString("MaSV"), result.getString("MatKhau"),
								result.getString("TenSV"), result.getString("GioiTinh"), result.getString("NgaySinh"),
								result.getString("Lop"), result.getString("Nganh"), result.getString("SoCCCD"),
								result.getString("DiaChi"), result.getString("SDT"), result.getString("Email")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectDB.close(result, state, conn);
		}
		return list;
	}

	public List<DangKyLuuTru> getList(int offset, int rowCount) {
		List<DangKyLuuTru> list = new ArrayList<DangKyLuuTru>();
		conn = connectDB.getConnection();
		String sql = "SELECT * FROM dangkyluutru LIMIT ?,?";
		try {
			pstate = conn.prepareStatement(sql);
			pstate.setInt(1, offset);
			pstate.setInt(2, rowCount);
			result = pstate.executeQuery();
			while (result.next()) {
				list.add(
						new DangKyLuuTru(result.getInt("IDDKLT"), result.getString("MaSV"), result.getString("MatKhau"),
								result.getString("TenSV"), result.getString("GioiTinh"), result.getString("NgaySinh"),
								result.getString("Lop"), result.getString("Nganh"), result.getString("SoCCCD"),
								result.getString("DiaChi"), result.getString("SDT"), result.getString("Email")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectDB.close(result, pstate, conn);
		}
		return list;
	}

	public int totalRow() {
		int count = 0;
		conn = connectDB.getConnection();
		String sql = "SELECT COUNT(*) FROM dangkyluutru";
		try {
			state = conn.createStatement();
			result = state.executeQuery(sql);
			while (result.next()) {
				count = result.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectDB.close(result, state, conn);
		}
		return count;
	}

	public List<DangKyLuuTru> search(String keyword, int offset, int rowCount) {
		List<DangKyLuuTru> list = new ArrayList<DangKyLuuTru>();
		conn = connectDB.getConnection();
		String sql = "SELECT * FROM dangkyluutru WHERE TenSV LIKE ? LIMIT ?,?";
		try {
			pstate = conn.prepareStatement(sql);
			pstate.setString(1, "%" + keyword + "%");
			pstate.setInt(2, offset);
			pstate.setInt(3, rowCount);
			result = pstate.executeQuery();
			while (result.next()) {
				list.add(
						new DangKyLuuTru(result.getInt("IDDKLT"), result.getString("MaSV"), result.getString("MatKhau"),
								result.getString("TenSV"), result.getString("GioiTinh"), result.getString("NgaySinh"),
								result.getString("Lop"), result.getString("Nganh"), result.getString("SoCCCD"),
								result.getString("DiaChi"), result.getString("SDT"), result.getString("Email")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectDB.close(result, pstate, conn);
		}
		return list;
	}

	public int totalRowSearch(String keyword) {
		int count = 0;
		conn = connectDB.getConnection();
		String sql = "SELECT COUNT(*) FROM dangkyluutru WHERE TenSV LIKE ?";
		try {
			pstate = conn.prepareStatement(sql);
			pstate.setString(1, "%" + keyword + "%");
			result = pstate.executeQuery();
			while (result.next()) {
				count = result.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectDB.close(result, pstate, conn);
		}
		return count;
	}

	public DangKyLuuTru findById(int id) {
		DangKyLuuTru sv = null;
		conn = connectDB.getConnection();
		String sql = "SELECT * FROM dangkyluutru WHERE IDDKLT = ?";
		try {
			pstate = conn.prepareStatement(sql);
			pstate.setInt(1, id);
			result = pstate.executeQuery();
			if (result.next()) {
				sv = new DangKyLuuTru(result.getInt("IDDKLT"), result.getString("MaSV"), result.getString("MatKhau"),
						result.getString("TenSV"), result.getString("GioiTinh"), result.getString("NgaySinh"),
						result.getString("Lop"), result.getString("Nganh"), result.getString("SoCCCD"),
						result.getString("DiaChi"), result.getString("SDT"), result.getString("Email"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectDB.close(result, pstate, conn);
		}
		return sv;
	}

	public int delete(int id) {
		int rs = 0;
		conn = connectDB.getConnection();
		String sql = "DELETE FROM dangkyluutru WHERE IDDKLT = ?";
		try {
			pstate = conn.prepareStatement(sql);
			pstate.setInt(1, id);
			rs = pstate.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectDB.close(pstate, conn);
		}
		return rs;
	}

}
