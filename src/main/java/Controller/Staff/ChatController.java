package Controller.Staff;

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

@WebServlet("/nvnhantin")
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
		HttpSession session = request.getSession(false);
		PersonalInfomationBO personalInfomationBO = new PersonalInfomationBO();
		if (session.getAttribute("user") == null||session==null) {
			destinationString = "/login.jsp";
		} else {
			ChatBO chatBO=new ChatBO();
			ArrayList<Chat> chat = null;
			chat=chatBO.getChatList((String) session.getAttribute("user"));
			request.setAttribute("chat",chat);
			System.out.println("ko");
			if (request.getParameter("mess") != null&&request.getParameter("mess").trim()!="") {
				Chat chatchat=new Chat();
				chatchat.setNoiDung(request.getParameter("mess"));
				chatchat.setiDTinNhan("102180000"+(String) session.getAttribute("user"));
				chatchat.setMaNV((String) session.getAttribute("user"));
				chatchat.setMaSV(("1"));
				chatchat.setNguoiGui((String) session.getAttribute("user"));
				Date date = new Date();
				 SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss a");
				String strDate = formatter.format(date);
				System.out.println(strDate);
				if(((String) session.getAttribute("user")).equals("10218")) {
					chatchat.setThoiGian(strDate+" - Bộ phận tài chính");
				}
				else if(((String) session.getAttribute("user")).equals("10219")) {
					chatchat.setThoiGian(strDate+" - Bộ phận sửa chữa");
				}else {
					chatchat.setThoiGian(strDate+" - Đội tự quản");
				}
				
				chatBO.AddMessage(chatchat);
				request.removeAttribute("mess");
			}
			destinationString = "/views/Staff/chat.jsp";
		}

		RequestDispatcher rd = getServletContext().getRequestDispatcher(destinationString);
		rd.forward(request, response);
	}

}
