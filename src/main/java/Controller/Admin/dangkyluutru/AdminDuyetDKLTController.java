package Controller.Admin.dangkyluutru;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.DangKyLuuTru;
import model.bean.SinhVien;
import model.bo.DangKyLuuTruBO;
import model.bo.SinhVienBO;
import util.DateUtil;

@WebServlet("/admin/duyet-dang-ky-luu-tru")
public class AdminDuyetDKLTController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminDuyetDKLTController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		if (session.getAttribute("adminLogin") == null) {
			response.sendRedirect(request.getContextPath() + "/admin/login");
			return;
		}
		DangKyLuuTruBO dangKyLuuTruBO = new DangKyLuuTruBO();
		SinhVienBO sinhVienBO = new SinhVienBO();
		int id = 0;
		if (request.getParameter("id") != null) {
			id = Integer.parseInt(request.getParameter("id"));
		}
		DangKyLuuTru svDK = dangKyLuuTruBO.findById(id);
		if (svDK == null) {
			response.sendRedirect(request.getContextPath() + "/admin/dang-ky-luu-tru?err=2");
			return;
		}
		SinhVien sv = new SinhVien(svDK.getMaSV(), svDK.getMatKhau(), svDK.getHoTen(), svDK.getGioiTinh(),
				DateUtil.convertDate(svDK.getNgaySinh()), svDK.getLop(), svDK.getNganh(), svDK.getSoCCCD(),
				svDK.getDiaChi(), svDK.getSoDienThoai(), "", "", "", DateUtil.getDatePresent(), "",
				DateUtil.getDatePresent(), "", "", "", "", svDK.getEmail(), null);
		if (sinhVienBO.add(sv) > 0) {
			// thêm table sinhvien => delete table dangkyluutru
			if (dangKyLuuTruBO.delete(id) > 0) {
				response.sendRedirect(request.getContextPath() + "/admin/dang-ky-luu-tru?msg=success");
				return;
			}
		}
		response.sendRedirect(request.getContextPath() + "/admin/dang-ky-luu-tru?msg=error");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
