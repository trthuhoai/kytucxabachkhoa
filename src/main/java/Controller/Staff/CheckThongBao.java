package Controller.Staff;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bo.StaffBO;

/**
 * Servlet implementation class CheckThongBao
 */
@WebServlet("/CheckThongBao")
public class CheckThongBao extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckThongBao() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String destinationString = null; 
		destinationString = "/views/Staff/ThongBao.jsp";
		RequestDispatcher rd = getServletContext().getRequestDispatcher(destinationString);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		String tieude = request.getParameter("tieude");
		String noidung = request.getParameter("noidung");
		if (noidung.equals("") || tieude.equals(""))
		{
			String message = "Vui lòng nhập đầy đủ thông tin";
			 request.setAttribute("message", message); 
			 System.out.print(message);
		}
		else {
			long millis=System.currentTimeMillis();   
			java.sql.Date date=new java.sql.Date(millis);   
			System.out.println(date); 
			HttpSession session = request.getSession();
			String manv= (String) session.getAttribute("user");
			System.out.print(manv);
			StaffBO staffBo = new StaffBO();
			staffBo.DangThongBao(manv, date, tieude, noidung);
			String message = "Bạn đã đăng thông báo thành công";
			request.setAttribute("message", message);
		}
		
	
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/views/Staff/ThongBao.jsp");
		rd.forward(request, response);
	}

}
