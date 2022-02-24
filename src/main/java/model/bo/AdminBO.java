package model.bo;

import model.bean.Admin;
import model.dao.AdminDAO;

public class AdminBO {

	private AdminDAO adminDAO = new AdminDAO();

	public Admin checkLogin(String maAdmin, String matKhau) {
		return adminDAO.checkLogin(maAdmin, matKhau);
	}
	
	public Admin findByMaAdmin(String maAdmin) {
		return adminDAO.findByMaAdmin(maAdmin);
	}

	public int updatePassword(Admin admin) {
		return adminDAO.updatePassword(admin);
	}

}
