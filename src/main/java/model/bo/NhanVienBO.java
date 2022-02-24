package model.bo;

import java.util.List;

import model.bean.NhanVien;
import model.dao.NhanVienDAO;

public class NhanVienBO {

	private NhanVienDAO nhanVienDAO = new NhanVienDAO();

	public List<NhanVien> getList(int offset, int rowCount) {
		return nhanVienDAO.getList(offset, rowCount);
	}

	public int totalRow() {
		return nhanVienDAO.totalRow();
	}

	public int add(NhanVien nv) {
		return nhanVienDAO.add(nv);
	}

	public int adminUpdate(NhanVien nv) {
		return nhanVienDAO.adminUpdate(nv);
	}

	public int delete(String maNV) {
		return nhanVienDAO.delete(maNV);
	}

	public NhanVien findByMaNV(String maNV) {
		return nhanVienDAO.findByMaNV(maNV);
	}

	public List<NhanVien> search(String keyword, String thuocTinh, int offset, int rowCount) {
		return nhanVienDAO.search(keyword, thuocTinh, offset, rowCount);
	}

	public int totalRowSearch(String keyword, String thuocTinh) {
		return nhanVienDAO.totalRowSearch(keyword, thuocTinh);
	}

}
