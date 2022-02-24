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

@WebServlet("/timkiemphong")
public class SearchChangeRoomController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SearchChangeRoomController() {
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
			String khu=request.getParameter("khu");
			String phong= request.getParameter("phong");
			request.setAttribute("khu1", request.getParameter("khu"));
			request.setAttribute("phong1", request.getParameter("phong"));
			if(khu.trim()==""&&phong.trim()=="")
			{
				registerRoom = registerRoomBO.getRoomList();
			}
			else {
				registerRoom=registerRoomBO.searchRoomList(khu, phong);
			}
			
			request.setAttribute("room", registerRoom);
			Student student = personalInfomationBO.getPersonalInfo((String) session.getAttribute("user"));
			request.setAttribute("student", student);
			System.out.println("ko");
			destinationString = "/views/Student/registerChangeRoom.jsp";
		}

		RequestDispatcher rd = getServletContext().getRequestDispatcher(destinationString);
		rd.forward(request, response);
	}

}

