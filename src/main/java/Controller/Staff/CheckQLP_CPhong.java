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
import model.bo.CheckLoginBO;
import model.bo.StaffBO;

@WebServlet("/CheckQLP_CPhong")
public class CheckQLP_CPhong extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public CheckQLP_CPhong() {
        super();
   
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		String destinationString = null;
		StaffBO staffbo = new StaffBO();
		ArrayList <Staff> listUser = staffbo.CPhong();
		request.setAttribute("listUser", listUser);
		destinationString = "/views/Staff/QLP_CPhong.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(destinationString);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		String action = request.getParameter("id");
		switch (action) {
		case "Tìm kiếm":
			String values = request.getParameter("timkiem");
			System.out.println(values);
			StaffBO staffbo = new StaffBO();
			String destination=null;
			ArrayList<Staff> listUser=null;
			listUser=staffbo.TimkiemQLCP(values);
			request.setAttribute("listUser", listUser);
			destination="/views/Staff/QLP_CPhong.jsp";
			RequestDispatcher rd=getServletContext().getRequestDispatcher(destination);
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
			staffbo2.capnhatcp(dulieu);
			listUser=staffbo2.CPhong();
			request.setAttribute("listUser", listUser);
			destination="/views/Staff/QLP_CPhong.jsp";
			 rd=getServletContext().getRequestDispatcher(destination);
			rd.forward(request, response);
			break;
		case "Reset":
			response.setContentType("text/html;charset=UTF-8");
			request.setCharacterEncoding("utf-8");
			String destinationString = null;
			StaffBO staffbo1 = new StaffBO();
			 listUser = staffbo1.CPhong();
			request.setAttribute("listUser", listUser);
			destinationString = "/views/Staff/QLP_CPhong.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(destinationString);
			dispatcher.forward(request, response);

	}

}
}
