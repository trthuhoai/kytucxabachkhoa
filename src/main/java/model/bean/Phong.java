package model.bean;

public class Phong {
	private String idPhong;
	private String phong;
	private String nha;
	private int soLuongSVChoPhep;
	private int soLuongSVDangLuuTru;
	private float giaMoiThang;
	private String gioiTinh;

	public Phong() {

	}

	public Phong(String idPhong, String phong, String nha, int soLuongSVChoPhep, int soLuongSVDangLuuTru,
			float giaMoiThang, String gioiTinh) {
		super();
		this.idPhong = idPhong;
		this.phong = phong;
		this.nha = nha;
		this.soLuongSVChoPhep = soLuongSVChoPhep;
		this.soLuongSVDangLuuTru = soLuongSVDangLuuTru;
		this.giaMoiThang = giaMoiThang;
		this.gioiTinh = gioiTinh;
	}

	public String getIdPhong() {
		return idPhong;
	}

	public void setIdPhong(String idPhong) {
		this.idPhong = idPhong;
	}

	public String getPhong() {
		return phong;
	}

	public void setPhong(String phong) {
		this.phong = phong;
	}

	public String getNha() {
		return nha;
	}

	public void setNha(String nha) {
		this.nha = nha;
	}

	public int getSoLuongSVChoPhep() {
		return soLuongSVChoPhep;
	}

	public void setSoLuongSVChoPhep(int soLuongSVChoPhep) {
		this.soLuongSVChoPhep = soLuongSVChoPhep;
	}

	public int getSoLuongSVDangLuuTru() {
		return soLuongSVDangLuuTru;
	}

	public void setSoLuongSVDangLuuTru(int soLuongSVDangLuuTru) {
		this.soLuongSVDangLuuTru = soLuongSVDangLuuTru;
	}

	public float getGiaMoiThang() {
		return giaMoiThang;
	}

	public void setGiaMoiThang(float giaMoiThang) {
		this.giaMoiThang = giaMoiThang;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

}