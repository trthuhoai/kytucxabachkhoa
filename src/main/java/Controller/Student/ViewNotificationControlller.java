package Controller.Student;


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.Notification;
import model.bean.Student;
import model.bo.CheckLoginBO;
import model.bo.student.NotificationBO;
import model.bo.student.PersonalInfomationBO;

@WebServlet("/thongbao")
public class  ViewNotificationControlller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public  ViewNotificationControlller() {
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String destinationString = null; 
		HttpSession session = request.getSession();
		if (session.getAttribute("user") == null) {
			destinationString = "/login.jsp";
		}
		else {
			NotificationBO notificationBO=new NotificationBO();
			ArrayList<Notification> notiArray = null;
			notiArray=notificationBO.getNotificationList();
			request.setAttribute("notiArray", notiArray);
			request.setAttribute("page", request.getParameter("page"));
			destinationString = "/views/Student/notification.jsp";
		}
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher(destinationString);
		rd.forward(request, response);
	}

}
