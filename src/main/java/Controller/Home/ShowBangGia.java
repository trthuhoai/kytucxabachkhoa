package Controller.Home;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bo.ShowBgBO;
import model.bean.*;

/**
 * Servlet implementation class ShowBangGia
 */
@WebServlet("/ShowBangGia")
public class ShowBangGia extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowBangGia() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String destination = null;
		ShowBgBO showBgBO = new ShowBgBO();
		ArrayList<PhiBD> pbd = null;
		pbd = showBgBO.getPBD();
		request.setAttribute("pbd", pbd);
		System.out.print("abc");
		
		ArrayList<BGLT> bglt = null;
		bglt = showBgBO.getBGLT();
		request.setAttribute("bglt", bglt);
		
		ArrayList<BGDB> bgdb = null;
		bgdb = showBgBO.getBGDB();
		request.setAttribute("bgdb", bgdb);
		destination="/view_cost.jsp";
		RequestDispatcher rd=getServletContext().getRequestDispatcher(destination);
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
