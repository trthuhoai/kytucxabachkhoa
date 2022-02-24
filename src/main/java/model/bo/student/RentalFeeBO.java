package model.bo.student;

import model.bean.RentalFee;
import model.dao.student.RentalFeeDao;

public class RentalFeeBO {
	RentalFeeDao rentalFeeDao=new RentalFeeDao();
	public RentalFee getRentalFeeInfo(String maSo, String hocKy) {
		return rentalFeeDao.getRentalFeeInfo(maSo, hocKy);
	}
	public void updateRentalFeeInfo(RentalFee rentalFee) {
		rentalFeeDao.updateRentalFeeInfo(rentalFee);
	}
}
