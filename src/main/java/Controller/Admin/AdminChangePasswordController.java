package Controller.Admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.Admin;
import model.bo.AdminBO;

@WebServlet("/admin/doi-mat-khau")
public class AdminChangePasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminChangePasswordController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("adminLogin") == null) {
			response.sendRedirect(request.getContextPath() + "/login.jsp");
			return;
		}
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/change-password.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		AdminBO adminBO = new AdminBO();
		HttpSession session = request.getSession();
		Admin admin = (Admin) session.getAttribute("adminLogin");
		String matKhauCu = request.getParameter("oldPassword");
		String matKhau = request.getParameter("password");
		String xacNhanMatKhau = request.getParameter("confirmPassword");

		// validate data
		request.setAttribute("alert", "danger");
		boolean validate = true;
		if (!matKhauCu.equals(admin.getMatKhau())) {
			request.setAttribute("oldPasswordError", "Mật khẩu cũ không chính xác");
			validate = false;
		}

		if (matKhau.equals("")) {
			request.setAttribute("passwordError", "Mật khẩu mới không được để trống");
			validate = false;
		}

		if (matKhau.length() > 50) {
			request.setAttribute("passwordError", "Mật khẩu tối đa 50 ký tự");
			validate = false;
		}

		if (!xacNhanMatKhau.equals(matKhau)) {
			request.setAttribute("confirmPasswordError", "Xác nhận mật khẩu không chính xác");
			validate = false;
		}

		if (!validate) {
			request.setAttribute("thongbao", "Có lỗi xảy ra khi nhập dữ liệu");
			RequestDispatcher rd = request.getRequestDispatcher("/views/admin/change-password.jsp");
			rd.forward(request, response);
			return;
		}

		admin.setMatKhau(matKhau); // update password
		if (adminBO.updatePassword(admin) > 0) {
			// success
			session.setAttribute("adminLogin", adminBO.findByMaAdmin(admin.getMaAdmin())); // update session
			request.setAttribute("alert", "success");
			request.setAttribute("thongbao", "Đổi mật khẩu thành công");
		} else {
			request.setAttribute("thongbao", "Có lỗi xảy ra");
		}
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/change-password.jsp");
		rd.forward(request, response);
	}

}
