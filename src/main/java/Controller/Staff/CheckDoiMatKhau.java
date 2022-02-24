package Controller.Staff;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.Staff;
import model.bo.CheckLoginBO;
import model.bo.StaffBO;

/**
 * Servlet implementation class CheckDoiMatKhau
 */
@WebServlet("/CheckDoiMatKhau")
public class CheckDoiMatKhau extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckDoiMatKhau() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		// TODO Auto-generated method stub
		String destinationString = null; 
		destinationString = "/views/Staff/DoiMatKhau.jsp";
		RequestDispatcher rd = getServletContext().getRequestDispatcher(destinationString);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");HttpSession session = request.getSession();
		String manv= (String) session.getAttribute("user");
		System.out.print(manv);
		String old = request.getParameter("old");
		String newpass = request.getParameter("new");
		String renewpass = request.getParameter("renew");
		
		CheckLoginBO checkLoginBO = new CheckLoginBO();
		
		if (!checkLoginBO.isValidStaff(manv, old)) 
		{
			String message = "Bạn đã nhập sai mật khẩu cũ";
			request.setAttribute("message", message); 
		}
		else 
			{
				if (!newpass.equals(renewpass))
				{
					String message = "Mật khẩu không khớp";
					 request.setAttribute("message", message); 
				}
				else
				{
					if (newpass.equals(old))
					{
						String message = "Bạn đã nhập mật khẩu mới trùng với mật khẩu cũ";
						 request.setAttribute("message", message); 
					}
					else
					{
						StaffBO staffBo = new StaffBO();
						staffBo.DoiMatKhau(manv, newpass);
						String message = "Bạn đã cập nhật mật khẩu thành công!";
						request.setAttribute("message", message); 
					}
				}
			}
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/views/Staff/DoiMatKhau.jsp");
		rd.forward(request, response);
	}

	}

