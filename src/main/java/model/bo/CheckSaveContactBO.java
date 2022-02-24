package model.bo;

import model.bean.Contact;
import model.dao.CheckSaveContactDAO;

public class CheckSaveContactBO {
	CheckSaveContactDAO checkSaveContactDAO = new CheckSaveContactDAO();

	public boolean isSaveSuccess(Contact contact) {
		return checkSaveContactDAO.saveSuccess(contact);
	}
}
