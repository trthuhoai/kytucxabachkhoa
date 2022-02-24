package Controller.Staff;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Staff;
import model.bo.CheckLoginBO;
import model.bo.StaffBO;

/**
 * Servlet implementation class CheckQLSC_YeuCau
 */
@WebServlet("/CheckQLSC_YeuCau")
public class CheckQLSC_YeuCau extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckQLSC_YeuCau() {
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
		ArrayList<Staff> StaffArray=null;
		StaffArray = staffBO.YCSC();
		request.setAttribute("StaffArray",StaffArray);
		destination="/views/Staff/YeuCauSuaChua.jsp";
		RequestDispatcher rd=getServletContext().getRequestDispatcher(destination);
		rd.forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		String action = request.getParameter("id");
		System.out.println(action);
		switch (action) {
		case "Tìm kiếm":
			String nha= request.getParameter("timkiem");
			String tg= request.getParameter("time");
			StaffBO staffBO= new StaffBO();
		   	ArrayList<Staff> StaffArray2=staffBO.TimKiemYCSC(nha);
			request.setAttribute("StaffArray",StaffArray2);
			RequestDispatcher rd=getServletContext().getRequestDispatcher("/views/Staff/YeuCauSuaChua.jsp");
			rd.forward(request, response);
		
		break;
		case "Cập nhật":
			String []na = request.getParameterValues("check");
			String dulieu="";
			for(String i:na) {
				dulieu=dulieu+i+",";
				System.out.println(dulieu);
			}
		StaffBO staffbo2 = new StaffBO();	
		staffbo2.capnhatycsc(dulieu);

			String destination=null;
			StaffBO staffBO2= new StaffBO();
			ArrayList<Staff> StaffArray=null;
			StaffArray = staffBO2.YCSC();
			request.setAttribute("StaffArray",StaffArray);
			destination="/views/Staff/YeuCauSuaChua.jsp";
			rd=getServletContext().getRequestDispatcher(destination);
			rd.forward(request, response);
			break;
		case "Reset":

				String destination1=null;
				StaffBO staffBO3= new StaffBO();
				ArrayList<Staff> StaffArray1=null;
				StaffArray1 = staffBO3.YCSC();
				request.setAttribute("StaffArray",StaffArray1);
				destination1="/views/Staff/YeuCauSuaChua.jsp";
				RequestDispatcher rd1=getServletContext().getRequestDispatcher(destination1);
				rd1.forward(request, response);
		
	}

	}
}