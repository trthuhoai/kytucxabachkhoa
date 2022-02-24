package model.bo;

import java.util.ArrayList;

import model.dao.ShowBgDAO;
import model.bean.BGDB;
import model.bean.BGLT;
import model.bean.PhiBD;

public class ShowBgBO {
	ShowBgDAO showbgDAO = new ShowBgDAO();
	
	
	public ArrayList<PhiBD> getPBD()
	{
		return showbgDAO.getPBD();
	}
	public ArrayList<BGLT> getBGLT()
	{
		return showbgDAO.getBGLT();
	}
	public ArrayList<BGDB> getBGDB()
	{
		return showbgDAO.getBGDB();
	}
}
