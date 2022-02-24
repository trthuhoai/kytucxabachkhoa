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
 * Servlet implementation class CheckQLP_TraPhong
 */
@WebServlet("/CheckQLP_TraPhong")
public class CheckQLP_TraPhong extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckQLP_TraPhong() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		String destinationString = null;
		StaffBO staffbo = new StaffBO();
		ArrayList <Staff> listUser = staffbo.TraPhong();
		request.setAttribute("listUser", listUser);
		destinationString = "/views/Staff/QLP_TraPhong.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(destinationString);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String action = request.getParameter("id");
        System.out.println(action);
        StaffBO staffbo = new StaffBO();
        ArrayList<Staff> listUser=null;
        switch (action) {
        case "Tìm kiếm":
            String values = request.getParameter("timkiem");
            System.out.println(values);
            String destination=null;
            listUser=staffbo.TimkiemQLTP(values);
            request.setAttribute("listUser", listUser);

            break;
        case "Cập nhật":
            staffbo.UpdateTraPhong();
            listUser=staffbo.TraPhong();
            request.setAttribute("listUser", listUser);
            break;
    }
        RequestDispatcher rd=getServletContext().getRequestDispatcher("/views/Staff/QLP_TraPhong.jsp");

        rd.forward(request, response);
    
	
	}

}
