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

@WebServlet("/changePasswordProcess")
public class ChangePasswordProcessController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ChangePasswordProcessController() {
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
		String mkString=request.getParameter("newpassword");
		Student student=new Student();
		String destinationString = null;
		HttpSession session = request.getSession(false);
		PersonalInfomationBO personalInfomationBO = new PersonalInfomationBO();
		personalInfomationBO.changePassword((String) session.getAttribute("user"), mkString);
		student = personalInfomationBO.getPersonalInfo((String) session.getAttribute("user"));
		request.setAttribute("student", student);
		request.setAttribute("message", "Bạn đã đổi mật khẩu thành công!");
		destinationString = "/views/Student/changePassword.jsp";
		RequestDispatcher rd = getServletContext().getRequestDispatcher(destinationString);
		rd.forward(request, response);
	}

}
