package model.bo;

import java.util.List;

import model.bean.SinhVien;
import model.dao.SinhVienDAO;

public class SinhVienBO {

	private SinhVienDAO sinhVienDAO = new SinhVienDAO();

	public List<SinhVien> getList(int offset, int rowCount) {
		return sinhVienDAO.getList(offset, rowCount);
	}

	public int totalRow() {
		return sinhVienDAO.totalRow();
	}

	public SinhVien findByMaSV(String maSV) {
		return sinhVienDAO.findByMaSV(maSV);
	}

	public int add(SinhVien sv) {
		return sinhVienDAO.add(sv);
	}

	public int adminUpdate(SinhVien sv) {
		return sinhVienDAO.adminUpdate(sv);
	}

	public int delete(String maSV) {
		return sinhVienDAO.delete(maSV);
	}

	public List<SinhVien> search(String keyword, String thuocTinh, int offset, int rowCount) {
		return sinhVienDAO.search(keyword, thuocTinh, offset, rowCount);
	}

	public int totalRowSearch(String keyword, String thuocTinh) {
		return sinhVienDAO.totalRowSearch(keyword, thuocTinh);
	}

}
