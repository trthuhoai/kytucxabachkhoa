package Controller.Admin.SinhVien;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.SinhVien;
import model.bo.SinhVienBO;

@WebServlet("/admin/sinh-vien/cap-nhat")
public class AdminSuaSinhVienController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminSuaSinhVienController() {
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
		SinhVienBO sinhVienBO = new SinhVienBO();
		String maSV = request.getParameter("masv");
		SinhVien sv = sinhVienBO.findByMaSV(maSV);
		if (sv == null) {
			response.sendRedirect(request.getContextPath() + "/admin/sinh-vien?err=2");
			return;
		}
		request.setAttribute("sv", sv);
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/sinhvien/update.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		SinhVienBO sinhVienBO = new SinhVienBO();
		String maSV = request.getParameter("masv");
		String matKhau = request.getParameter("matkhau");
		String hoTen = request.getParameter("hoten");
		String sdt = request.getParameter("sdt");
		String email = request.getParameter("email");
		String ngaySinh = request.getParameter("ngaysinh");
		String gioiTinh = request.getParameter("gioitinh");
		String diaChi = request.getParameter("diachi");
		String nganh = request.getParameter("khoa");
		String lop = request.getParameter("lop");
		SinhVien sv = new SinhVien(maSV, matKhau, hoTen, gioiTinh, ngaySinh, lop, nganh, diaChi, sdt, email);
		request.setAttribute("sv", sv);

		// validate
		request.setAttribute("alert", "danger");
		boolean validate = true;
		if (hoTen.equals("")) {
			request.setAttribute("hoTenError", "H??????? t????n kh????ng ???????????????c ??????????? tr???????ng");
			validate = false;
		}
		if (sdt.equals("")) {
			request.setAttribute("sdtError", "S??????? ?????i???????n tho??????i kh????ng ???????????????c ??????????? tr???????ng");
			validate = false;
		}
		if (email.equals("")) {
			request.setAttribute("emailError", "Email kh????ng ???????????????c ??????????? tr???????ng");
			validate = false;
		}
		if (ngaySinh.equals("")) {
			request.setAttribute("ngaySinhError", "Ng????y sinh kh????ng ???????????????c ??????????? tr???????ng");
			validate = false;
		}
		if (gioiTinh == null) {
			request.setAttribute("gioiTinhError", "Vui l????ng ch???????n gi???????i t????nh");
			validate = false;
		}
		if (diaChi.equals("")) {
			request.setAttribute("diaChiError", "????????????a ch??????? kh????ng ???????????????c ??????????? tr???????ng");
			validate = false;
		}
		if (nganh.equals("")) {
			request.setAttribute("khoaError", "Khoa kh????ng ???????????????c ??????????? tr???????ng");
			validate = false;
		}
		if (lop.equals("")) {
			request.setAttribute("lopError", "L???????p kh????ng ???????????????c ??????????? tr???????ng");
			validate = false;
		}

		if (!validate) {
			request.setAttribute("thongbao", "C???? l???????i x??????y ra khi nh??????p d?????? li???????u");
			RequestDispatcher rd = request.getRequestDispatcher("/views/admin/sinhvien/update.jsp");
			rd.forward(request, response);
			return;
		}

		if (matKhau.equals("")) {
			// g????n password l???? password c????
			SinhVien sinhVien = sinhVienBO.findByMaSV(maSV);
			sv.setMatKhau(sinhVien.getMatKhau());
		}

		if (sinhVienBO.adminUpdate(sv) > 0) {
			// success
			response.sendRedirect(
					request.getContextPath() + "/admin/sinh-vien/xem-chi-tiet?masv=" + maSV + "&update=success");
			return;
		}
		request.setAttribute("thongbao", "C???? l???????i x??????y ra");
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/sinhvien/update.jsp");
		rd.forward(request, response);
	}

}
