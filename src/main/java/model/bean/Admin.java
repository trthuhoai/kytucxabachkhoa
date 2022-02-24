package model.bean;

public class Admin {
	private String maAdmin;
	private String matKhau;

	public Admin() {

	}

	public Admin(String maAdmin, String matKhau) {
		super();
		this.maAdmin = maAdmin;
		this.matKhau = matKhau;
	}

	public String getMaAdmin() {
		return maAdmin;
	}

	public void setMaAdmin(String maAdmin) {
		this.maAdmin = maAdmin;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

}
