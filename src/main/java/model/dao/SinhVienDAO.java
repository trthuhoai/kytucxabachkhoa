package model.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.bean.Phong;
import model.bean.SinhVien;

public class SinhVienDAO extends AbstractDAO {

	public SinhVienDAO() {
		connectDB = new Connect1();
	}

	public List<SinhVien> getList(int offset, int rowCount) {
		List<SinhVien> list = new ArrayList<SinhVien>();
		conn = connectDB.getConnection();
		String sql = "SELECT * FROM sinhvien sv LEFT JOIN phong p ON sv.IDPhong = p.IDPhong LIMIT ?,?";
		try {
			pstate = conn.prepareStatement(sql);
			pstate.setInt(1, offset);
			pstate.setInt(2, rowCount);
			result = pstate.executeQuery();
			while (result.next()) {
				list.add(new SinhVien(result.getString("MaSV"), result.getString("MatKhau"), result.getString("TenSV"),
						result.getString("GioiTinh"), result.getString("NgaySinh"), result.getString("Lop"),
						result.getString("Nganh"), result.getString("SoCCCD"), result.getString("DiaChi"),
						result.getString("SDT"), result.getString("SoTaiKhoan"), result.getString("NganHang"),
						result.getString("TenCha"), result.getString("NgaySinhCha"), result.getString("TenMe"),
						result.getString("NgaySinhMe"), result.getString("TenNguoiBaoTin"),
						result.getString("QuanHeNguoiBaoTin"), result.getString("SDTNguoiBaoTin"),
						result.getString("DiaChiNguoiBaoTin"), result.getString("Email"),
						new Phong(result.getString("sv.IDPhong"), result.getString("Phong"), result.getString("Nha"),
								result.getInt("SLuongSVChoPhep"), result.getInt("SLuongSVDangLuuTru"),
								result.getFloat("GiaMoiThang"), result.getString("Nam"))));
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
		String sql = "SELECT COUNT(*) FROM sinhvien sv LEFT JOIN phong p ON sv.IDPhong = p.IDPhong";
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

	public SinhVien findByMaSV(String maSV) {
		SinhVien sv = null;
		conn = connectDB.getConnection();
		String sql = "SELECT * FROM sinhvien sv LEFT JOIN phong p ON sv.IDPhong = p.IDPhong WHERE BINARY MaSV = ?";
		try {
			pstate = conn.prepareStatement(sql);
			pstate.setString(1, maSV);
			result = pstate.executeQuery();
			if (result.next()) {
				sv = new SinhVien(result.getString("MaSV"), result.getString("MatKhau"), result.getString("TenSV"),
						result.getString("GioiTinh"), result.getString("NgaySinh"), result.getString("Lop"),
						result.getString("Nganh"), result.getString("SoCCCD"), result.getString("DiaChi"),
						result.getString("SDT"), result.getString("SoTaiKhoan"), result.getString("NganHang"),
						result.getString("TenCha"), result.getString("NgaySinhCha"), result.getString("TenMe"),
						result.getString("NgaySinhMe"), result.getString("TenNguoiBaoTin"),
						result.getString("QuanHeNguoiBaoTin"), result.getString("SDTNguoiBaoTin"),
						result.getString("DiaChiNguoiBaoTin"), result.getString("Email"),
						new Phong(result.getString("sv.IDPhong"), result.getString("Phong"), result.getString("Nha"),
								result.getInt("SLuongSVChoPhep"), result.getInt("SLuongSVDangLuuTru"),
								result.getFloat("GiaMoiThang"), result.getString("Nam")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectDB.close(result, pstate, conn);
		}
		return sv;
	}

	public int add(SinhVien sv) {
		int rs = 0;
		conn = connectDB.getConnection();
		String sql = "INSERT INTO sinhvien(MaSV,MatKhau,TenSV,GioiTinh,NgaySinh,Lop,Nganh,SoCCCD,DiaChi,SDT,SoTaiKhoan,NganHang,"
				+ "TenCha,NgaySinhCha,TenMe,NgaySinhMe,TenNguoiBaoTin,QuanHeNguoiBaoTin,SDTNguoiBaoTin,DiaChiNguoiBaoTin,Email,IDPhong)"
				+ " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			pstate = conn.prepareStatement(sql);
			pstate.setString(1, sv.getMaSV());
			pstate.setString(2, sv.getMatKhau());
			pstate.setString(3, sv.getHoTen());
			pstate.setString(4, sv.getGioiTinh());
			pstate.setString(5, sv.getNgaySinh());
			pstate.setString(6, sv.getLop());
			pstate.setString(7, sv.getNganh());
			pstate.setString(8, sv.getSoCCCD());
			pstate.setString(9, sv.getDiaChi());
			pstate.setString(10, sv.getSoDienThoai());
			pstate.setString(11, sv.getSoTaiKhoan());
			pstate.setString(12, sv.getNganHang());
			pstate.setString(13, sv.getTenCha());
			pstate.setString(14, sv.getNgaySinhCha());
			pstate.setString(15, sv.getTenMe());
			pstate.setString(16, sv.getNgaySinhMe());
			pstate.setString(17, sv.getTenNguoiBaoTin());
			pstate.setString(18, sv.getQuanHeNguoiBaoTin());
			pstate.setString(19, sv.getSoDienThoaiNguoiBaoTin());
			pstate.setString(20, sv.getDiaChiNguoiBaoTin());
			pstate.setString(21, sv.getEmail());
			pstate.setString(22, "");
			rs = pstate.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectDB.close(pstate, conn);
		}
		return rs;
	}

	public int adminUpdate(SinhVien sv) {
		int rs = 0;
		conn = connectDB.getConnection();
		String sql = "UPDATE sinhvien SET TenSV = ?, SDT = ?, Email = ?, NgaySinh = ?, GioiTinh = ?, DiaChi = ?, Nganh = ?, Lop = ?, MatKhau = ?"
				+ " WHERE BINARY MaSV = ?";
		try {
			pstate = conn.prepareStatement(sql);
			pstate.setString(1, sv.getHoTen());
			pstate.setString(2, sv.getSoDienThoai());
			pstate.setString(3, sv.getEmail());
			pstate.setString(4, sv.getNgaySinh());
			pstate.setString(5, sv.getGioiTinh());
			pstate.setString(6, sv.getDiaChi());
			pstate.setString(7, sv.getNganh());
			pstate.setString(8, sv.getLop());
			pstate.setString(9, sv.getMatKhau());
			pstate.setString(10, sv.getMaSV());
			rs = pstate.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectDB.close(pstate, conn);
		}
		return rs;
	}

	public int delete(String maSV) {
		int rs = 0;
		conn = connectDB.getConnection();
		String sql = "DELETE FROM sinhvien WHERE BINARY MaSV = ?";
		try {
			pstate = conn.prepareStatement(sql);
			pstate.setString(1, maSV);
			rs = pstate.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectDB.close(pstate, conn);
		}
		return rs;
	}

	public List<SinhVien> search(String keyword, String thuocTinh, int offset, int rowCount) {
		List<SinhVien> list = new ArrayList<SinhVien>();
		conn = connectDB.getConnection();
		String sql = "SELECT * FROM sinhvien sv LEFT JOIN phong p ON sv.IDPhong = p.IDPhong WHERE";
		if (thuocTinh.equals("ten")) {
			sql += " TenSV LIKE ?";
		}
		if (thuocTinh.equals("phong")) {
			sql += " p.Phong LIKE ?";
		}
		sql += " LIMIT ?,?";
		try {
			pstate = conn.prepareStatement(sql);
			pstate.setString(1, "%" + keyword + "%");
			pstate.setInt(2, offset);
			pstate.setInt(3, rowCount);
			result = pstate.executeQuery();
			while (result.next()) {
				list.add(new SinhVien(result.getString("MaSV"), result.getString("MatKhau"), result.getString("TenSV"),
						result.getString("GioiTinh"), result.getString("NgaySinh"), result.getString("Lop"),
						result.getString("Nganh"), result.getString("SoCCCD"), result.getString("DiaChi"),
						result.getString("SDT"), result.getString("SoTaiKhoan"), result.getString("NganHang"),
						result.getString("TenCha"), result.getString("NgaySinhCha"), result.getString("TenMe"),
						result.getString("NgaySinhMe"), result.getString("TenNguoiBaoTin"),
						result.getString("QuanHeNguoiBaoTin"), result.getString("SDTNguoiBaoTin"),
						result.getString("DiaChiNguoiBaoTin"), result.getString("Email"),
						new Phong(result.getString("sv.IDPhong"), result.getString("Phong"), result.getString("Nha"),
								result.getInt("SLuongSVChoPhep"), result.getInt("SLuongSVDangLuuTru"),
								result.getFloat("GiaMoiThang"), result.getString("Nam"))));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectDB.close(result, pstate, conn);
		}
		return list;
	}

	public int totalRowSearch(String keyword, String thuocTinh) {
		int count = 0;
		conn = connectDB.getConnection();
		String sql = "SELECT COUNT(*) FROM sinhvien sv LEFT JOIN phong p ON sv.IDPhong = p.IDPhong WHERE";
		if (thuocTinh.equals("ten")) {
			sql += " TenSV LIKE ?";
		}
		if (thuocTinh.equals("phong")) {
			sql += " p.Phong LIKE ?";
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
