package model.bo;
import java.util.ArrayList;

import model.bean.Staff;
import model.dao.*;
public class CheckLoginBO {
	CheckLoginAdminDAO checkLoginAdminDao = new CheckLoginAdminDAO();
	CheckLoginStaffDAO checkLoginStaffDao = new CheckLoginStaffDAO();
	CheckLoginStudentDAO checkLoginStudentDao = new CheckLoginStudentDAO();

	public boolean isValidAdmin(String userName, String password) {
		return checkLoginAdminDao.isExistUser(userName, password);

	}
	public boolean isValidStaff(String userName, String password) {
		return checkLoginStaffDao.isExistUser(userName, password);

	}
	public boolean isValidStudent(String userName, String password) {
		return checkLoginStudentDao.isExistUser(userName, password);

	}
	public ArrayList<Staff> getUpdateNV(String manv) {
		return checkLoginStaffDao.UpdateNV(manv);

	}
	public ArrayList<Staff> DanhSachCPSV() {
		return checkLoginStaffDao.DanhSachCPSV();

	}
	public ArrayList<Staff> TimkiemCPSV(String values) {
		return checkLoginStaffDao.TimkiemCPSV(values);

	}

}
