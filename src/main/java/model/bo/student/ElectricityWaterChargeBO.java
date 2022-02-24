package model.bo.student;

import model.bean.ElectricityWaterCharge;
import model.dao.student.ElectricityWaterChargeDao;

public class ElectricityWaterChargeBO {
	ElectricityWaterChargeDao electricityWaterChargeDao=new ElectricityWaterChargeDao();
	public ElectricityWaterCharge getRentalFeeInfo(String maSo, String thoiGian) {
		return electricityWaterChargeDao.getRentalFeeInfo(maSo, thoiGian);
	}
	public void updateElectricityWaterCharge(ElectricityWaterCharge electricityWaterCharge) {
		electricityWaterChargeDao.updateElectricityWaterCharge(electricityWaterCharge);
	}
}
