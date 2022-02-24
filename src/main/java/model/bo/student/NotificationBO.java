package model.bo.student;

import java.util.ArrayList;

import model.bean.Notification;
import model.dao.student.NotificationDao;

public class NotificationBO {
	NotificationDao notificationDao=new NotificationDao();
	public ArrayList<Notification> getNotificationList() {
		return notificationDao.getNotificationList();
	}
}
