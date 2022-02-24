package model.bo;

import java.sql.Date;
import java.util.ArrayList;

import model.bean.Staff;
import model.dao.CheckLoginStaffDAO;

public class StaffBO {
	CheckLoginStaffDAO checkLoginStaffDao = new CheckLoginStaffDAO();
	public boolean capnhatycsc(String values)
	{
	return checkLoginStaffDao.capnhatycsc(values);
	}
	public ArrayList < Staff> CPhong()
	{
		return checkLoginStaffDao.CPhong();
	}
	public ArrayList<Staff> TimkiemQLCP(String values){
		return checkLoginStaffDao.TimkiemQLCP(values);
	}
	public ArrayList < Staff> TraPhong()
	{
		return checkLoginStaffDao.TraPhong();
	}
	public void capnhatphiThue(String ngay, int id) {
		checkLoginStaffDao.capnhatphiThue(ngay, id);
	}
	public ArrayList<Staff> TimkiemQLTP(String values) {
		return checkLoginStaffDao.TimkiemQLTP(values);
	}
	public boolean capnhatdk(String values) {
		return checkLoginStaffDao.capnhatdk(values);
	}
	public boolean capnhatcp(String values) {
		return checkLoginStaffDao.capnhatcp(values);
	}
	public ArrayList < Staff> TTPhong(){
		return checkLoginStaffDao.TTPhong();
	}
	public ArrayList<Staff> thongtinchitiet(String idphong){
		return checkLoginStaffDao.thongtinchitiet(idphong);
	}
	public ArrayList<Staff> Timkiemthongtinchitiet(String idphong,String values){
		return checkLoginStaffDao.Timkiemthongtinchitiet(idphong, values);
	}
	public ArrayList < Staff> TienDienNuoc(){
		return checkLoginStaffDao.TienDienNuoc();
	}
	public ArrayList < Staff> TimkiemTienDienNuoc(String values,String nha){
		return checkLoginStaffDao.TimkiemTienDienNuoc(values,nha );
	}
	public void capnhatphiDN(String nguoiNop, String ngayNop, int id) {
		checkLoginStaffDao.capnhatphiDN(nguoiNop, ngayNop, id);
	}
	public boolean capnhatthanhtoan(String values) {
		return checkLoginStaffDao.capnhatthanhtoan(values);
	}
	public boolean capnhatngaynop(String values,String iddiennuoc) {
		return checkLoginStaffDao.capnhatngaynop(values, iddiennuoc);
	}
	public ArrayList<Staff> TimkiemTTPhong(String nha)
	{
		return checkLoginStaffDao.TimkiemTTPhong(nha);
	}
	public ArrayList < Staff> YCSC()
	{
	return checkLoginStaffDao.YCSC();
	}
	public ArrayList < Staff> TimKiemYCSC(String value)
	{
	return checkLoginStaffDao.TimKiemYCSC(value);
	}
	public ArrayList < Staff> TimKiemthangnamdiennc(String nha, String thang){
		return checkLoginStaffDao.TimKiemthangnamdiennc(nha, thang);
	}
	 public boolean UpdateTTCN(String manv, String diachi, String sdt,String stk,String tennh,String tencha,String ngaysinhcha,String tenme,String ngaysinhme, String email,String chucvu,String tennguoibt ,String quanhe,String sdtbt,String diachibt)
	    {
	        return checkLoginStaffDao.UpdateTTCN(manv, diachi, sdt, stk, tennh, tencha, ngaysinhcha, tenme, ngaysinhme, email, chucvu, tennguoibt, quanhe, sdtbt, diachibt);
	    }
	 public boolean DoiMatKhau(String manv, String mk)
	 {
	 return checkLoginStaffDao.DoiMatKhau(manv, mk);
	 }
	 public boolean DangThongBao(String manv, Date date, String tieude, String noidung)
	 {
	 return checkLoginStaffDao.DangThongBao(manv, date, tieude, noidung);
	 }
	 public ArrayList<Staff> PhiThuePhong()
	    {
	        return checkLoginStaffDao.PhiThuePhong();
	    }
	    public ArrayList<Staff> TimkiemPhiThuePhong(String namhoc,int hocky)
	    {
	        return checkLoginStaffDao.TimkiemPhiThuePhong(namhoc, hocky);
	    }
	    public boolean UpdatePhiThuePhong(String ngaynop, String masv)
	    {
	        return checkLoginStaffDao.UpdatePhiThuePhong(ngaynop, masv);
	    }
	    public ArrayList<Staff> timkiemPhiThuePhongMsv(String masv,String namhoc,int hocky) {
	    	return checkLoginStaffDao.timkiemPhiThuePhongMsv(masv, namhoc, hocky);
	    }
	    public ArrayList < Staff> TimKiemThongKe(String nam)
	    {
	        return checkLoginStaffDao.TimKiemThongKe(nam);
	    }
	    public ArrayList < Staff> ThongKe()
	    {
	        return checkLoginStaffDao.ThongKe();
	    }
	    public boolean UpdateTraPhong() {
	    	return checkLoginStaffDao.UpdateTraPhong();
	    }
}
