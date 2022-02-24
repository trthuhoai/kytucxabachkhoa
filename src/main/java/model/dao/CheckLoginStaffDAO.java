package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


import model.bean.Staff;

public class CheckLoginStaffDAO {
	
	public boolean isExistUser(String userName, String password) {
		try {
			Connect cnConnect=new Connect();
			Connection conn = cnConnect.getConn();
			Statement stmt = conn.createStatement();
			String queryString = "select * from nhanvienquanly where MaNV=\'" + userName + "\'and MatKhau=\'" + password + "\'";
			ResultSet rs = stmt.executeQuery(queryString);
			if (rs.next()) {
				conn.close();
				return true;
			} else {
				conn.close();
				return false;
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}
	public ArrayList<Staff> UpdateNV(String manv) {
		ArrayList<Staff> result = new ArrayList<Staff>();
		try {
			Connect cnConnect=new Connect();
			Connection conn = cnConnect.getConn();
			//System.out.print("hhhjjjj123444");
			String sql = "select * from nhanvienquanly where  manv=?";
			PreparedStatement ps = conn.prepareStatement(sql);
		    ps.setString(1, manv);
		    ResultSet rs=ps.executeQuery();
			//System.out.print(rs.next());
		    while(rs.next()) {
				//System.out.print("hhhjjjj123444");
				String tennv=rs.getString("TenNV");
				//System.out.print(tennv);
				String gioitinh=rs.getString("GioiTinh");
				//System.out.print(gioitinh);
				String ngaysinh=rs.getString("NgaySinh");
				String socccd=rs.getString("SoCCCD");
				String diachi=rs.getString("DiaChi");
				String sdt=rs.getString("SDT");
				String stk=rs.getString("SoTaiKhoan");
				String tennh=rs.getString("NganHang");
				String tencha=rs.getString("TenCha");
				String ngaycha=rs.getString("NgaySinhCha");
				String tenme=rs.getString("TenMe");
				String ngayme=rs.getString("NgaySinhMe");
				String email=rs.getString("Email");
				String chucvu=rs.getString("ChucVu");
				String tennguoibt=rs.getString("TenNguoiBaoTin");
				String quanhe=rs.getString("QuanHeNguoiBaoTin");
				String sdtbt=rs.getString("SDTNguoiBaoTin");
				String diachibt=rs.getString("DiaChiNguoiBaoTin");
//				System.out.print(ngaysinh);
//				System.out.print(ngaysinh);System.out.print(socccd);
//				System.out.print(diachi);
//				System.out.print(sdt);
//				System.out.print(tennh);
//				System.out.print(tencha);
//				System.out.print(ngaycha);
//				System.out.print(tenme);
//				System.out.print(ngayme);
//				System.out.print(email);
//				System.out.print(chucvu);
//				System.out.print(tennguoibt);
//				System.out.print(sdtbt);
//				System.out.print(quanhe);
//				System.out.print(diachibt);
				//result.add(new Staff(manv, tennv, gioitinh, ngaysinh, socccd, diachi, sdt, stk, tennh, tencha, ngaycha, tenme, ngayme, email, chucvu, tennguoibt, quanhe, sdtbt, diachibt));
				result.add(new Staff(manv, tennv, gioitinh, ngaysinh, socccd, diachi, sdt, stk, tennh, tencha, ngaycha, tenme, ngayme, email, chucvu, tennguoibt, quanhe, sdtbt, diachibt));
//				for (int i = 0; i < result.size(); i++) {
//			            System.out.println(result.get(i));
//			        }
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return result;
	
	}
	public boolean DoiMatKhau(String manv, String password) {
		boolean check = false;
		try {
		System.out.print("goi doi mk");
		Connect cnConnect=new Connect();
		Connection conn1 = cnConnect.getConn();
		Statement stmt = conn1.createStatement();
		String queryString = "update nhanvienquanly set MatKhau='"+password+"' where MaNV='"+manv+"'";

		check = stmt.executeUpdate(queryString) >0;

		// close connection
		conn1.close();
		} catch (Exception ex) {
		ex.printStackTrace();
		}
		System.out.print("Doi xong");
		return check;
		}
	public boolean DangThongBao(String manv, Date date, String tieude, String noidung) {
	boolean check = false;
	try {
	Connect cnConnect=new Connect();
	Connection conn1 = cnConnect.getConn();
	Statement stmt = conn1.createStatement();
	String queryString = "insert into thongbao set MaNV='"+manv+"' , Ngay = '"+date+"', TieuDe= '"+tieude+"', NoiDung ='"+noidung+"' , MaAdmin ='' ";
	check = stmt.executeUpdate(queryString) >0;
	// close connection
	conn1.close();
	} catch (Exception ex) {
	ex.printStackTrace();
	}
	System.out.print("dang xong");
	return check;
	}


	public boolean UpdateTTCN(String manv, String diachi, String sdt,String stk,String tennh,String tencha,String ngaysinhcha,String tenme,String ngaysinhme, String email,String chucvu,String tennguoibt ,String quanhe,String sdtbt,String diachibt)
	{
	boolean rowUpdated =false;
	try {
	Connect cnConnect=new Connect();
	Connection conn = cnConnect.getConn();
	String sql = "UPDATE nhanvienquanly SET DiaChi=\'"+diachi+"\',SDT=\'"+sdt+"\', SoTaiKhoan = \'"+stk+"\', NganHang=\'"+tennh+"\', TenCha=\'"+tencha+"\', NgaySinhCha=\'"+ngaysinhcha+"\', TenMe=\'"+tenme+"\', NgaySinhMe=\'"+ngaysinhme+"\', Email=\'"+email+"\', ChucVu=\'"+chucvu+"\', TenNguoiBaoTin=\'"+ tennguoibt+"\', QuanHeNguoiBaoTin=\'"+quanhe+"\', SDTNguoiBaoTin=\'"+sdtbt+"\', DiaChiNguoiBaoTin=\'"+diachibt+"\' where MaNV=\'" +manv+ "\'";
	PreparedStatement pstmt = conn.prepareStatement(sql);
	rowUpdated = pstmt.executeUpdate()>0;

	} catch (Exception ex) {
	ex.printStackTrace();
	}
	System.out.println(rowUpdated);
	return rowUpdated;
	}
	public ArrayList<Staff> DanhSachCPSV() {
		ArrayList<Staff> result = new ArrayList<Staff>();
		try {
			Connect cnConnect=new Connect();
			Connection conn = cnConnect.getConn();
			String sql = "SELECT sinhvien.MaSV,sinhvien.TenSV,phong.Phong,phong.Nha,dangkyphong.ChapNhan FROM dangkyphong INNER JOIN sinhvien ON dangkyphong.MaSV = sinhvien.MaSV INNER JOIN phong ON dangkyphong.IDPhong= phong.IDPhong where dangkyphong.ChapNhan='0'";
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			while (rs.next()) {
				String masv=rs.getString("MaSV");
				//System.out.print(masv);
				String tensv=rs.getString("TenSV");
				String tenphong=rs.getString("Phong");
				String nha=rs.getString("Nha");
				String chapnhan=rs.getString("ChapNhan");
				
				result.add(new Staff(chapnhan, masv, tensv, tenphong, nha));
			
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return result;
	
	}
	public ArrayList < Staff> TTPhong()
	{
		ArrayList <Staff> users = new ArrayList<>();

		try {
				Connect cnConnect=new Connect();
				Connection conn = cnConnect.getConn();		
				PreparedStatement preparedStatement = conn.prepareStatement("select * from phong");
				ResultSet rs = preparedStatement.executeQuery();
		    
            while (rs.next()) {
            	String idp=rs.getString("IDPhong");
                String tenphong = rs.getString("Phong");
                int sLSVDangLuuTru = rs.getInt("SLuongSVDangLuuTru");
                String gioitinh = rs.getString("Nam");
                String nha = rs.getString("Nha");
                System.out.println(nha);
                users.add(new Staff(sLSVDangLuuTru, idp, gioitinh, tenphong, nha));
            }
            for (Staff o : users) {
                System.out.println(o);
            }
            
        } catch (Exception ex) {
			ex.printStackTrace();
		}
		return users;       
    }
	public ArrayList<Staff> TimkiemCPSV(String values) {
		ArrayList<Staff> result = new ArrayList<Staff>();
		try {
			Connect cnConnect=new Connect();
			Connection conn = cnConnect.getConn();
			System.out.print("hhhjjjj123444");
			String sql = "SELECT sinhvien.MaSV,sinhvien.TenSV,phong.Phong,phong.Nha,dangkyphong.ChapNhan FROM dangkyphong INNER JOIN sinhvien ON dangkyphong.MaSV = sinhvien.MaSV INNER JOIN phong ON dangkyphong.IDPhong= phong.IDPhong where (sinhvien.MaSV LIKE'%"+values+"%'or sinhvien.tensv LIKE '%" +values+ "%'or phong.Phong LIKE'%"+values+"%'or phong.nha LIkE'%"+values+"%')and dangkyphong.ChapNhan='0'";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String masv=rs.getString("MaSV");
				System.out.print(masv);
				String tensv=rs.getString("TenSV");
				String tenphong=rs.getString("Phong");
				String nha=rs.getString("Nha");
				String chapnhan=rs.getString("ChapNhan");
				System.out.print(tensv);
				System.out.print(tenphong);
				result.add(new Staff(chapnhan, masv, tensv, tenphong, nha));
			
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return result;
	
	}
	public ArrayList<Staff> thongtinchitiet(String idphong) {
		ArrayList<Staff> result = new ArrayList<Staff>();
		try {
			Connect cnConnect=new Connect();
			Connection conn = cnConnect.getConn();
			//System.out.print("hhhjjjj123444");
			String sql = "SELECT MaSV,TenSV,SDT,Lop,Nganh,SoCCCD,SoTaiKhoan,NganHang,DiaChi FROM sinhvien WHERE IDPhong=\'"+ idphong+"\'";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			System.out.print("qeerrrr");
			while (rs.next()) {
				String masv=rs.getString("MaSV");
				System.out.print(masv);
				String tensv=rs.getString("TenSV");
				String sdt=rs.getString("SDT");
				String lop=rs.getString("Lop");
				String nganh=rs.getString("Nganh");
				String socccd=rs.getString("SoCCCD");
				String stk=rs.getString("SoTaiKhoan");
				String tennh=rs.getString("NganHang");
				String diachi=rs.getString("DiaChi");
				System.out.print(tensv);
				//System.out.print(tenphong);
				result.add(new Staff(lop, nganh, socccd, diachi, sdt, stk, tennh, masv, tensv));
			
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return result;
	
	}
	public ArrayList<Staff> Timkiemthongtinchitiet(String idphong,String values) {
		ArrayList<Staff> result = new ArrayList<Staff>();
		try {
			Connect cnConnect=new Connect();
			Connection conn = cnConnect.getConn();
			//System.out.print("hhhjjjj123444");
			String sql = "SELECT MaSV,TenSV,SDT,Lop,Nganh,SoCCCD,SoTaiKhoan,NganHang,DiaChi FROM sinhvien WHERE (MaSV LIKE'%"+values+"%' or TenSV LIKE '%"+values+"%' or Lop LIKE '%"+ values+"%' or Nganh LIKE'%"+values+"%' or SoCCCD LIKE'%"+values+"%' or SoTaiKhoan LIKE'%"+values+"%' or NganHang LIKE'%"+values+"%' or DiaChi LIKE'%"+values+"%') and IDPhong=\'"+ idphong+"\'";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			System.out.print("qeerrrr");
			while (rs.next()) {
				String masv=rs.getString("MaSV");
				System.out.print(masv);
				String tensv=rs.getString("TenSV");
				String sdt=rs.getString("SDT");
				String lop=rs.getString("Lop");
				String nganh=rs.getString("Nganh");
				String socccd=rs.getString("SoCCCD");
				String stk=rs.getString("SoTaiKhoan");
				String tennh=rs.getString("NganHang");
				String diachi=rs.getString("DiaChi");
				System.out.print(tensv);
				//System.out.print(tenphong);
				result.add(new Staff(lop, nganh, socccd, diachi, sdt, stk, tennh, masv, tensv));
			
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return result;
	
	}
	public ArrayList < Staff> CPhong()
	{	  
		ArrayList <Staff> users = new ArrayList<>();
		try {
				Connect cnConnect=new Connect();
				Connection conn = cnConnect.getConn();		
				String sql = "select sinhvien.MaSV, sinhvien.TenSV, phong.Nha, phong.Phong, dangkychuyenphong.IDPhong,dangkychuyenphong.NgayChuyen,dangkychuyenphong.ChapNhan FROM sinhvien INNER JOIN  dangkychuyenphong ON sinhvien.MaSV = dangkychuyenphong.MaSV INNER JOIN phong ON phong.IDPhong = sinhvien.IDPhong where dangkychuyenphong.ChapNhan='0'";
				Statement stmt=conn.createStatement();
				ResultSet rs=stmt.executeQuery(sql);
            while (rs.next()) {
                   String masv = rs.getString("MaSV");
                   String tensv = rs.getString("TenSV");    
                 String tenphong = rs.getString("Phong");                 
                 String nha = rs.getString("Nha");
                  String idp_new = rs.getString("IDPhong");              
                  String ngaychuyen = rs.getString("NgayChuyen");
                  String chapnhan= rs.getString("ChapNhan");                 
                  System.out.println(masv);
                 users.add(new Staff(idp_new, ngaychuyen, chapnhan, masv, tensv, tenphong, nha));  
               }
               for (Staff o : users) {
                   System.out.println(o);
               }          
         } catch (Exception ex) {
			ex.printStackTrace();
		}
		return users;       
    }
	public ArrayList < Staff> TienDienNuoc()
	{	  
		ArrayList <Staff> users = new ArrayList<>();
		try {
				Connect cnConnect=new Connect();
				Connection conn = cnConnect.getConn();	
//				String sql = "select phong.Phong,phong.Nha,tiendiennuoc.TongTien,tiendiennuoc.ThoiHan ,tiendiennuoc.TrangThai,tiendiennuoc.IDPhiDienNuoc FROM tiendiennuoc INNER JOIN  phong ON phong.IDPhong=tiendiennuoc.IDPhong where tiendiennuoc.TrangThai='0'"; 
				String sql = "select phong.Phong,phong.Nha,tiendiennuoc.TongTien,tiendiennuoc.ThoiHan ,tiendiennuoc.TrangThai,tiendiennuoc.IDPhiDienNuoc, tiendiennuoc.NgayNop, tiendiennuoc.NguoiNop, tiendiennuoc.IDPhiDienNuoc  FROM tiendiennuoc INNER JOIN  phong ON phong.IDPhong=tiendiennuoc.IDPhong"; 
				Statement stmt=conn.createStatement();
				ResultSet rs=stmt.executeQuery(sql);
            while (rs.next()) {
            	String idpdnuoc=rs.getString("IDPhiDienNuoc");
                   String tenphong = rs.getString("Phong");
                   String nha = rs.getString("Nha");    
                 String tiendiennuoc = rs.getString("TongTien");                 
                 Date thoihan = rs.getDate("ThoiHan");         
                   String chapnhan= rs.getString("TrangThai");                 
                   String nguoiNop=rs.getString("NguoiNop");
                   Date ngayNop= null;
                   int id=rs.getInt("IDPhiDienNuoc");
                		   
                	try {
						ngayNop=  rs.getDate("NgayNop");
					} catch (Exception e) {
						// TODO: handle exception
					}	 
                 
                 users.add(new Staff(idpdnuoc, tiendiennuoc, thoihan, chapnhan, tenphong, nha,nguoiNop,ngayNop, id));  
               }
               for (Staff o : users) {
                   System.out.println(o);
               }          
         } catch (Exception ex) {
			ex.printStackTrace();
		}
		return users;       
    }
	public ArrayList < Staff> TimkiemTienDienNuoc(String values,String nha)
	{	  
		ArrayList <Staff> users = new ArrayList<>();
		try {
				Connect cnConnect=new Connect();
				Connection conn = cnConnect.getConn();		
				String sql = "select phong.Phong,phong.Nha,tiendiennuoc.TongTien,tiendiennuoc.ThoiHan ,tiendiennuoc.TrangThai,tiendiennuoc.IDPhiDienNuoc, tiendiennuoc.NgayNop, tiendiennuoc.NguoiNop, tiendiennuoc.IDPhiDienNuoc FROM tiendiennuoc INNER JOIN  phong ON phong.IDPhong=tiendiennuoc.IDPhong Where phong.Phong like'%"+values+"'"; 
				Statement stmt=conn.createStatement();
				ResultSet rs=stmt.executeQuery(sql);
            while (rs.next()) {
            	String idpdnuoc=rs.getString("IDPhiDienNuoc");
                   String tenphong = rs.getString("Phong");
                   String nha1 = rs.getString("Nha");    
                 String tiendiennuoc = rs.getString("TongTien");                 
                 Date thoihan = rs.getDate("ThoiHan");         
                   String chapnhan= rs.getString("TrangThai");   
                   String nguoiNop=rs.getString("NguoiNop");
                   Date ngayNop=rs.getDate("NgayNop");
                   int phi=rs.getInt("IDPhiDienNuoc");
                 
                 users.add(new Staff(idpdnuoc, tiendiennuoc, thoihan, chapnhan, tenphong, nha1,nguoiNop,ngayNop,phi));  
               }
               for (Staff o : users) {
                   System.out.println(o);
               }          
         } catch (Exception ex) {
			ex.printStackTrace();
		}
		return users;       
    }
	public ArrayList<Staff> TimkiemQLCP(String values) {
		ArrayList<Staff> result = new ArrayList<Staff>();
		try {
			Connect cnConnect=new Connect();
			Connection conn = cnConnect.getConn();
			String sql = "select sinhvien.MaSV, sinhvien.TenSV, phong.Nha, phong.Phong, dangkychuyenphong.IDPhong,dangkychuyenphong.NgayChuyen,dangkychuyenphong.ChapNhan FROM sinhvien INNER JOIN  dangkychuyenphong ON sinhvien.MaSV = dangkychuyenphong.MaSV INNER JOIN phong ON phong.IDPhong = sinhvien.IDPhong where (sinhvien.MaSV LIKE'%"+values+"%'or sinhvien.tensv LIKE'%" +values+ "%'or phong.Phong LIKE'%"+values+"%'or phong.nha LIKE'%"+values+"%') and dangkychuyenphong.ChapNhan='0'";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			  while (rs.next()) {
                  String masv = rs.getString("MaSV");
                  String tensv = rs.getString("TenSV");    
                String tenphong = rs.getString("Phong");                 
                String nha = rs.getString("Nha");
                 String idp_new = rs.getString("IDPhong");              
                 String ngaychuyen = rs.getString("NgayChuyen");
                  String chapnhan= rs.getString("ChapNhan");                 
                  System.out.println(masv);
                  result.add(new Staff(idp_new, ngaychuyen, chapnhan, masv, tensv, tenphong, nha));  
              }

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return result;
	
	}
	public ArrayList < Staff> TraPhong()
	{	  
		ArrayList <Staff> users = new ArrayList<>();
		try {
				Connect cnConnect=new Connect();
				Connection conn = cnConnect.getConn();		
				String sql = "select sinhvien.MaSV, sinhvien.TenSV, phong.Nha, phong.Phong, dangkytraphong.NgayTraPhong, dangkytraphong.LyDoTraPhong FROM sinhvien INNER JOIN  dangkytraphong ON sinhvien.MaSV = dangkytraphong.MaSV INNER JOIN phong ON phong.IDPhong = sinhvien.IDPhong";
				Statement stmt=conn.createStatement();
				ResultSet rs=stmt.executeQuery(sql);
            while (rs.next()) {
		         String masv = rs.getString("MaSV");
		         String tensv = rs.getString("TenSV");    
                 String tenphong = rs.getString("Phong");                 
                 String nha = rs.getString("Nha");
                 String ngaytraphong = rs.getString("NgayTraPhong");
                 String lydotra = rs.getString("LyDoTraPhong");              
                   System.out.println(masv);
                 users.add(new Staff(ngaytraphong, lydotra, masv, tensv, nha, tenphong));  
               }
               for (Staff o : users) {
                   System.out.println(o);
               }          
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return users;       
    }
	public void capnhatphiDN(String nguoiNop, String ngayNop, int id)
	{	  
		try {
			Connect cnConnect=new Connect();
			Connection conn1 = cnConnect.getConn();
			Statement stmt = conn1.createStatement();
			String queryString = "update tiendiennuoc set NguoiNop='"+nguoiNop+"', NgayNop='"+ngayNop+"',TrangThai='"+1+"' where IDPhiDienNuoc='"+id+"'";		
			stmt.executeUpdate(queryString);
			// show data
			// close connection
			conn1.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
     
    }
	public boolean capnhatdk(String values)
	{	  
		boolean rowUpdated =false;
		String[] st1= values.split(",");
		try {
				Connect cnConnect=new Connect();
				Connection conn = cnConnect.getConn();	
				 for (int i = 0; i < st1.length; i++) {
					String masv=st1[i];
					System.out.print(masv);
					String sql = "UPDATE dangkyphong SET ChapNhan='1' where MaSV=\'" +masv+ "\'"; 
			PreparedStatement pstmt = conn.prepareStatement(sql);
			 rowUpdated = pstmt.executeUpdate()>0;

				 }
				   
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		System.out.println(rowUpdated);
		return rowUpdated;       
    }
	public boolean capnhatthanhtoan(String values)
	{	  
		boolean rowUpdated =false;
		String[] st1= values.split(",");
		try {
				Connect cnConnect=new Connect();
				Connection conn = cnConnect.getConn();	
				 for (int i = 0; i < st1.length; i++) {
					String iddiennc=st1[i];
					//System.out.print(iddiennc);
					String sql = "UPDATE tiendiennuoc SET TrangThai='1' where IDPhiDienNuoc=\'" +iddiennc+ "\'"; 
			PreparedStatement pstmt = conn.prepareStatement(sql);
			 rowUpdated = pstmt.executeUpdate()>0;

				 }
				   
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		System.out.println(rowUpdated);
		return rowUpdated;       
    }
	public boolean capnhatngaynop(String values,String iddc)
	{	  
		boolean rowUpdated =false;
		String[] st1= values.split(",");
		String[] st2= iddc.split(",");
		try {
				Connect cnConnect=new Connect();
				Connection conn = cnConnect.getConn();	
				 for (int i = 0; i < st2.length; i++) {
					String ngaynop=st1[i];
					String iddiennuoc=st2[i];
						
						//	System.out.println(ngaynop);
							String sql = "UPDATE tiendiennuoc SET NgayNop=? where IDPhiDienNuoc=\'" +iddiennuoc+ "\'"; 
							System.out.println(iddiennuoc);
							System.out.println(i);
							PreparedStatement pstmt = conn.prepareStatement(sql);
							pstmt.setString(1, ngaynop);
							 rowUpdated = pstmt.executeUpdate()>0;

					}
					
				
			
				// }
				   
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		System.out.println(rowUpdated);
		return rowUpdated;       
    }
	public ArrayList<Staff> YCSC()
	{
	//and YEAR(ThoiGianDK) ='2022'
	ArrayList <Staff> users = new ArrayList<>();
	try {
	Connect cnConnect=new Connect();
	Connection conn = cnConnect.getConn();
	String sql = "select *from suachua, phong where phong.IDPhong= suachua.IDPhong order by suachua.IDDeXuat DESC ";
	Statement stmt=conn.createStatement();
	ResultSet rs=stmt.executeQuery(sql);
	while (rs.next()) {
	String noidung = rs.getString("NoiDung");
	String tenphong = rs.getString("Phong");
	String nha = rs.getString("Nha");
	String thoigian = rs.getString("ThoigianDK");
	String deXuat=rs.getString("DeXuat");
	String ghiChu=rs.getString("GhiChu");
	int tinhTrang=rs.getInt("TinhTrang");
	int idSC=rs.getInt("IDDeXuat");

	users.add(new Staff(nha, tenphong, noidung, thoigian,deXuat,ghiChu,tinhTrang,idSC));
	}
	for (Staff o : users) {
	System.out.println(o);
	}
	} catch (Exception ex) {
	ex.printStackTrace();
	}
	return users;
	}
	public boolean capnhatycsc(String values)
	{	  
		boolean rowUpdated =false;
		String[] st1= values.split(",");
		try {
				Connect cnConnect=new Connect();
				Connection conn = cnConnect.getConn();	
				 for (int i = 0; i < st1.length; i++) {
					String idp=st1[i];
					System.out.print("hihi"+idp);
					String sql = "UPDATE suachua SET TinhTrang='1' where IDDeXuat=\'" +idp+ "\'"; 
					//String sql1="UPDATE sinhvien SET IDPhong=(SELECT IDPhong FROM dangkychuyenphong WHERE sinhvien.MaSV=dangkychuyenphong.MaSV) where MaSV=\'" +masv+ "\'";
			PreparedStatement pstmt = conn.prepareStatement(sql);
		//	PreparedStatement pstmt1 = conn.prepareStatement(sql1);
			 rowUpdated = pstmt.executeUpdate()>0;
			// rowUpdated = pstmt1.executeUpdate()>0;

				 }
				   
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		System.out.println(rowUpdated);
		return rowUpdated;       
    }
	public ArrayList < Staff> TimKiemYCSC(String value)
	{
	//and YEAR(ThoiGianDK) ='2022'
	ArrayList <Staff> users = new ArrayList<>();
	try {
	Connect cnConnect=new Connect();
	Connection conn = cnConnect.getConn();
	String sql = "select *from suachua, phong where phong.IDPhong= suachua.IDPhong and phong.phong=\'"+value+"\'";
//	String sql = "select *from suachua, phong where phong.IDPhong= suachua.IDPhong and (( YEAR(ThoiGianDK) =\'"+nam+"\' and MONTH(ThoiGianDK) =\'"+thang+"\') and phong.nha=\'"+nha+"\') ";
	Statement stmt=conn.createStatement();
	ResultSet rs=stmt.executeQuery(sql);
	while (rs.next()) {
	String noidung = rs.getString("NoiDung");
	String tenphong = rs.getString("Phong");
	// String nha = rs.getString("Nha");
	String thoigian = rs.getString("ThoigianDK");
	String nha = rs.getString("Nha");
	String deXuat=rs.getString("DeXuat");
	String ghiChu=rs.getString("GhiChu");
	int tinhTrang=rs.getInt("TinhTrang");
	int idSC=rs.getInt("IDDeXuat");

	users.add(new Staff(nha, tenphong, noidung, thoigian,deXuat,ghiChu,tinhTrang,idSC));
	}
	for (Staff o : users) {
	System.out.println(o);
	}
	} catch (Exception ex) {
	ex.printStackTrace();
	}
	return users;
	}
//	public ArrayList < Staff> TimKiemthangnamdiennc(String nha, int thang, int nam)
//	{
//	//and YEAR(ThoiGianDK) ='2022'
//	ArrayList <Staff> users = new ArrayList<>();
//	try {
//	Connect cnConnect=new Connect();
//	Connection conn = cnConnect.getConn();
//	//String sql = "select *from suachua, phong where phong.IDPhong= suachua.IDPhong and (( YEAR(ThoiGianDK) =\'"+nam+"\' and MONTH(ThoiGianDK) =\'"+thang+"\') and phong.nha=\'"+nha+"\') ";
//	String sql = "select phong.Phong,phong.Nha,tiendiennuoc.TongTien,tiendiennuoc.ThoiHan ,tiendiennuoc.TrangThai,tiendiennuoc.IDPhiDienNuoc FROM tiendiennuoc INNER JOIN  phong ON phong.IDPhong=tiendiennuoc.IDPhong where tiendiennuoc.TrangThai='0' and (( YEAR(ThoiGian) =\'"+nam+"\' and MONTH(ThoiGian) =\'"+thang+"\') and phong.nha=\'"+nha+"\')"; 
//	Statement stmt=conn.createStatement();
//	ResultSet rs=stmt.executeQuery(sql);
//	   while (rs.next()) {
//       	String idpdnuoc=rs.getString("IDPhiDienNuoc");
//              String tenphong = rs.getString("Phong");
//            //  String nha = rs.getString("Nha");    
//            String tiendiennuoc = rs.getString("TongTien");                 
//            Date thoihan = rs.getDate("ThoiHan");         
//              String chapnhan= rs.getString("TrangThai");                 
//            
//            users.add(new Staff(idpdnuoc, tiendiennuoc, thoihan, chapnhan, tenphong, nha));  
//	}
//	for (Staff o : users) {
//	System.out.println(o);
//	}
//	} catch (Exception ex) {
//	ex.printStackTrace();
//	}
//	return users;
//	}
	public ArrayList < Staff> TimKiemthangnamdiennc(String nha, String thang)
	{
	//and YEAR(ThoiGianDK) ='2022'
	ArrayList <Staff> users = new ArrayList<>();
	try {
	Connect cnConnect=new Connect();
	Connection conn = cnConnect.getConn();
	//String sql = "select *from suachua, phong where phong.IDPhong= suachua.IDPhong and (( YEAR(ThoiGianDK) =\'"+nam+"\' and MONTH(ThoiGianDK) =\'"+thang+"\') and phong.nha=\'"+nha+"\') ";
	String sql = "";
	if(thang!="") {
		sql="select phong.Phong,phong.Nha,tiendiennuoc.TongTien,tiendiennuoc.ThoiHan ,tiendiennuoc.TrangThai,tiendiennuoc.IDPhiDienNuoc, tiendiennuoc.NgayNop, tiendiennuoc.NguoiNop FROM tiendiennuoc INNER JOIN  phong ON phong.IDPhong=tiendiennuoc.IDPhong where tiendiennuoc.ThoiGian='"+thang+"'and phong.nha=\'"+nha+"\'"; 
	}
	else {
		sql="select phong.Phong,phong.Nha,tiendiennuoc.TongTien,tiendiennuoc.ThoiHan ,tiendiennuoc.TrangThai,tiendiennuoc.IDPhiDienNuoc, tiendiennuoc.NgayNop, tiendiennuoc.NguoiNop, tiendiennuoc.IDPhiDienNuoc FROM tiendiennuoc INNER JOIN  phong ON phong.IDPhong=tiendiennuoc.IDPhong where phong.nha=\'"+nha+"\'"; 
	}
	Statement stmt=conn.createStatement();
	ResultSet rs=stmt.executeQuery(sql);
	   while (rs.next()) {
       	String idpdnuoc=rs.getString("IDPhiDienNuoc");
              String tenphong = rs.getString("Phong");
            //  String nha = rs.getString("Nha");    
            String tiendiennuoc = rs.getString("TongTien");                 
            Date thoihan = rs.getDate("ThoiHan");         
              String chapnhan= rs.getString("TrangThai");   
              String nguoiNop=rs.getString("NguoiNop");
              Date ngayNop=null;
              try {
            	  System.out.println("NNNN"+rs.getDate("NgayNop"));
            	 ngayNop=rs.getDate("NgayNop");
			} catch (Exception e) {
				// TODO: handle exception
			}
             int id=rs.getInt("IDPhiDienNuoc");
             
            
            users.add(new Staff(idpdnuoc, tiendiennuoc, thoihan, chapnhan, tenphong, nha,nguoiNop,ngayNop,id));  
	}
	for (Staff o : users) {
	System.out.println(o);
	}
	} catch (Exception ex) {
	ex.printStackTrace();
	}
	return users;
	}
	public ArrayList<Staff> TimkiemTTPhong(String nha) {
		ArrayList<Staff> result = new ArrayList<Staff>();
		try {
			Connect cnConnect=new Connect();
			Connection conn = cnConnect.getConn();
			System.out.print("hhhjjjj123444");
			String sql = "SELECT *from  phong WHERE nha = \'"+nha+"\' ";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String idp=rs.getString("IDPhong");
                String tenphong = rs.getString("Phong");
                int sLSVDangLuuTru = rs.getInt("SLuongSVDangLuuTru");
                String gioitinh = rs.getString("Nam");
              // String nha1 = rs.getString("Nha");
                System.out.println(nha);
                result.add(new Staff(sLSVDangLuuTru, idp, gioitinh, tenphong, nha));
            }

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return result;
	
	}
	public boolean capnhatcp(String values)
	{	  
		boolean rowUpdated =false;
		String[] st1= values.split(",");
		try {
				Connect cnConnect=new Connect();
				Connection conn = cnConnect.getConn();	
				 for (int i = 0; i < st1.length; i++) {
					String masv=st1[i];
					System.out.print(masv);
					String sql = "UPDATE dangkychuyenphong SET ChapNhan='1' where MaSV=\'" +masv+ "\'"; 
					String sql1="UPDATE sinhvien SET IDPhong=(SELECT IDPhong FROM dangkychuyenphong WHERE sinhvien.MaSV=dangkychuyenphong.MaSV) where MaSV=\'" +masv+ "\'";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			PreparedStatement pstmt1 = conn.prepareStatement(sql1);
			 rowUpdated = pstmt.executeUpdate()>0;
			 rowUpdated = pstmt1.executeUpdate()>0;

				 }
				   
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		System.out.println(rowUpdated);
		return rowUpdated;       
    }
	public ArrayList<Staff> TimkiemQLTP(String values) {
		ArrayList<Staff> result = new ArrayList<Staff>();
		try {
			Connect cnConnect=new Connect();
			Connection conn = cnConnect.getConn();
			System.out.print("hhhjjjj123444");
			String sql = "select sinhvien.MaSV, sinhvien.TenSV, phong.Nha, phong.Phong, dangkytraphong.NgayTraPhong, dangkytraphong.LyDoTraPhong FROM sinhvien INNER JOIN  dangkytraphong ON sinhvien.MaSV = dangkytraphong.MaSV INNER JOIN phong ON phong.IDPhong = sinhvien.IDPhong where sinhvien.MaSV LIKE'%"+values+"%'or sinhvien.tensv LIKE'%" +values+ "%'or phong.Phong LIKE'%"+values+"%'or phong.nha LIKE'%"+values+"%'";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			 while (rs.next()) {
                 String masv = rs.getString("MaSV");
                 String tensv = rs.getString("TenSV");    
               String tenphong = rs.getString("Phong");                 
               String nha = rs.getString("Nha");
               String ngaytraphong = rs.getString("NgayTraPhong");
               String lydotra = rs.getString("LyDoTraPhong");              
                 System.out.println(masv);
                 result.add(new Staff(ngaytraphong, lydotra, masv, tensv, nha, tenphong));  
             }

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return result;
	
	}
	public boolean UpdatePhiThuePhong(String ngaynop, String masv)
	{
	boolean rowUpdated =false;
	//String[] st1= trangthai.split(",");
	String[] st2= ngaynop.split(",");
	String[] st3= masv.split(",");
	try {
	Connect cnConnect=new Connect();
	Connection conn = cnConnect.getConn();
	System.out.println("do dai "+ st2.length);
	for (int i = 0; i < st2.length; i++) {
	// String trangthai1=st1[i];
	String masv1=st3[i];
	String ngaynop1=st2[i];
	System.out.print(masv1);
	// if(ngaynop1.equals(""))
	// {
	// System.out.println(i+"rong roi") ;
	// continue;
	// }
	System.out.print("cap nhat nef");
	//System.out.print(ngaynop1);
	String sql = "UPDATE phithuephong SET TrangThai='1', NgayThanhToan=\'"+ngaynop1+"\' where MaSV=\'" +masv1+ "\'";
	PreparedStatement pstmt = conn.prepareStatement(sql);
	rowUpdated = pstmt.executeUpdate()>0;
	}
	} catch (Exception ex) {
	ex.printStackTrace();
	}
	System.out.println(rowUpdated);
	return rowUpdated;
	}
	public void capnhatphiThue(String ngay, int id) {
		try {
			Connect cnConnect=new Connect();
			Connection conn1 = cnConnect.getConn();
			Statement stmt = conn1.createStatement();
			String queryString = "update phithuephong set  NgayThanhToan='"+ngay+"',TrangThai='"+1+"' where IDPhiThue='"+id+"'";		
			stmt.executeUpdate(queryString);
			// show data
			// close connection
			conn1.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public ArrayList<Staff> TimkiemPhiThuePhong(String namhoc,int hocky) {
	ArrayList<Staff> result = new ArrayList<Staff>();
	try {
	Connect cnConnect=new Connect();
	Connection conn = cnConnect.getConn();
	String sql = "SELECT * FROM phithuephong,sinhvien where sinhvien.masv= phithuephong.masv and phithuephong.namhoc = \'"+namhoc+"\' and phithuephong.hocky=\'"+hocky+"\' ";
	Statement stmt=conn.createStatement();
	ResultSet rs=stmt.executeQuery(sql);
	while (rs.next()) {
	String masv=rs.getString("MaSV");
	//System.out.print(masv);
	int tongphi=rs.getInt("TongPhi");
	int trangthai=rs.getInt("TrangThai");
	int hinhthuc=rs.getInt("HinhThucNop");
	Date ngayTT=rs.getDate("NgayThanhToan");
	int id=rs.getInt("IDPhiThue");
	result.add(new Staff(hocky, namhoc, tongphi, masv,trangthai,hinhthuc,ngayTT,id));
	} } catch (Exception ex) {
	ex.printStackTrace();
	}
	return result;
	}
	public ArrayList<Staff> PhiThuePhong() {
	ArrayList<Staff> result = new ArrayList<Staff>();
	try {
	Connect cnConnect=new Connect();
	Connection conn = cnConnect.getConn();
//	String sql = "SELECT * FROM phithuephong,sinhvien where sinhvien.masv= phithuephong.masv and phithuephong.TrangThai='0'";
	String sql = "SELECT * FROM phithuephong,sinhvien where sinhvien.masv= phithuephong.masv";
	Statement stmt=conn.createStatement();
	ResultSet rs=stmt.executeQuery(sql);
	while (rs.next()) {
	String masv=rs.getString("MaSV");
	//System.out.print(masv);
	int hocky=rs.getInt("HocKy");
	String namhoc=rs.getString("NamHoc");
	int tongphi=rs.getInt("TongPhi");
	int trangthai=rs.getInt("TrangThai");
	int hinhthuc=rs.getInt("HinhThucNop");
	Date ngayTT=rs.getDate("NgayThanhToan");
	int id=rs.getInt("IDPhiThue");
	result.add(new Staff(hocky, namhoc, tongphi, masv,trangthai,hinhthuc,ngayTT,id));
	} } catch (Exception ex) {
	ex.printStackTrace();
	}
	return result;
	}
	public ArrayList<Staff> timkiemPhiThuePhongMsv(String val,String namhoc,int hocky) {
		ArrayList<Staff> result = new ArrayList<Staff>();
		try {
		Connect cnConnect=new Connect();
		Connection conn = cnConnect.getConn();
		String sql = "SELECT * FROM phithuephong,sinhvien where sinhvien.masv= phithuephong.masv and phithuephong.NamHoc='"+namhoc+"' and phithuephong.HocKy='"+hocky+"' and sinhvien.MaSV like '%"+val+"%'";
		//String sql = "SELECT * FROM phithuephong,sinhvien where sinhvien.MaSV= phithuephong.MaSV and phithuephong.TrangThai='0' and sinhvien.MaSV like '%"+masv+"%'";
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery(sql);
		while (rs.next()) {
		String masv=rs.getString("MaSV");
		//System.out.print(masv);
		//int hocky=rs.getInt("HocKy");
		//String namhoc=rs.getString("NamHoc");
		int tongphi=rs.getInt("TongPhi");
		int trangthai=rs.getInt("TrangThai");
		int hinhthuc=rs.getInt("HinhThucNop");
		Date ngayTT=rs.getDate("NgayThanhToan");
		int id=rs.getInt("IDPhiThue");
		result.add(new Staff(hocky, namhoc, tongphi, masv,trangthai,hinhthuc,ngayTT,id));
		} } catch (Exception ex) {
		ex.printStackTrace();
		}
		return result;
		}

	public ArrayList < Staff> TimKiemThongKe(String nam)
	{
	ArrayList <Staff> users = new ArrayList<>();
	//SELECT COUNT(DISTINCT IDPhong) FROM sinhvien
	int count = 0;
	int phongsd=0;
	int tongphong=0;
	int traphong=0;
	int dkphong=0;
	int suachua=0;
	float phiphong = 0 ;// tien phong
	float diennuoc=0;
	float tongphi=0;
	try {
	Connect cnConnect=new Connect();
	Connection conn = cnConnect.getConn();
	String sql1 = "SELECT COUNT(*) AS total1 FROM dangkyphong Where ChapNhan='1' and YEAR(ThoiGianDK) =\'"+nam+"\' ";
	String sql2 = "SELECT COUNT(*) AS total2 FROM dangkytraphong where YEAR(ThoiGianDK) =\'"+nam+"\' ";
	String sql3 = "SELECT COUNT(DISTINCT IDPhong) AS total3 FROM sinhvien"; //phong dang sd
	String sql4 = "SELECT COUNT(*) AS total4 FROM phong";
	// phong trong = total4-total3
	String sql5 = "SELECT COUNT(*) AS total5 FROM suachua Where ChapNhan='1'and YEAR(ThoiGianDK) =\'"+nam+"\'";
	String sql6 = "SELECT SUM(TongPhi) AS total6 FROM phithuephong WHERE TrangThai='1'and YEAR(NgayThanhToan) =\'"+nam+"\'";
	String sql7 = "SELECT SUM(TongTien) AS total7 FROM tiendiennuoc WHERE TrangThai='1'and YEAR(NgayNop) =\'"+nam+"\' ";
	// String sql8 = "SELECT COUNT(*) AS total7 FROM phong";
	Statement stmt=conn.createStatement();
	ResultSet rs1=stmt.executeQuery(sql1);
	while (rs1.next()) {
	dkphong = rs1.getInt("total1");}
	ResultSet rs2=stmt.executeQuery(sql2);
	while (rs2.next()) {
	traphong = rs2.getInt("total2");}
	ResultSet rs3=stmt.executeQuery(sql3);
	while (rs3.next()) {
	phongsd = rs3.getInt("total3");}
	ResultSet rs4=stmt.executeQuery(sql4);
	while (rs4.next()) {
	tongphong= rs4.getInt("total4");} //phong sd
	ResultSet rs5=stmt.executeQuery(sql5);
	while (rs5.next()) {
	suachua= rs5.getInt("total5");}
	ResultSet rs6=stmt.executeQuery(sql6);
	while (rs6.next()) {
	phiphong = rs6.getFloat("total6");}
	int phongtrong = tongphong-phongsd;
	ResultSet rs7=stmt.executeQuery(sql7);
	while (rs7.next()) {
	diennuoc = rs7.getFloat("total7");}
	tongphi= phiphong+diennuoc;
	users.add(new Staff(dkphong, traphong, phongsd, tongphong, suachua, tongphi, phongtrong));
	} catch (Exception ex) {
	ex.printStackTrace();
	}
	return users;
	}
	public ArrayList < Staff> ThongKe()
	{
	ArrayList <Staff> users = new ArrayList<>();
	//SELECT COUNT(DISTINCT IDPhong) FROM sinhvien
	int count = 0;
	int phongsd=0;
	int tongphong=0;
	int traphong=0;
	int dkphong=0;
	int suachua=0;
	float phiphong = 0 ;// tien phong
	float diennuoc=0;
	float tongphi=0;
	try {
	Connect cnConnect=new Connect();
	Connection conn = cnConnect.getConn();
//	String sql1 = "SELECT COUNT(*) AS total1 FROM dangkyphong Where ChapNhan='1' and YEAR(ThoiGianDK) ='2022' ";
	String sql1 = "SELECT COUNT(*) AS total1 FROM dangkyphong Where YEAR(ThoiGianDK) ='2022' ";
	String sql2 = "SELECT COUNT(*) AS total2 FROM dangkytraphong where YEAR(ThoiGianDK) ='2022' ";
	String sql3 = "SELECT COUNT(DISTINCT IDPhong) AS total3 FROM sinhvien where IDPhong!=0"; //phong dang sd
	String sql4 = "SELECT COUNT(*) AS total4 FROM phong";
	// phong trong = total4-total3
	String sql5 = "SELECT COUNT(*) AS total5 FROM suachua Where YEAR(ThoiGianDK) ='2022'";
//	String sql5 = "SELECT COUNT(*) AS total5 FROM suachua Where ChapNhan='1'and YEAR(ThoiGianDK) ='2022'";
	String sql6 = "SELECT SUM(TongPhi) AS total6 FROM phithuephong WHERE TrangThai='1'and YEAR(NgayThanhToan) ='2022'";
	String sql7 = "SELECT SUM(TongTien) AS total7 FROM tiendiennuoc WHERE TrangThai='1'and YEAR(NgayNop) ='2022'";
	String sql8 = "SELECT COUNT(*) AS total7 FROM phong";
	Statement stmt=conn.createStatement();
	ResultSet rs1=stmt.executeQuery(sql1);
	while (rs1.next()) {
	dkphong = rs1.getInt("total1");}
	ResultSet rs2=stmt.executeQuery(sql2);
	while (rs2.next()) {
	traphong = rs2.getInt("total2");}
	ResultSet rs3=stmt.executeQuery(sql3);
	while (rs3.next()) {
	phongsd = rs3.getInt("total3");}
	ResultSet rs4=stmt.executeQuery(sql4);
	while (rs4.next()) {
	tongphong= rs4.getInt("total4");} //phong sd
	tongphong=tongphong-phongsd;
	ResultSet rs5=stmt.executeQuery(sql5);
	while (rs5.next()) {
	suachua= rs5.getInt("total5");}
	ResultSet rs6=stmt.executeQuery(sql6);
	while (rs6.next()) {
	phiphong = rs6.getFloat("total6");}
	int phongtrong = tongphong-phongsd;
	ResultSet rs7=stmt.executeQuery(sql7);
	while (rs7.next()) {
	diennuoc = rs7.getFloat("total7");}
	tongphi= phiphong;
//	tongphi= phiphong+diennuoc;
	users.add(new Staff(dkphong, traphong, phongsd, tongphong, suachua, tongphi, phongtrong));
	} catch (Exception ex) {
	ex.printStackTrace();
	}
	return users;
	}
	public boolean UpdateTraPhong()
	{	  
		boolean rowUpdated =false;
		try {
				Connect cnConnect=new Connect();
				Connection conn = cnConnect.getConn();	
				String sql = "UPDATE sinhvien, dangkytraphong SET sinhvien.IDPhong=0 Where sinhvien.MaSV = dangkytraphong.MaSV"; 
			PreparedStatement pstmt = conn.prepareStatement(sql);
			 rowUpdated = pstmt.executeUpdate()>0;
			   
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		System.out.println(rowUpdated);
		return rowUpdated;       
    }

}


