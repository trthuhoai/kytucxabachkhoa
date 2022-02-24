package model.bo.student;

import java.util.ArrayList;

import model.bean.Chat;
import model.dao.student.ChatDao;

public class ChatBO {
	ChatDao chatDao=new ChatDao();
	public ArrayList<Chat> getChatList(String iDTinNhan) {
		return chatDao.getChatList(iDTinNhan);
	}
	public void AddMessage(Chat chat) {
		chatDao.AddMessage(chat);
	}
}
