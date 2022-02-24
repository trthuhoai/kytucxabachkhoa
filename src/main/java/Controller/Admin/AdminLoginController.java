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

@WebServlet("/admin/login")
public class AdminLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminLoginController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/login.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		AdminBO adminBO = new AdminBO();
		HttpSession session = request.getSession();
		String taiKhoan = request.getParameter("taikhoan");
		String matKhau = request.getParameter("matkhau");
		Admin admin = adminBO.checkLogin(taiKhoan, matKhau);
		if (admin == null) {
			// error
			request.setAttribute("taiKhoan", taiKhoan);
			request.setAttribute("message", "Tài khoản hoặc mật khẩu không chính xác");
			RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
			rd.forward(request, response);
			return;
		}
		// success
		session.setAttribute("adminLogin", admin);
		response.sendRedirect(request.getContextPath() + "/admin");
	}

}
