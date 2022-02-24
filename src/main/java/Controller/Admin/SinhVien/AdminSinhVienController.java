package Controller.Admin.SinhVien;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import constant.GlobalConstant;
import model.bean.SinhVien;
import model.bo.SinhVienBO;
import util.PageUtil;

@WebServlet("/admin/sinh-vien")
public class AdminSinhVienController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminSinhVienController() {
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
		int currentPage = 1; // số trang mặc định ban đầu
		if (request.getParameter("page") != null) {
			try {
				int page = Integer.parseInt(request.getParameter("page"));
				if (page < 1) {
					throw new Exception();
				}
				currentPage = page;
			} catch (Exception e) {
				response.sendRedirect(request.getContextPath() + "/admin/sinh-vien?err=1");
				return;
			}
		}
		int offset = PageUtil.getOffset(currentPage);
		int totalRow = sinhVienBO.totalRow();
		int totalPage = PageUtil.getTotalPage(totalRow);
		List<SinhVien> listSV = sinhVienBO.getList(offset, GlobalConstant.TOTAL_ROW);
		if (request.getParameter("keyword") != null) {
			// có tìm kiếm
			String keyword = request.getParameter("keyword");
			String thuocTinh = request.getParameter("thuoctinh");
			request.setAttribute("keyword", keyword);
			request.setAttribute("thuoctinh", thuocTinh);
			listSV = sinhVienBO.search(keyword, thuocTinh, offset, GlobalConstant.TOTAL_ROW);
			totalRow = sinhVienBO.totalRowSearch(keyword, thuocTinh);
			totalPage = PageUtil.getTotalPage(totalRow);
		}
		request.setAttribute("listSV", listSV);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("totalPage", totalPage);
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/sinhvien/index.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
