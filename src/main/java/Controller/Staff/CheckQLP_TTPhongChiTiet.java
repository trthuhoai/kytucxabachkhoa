package Controller.Staff;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.Staff;
import model.bo.StaffBO;

/**
 * Servlet implementation class CheckQLP_TTPhongChiTiet
 */
@WebServlet("/CheckQLP_TTPhongChiTiet")
public class CheckQLP_TTPhongChiTiet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckQLP_TTPhongChiTiet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		HttpSession session=request.getSession();
		String idphong = request.getParameter("idphong");
		session.setAttribute("idphong",idphong);
		System.out.print(idphong);
		StaffBO staffbo = new StaffBO();
		String destination=null;
		ArrayList<Staff> listUser=null;
		listUser=staffbo.thongtinchitiet(idphong);
		request.setAttribute("listUser", listUser);
		destination="/views/Staff/XemDanhSachChiTiet.jsp";
		RequestDispatcher rd=getServletContext().getRequestDispatcher(destination);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		HttpSession session=request.getSession();
		 String idphong= (String) session.getAttribute("idphong");
		String values = request.getParameter("timkiem");
		System.out.print(idphong);
		StaffBO staffbo = new StaffBO();
		String destination=null;
		ArrayList<Staff> listUser=null;
		listUser=staffbo.Timkiemthongtinchitiet(idphong, values);
		request.setAttribute("listUser", listUser);
		destination="/views/Staff/XemDanhSachChiTiet.jsp";
		RequestDispatcher rd=getServletContext().getRequestDispatcher(destination);
		rd.forward(request, response);
	}

}
