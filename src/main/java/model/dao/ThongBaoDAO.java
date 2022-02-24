package model.dao;

import java.sql.SQLException;

import model.bean.ThongBao;

public class ThongBaoDAO extends AbstractDAO {

	public ThongBaoDAO() {
		connectDB = new Connect1();
	}

	public int add(ThongBao tb) {
		int rs = 0;
		conn = connectDB.getConnection();
		String sql = "INSERT INTO thongbao(MaNV,MaAdmin,Ngay,TieuDe,NoiDung) VALUES (?,?,?,?,?)";
		try {
			pstate = conn.prepareStatement(sql);
			pstate.setString(1, tb.getMaNV());
			pstate.setString(2, tb.getMaAdmin());
			pstate.setString(3, tb.getNgayDang());
			pstate.setString(4, tb.getTieuDe());
			pstate.setString(5, tb.getNoiDung());
			rs = pstate.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectDB.close(pstate, conn);
		}
		return rs;
	}

}
