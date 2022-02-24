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
import model.bean.RegisterRoom;
import model.bean.Student;
import model.bo.student.PersonalInfomationBO;
import model.bo.student.RegisterRoomBO;

@WebServlet("/dangkyphong")
public class RegisterRoomController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegisterRoomController() {
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
			RegisterRoomBO registerRoomBO = new RegisterRoomBO();
			ArrayList<RegisterRoom> registerRoom = null;
			registerRoom = registerRoomBO.getRoomList();
			request.setAttribute("room", registerRoom);
			Student student = personalInfomationBO.getPersonalInfo((String) session.getAttribute("user"));
			request.setAttribute("student", student);
			System.out.println("ko");
			if (request.getParameter("phong") != null) {
				request.setAttribute("khu", request.getParameter("khu"));
				request.setAttribute("phong", request.getParameter("phong"));
				System.out.println("co");
				
				  RegisterRoom registerRoomDetail=new RegisterRoom();
				  registerRoomDetail.setMsv((String) session.getAttribute("user"));
				  registerRoomDetail.setiDPhong(request.getParameter("khu")+request.
				  getParameter("phong"));
				  registerRoomDetail.setHocKy("Học kỳ 1 - Năm học 2021-2022"); LocalDateTime
				  today = LocalDateTime.now();
				  registerRoomDetail.setThoiGianDK(today.toString());
				  registerRoomBO.AddRegisterRoom(registerRoomDetail);
				  request.setAttribute("detail",registerRoomDetail);
				 request.setAttribute("message", "Bạn đã đăng ký thành công!");
				 

			}
			destinationString = "/views/Student/registerRoom.jsp";
		}

		RequestDispatcher rd = getServletContext().getRequestDispatcher(destinationString);
		rd.forward(request, response);
	}

}
