package model.bo;
import model.bean.Student;
import model.dao.CheckRegistersDAO;

public class CheckRegisterBO {
	CheckRegistersDAO checkRegisterDAO = new CheckRegistersDAO();

	public boolean isNotValidNewUser(Student student) {
		return checkRegisterDAO.isExitUser(student);
	}
	public void creatNewUser(Student student) {
		checkRegisterDAO.creatNewUser(student);
	}

}
