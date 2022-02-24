package Controller.Student;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.Chat;
import model.bean.Notification;
import model.bean.RegisterRoom;
import model.bean.Student;
import model.bo.student.ChatBO;
import model.bo.student.PersonalInfomationBO;
import model.bo.student.RegisterRoomBO;
import model.dao.student.ChatDao;

@WebServlet("/nhantin")
public class ChatController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ChatController() {
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
		if (session.getAttribute("user") == null||session==null) {
			destinationString = "/login.jsp";
		} else {
			ChatBO chatBO=new ChatBO();
			ArrayList<Chat> chat = null;
			if(request.getParameter("nhanvien")==null) {
			chat=chatBO.getChatList("10218");
			request.setAttribute("chat",chat);
			Student student = personalInfomationBO.getPersonalInfo((String) session.getAttribute("user"));
			request.setAttribute("student", student);
			System.out.println("ko");
			if (request.getParameter("mess") != null&&request.getParameter("mess").trim()!="") {
				Chat chatchat=new Chat();
				chatchat.setNoiDung(request.getParameter("mess"));
				chatchat.setiDTinNhan((String) session.getAttribute("user")+"10218");
				chatchat.setMaNV("10218");
				chatchat.setMaSV((String) session.getAttribute("user"));
				chatchat.setNguoiGui((String) session.getAttribute("user"));
				Date date = new Date();
				SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss a");
				String strDate = formatter.format(date);
				System.out.println(strDate);
				chatchat.setThoiGian(strDate);
				chatBO.AddMessage(chatchat);
				request.removeAttribute("mess");
				 

			}
			destinationString = "/views/Student/chat.jsp";
		}else {
			chat=chatBO.getChatList(request.getParameter("nhanvien"));
			request.setAttribute("chat",chat);
			request.setAttribute("nv", request.getParameter("nhanvien"));
			Student student = personalInfomationBO.getPersonalInfo((String) session.getAttribute("user"));
			request.setAttribute("student", student);
			System.out.println("ko");
			if (request.getParameter("mess") != null&&request.getParameter("mess").trim()!="") {
				Chat chatchat=new Chat();
				chatchat.setNoiDung(request.getParameter("mess"));
				chatchat.setiDTinNhan((String) session.getAttribute("user")+request.getParameter("nhanvien"));
				chatchat.setMaNV(request.getParameter("nhanvien"));
				chatchat.setMaSV((String) session.getAttribute("user"));
				chatchat.setNguoiGui((String) session.getAttribute("user"));
				Date date = new Date();
				SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss a");
				String strDate = formatter.format(date);
				System.out.println(strDate);
				chatchat.setThoiGian(strDate+" - "+(String) session.getAttribute("user"));
				chatBO.AddMessage(chatchat);
				request.removeAttribute("mess");
				 

			}
			destinationString = "/views/Student/chat.jsp";
		}
			}

		RequestDispatcher rd = getServletContext().getRequestDispatcher(destinationString);
		rd.forward(request, response);
	}

}
