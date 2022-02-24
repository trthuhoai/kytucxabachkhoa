package model.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.bean.NhanVien;

public class NhanVienDAO extends AbstractDAO {

	public NhanVienDAO() {
		connectDB = new Connect1();
	}

	public List<NhanVien> getList(int offset, int rowCount) {
		List<NhanVien> list = new ArrayList<NhanVien>();
		conn = connectDB.getConnection();
		String sql = "SELECT * FROM nhanvienquanly LIMIT ?,?";
		try {
			pstate = conn.prepareStatement(sql);
			pstate.setInt(1, offset);
			pstate.setInt(2, rowCount);
			result = pstate.executeQuery();
			while (result.next()) {
				list.add(new NhanVien(result.getString("MaNV"), result.getString("MatKhau"), result.getString("TenNV"),
						result.getString("GioiTinh"), result.getString("NgaySinh"), result.getString("SoCCCD"),
						result.getString("DiaChi"), result.getString("SDT"), result.getString("SoTaiKhoan"),
						result.getString("NganHang"), result.getString("TenCha"), result.getString("NgaySinhCha"),
						result.getString("TenMe"), result.getString("NgaySinhMe"), result.getString("Email"),
						result.getString("ChucVu"), result.getString("TenNguoiBaoTin"),
						result.getString("QuanHeNguoiBaoTin"), result.getString("SDTNguoiBaoTin"),
						result.getString("DiaChiNguoiBaoTin")));
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
		String sql = "SELECT COUNT(*) FROM nhanvienquanly";
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

	public int add(NhanVien nv) {
		int rs = 0;
		conn = connectDB.getConnection();
		String sql = "INSERT INTO nhanvienquanly(MaNV,MatKhau,TenNV,GioiTinh,NgaySinh,SoCCCD,DiaChi,SDT,SoTaiKhoan,NganHang,"
				+ "TenCha,NgaySinhCha,TenMe,NgaySinhMe,Email,ChucVu,TenNguoiBaoTin,QuanHeNguoiBaoTin,SDTNguoiBaoTin,DiaChiNguoiBaoTin)"
				+ " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			pstate = conn.prepareStatement(sql);
			pstate.setString(1, nv.getMaNV());
			pstate.setString(2, nv.getMatKhau());
			pstate.setString(3, nv.getHoTen());
			pstate.setString(4, nv.getGioiTinh());
			pstate.setString(5, nv.getNgaySinh());
			pstate.setString(6, nv.getSoCCCD());
			pstate.setString(7, nv.getDiaChi());
			pstate.setString(8, nv.getSoDienThoai());
			pstate.setString(9, nv.getSoTaiKhoan());
			pstate.setString(10, nv.getNganHang());
			pstate.setString(11, nv.getTenCha());
			pstate.setString(12, nv.getNgaySinhCha());
			pstate.setString(13, nv.getTenMe());
			pstate.setString(14, nv.getNgaySinhMe());
			pstate.setString(15, nv.getEmail());
			pstate.setString(16, nv.getChucVu());
			pstate.setString(17, nv.getTenNguoiBaoTin());
			pstate.setString(18, nv.getQuanHeNguoiBaoTin());
			pstate.setString(19, nv.getSoDienThoaiNguoiBaoTin());
			pstate.setString(20, nv.getDiaChiNguoiBaoTin());
			rs = pstate.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectDB.close(pstate, conn);
		}
		return rs;
	}

	public int adminUpdate(NhanVien nv) {
		int rs = 0;
		conn = connectDB.getConnection();
		String sql = "UPDATE nhanvienquanly SET TenNV = ?, GioiTinh = ?, NgaySinh = ?, DiaChi = ?, SDT = ?, Email = ?, ChucVu = ?, MatKhau = ?"
				+ " WHERE BINARY MaNV = ?";
		try {
			pstate = conn.prepareStatement(sql);
			pstate.setString(1, nv.getHoTen());
			pstate.setString(2, nv.getGioiTinh());
			pstate.setString(3, nv.getNgaySinh());
			pstate.setString(4, nv.getDiaChi());
			pstate.setString(5, nv.getSoDienThoai());
			pstate.setString(6, nv.getEmail());
			pstate.setString(7, nv.getChucVu());
			pstate.setString(8, nv.getMatKhau());
			pstate.setString(9, nv.getMaNV());
			rs = pstate.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectDB.close(pstate, conn);
		}
		return rs;
	}

	public int delete(String maNV) {
		int rs = 0;
		conn = connectDB.getConnection();
		String sql = "DELETE FROM nhanvienquanly WHERE BINARY MaNV = ?";
		try {
			pstate = conn.prepareStatement(sql);
			pstate.setString(1, maNV);
			rs = pstate.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectDB.close(pstate, conn);
		}
		return rs;
	}

	public NhanVien findByMaNV(String maNV) {
		NhanVien nv = null;
		conn = connectDB.getConnection();
		String sql = "SELECT * FROM nhanvienquanly WHERE BINARY MaNV = ?";
		try {
			pstate = conn.prepareStatement(sql);
			pstate.setString(1, maNV);
			result = pstate.executeQuery();
			if (result.next()) {
				nv = new NhanVien(result.getString("MaNV"), result.getString("MatKhau"), result.getString("TenNV"),
						result.getString("GioiTinh"), result.getString("NgaySinh"), result.getString("SoCCCD"),
						result.getString("DiaChi"), result.getString("SDT"), result.getString("SoTaiKhoan"),
						result.getString("NganHang"), result.getString("TenCha"), result.getString("NgaySinhCha"),
						result.getString("TenMe"), result.getString("NgaySinhMe"), result.getString("Email"),
						result.getString("ChucVu"), result.getString("TenNguoiBaoTin"),
						result.getString("QuanHeNguoiBaoTin"), result.getString("SDTNguoiBaoTin"),
						result.getString("DiaChiNguoiBaoTin"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectDB.close(result, pstate, conn);
		}
		return nv;
	}

	public List<NhanVien> search(String keyword, String thuocTinh, int offset, int rowCount) {
		List<NhanVien> list = new ArrayList<NhanVien>();
		conn = connectDB.getConnection();
		String sql = "SELECT * FROM nhanvienquanly WHERE";
		if (thuocTinh.equals("ten")) {
			sql += " TenNV LIKE ?";
		}
		if (thuocTinh.equals("chucvu")) {
			sql += " ChucVu LIKE ?";
		}
		sql += " LIMIT ?,?";
		try {
			pstate = conn.prepareStatement(sql);
			pstate.setString(1, "%" + keyword + "%");
			pstate.setInt(2, offset);
			pstate.setInt(3, rowCount);
			result = pstate.executeQuery();
			while (result.next()) {
				list.add(new NhanVien(result.getString("MaNV"), result.getString("MatKhau"), result.getString("TenNV"),
						result.getString("GioiTinh"), result.getString("NgaySinh"), result.getString("SoCCCD"),
						result.getString("DiaChi"), result.getString("SDT"), result.getString("SoTaiKhoan"),
						result.getString("NganHang"), result.getString("TenCha"), result.getString("NgaySinhCha"),
						result.getString("TenMe"), result.getString("NgaySinhMe"), result.getString("Email"),
						result.getString("ChucVu"), result.getString("TenNguoiBaoTin"),
						result.getString("QuanHeNguoiBaoTin"), result.getString("SDTNguoiBaoTin"),
						result.getString("DiaChiNguoiBaoTin")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectDB.close(result, pstate, conn);
		}
		return list;
	}

	// đếm số lượng record tìm kiếm (phân trang)
	public int totalRowSearch(String keyword, String thuocTinh) {
		int count = 0;
		conn = connectDB.getConnection();
		String sql = "SELECT COUNT(*) FROM nhanvienquanly WHERE";
		if (thuocTinh.equals("ten")) {
			sql += " TenNV LIKE ?";
		}
		if (thuocTinh.equals("chucvu")) {
			sql += " ChucVu LIKE ?";
		}
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

}
