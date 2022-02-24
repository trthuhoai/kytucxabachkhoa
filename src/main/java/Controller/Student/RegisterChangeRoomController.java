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
import model.bean.RegisterChangeRoom;
import model.bean.RegisterRoom;
import model.bean.Student;
import model.bo.student.PersonalInfomationBO;
import model.bo.student.RegisterChangeRoomBO;
import model.bo.student.RegisterRoomBO;

@WebServlet("/dangkychuyenphong")
public class RegisterChangeRoomController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegisterChangeRoomController() {
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
			RegisterChangeRoomBO registerChangeRoomBO = new RegisterChangeRoomBO();
			ArrayList<RegisterRoom> registerRoom = null;
			registerRoom = registerRoomBO.getRoomList();
			request.setAttribute("room", registerRoom);
			Student student = personalInfomationBO.getPersonalInfo((String) session.getAttribute("user"));
			request.setAttribute("student", student);
			System.out.println("ko");
			if (request.getParameter("phong") != null) {
				request.setAttribute("khu", request.getParameter("khu"));
				request.setAttribute("phong", request.getParameter("phong"));
				request.setAttribute("lydo", request.getParameter("lydo"));
				request.setAttribute("ngaychuyen", request.getParameter("ngay"));
				System.out.println("co");
				System.out.println("ko"+request.getParameter("lydo"));
				  RegisterChangeRoom registerChangeRoomDetail=new RegisterChangeRoom();
				  registerChangeRoomDetail.setLyDoChuyen(request.getParameter("lydo"));
				  registerChangeRoomDetail.setMaSV((String) session.getAttribute("user"));
				  registerChangeRoomDetail.setiDPhong(request.getParameter("khu")+request.getParameter("phong"));
				  registerChangeRoomDetail.setNgayChuyen(request.getParameter("ngay"));
				  registerChangeRoomDetail.setHocKy("Học kỳ 1 - Năm học 2021-2022"); 
				  LocalDateTime today = LocalDateTime.now();
				  registerChangeRoomDetail.setThoiGianDK(today.toString());
				  registerChangeRoomBO.AddRegisterChangeRoom(registerChangeRoomDetail);
				  request.setAttribute("detail",registerChangeRoomDetail);
				 request.setAttribute("message", "Bạn đã đăng ký chuyển phòng thành công!");
				 

			}
			destinationString = "/views/Student/registerChangeRoom.jsp";
		}

		RequestDispatcher rd = getServletContext().getRequestDispatcher(destinationString);
		rd.forward(request, response);
	}

}
