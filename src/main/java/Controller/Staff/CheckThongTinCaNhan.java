package Controller.Staff;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.Staff;
import model.bo.CheckLoginBO;
//import Controller.Home.*;
import model.bo.StaffBO;

/**
 * Servlet implementation class CheckThongTinCaNhan
 */
@WebServlet("/CheckThongTinCaNhan")
public class CheckThongTinCaNhan extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String Matkhau = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckThongTinCaNhan() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    public boolean SpecialCharacter(String s) {
        
        Pattern p = Pattern.compile("[^A-Za-z]");
        Matcher m = p.matcher(s);
        boolean b = m.find();
        return b;
   }
public boolean number(String s) {
        
        Pattern p = Pattern.compile("[0-9]");
        Matcher m = p.matcher(s);
        boolean b = m.find();
        return b;
   }
public boolean chieudai (String s)
{
	int len = s.length();
	if (len == 0 ) return true;
	return false;
}
public boolean Check(String b)
{
	boolean status = true;
	for (int i =0 ; i <= b.length() - 1 ; i++)
	{
		char c;
		c = b.charAt(i);
		if ( c < '0' || c > '9')
		{
			status = false;
			break;
		}
	}
	return status;
}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String manv= (String) session.getAttribute("user");
		System.out.print(manv);
		CheckLoginBO checkLoginBO=new CheckLoginBO();
		String destination=null;
		ArrayList<Staff> StaffArray=null;
		StaffArray=checkLoginBO.getUpdateNV(manv);
		request.setAttribute("StaffArray",StaffArray);
		for (int i = 0; i < StaffArray.size(); i++) {
		System.out.println(StaffArray.get(i));
		}
		destination="/views/Staff/ThongTinCaNhan.jsp";
		RequestDispatcher rd=getServletContext().getRequestDispatcher(destination);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		StaffBO staffBo= new StaffBO();
		System.out.print("dfdg");
		HttpSession session = request.getSession();
		String manv= (String) session.getAttribute("user");
		System.out.print(manv);
		String diachi = request.getParameter("diachi").trim();
		String sdt = request.getParameter("sdt").trim() ;
		String stk = request.getParameter("stk").trim();
		String tennh = request.getParameter("tennh").trim();
		String tencha = request.getParameter("tencha").trim();
		String ngaysinhcha = request.getParameter("ngaycha").trim();
		String tenme = request.getParameter("tenme").trim();
		String ngaysinhme = request.getParameter("ngayme").trim();
		String email = request.getParameter("email").trim();
		String chucvu = request.getParameter("chucvu").trim();
		String tennguoibt = request.getParameter("tennguoibt").trim();
		String quanhe = request.getParameter("quanhe").trim();
		String sdtbt = request.getParameter("sdtbt").trim();
		String diachibt = request.getParameter("diachibt").trim();
		System.out.print("goj ne");
		if (!Check(sdt) || !Check(stk) || !Check(sdtbt) )
		{
			 String message = "Bạn nhập sai sđt hoặc stk hoặc sdtbt ";
			 request.setAttribute("message", message); 	
		}
		else
		{
			if (tennh.isEmpty() || diachi.isEmpty() || email.isEmpty()|| chucvu.isEmpty()||  stk.isEmpty()|| sdt.isEmpty() )
			{
			
				String message = "Bạn nhập thiếu ";
				 request.setAttribute("message", message); 
			}
			else
			{
				staffBo.UpdateTTCN(manv, diachi, sdt, stk, tennh, tencha, ngaysinhcha, tenme, ngaysinhme, email, chucvu, tennguoibt, quanhe, sdtbt, diachibt);
				String message = "Bạn đã cập nhật thông tin thành công";
				 request.setAttribute("message", message); 
			}
		}
		CheckLoginBO checkLoginBO=new CheckLoginBO();
		String destination=null;
		ArrayList<Staff> StaffArray=null;
		StaffArray=checkLoginBO.getUpdateNV(manv);
		request.setAttribute("StaffArray",StaffArray);
		 String destination1 = "/views/Staff/ThongTinCaNhan.jsp";
		 RequestDispatcher dispatcher = request.getRequestDispatcher(destination1);
            dispatcher.forward(request, response);
	
	}

	
}
