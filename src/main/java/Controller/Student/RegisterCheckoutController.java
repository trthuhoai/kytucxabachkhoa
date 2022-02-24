package Controller.Student;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.Notification;
import model.bean.RegisterCheckout;
import model.bean.RegisterRoom;
import model.bean.Student;
import model.bo.student.PersonalInfomationBO;
import model.bo.student.RegisterCheckoutBO;
import model.bo.student.RegisterRoomBO;

@WebServlet("/traphong")
public class RegisterCheckoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegisterCheckoutController() {
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
		String destinationString = null;
		HttpSession session = request.getSession();
		PersonalInfomationBO personalInfomationBO = new PersonalInfomationBO();
		if (session.getAttribute("user") == null) {
			destinationString = "/login.jsp";
		} else {
			Student student = personalInfomationBO.getPersonalInfo((String) session.getAttribute("user"));
			request.setAttribute("student", student);
			System.out.println("ko");
			if (request.getParameter("ngay") != null) {
				
				RegisterCheckoutBO registerCheckoutBO=new RegisterCheckoutBO();
				RegisterCheckout registerCheckout=new RegisterCheckout();
				registerCheckout.setMaSV(student.getMaSV());
				registerCheckout.setiDPhong(student.getIDPhong());
				LocalDateTime today = LocalDateTime.now();
				registerCheckout.setThoiGianDK(today.toString());
				registerCheckout.setNgayTraPhong(request.getParameter("ngay"));
				registerCheckout.setLyDoTraPhong(request.getParameter("lydo"));
				registerCheckoutBO.AddRegisterCheckout(registerCheckout);
				request.setAttribute("detail",registerCheckout);
				request.setAttribute("message", "Bạn đã đăng ký thành công!");
			}
			destinationString = "/views/Student/registerCheckout.jsp";
		}
		RequestDispatcher rd = getServletContext().getRequestDispatcher(destinationString);
		rd.forward(request, response);
	}

}
