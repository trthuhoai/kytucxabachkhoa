package Controller.Staff;

import java.io.IOException;
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
import javax.servlet.http.HttpSession;

import model.bean.Staff;
import model.bo.StaffBO;

@WebServlet("/CheckQL_TienDienNuoc")
public class CheckQL_TienDienNuoc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckQL_TienDienNuoc() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		String destinationString = null;
		StaffBO staffbo = new StaffBO();
		ArrayList <Staff> listUser = staffbo.TienDienNuoc();
		request.setAttribute("listUser", listUser);
		destinationString = "/views/Staff/XemDanhSachDienNuoc.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(destinationString);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		String nguoiNop=request.getParameter("nguoinop");
		if(nguoiNop!=null) {
			String ngayNop=request.getParameter("ngaynop");
			String destination=null;
			int id=Integer.parseInt(request.getParameter("capnhat"));
			StaffBO staffbo1 = new StaffBO();
			staffbo1.capnhatphiDN(nguoiNop, ngayNop, id);
			ArrayList<Staff> listUser=null;
			 listUser = staffbo1.TienDienNuoc();
			request.setAttribute("listUser", listUser);
			destination = "/views/Staff/XemDanhSachDienNuoc.jsp";
			RequestDispatcher rd=getServletContext().getRequestDispatcher(destination);
			rd.forward(request, response);
		}
		else {
		String action = request.getParameter("id");
		HttpSession session=request.getSession();
		System.out.println(action);
		switch (action) {
		case "Tìm kiếm":
			String nha= (String) session.getAttribute("nha");
			String values = request.getParameter("timkiem");
			System.out.println(values);
			StaffBO staffbo = new StaffBO();
			String destination=null;
			ArrayList<Staff> listUser=null;
			listUser=staffbo.TimkiemTienDienNuoc(values,nha);
			request.setAttribute("listUser", listUser);
			destination = "/views/Staff/XemDanhSachDienNuoc.jsp";
			RequestDispatcher rd=getServletContext().getRequestDispatcher(destination);
			rd.forward(request, response);
			break;
		case "Cập nhật":
			String []na = request.getParameterValues("check");
			String []ngay = request.getParameterValues("ngay");
			   StaffBO staffbo2 = new StaffBO();
			String ngaynop="";
			String trangthai="";
			for(String i:ngay) {
				if(i.equals("")) continue;
				ngaynop=ngaynop+i+",";
				System.out.println(ngaynop);
			}	
			for(String i:na) {
				
				trangthai=trangthai+i+",";
				System.out.println(trangthai);
			}
		
			staffbo2.capnhatthanhtoan(trangthai);
			staffbo2.capnhatngaynop(ngaynop, trangthai);
			listUser=staffbo2.TienDienNuoc();
			request.setAttribute("listUser", listUser);
			destination = "/views/Staff/XemDanhSachDienNuoc.jsp";
			rd=getServletContext().getRequestDispatcher(destination);
			rd.forward(request, response);
			break;
		case "Reset":
			response.setContentType("text/html;charset=UTF-8");
			request.setCharacterEncoding("utf-8");
			String destinationString = null;
			StaffBO staffbo1 = new StaffBO();
			 listUser = staffbo1.TienDienNuoc();
			request.setAttribute("listUser", listUser);
			destinationString = "/views/Staff/XemDanhSachDienNuoc.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(destinationString);
			dispatcher.forward(request, response);
		case "Dữ liệu":
			
			String nha1= request.getParameter("nha");
			request.setAttribute("nha1", nha1);
			String tg= request.getParameter("time");
			request.setAttribute("tg", tg);
			StaffBO staffBO= new StaffBO();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM");
			    ArrayList<Staff> listUser1=staffBO.TimKiemthangnamdiennc(nha1,tg);
			    request.setAttribute("listUser", listUser1);
			     rd=getServletContext().getRequestDispatcher("/views/Staff/XemDanhSachDienNuoc.jsp");
				rd.forward(request, response);
			    
		}
	}
	}

}
