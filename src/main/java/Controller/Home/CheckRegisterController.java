package Controller.Home;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bo.CheckLoginBO;
import model.bo.CheckRegisterBO;
import model.bean.Student;

/**
 * Servlet implementation class CheckRegisterController
 */
@WebServlet("/registerProcess")
public class CheckRegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public CheckRegisterController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		String destinationString = null;
		String name = request.getParameter("hoten");
		String phone = request.getParameter("phone");
		String cmnd = request.getParameter("identify");
		String dob = request.getParameter("dob");
		String mssv = request.getParameter("mssv");
		String major = request.getParameter("major");
		String lop = request.getParameter("class");
		String gtinh = request.getParameter("gtinh");
		String password = request.getParameter("password");
		String repass = request.getParameter("reenterpass");
		Student student = new Student();
		student.setTenSV(name);
		student.setSDT(phone);
		student.setSoCCCD(cmnd);
		student.setNgaySinh(dob);
		student.setMaSV(mssv);
		student.setNganh(major);
		student.setLop(lop);
		student.setGioiTinh(gtinh);
		student.setMatKhau(password);
		student.setEmail(request.getParameter("email"));
		student.setDiaChi(request.getParameter("diachi"));
		CheckRegisterBO checkRegisterBO = new CheckRegisterBO();
		if((name.length()==0) || (phone.length()==0) || (cmnd.length()==0) ||  (mssv.length()==0) || (major.length()==0) || (lop.length()==0) || (gtinh.length()==0) || (password.length()==0) || (repass.length()==0) || (!(password.equals(repass))))
		{
			String error = "Vui lòng nhập đủ thông tin";
			System.out.print(error);
			destinationString = "/register.jsp";
			request.setAttribute("error", error);
						
		}
		else
		{
			if(hasSpecialCharacter(name))
			{
				System.out.print(hasSpecialCharacter(name));
				String error = "Tên không chứa số và kí tự đặc biệt";
				destinationString = "/register.jsp";
				request.setAttribute("error", error);
//				RequestDispatcher rd=getServletContext().getRequestDispatcher(destinationString);
//				rd.forward(request, response);
			}
			else if(notNumber(phone))
			{
				System.out.print(notNumber(phone));
				String error = "SĐT chỉ bao gồm số";
				destinationString = "/register.jsp";
				request.setAttribute("error", error);
			}
			else if(notNumber(cmnd))
			{
				System.out.print(notNumber(cmnd));
				String error = "CMND chỉ bao gồm số";
				destinationString = "/register.jsp";
				request.setAttribute("error", error);
			}
			else if(notNumber(mssv))
			{
				System.out.print(notNumber(mssv));
				String error = "MSSV chỉ bao gồm số";
				destinationString = "/register.jsp";
				request.setAttribute("error", error);
			}
			else if(hasSpecialCharacter(major))
			{
				System.out.print(hasSpecialCharacter(major));
				String error = "Ngành không chứa số và kí tự đặc biệt";
				destinationString = "/register.jsp";
				request.setAttribute("error", error);
			}
			else if(notNumberAndCharacter(lop))
			{
				System.out.print(notNumberAndCharacter(lop));
				String error = "Lớp không bao gồm kí tự đặc biệt";
				destinationString = "/register.jsp";
				request.setAttribute("error", error);
			}
			else if(checkRegisterBO.isNotValidNewUser(student))
			{
				System.out.print(123);
				destinationString = "/register.jsp";
				String error = "Tài khoản đã tồn tại";
				request.setAttribute("error", error);
			}
			else {
				String error = "Bạn đã đăng ký lưu trú thành công";
				request.setAttribute("error", error);
				
				destinationString = "/register.jsp";
			}
		}
		request.setAttribute("student", student);
		RequestDispatcher rd = getServletContext().getRequestDispatcher(destinationString);
		rd.forward(request, response);
	}
	
	public boolean hasSpecialCharacter(String s) {
	     return false;
	}
	public boolean notNumber(String s) {
	     
	     Pattern p = Pattern.compile("[^0-9]");
	     Matcher m = p.matcher(s);
	     boolean b = m.find();
	     return b;
	}
	public boolean notNumberAndCharacter(String s) {
	     
	     Pattern p = Pattern.compile("[^A-Za-z0-9]");
	     Matcher m = p.matcher(s);
	     boolean b = m.find();
	     return b;
	}

}
