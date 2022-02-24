package model.bean;

import java.sql.Date;

public class Contact {
	private String Hoten;
	private String MaSV;
	private String SDT;
	private String Content;
	
	public String getMaSV() {
		return MaSV;
	}
	public void setMaSV(String maSV) {
		MaSV = maSV;
	}
	
	public String getHoten() {
		return Hoten;
	}
	public void setHoten(String hoten) {
		Hoten = hoten;
	}
	
	public String getSDT() {
		return SDT;
	}
	public void setSDT(String sDT) {
		SDT = sDT;
	}
	
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}

}
