package Controller.Home;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import constant.GlobalConstant;
import model.bean.*;
import model.bo.*;
import model.bo.student.NotificationBO;
import model.bo.student.PersonalInfomationBO;
import util.PageUtil;

@WebServlet("/loginProcess")
public class CheckLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CheckLoginController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String destinationString = null;
		HttpSession session=request.getSession();
		String usernameString = request.getParameter("maso");
		String passwordString = request.getParameter("matkhau");
	
		if (usernameString.length() == 3) {
			CheckLoginBO checkLoginBO = new CheckLoginBO();
			if (checkLoginBO.isValidAdmin(usernameString, passwordString)) {
				
				
				AdminBO adminBO = new AdminBO();
				Admin admin = adminBO.checkLogin(usernameString, passwordString);
				session.setAttribute("adminLogin",admin);
				NhanVienBO nhanVienBO = new NhanVienBO();
				int currentPage = 1; // sá»‘ trang máº·c Ä‘á»‹nh ban Ä‘áº§u
				int offset = PageUtil.getOffset(currentPage);
				int totalRow = nhanVienBO.totalRow();
				int totalPage = PageUtil.getTotalPage(totalRow);
				List<NhanVien> listNV = nhanVienBO.getList(offset, GlobalConstant.TOTAL_ROW);
				if (request.getParameter("keyword") != null) {
					// cÃ³ tÃ¬m kiáº¿m
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
				destinationString="/views/admin/nhanvien/index.jsp";
//				rd.forward(request, response);
			} else {
				request.setAttribute("message", "Mã số hoặc mật khẩu chưa đúng!");
				destinationString = "/login.jsp";
			}
		} else if (usernameString.length() == 5) {
			CheckLoginBO checkLoginBO = new CheckLoginBO();
			if (checkLoginBO.isValidStaff(usernameString, passwordString)) {
				session.setAttribute("user",usernameString);
				ArrayList<Staff> StaffArray=null;
				StaffArray=checkLoginBO.getUpdateNV(usernameString);
				request.setAttribute("StaffArray",StaffArray);
				destinationString = "/views/Staff/ThongTinCaNhan.jsp";
			} else {
				request.setAttribute("message", "Mã số hoặc mật khẩu chưa đúng!");
				destinationString = "/login.jsp";
			}
		} else if (usernameString.length() == 9) {
			CheckLoginBO checkLoginBO = new CheckLoginBO();
			if (checkLoginBO.isValidStudent(usernameString, passwordString)) {
				NotificationBO notificationBO=new NotificationBO();
				PersonalInfomationBO personalInfomationBO=new PersonalInfomationBO();
				Student student=personalInfomationBO.getPersonalInfo(usernameString);
				ArrayList<Notification> notiArray = null;
				notiArray=notificationBO.getNotificationList();
				request.setAttribute("notiArray", notiArray);
				session.setAttribute("user",usernameString);
				session.setAttribute("tensv",student.getTenSV());
				destinationString = "/views/Student/notification.jsp";
			} else {
				request.setAttribute("message", "Mã số hoặc mật khẩu chưa đúng!");
				destinationString = "/login.jsp";
			}
		} else {
			request.setAttribute("message", "Mã số hoặc mật khẩu chưa đúng!");
			destinationString = "/login.jsp";
		}
		RequestDispatcher rd = getServletContext().getRequestDispatcher(destinationString);
		rd.forward(request, response);
	}

}
