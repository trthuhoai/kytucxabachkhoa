package model.bean;

public class ThongBao {
	private int id;
	private String maNV;
	private String maAdmin;
	private String ngayDang;
	private String tieuDe;
	private String noiDung;

	public ThongBao() {

	}

	public ThongBao(int id, String maNV, String maAdmin, String ngayDang, String tieuDe, String noiDung) {
		super();
		this.id = id;
		this.maNV = maNV;
		this.maAdmin = maAdmin;
		this.ngayDang = ngayDang;
		this.tieuDe = tieuDe;
		this.noiDung = noiDung;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMaNV() {
		return maNV;
	}

	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}

	public String getMaAdmin() {
		return maAdmin;
	}

	public void setMaAdmin(String maAdmin) {
		this.maAdmin = maAdmin;
	}

	public String getNgayDang() {
		return ngayDang;
	}

	public void setNgayDang(String ngayDang) {
		this.ngayDang = ngayDang;
	}

	public String getTieuDe() {
		return tieuDe;
	}

	public void setTieuDe(String tieuDe) {
		this.tieuDe = tieuDe;
	}

	public String getNoiDung() {
		return noiDung;
	}

	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}

}
