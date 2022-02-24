package model.bo;

import model.bean.ThongBao;
import model.dao.ThongBaoDAO;

public class ThongBaoBO {

	private ThongBaoDAO thongBaoDAO = new ThongBaoDAO();

	public int add(ThongBao tb) {
		return thongBaoDAO.add(tb);
	}

}
