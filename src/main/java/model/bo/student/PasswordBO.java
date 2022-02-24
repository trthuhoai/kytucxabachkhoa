package model.bo.student;

import model.bean.Password;
import model.dao.student.PasswordDao;

public class PasswordBO {
	PasswordDao passwordDao=new PasswordDao();

	public boolean checkInfo(Password password) {
		return passwordDao.checkInfo(password);
	}
	public void resetPassword(String maSo, String mk) {
		passwordDao.resetPassword(maSo, mk);
	}
}
