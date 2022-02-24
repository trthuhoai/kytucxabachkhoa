package Controller.Admin.SinhVien;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.SinhVien;
import model.bo.SinhVienBO;

@WebServlet("/admin/sinh-vien/xoa")
public class AdminXoaSinhVienController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminXoaSinhVienController() {
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
		if (sinhVienBO.delete(maSV) > 0) {
			// success
			response.sendRedirect(request.getContextPath() + "/admin/sinh-vien?delete=success");
			return;
		}
		response.sendRedirect(request.getContextPath() + "/admin/sinh-vien/xem-chi-tiet?masv=" + maSV);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
