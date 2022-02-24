package Controller.Student;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.Student;
import model.bo.student.PersonalInfomationBO;

@WebServlet("/updateInfoProcess")
public class UpdatePersonalInformationController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdatePersonalInformationController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		Student student = new Student();
		student.setEmail(request.getParameter("email"));
		student.setSDT(request.getParameter("sdt"));
		student.setSoTaiKhoan(request.getParameter("sotaikhoan"));
		student.setNganHang(request.getParameter("nganhang"));
		student.setTenCha(request.getParameter("tencha"));
		student.setNgaySinhCha(request.getParameter("ngaysinhcha"));
		student.setNgaySinhMe(request.getParameter("ngaysinhme"));
		student.setTenMe(request.getParameter("tenme"));
		student.setTenNguoiBaoTin(request.getParameter("tennguoibaotin"));
		student.setQuanHeNguoiBaoTin(request.getParameter("quanhe"));
		student.setSDTNguoiBaoTin(request.getParameter("sodienthoainbt"));
		student.setThanhPho_TinhNBT(request.getParameter("calc_shipping_provinces"));
		student.setQuan_HuyenNBT(request.getParameter("calc_shipping_district"));
		student.setDiaChiNguoiBaoTin(request.getParameter("diachinbt"));
		String destinationString = null;
		HttpSession session = request.getSession(false);
		PersonalInfomationBO personalInfomationBO = new PersonalInfomationBO();
		personalInfomationBO.updategetPersonalInfo((String) session.getAttribute("user"), student);
		student = personalInfomationBO.getPersonalInfo((String) session.getAttribute("user"));
		request.setAttribute("student", student);
		request.setAttribute("message", "Bạn đã cập nhật thông tin thành công");
		destinationString = "/views/Student/personalInformation.jsp";
		RequestDispatcher rd = getServletContext().getRequestDispatcher(destinationString);
		rd.forward(request, response);
	}

}
