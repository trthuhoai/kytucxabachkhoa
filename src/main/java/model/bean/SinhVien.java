package model.bean;

public class SinhVien {
	private String maSV;
	private String matKhau;
	private String hoTen;
	private String gioiTinh;
	private String ngaySinh;
	private String lop;
	private String nganh;
	private String soCCCD;
	private String diaChi;
	private String soDienThoai;
	private String soTaiKhoan;
	private String nganHang;
	private String tenCha;
	private String ngaySinhCha;
	private String tenMe;
	private String ngaySinhMe;
	private String tenNguoiBaoTin;
	private String quanHeNguoiBaoTin;
	private String soDienThoaiNguoiBaoTin;
	private String diaChiNguoiBaoTin;
	private String email;
	private Phong phong;

	public SinhVien() {

	}

	public SinhVien(String maSV, String matKhau, String hoTen, String gioiTinh, String ngaySinh, String lop,
			String nganh, String soCCCD, String diaChi, String soDienThoai, String soTaiKhoan, String nganHang,
			String tenCha, String ngaySinhCha, String tenMe, String ngaySinhMe, String tenNguoiBaoTin,
			String quanHeNguoiBaoTin, String soDienThoaiNguoiBaoTin, String diaChiNguoiBaoTin, String email,
			Phong phong) {
		super();
		this.maSV = maSV;
		this.matKhau = matKhau;
		this.hoTen = hoTen;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
		this.lop = lop;
		this.nganh = nganh;
		this.soCCCD = soCCCD;
		this.diaChi = diaChi;
		this.soDienThoai = soDienThoai;
		this.soTaiKhoan = soTaiKhoan;
		this.nganHang = nganHang;
		this.tenCha = tenCha;
		this.ngaySinhCha = ngaySinhCha;
		this.tenMe = tenMe;
		this.ngaySinhMe = ngaySinhMe;
		this.tenNguoiBaoTin = tenNguoiBaoTin;
		this.quanHeNguoiBaoTin = quanHeNguoiBaoTin;
		this.soDienThoaiNguoiBaoTin = soDienThoaiNguoiBaoTin;
		this.diaChiNguoiBaoTin = diaChiNguoiBaoTin;
		this.email = email;
		this.phong = phong;
	}

	public SinhVien(String maSV, String matKhau, String hoTen, String gioiTinh, String ngaySinh, String lop,
			String nganh, String diaChi, String soDienThoai, String email) {
		super();
		this.maSV = maSV;
		this.matKhau = matKhau;
		this.hoTen = hoTen;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
		this.lop = lop;
		this.nganh = nganh;
		this.diaChi = diaChi;
		this.soDienThoai = soDienThoai;
		this.email = email;
	}

	public String getMaSV() {
		return maSV;
	}

	public void setMaSV(String maSV) {
		this.maSV = maSV;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getLop() {
		return lop;
	}

	public void setLop(String lop) {
		this.lop = lop;
	}

	public String getNganh() {
		return nganh;
	}

	public void setNganh(String nganh) {
		this.nganh = nganh;
	}

	public String getSoCCCD() {
		return soCCCD;
	}

	public void setSoCCCD(String soCCCD) {
		this.soCCCD = soCCCD;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getSoTaiKhoan() {
		return soTaiKhoan;
	}

	public void setSoTaiKhoan(String soTaiKhoan) {
		this.soTaiKhoan = soTaiKhoan;
	}

	public String getNganHang() {
		return nganHang;
	}

	public void setNganHang(String nganHang) {
		this.nganHang = nganHang;
	}

	public String getTenCha() {
		return tenCha;
	}

	public void setTenCha(String tenCha) {
		this.tenCha = tenCha;
	}

	public String getNgaySinhCha() {
		return ngaySinhCha;
	}

	public void setNgaySinhCha(String ngaySinhCha) {
		this.ngaySinhCha = ngaySinhCha;
	}

	public String getTenMe() {
		return tenMe;
	}

	public void setTenMe(String tenMe) {
		this.tenMe = tenMe;
	}

	public String getNgaySinhMe() {
		return ngaySinhMe;
	}

	public void setNgaySinhMe(String ngaySinhMe) {
		this.ngaySinhMe = ngaySinhMe;
	}

	public String getTenNguoiBaoTin() {
		return tenNguoiBaoTin;
	}

	public void setTenNguoiBaoTin(String tenNguoiBaoTin) {
		this.tenNguoiBaoTin = tenNguoiBaoTin;
	}

	public String getQuanHeNguoiBaoTin() {
		return quanHeNguoiBaoTin;
	}

	public void setQuanHeNguoiBaoTin(String quanHeNguoiBaoTin) {
		this.quanHeNguoiBaoTin = quanHeNguoiBaoTin;
	}

	public String getSoDienThoaiNguoiBaoTin() {
		return soDienThoaiNguoiBaoTin;
	}

	public void setSoDienThoaiNguoiBaoTin(String soDienThoaiNguoiBaoTin) {
		this.soDienThoaiNguoiBaoTin = soDienThoaiNguoiBaoTin;
	}

	public String getDiaChiNguoiBaoTin() {
		return diaChiNguoiBaoTin;
	}

	public void setDiaChiNguoiBaoTin(String diaChiNguoiBaoTin) {
		this.diaChiNguoiBaoTin = diaChiNguoiBaoTin;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Phong getPhong() {
		return phong;
	}

	public void setPhong(Phong phong) {
		this.phong = phong;
	}

}
