package Controller.Admin.Nhanvien;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.NhanVien;
import model.bo.NhanVienBO;

@WebServlet("/admin/nhan-vien/cap-nhat")
public class AdminSuaNhanVienController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminSuaNhanVienController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		if (session.getAttribute("adminLogin") == null) {
			response.sendRedirect(request.getContextPath() + "/login.jsp");
			return;
		}
		NhanVienBO nhanVienBO = new NhanVienBO();
		String maNV = request.getParameter("manv");
		NhanVien nv = nhanVienBO.findByMaNV(maNV);
		if (nv == null) {
			response.sendRedirect(request.getContextPath() + "/admin/nhan-vien?err=2");
			return;
		}
		request.setAttribute("nv", nv);
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/nhanvien/update.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		NhanVienBO nhanVienBO = new NhanVienBO();
		String maNV = request.getParameter("manv");
		String matKhau = request.getParameter("matkhau");
		String hoTen = request.getParameter("hoten");
		String sdt = request.getParameter("sdt");
		String email = request.getParameter("email");
		String ngaySinh = request.getParameter("ngaysinh");
		String gioiTinh = request.getParameter("gioitinh");
		String chucVu = request.getParameter("chucvu");
		String diaChi = request.getParameter("diachi");
		NhanVien nv = new NhanVien(maNV, matKhau, hoTen, gioiTinh, ngaySinh, diaChi, sdt, email, chucVu);
		request.setAttribute("nv", nv);

		// validate
		request.setAttribute("alert", "danger");
		boolean validate = true;
		if (hoTen.equals("")) {
			request.setAttribute("hoTenError", "Họ tên không được để trống");
			validate = false;
		}
		if (sdt.equals("")) {
			request.setAttribute("sdtError", "Số điện thoại không được để trống");
			validate = false;
		}
		if (email.equals("")) {
			request.setAttribute("emailError", "Email không được để trống");
			validate = false;
		}
		if (ngaySinh.equals("")) {
			request.setAttribute("ngaySinhError", "Ngày sinh không được để trống");
			validate = false;
		}
		if (gioiTinh == null) {
			request.setAttribute("gioiTinhError", "Vui lòng chọn giới tính");
			validate = false;
		}
		if (chucVu.equals("")) {
			request.setAttribute("chucVuError", "Chức vụ không được để trống");
			validate = false;
		}
		if (diaChi.equals("")) {
			request.setAttribute("diaChiError", "Địa chỉ không được để trống");
			validate = false;
		}

		if (!validate) {
			request.setAttribute("thongbao", "Có lỗi xảy ra khi nhập dữ liệu");
			RequestDispatcher rd = request.getRequestDispatcher("/views/admin/nhanvien/update.jsp");
			rd.forward(request, response);
			return;
		}

		if (matKhau.equals("")) {
			// gán password là password cũ
			NhanVien nhanVien = nhanVienBO.findByMaNV(maNV);
			nv.setMatKhau(nhanVien.getMatKhau());
		}

		if (nhanVienBO.adminUpdate(nv) > 0) {
			// success
			response.sendRedirect(request.getContextPath() + "/admin/nhan-vien/xem-chi-tiet?manv=" + maNV + "&update=success");
			return;
		}
		request.setAttribute("thongbao", "Có lỗi xảy ra");
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/nhanvien/update.jsp");
		rd.forward(request, response);
	}

}