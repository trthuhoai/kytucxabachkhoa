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
import util.DateUtil;

@WebServlet("/admin/nhan-vien/them-moi")
public class AdminThemNhanVienController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminThemNhanVienController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("adminLogin") == null) {
			response.sendRedirect(request.getContextPath() + "/login.jsp");
			return;
		}
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/nhanvien/add.jsp");
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
		NhanVien nv = new NhanVien(maNV, matKhau, hoTen, gioiTinh, ngaySinh, "", diaChi, sdt, "", "", "",
				DateUtil.getDatePresent(), "", DateUtil.getDatePresent(), email, chucVu, "", "", "", "");
		request.setAttribute("nv", nv);

		// validate
		request.setAttribute("alert", "danger");
		boolean validate = true;
		if (hoTen.equals("")) {
			request.setAttribute("hoTenError", "H??? t??n kh??ng ???????c ????? tr???ng");
			validate = false;
		}
		if (sdt.equals("")) {
			request.setAttribute("sdtError", "S??? ??i???n tho???i kh??ng ???????c ????? tr???ng");
			validate = false;
		}
		if (email.equals("")) {
			request.setAttribute("emailError", "Email kh??ng ???????c ????? tr???ng");
			validate = false;
		}
		if (ngaySinh.equals("")) {
			request.setAttribute("ngaySinhError", "Ng??y sinh kh??ng ???????c ????? tr???ng");
			validate = false;
		}
		if (gioiTinh == null) {
			request.setAttribute("gioiTinhError", "Vui l??ng ch???n gi???i t??nh");
			validate = false;
		}
		if (chucVu.equals("")) {
			request.setAttribute("chucVuError", "Ch???c v??? kh??ng ???????c ????? tr???ng");
			validate = false;
		}
		if (diaChi.equals("")) {
			request.setAttribute("diaChiError", "?????a ch??? kh??ng ???????c ????? tr???ng");
			validate = false;
		}
		if (maNV.equals("")) {
			request.setAttribute("maNVError", "M?? nh??n vi??n kh??ng ???????c ????? tr???ng");
			validate = false;
		}
		if (nhanVienBO.findByMaNV(maNV) != null) {
			// tr??ng m??
			request.setAttribute("maNVError", "M?? nh??n vi??n ???? t???n t???i, vui l??ng s??? d???ng m?? kh??c");
			validate = false;
		}
		if (matKhau.equals("")) {
			request.setAttribute("matKhauError", "M???t kh???u kh??ng ???????c ????? tr???ng");
			validate = false;
		}

		if (!validate) {
			request.setAttribute("thongbao", "C?? l???i x???y ra khi nh???p d??? li???u");
			RequestDispatcher rd = request.getRequestDispatcher("/views/admin/nhanvien/add.jsp");
			rd.forward(request, response);
			return;
		}

		if (nhanVienBO.add(nv) > 0) {
			// success
			request.setAttribute("alert", "success");
			request.setAttribute("thongbao", "Th??m m???i nh??n vi??n th??nh c??ng");
			request.setAttribute("nv", null);
		} else {
			request.setAttribute("thongbao", "C?? l???i x???y ra");
		}
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/nhanvien/add.jsp");
		rd.forward(request, response);
	}

}
