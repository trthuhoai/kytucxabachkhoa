package Controller.Staff;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

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
 * Servlet implementation class Check_DSDK
 */
@WebServlet("/Check_DSDK")
public class Check_DSDK extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Check_DSDK() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		CheckLoginBO checkLoginBO=new CheckLoginBO();
		String destination=null;
		ArrayList<Staff> StaffArray=new ArrayList<Staff>();
		StaffArray=checkLoginBO.DanhSachCPSV();
		System.out.println("ccccccc"+StaffArray.size());
		request.setAttribute("StaffArray",StaffArray);
		destination="/views/Staff/DanhSachDK.jsp";
		RequestDispatcher rd=getServletContext().getRequestDispatcher(destination);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	doGet(request, response);
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		String action = request.getParameter("id");
		System.out.println(action);
		ArrayList<Staff> StaffArray=new ArrayList<Staff>();
		switch (action) {
		case "Tìm kiếm":
			String values = request.getParameter("timkiem");
			System.out.println(values);
			CheckLoginBO checkLoginBO=new CheckLoginBO();
			String destination=null;
			
			StaffArray=checkLoginBO.TimkiemCPSV(values);
			request.setAttribute("StaffArray",StaffArray);
			destination="/views/Staff/DanhSachDK.jsp";
			//RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
			RequestDispatcher rd=getServletContext().getRequestDispatcher(destination);
			//RequestDispatcher rd=request.getRequestDispatcher(destination);
			rd.forward(request, response);
			break;
		case "Cập nhật":
			String []na = request.getParameterValues("check");
			String dulieu="";
			for(String i:na) {
				dulieu=dulieu+i+",";
				System.out.println(dulieu);
			}
			StaffBO staffbo = new StaffBO();
		
			staffbo.capnhatdk(dulieu);
			CheckLoginBO checkLoginBO2=new CheckLoginBO();
		//	String destination=null;
		//	ArrayList<Staff> StaffArray=null;
			StaffArray=checkLoginBO2.DanhSachCPSV();
			request.setAttribute("StaffArray",StaffArray);
			destination="/views/Staff/DanhSachDK.jsp";
		   rd=getServletContext().getRequestDispatcher(destination);
			rd.forward(request, response);
			break;
		case "Reset":
			response.setContentType("text/html;charset=UTF-8");
			request.setCharacterEncoding("utf-8");
			//response.getWriter().append("Served at: ").append(request.getContextPath());
			CheckLoginBO checkLoginBO1=new CheckLoginBO();
			//String destination=null;
		//	ArrayList<Staff> StaffArray=null;
			StaffArray=checkLoginBO1.DanhSachCPSV();
			
			request.setAttribute("StaffArray",StaffArray);
			destination="/views/Staff/DanhSachDK.jsp";
		    rd=getServletContext().getRequestDispatcher(destination);
			rd.forward(request, response);
			break;
	}

}
}
