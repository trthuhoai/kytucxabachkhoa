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

@WebServlet("/doimatkhau")
public class  ChangePasswordController  extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public  ChangePasswordController () {
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
		 HttpSession session=request.getSession();
		 PersonalInfomationBO personalInfomationBO=new PersonalInfomationBO();
		if (session.getAttribute("user") == null) {
			 destinationString = "/login.jsp";
		 }else {
			 Student student=personalInfomationBO.getPersonalInfo((String) session.getAttribute("user"));
			  request.setAttribute("student", student);
				destinationString = "/views/Student/changePassword.jsp";
		 }
		
			RequestDispatcher rd = getServletContext().getRequestDispatcher(destinationString);
			rd.forward(request, response);
	}

}
