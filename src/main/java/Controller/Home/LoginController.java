package Controller.Home;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class  LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public  LoginController() {
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 String destinationString = null; 
			destinationString = "/login.jsp";
			RequestDispatcher rd = getServletContext().getRequestDispatcher(destinationString);
			rd.forward(request, response);
	}

}
