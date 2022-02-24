package Controller.Admin.ThongBao;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.Admin;
import model.bean.ThongBao;
import model.bo.ThongBaoBO;
import util.DateUtil;

@WebServlet("/admin/dang-thong-bao")
public class AdminDangThongBaoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminDangThongBaoController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("adminLogin") == null) {
			response.sendRedirect(request.getContextPath() + "/login.jsp");
			return;
		}
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/thongbao/post.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		ThongBaoBO thongBaoBO = new ThongBaoBO();
		HttpSession session = request.getSession();
		Admin admin = (Admin) session.getAttribute("adminLogin");
		String tieuDe = request.getParameter("tieude");
		String noiDung = request.getParameter("noidung");
		ThongBao tb = new ThongBao(0, "", admin.getMaAdmin(), DateUtil.getDatePresent(), tieuDe, noiDung);
		request.setAttribute("tb", tb);

		// validate data
		request.setAttribute("alert", "danger");
		boolean validate = true;
		if (tieuDe.equals("")) {
			request.setAttribute("tieuDeError", "Tiêu đề không được để trống");
			validate = false;
		}

		if (noiDung.equals("")) {
			request.setAttribute("noiDungError", "Nội dung thông báo không được để trống");
			validate = false;
		}

		if (!validate) {
			request.setAttribute("thongbao", "Có lỗi xảy ra khi nhập dữ liệu");
			RequestDispatcher rd = request.getRequestDispatcher("/views/admin/thongbao/post.jsp");
			rd.forward(request, response);
			return;
		}

		if (thongBaoBO.add(tb) > 0) {
			// success
			request.setAttribute("alert", "success");
			request.setAttribute("thongbao", "Đăng thông báo thành công");
			request.setAttribute("tb", null);
		} else {
			request.setAttribute("thongbao", "Có lỗi xảy ra");
		}
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/thongbao/post.jsp");
		rd.forward(request, response);
	}

}

