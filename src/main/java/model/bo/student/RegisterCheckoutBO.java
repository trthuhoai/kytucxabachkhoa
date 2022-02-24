package model.bo.student;

import model.bean.RegisterCheckout;
import model.dao.student.RegisterCheckoutDao;

public class RegisterCheckoutBO {
	RegisterCheckoutDao registerCheckoutDao=new RegisterCheckoutDao();
	public void AddRegisterCheckout(RegisterCheckout registerCheckout) {
		registerCheckoutDao.AddRegisterCheckout(registerCheckout);
	}
}
