package Controller.Admin.Nhanvien;

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
import model.bean.NhanVien;
import model.bo.NhanVienBO;
import util.PageUtil;

@WebServlet("/admin/nhan-vien")
public class AdminNhanVienController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminNhanVienController() {
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
		int currentPage = 1; // số trang mặc định ban đầu
		if (request.getParameter("page") != null) {
			try {
				int page = Integer.parseInt(request.getParameter("page"));
				if (page < 1) {
					throw new Exception();
				}
				currentPage = page;
			} catch (Exception e) {
				response.sendRedirect(request.getContextPath() + "/admin/nhan-vien?err=1");
				return;
			}
		}
		int offset = PageUtil.getOffset(currentPage);
		int totalRow = nhanVienBO.totalRow();
		int totalPage = PageUtil.getTotalPage(totalRow);
		List<NhanVien> listNV = nhanVienBO.getList(offset, GlobalConstant.TOTAL_ROW);
		if (request.getParameter("keyword") != null) {
			// có tìm kiếm
			String keyword = request.getParameter("keyword");
			String thuocTinh = request.getParameter("thuoctinh");
			request.setAttribute("keyword", keyword);
			request.setAttribute("thuoctinh", thuocTinh);
			listNV = nhanVienBO.search(keyword, thuocTinh, offset, GlobalConstant.TOTAL_ROW);
			totalRow = nhanVienBO.totalRowSearch(keyword, thuocTinh);
			totalPage = PageUtil.getTotalPage(totalRow);
		}
		request.setAttribute("listNV", listNV);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("totalPage", totalPage);
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/nhanvien/index.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
