package Controller.Admin.Nhanvien;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.NhanVien;
import model.bo.NhanVienBO;

@WebServlet("/admin/nhan-vien/xoa")
public class AdminXoaNhanVienController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminXoaNhanVienController() {
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
		if (nhanVienBO.delete(maNV) > 0) {
			// success
			response.sendRedirect(request.getContextPath() + "/admin/nhan-vien?delete=success");
			return;
		}
		response.sendRedirect(request.getContextPath() + "/admin/nhan-vien/xem-chi-tiet?manv=" + maNV);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
