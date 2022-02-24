package model.bo;

import java.util.List;

import model.bean.DangKyLuuTru;
import model.dao.DangKyLuuTruDAO;

public class DangKyLuuTruBO {

	private DangKyLuuTruDAO dangKyLuuTruDAO = new DangKyLuuTruDAO();

	public List<DangKyLuuTru> getAll() {
		return dangKyLuuTruDAO.getAll();
	}

	public List<DangKyLuuTru> getList(int offset, int rowCount) {
		return dangKyLuuTruDAO.getList(offset, rowCount);
	}

	public int totalRow() {
		return dangKyLuuTruDAO.totalRow();
	}

	public List<DangKyLuuTru> search(String keyword, int offset, int rowCount) {
		return dangKyLuuTruDAO.search(keyword, offset, rowCount);
	}

	public int totalRowSearch(String keyword) {
		return dangKyLuuTruDAO.totalRowSearch(keyword);
	}

	public DangKyLuuTru findById(int id) {
		return dangKyLuuTruDAO.findById(id);
	}

	public int delete(int id) {
		return dangKyLuuTruDAO.delete(id);
	}

}
