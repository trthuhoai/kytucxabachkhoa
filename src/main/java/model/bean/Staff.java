package model.bean;

import java.sql.Date;

public class Staff {
	public String getNoidungyc() {
		return noidungyc;
	}
	public void setNoidungyc(String noidungyc) {
		this.noidungyc = noidungyc;
	}
	public String getTgyeucau() {
		return tgyeucau;
	}
	public void setTgyeucau(String tgyeucau) {
		this.tgyeucau = tgyeucau;
	}
	public int getDkphong() {
		return dkphong;
	}
	public void setDkphong(int dkphong) {
		this.dkphong = dkphong;
	}
	public int getTraphong() {
		return traphong;
	}
	public void setTraphong(int traphong) {
		this.traphong = traphong;
	}
	public int getPhongsd() {
		return phongsd;
	}
	public void setPhongsd(int phongsd) {
		this.phongsd = phongsd;
	}
	public int getTongphong() {
		return tongphong;
	}
	public void setTongphong(int tongphong) {
		this.tongphong = tongphong;
	}
	public int getSuachua() {
		return suachua;
	}
	public void setSuachua(int suachua) {
		this.suachua = suachua;
	}
	public float getPhi() {
		return phi;
	}
	public void setPhi(float phi) {
		this.phi = phi;
	}
	public int getPhongtrong() {
		return phongtrong;
	}
	public void setPhongtrong(int phongtrong) {
		this.phongtrong = phongtrong;
	}


	public int getHocky() {
		return hocky;
	}
	public void setHocky(int hocky) {
		this.hocky = hocky;
	}
	public String getNamhoc() {
		return namhoc;
	}
	public void setNamhoc(String namhoc) {
		this.namhoc = namhoc;
	}
	public int getTongphi() {
		return tongphi;
	}
	public void setTongphi(int tongphi) {
		this.tongphi = tongphi;
	}


