package model.bean;

public class BGDB {
	private String tenvattu;
	private String chungloai;
	private String donvitinh;
	private int soluong;
	private int dongia;
	private String ghichu;
	public String getten() {
		return tenvattu;
	}
	public String getchungloai() {
		return chungloai;
	}
	public String getdvt() {
		return donvitinh;
	}
	public int getsoluong() {
		return soluong;
	}
	public int getdongia() {
		return dongia;
	}
	public String getnote() {
		return ghichu;
	}
	
	public void setten(String tenvattu) {
		this.tenvattu = tenvattu;
	}
	public void setchungloai(String chungloai) {
		this.chungloai = chungloai;
	}
	public void setdvt(String donvitinh) {
		this.donvitinh = donvitinh;
	}
	public void setsoluong(int soluong) {
		this.soluong = soluong;
	}
	public void setdongia(int dongia) {
		this.dongia = dongia;
	}
	public void setnote(String ghichu) {
		this.ghichu = ghichu;
	}
	
	public BGDB(String tenvattu, String chungloai, String donvitinh, int soluong, int dongia, String ghichu) {
		super();
		this.tenvattu = tenvattu;
		this.chungloai = chungloai;
		this.donvitinh = donvitinh;
		this.soluong = soluong;
		this.dongia = dongia;
		this.ghichu = ghichu;
	}
}
