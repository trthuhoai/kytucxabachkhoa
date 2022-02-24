package Controller.Staff;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Staff;
import model.bo.StaffBO;

/**
 * Servlet implementation class CheckThongKe
 */
@WebServlet("/CheckThongKe")
public class CheckThongKe extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckThongKe() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	
		String destination=null;
		StaffBO staffBO= new StaffBO();
		ArrayList<Staff> StaffArray=staffBO.ThongKe();

		request.setAttribute("StaffArray",StaffArray);
		destination="/views/Staff/ThongKe.jsp";
		RequestDispatcher rd=getServletContext().getRequestDispatcher(destination);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nam = request.getParameter("nam");
		StaffBO staffbo= new StaffBO();
		ArrayList<Staff> StaffArray=staffbo.TimKiemThongKe(nam);
		request.setAttribute("StaffArray",StaffArray);
		RequestDispatcher rd=getServletContext().getRequestDispatcher("/views/Staff/ThongKe.jsp");
		rd.forward(request, response);
		
	}

}
