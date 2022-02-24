package model.bo.student;

import model.bean.SuggestedRepair;
import model.dao.student.SuggestedRepairDao;

public class SuggestedRepairBO {
	SuggestedRepairDao suggestedRepairDao=new SuggestedRepairDao();
	public void AddSuggestedRepair(SuggestedRepair suggestedRepair) {
		suggestedRepairDao.AddSuggestedRepair(suggestedRepair);
	}
}
