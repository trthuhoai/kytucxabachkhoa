package Controller.Staff;

import java.awt.List;
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
 * Servlet implementation class CheckQLP_TTPhong
 */
@WebServlet("/CheckQLP_TTPhong")
public class CheckQLP_TTPhong extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckQLP_TTPhong() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		String destinationString = null;
		StaffBO staffbo = new StaffBO();
		ArrayList <Staff> listUser = staffbo.TTPhong();
		request.setAttribute("listUser", listUser);
		destinationString = "/views/Staff/QLP_TTPhong.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(destinationString);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nha = request.getParameter("nha");
		request.setAttribute("nha", nha);
		StaffBO staffBO=new StaffBO();
		String destination=null;
		ArrayList<Staff> StaffArray=null;
		StaffArray=staffBO.TimkiemTTPhong(nha);
		request.setAttribute("listUser",StaffArray);
		destination="/views/Staff/QLP_TTPhong.jsp";
		RequestDispatcher rd=getServletContext().getRequestDispatcher(destination);
		rd.forward(request, response);
	}

}