	private int hocky;
	private String namhoc;
	private int tongphi;
	private int trangThai;
	private int hinhThuc;
	private Date ngayTT;
	private int idPhiPhong;

	
	public int getIdPhiPhong() {
		return idPhiPhong;
	}
	public void setIdPhiPhong(int idPhiPhong) {
		this.idPhiPhong = idPhiPhong;
	}
	public Date getNgayTT() {
		return ngayTT;
	}
	public void setNgayTT(Date ngayTT) {
		this.ngayTT = ngayTT;
	}
	public int getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}
	public int getHinhThuc() {
		return hinhThuc;
	}
	public void setHinhThuc(int hinhThuc) {
		this.hinhThuc = hinhThuc;
	}
	public Staff(int hocky, String namhoc,int tongphi, String masv, int trangthai,int hinhthuc, Date ngayTT,int id) {
		super();
		this.hocky = hocky;
		this.namhoc = namhoc;
		this.tongphi = tongphi;
		this.masv = masv;
		this.trangThai=trangthai;
		this.hinhThuc=hinhthuc;
		this.ngayTT=ngayTT;
		this.idPhiPhong=id;
	}


	private String noidungyc; //nd yeu cau
	private String tgyeucau; //thoi gian yeu cau sua chua
	private int dkphong;
	private int traphong;
	private int phongsd;
	private int tongphong;
	private int suachua;
	private float phi;
	private int phongtrong;
	private String nguoiNop;
	private Date ngayNop;
	private int iDPhiDienNuoc;
	private String deXuat;
	private String ghiChu;
	private String nhanVien;
	private int tinhTrang;
	private int idSC;
	
	
	public int getIdSC() {
		return idSC;
	}
	public void setIdSC(int idSC) {
		this.idSC = idSC;
	}
	public String getDeXuat() {
		return deXuat;
	}
	public void setDeXuat(String deXuat) {
		this.deXuat = deXuat;
	}
	public String getGhiChu() {
		return ghiChu;
	}
	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	public String getNhanVien() {
		return nhanVien;
	}
	public void setNhanVien(String nhanVien) {
		this.nhanVien = nhanVien;
	}
	public int getTinhTrang() {
		return tinhTrang;
	}
	public void setTinhTrang(int tinhTrang) {
		this.tinhTrang = tinhTrang;
	}
	public int getiDPhiDienNuoc() {
		return iDPhiDienNuoc;
	}
	public void setiDPhiDienNuoc(int iDPhiDienNuoc) {
		this.iDPhiDienNuoc = iDPhiDienNuoc;
	}
	public String getNguoiNop() {
		return nguoiNop;
	}
	public void setNguoiNop(String nguoiNop) {
		this.nguoiNop = nguoiNop;
	}
	public Date getNgayNop() {
		return ngayNop;
	}
	public void setNgayNop(Date ngayNop) {
		this.ngayNop = ngayNop;
	}
	public Staff(String manv, String matkhau) {
	super();
	this.manv = manv;
	this.matkhau = matkhau;
	}
	public Staff(String nha,String tenphong, String noidungyc, String tgyeucau, String deXuat, String ghiChu,int tinhTrang, int idSC) {
	super();
	this.nha = nha;
	this.tenphong = tenphong;
	this.noidungyc = noidungyc;
	this.tgyeucau = tgyeucau;
	this.deXuat=deXuat;
	this.ghiChu=ghiChu;
	this.tinhTrang=tinhTrang;
	this.idSC=idSC;
	}
	public Staff(int dkphong, int traphong, int phongsd, int tongphong, int suachua, float phi, int phongtrong) {
	super();
	this.dkphong = dkphong;
	this.traphong = traphong;
	this.phongsd = phongsd;
	this.tongphong = tongphong;
	this.suachua = suachua;
	this.phi = phi;
	this.phongtrong = phongtrong;
	}


	private int SLSVDangLuuTru;
	private String lop;
	private String nganh;
	private String idpdnuoc;
	public String getIdpdnuoc() {
		return idpdnuoc;
	}
	public void setIdpdnuoc(String idpdnuoc) {
		this.idpdnuoc = idpdnuoc;
	}
	private String Tiendiennuoc;
	private Date ngay;

	
	public Date getNgay() {
		return ngay;
	}
	public void setNgay(Date ngay) {
		this.ngay = ngay;
	}
	
	
	public Staff(String idpdnuoc, String tiendiennuoc, Date ngay, String chapnhan, String tenphong, String nha, String nguoiNop, Date ngayThanhToan, int phi) {
		super();
		this.idpdnuoc = idpdnuoc;
		Tiendiennuoc = tiendiennuoc;
		this.ngay = ngay;
		this.chapnhan = chapnhan;
		this.tenphong = tenphong;
		this.nha = nha;
		this.nguoiNop=nguoiNop;
		this.ngayNop=ngayThanhToan;
		this.iDPhiDienNuoc=phi;
	}
	public Staff(String idpdnuoc, String tiendiennuoc, Date ngay, String chapnhan, String tenphong, String nha) {
		super();
		this.idpdnuoc = idpdnuoc;
		Tiendiennuoc = tiendiennuoc;
		this.ngay = ngay;
		this.chapnhan = chapnhan;
		this.tenphong = tenphong;
		this.nha = nha;
	}
	public String getTiendiennuoc() {
		return Tiendiennuoc;
	}
	public void setTiendiennuoc(String tiendiennuoc) {
		Tiendiennuoc = tiendiennuoc;
	}
	public Staff(String lop, String nganh, String socccd, String diachi, String sdt, String stk, String tennh,
			String masv, String tensv) {
		super();
		this.lop = lop;
		this.nganh = nganh;
		this.socccd = socccd;
		this.diachi = diachi;
		this.sdt = sdt;
		this.stk = stk;
		this.tennh = tennh;
		this.masv = masv;
		this.tensv = tensv;
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
	public Staff(String ngaytraphong, String lydotra, String masv, String tensv, String tenphong, String nha) {
		super();
		this.ngaytraphong = ngaytraphong;
		this.lydotra = lydotra;
		this.masv = masv;
		this.tensv = tensv;
		this.tenphong = tenphong;
		this.nha = nha;
	}
	public Staff(String idp_new, String ngaychuyen, String chapnhan, String masv, String tensv, String tenphong,
			String nha) {
		super();
		this.idp_new = idp_new;
		this.ngaychuyen = ngaychuyen;
		this.chapnhan = chapnhan;
		this.masv = masv;
		this.tensv = tensv;
		this.tenphong = tenphong;
		this.nha = nha;
	}
	public int getSLSVDangLuuTru() {
		return SLSVDangLuuTru;
	}
	public void setSLSVDangLuuTru(int sLSVDangLuuTru) {
		SLSVDangLuuTru = sLSVDangLuuTru;
	}
	
	public String getIdp_old() {
		return idp_old;
	}
	public void setIdp_old(String idp_old) {
		this.idp_old = idp_old;
	}
	public String getIdp_new() {
		return idp_new;
	}
	public void setIdp_new(String idp_new) {
		this.idp_new = idp_new;
	}
	public String getNgaychuyen() {
		return ngaychuyen;
	}
	public void setNgaychuyen(String ngaychuyen) {
		this.ngaychuyen = ngaychuyen;
	}
	public String getNgaytraphong() {
		return ngaytraphong;
	}
	public void setNgaytraphong(String ngaytraphong) {
		this.ngaytraphong = ngaytraphong;
	}
	public String getLydotra() {
		return lydotra;
	}
	public void setLydotra(String lydotra) {
		this.lydotra = lydotra;
	}
	private String idp_old;
	private String idp_new;
	private String ngaychuyen;
	private String ngaytraphong;
	private String lydotra;
	private String manv;
	private String matkhau;
	private String tennv;
	private String gioitinh;
	private String ngaysinh;
	private String socccd;
	private String diachi;
	private String sdt;
	private String stk;
	private String tennh;
	private String tencha;
	private String ngaycha;
	private String tenme;
	private String ngayme;
	private String email;
	private String chucvu;
	private String tennguoibt;
	private String quanhe;
	private String chapnhan;
	public String toString() {
		   return manv+"\t"+ tennv+"\t"+ gioitinh+"\t"+ ngaysinh+"\t"+socccd+"\t"+ diachi+"\t"+ sdt+"\t"+ stk+"\t"+ tennh+"\t"+tencha+"\t"+ ngaycha+"\t"+ tenme+"\t"+ ngayme+"\t"+email+"\t"+ chucvu+"\t"+tennguoibt+"\t"+ quanhe+"\t"+ sdtbt+"\t"+ diachibt;
    }
	public Staff(String chapnhan, String masv, String tensv, String tenphong, String nha) {
		super();
		this.chapnhan = chapnhan;
		this.masv = masv;
		this.tensv = tensv;
		this.tenphong = tenphong;
		this.nha = nha;
	}
	

	public Staff(int sLSVDangLuuTru, String idp_old, String gioitinh, String tenphong, String nha) {
		super();
		SLSVDangLuuTru = sLSVDangLuuTru;
		this.idp_old = idp_old;
		this.gioitinh = gioitinh;
		this.tenphong = tenphong;
		this.nha = nha;
	}
	public String getChapnhan() {
		return chapnhan;
	}
	public void setChapnhan(String chapnhan) {
		this.chapnhan = chapnhan;
	}
	private String sdtbt;
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getSdtbt() {
		return sdtbt;
	}
	public void setSdtbt(String sdtbt) {
		this.sdtbt = sdtbt;
	}
	public String getMasv() {
		return masv;
	}
	public void setMasv(String masv) {
		this.masv = masv;
	}
	public String getTensv() {
		return tensv;
	}
	public void setTensv(String tensv) {
		this.tensv = tensv;
	}
	public String getTenphong() {
		return tenphong;
	}
	public void setTenphong(String tenphong) {
		this.tenphong = tenphong;
	}
	public String getNha() {
		return nha;
	}
	public void setNha(String nha) {
		this.nha = nha;
	}
	private String diachibt;
	private String masv;
	private String tensv;
	private String tenphong;
	private String nha;
	public String getManv() {
		return manv;
	}
	public void setManv(String manv) {
		this.manv = manv;
	}
	public String getMatkhau() {
		return matkhau;
	}
	public void setMatkhau(String matkhau) {
		this.matkhau = matkhau;
	}
	public String getTennv() {
		return tennv;
	}
	public void setTennv(String tennv) {
		this.tennv = tennv;
	}
	public String getGioitinh() {
		return gioitinh;
	}
	public void setGioitinh(String gioitinh) {
		this.gioitinh = gioitinh;
	}
	public String getNgaysinh() {
		return ngaysinh;
	}
	public void setNgaysinh(String ngaysinh) {
		this.ngaysinh = ngaysinh;
	}
	public String getSocccd() {
		return socccd;
	}
	public void setSocccd(String socccd) {
		this.socccd = socccd;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	
	
	public String getTennh() {
		return tennh;
	}
	public void setTennh(String tennh) {
		this.tennh = tennh;
	}
	public String getTencha() {
		return tencha;
	}
	public void setTencha(String tencha) {
		this.tencha = tencha;
	}
	public String getNgaycha() {
		return ngaycha;
	}
	public void setNgaycha(String ngaycha) {
		this.ngaycha = ngaycha;
	}
	public String getTenme() {
		return tenme;
	}
	public void setTenme(String tenme) {
		this.tenme = tenme;
	}
	public String getNgayme() {
		return ngayme;
	}
	public void setNgayme(String ngayme) {
		this.ngayme = ngayme;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getChucvu() {
		return chucvu;
	}
	public void setChucvu(String chucvu) {
		this.chucvu = chucvu;
	}
	public String getTennguoibt() {
		return tennguoibt;
	}
	public void setTennguoibt(String tennguoibt) {
		this.tennguoibt = tennguoibt;
	}
	public String getQuanhe() {
		return quanhe;
	}
	public void setQuanhe(String quanhe) {
		this.quanhe = quanhe;
	}
	
	public String getDiachibt() {
		return diachibt;
	}
	public void setDiachibt(String diachibt) {
		this.diachibt = diachibt;
	}
	public String getStk() {
		return stk;
	}
	public void setStk(String stk) {
		this.stk = stk;
	}
	public Staff(String manv, String tennv, String gioitinh, String ngaysinh, String socccd, String diachi, String sdt,
			String stk, String tennh, String tencha, String ngaycha, String tenme, String ngayme, String email,
			String chucvu, String tennguoibt, String quanhe, String sdtbt, String diachibt) {
		super();
		this.manv = manv;
		this.tennv = tennv;
		this.gioitinh = gioitinh;
		this.ngaysinh = ngaysinh;
		this.socccd = socccd;
		this.diachi = diachi;
		this.sdt = sdt;
		this.stk = stk;
		this.tennh = tennh;
		this.tencha = tencha;
		this.ngaycha = ngaycha;
		this.tenme = tenme;
		this.ngayme = ngayme;
		this.email = email;
		this.chucvu = chucvu;
		this.tennguoibt = tennguoibt;
		this.quanhe = quanhe;
		this.sdtbt = sdtbt;
		this.diachibt = diachibt;
	}
	
	
	

}
