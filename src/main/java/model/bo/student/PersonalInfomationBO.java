package model.bo.student;

import model.bean.Student;
import model.dao.student.PersonalInformationDao;

public class PersonalInfomationBO {
PersonalInformationDao personalInformationDao=new PersonalInformationDao();

public Student getPersonalInfo(String maSo) {
	return personalInformationDao.getPersonalInfo(maSo);

}
public void updategetPersonalInfo(String maSo, Student student) {
	personalInformationDao.updatePersonalInfo(maSo, student);
}
public void changePassword(String maSo, String mk) {
	personalInformationDao.changePassword(maSo, mk);
}

}
