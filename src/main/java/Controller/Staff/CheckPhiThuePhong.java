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
 * Servlet implementation class CheckHocPhi
 */
@WebServlet("/CheckPhiThuePhong")
public class CheckPhiThuePhong extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckPhiThuePhong() {
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
		StaffBO staffBo=new StaffBO();
		 ArrayList<Staff> StaffArray=staffBo.PhiThuePhong();
			request.setAttribute("StaffArray",StaffArray);
		String destinationString = null; 
		destinationString = "/views/Staff/PhiThuePhong.jsp";
		RequestDispatcher rd = getServletContext().getRequestDispatcher(destinationString);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		String ngayNop=request.getParameter("ngaythanhtoan");
		StaffBO staffBo=new StaffBO();
		String destinationString = null; 
		ArrayList<Staff> StaffArray = null;
		if(ngayNop!=null) {
			int id=Integer.parseInt(request.getParameter("capnhat"));
			StaffBO staffbo1 = new StaffBO();
			staffbo1.capnhatphiThue(ngayNop, id);
			ArrayList<Staff> listUser=null;
			StaffArray=staffBo.PhiThuePhong();
				request.setAttribute("StaffArray",StaffArray);
			destinationString = "/views/Staff/PhiThuePhong.jsp";
			
			RequestDispatcher rd=getServletContext().getRequestDispatcher(destinationString);
			rd.forward(request, response);
		}
		else {
		String action = request.getParameter("id");
		HttpSession session=request.getSession();
		System.out.print("aaaaavvvvv"+action);
		destinationString = "/views/Staff/PhiThuePhong.jsp";
		switch (action) {
		case "Tìm kiếm":
			int hocky=  Integer.parseInt(request.getParameter("hocky")) ;
			String namhoc= request.getParameter("namhoc");
			String val = request.getParameter("timkiem");
			System.out.print("vvvvv"+val);
			StaffArray=staffBo.timkiemPhiThuePhongMsv(val, namhoc, hocky);
			request.setAttribute("StaffArray",StaffArray);
			break;
		case "Dữ liệu":
			System.out.print("vvvvv");
			int  hocky1= Integer.parseInt(request.getParameter("hocky"));
			session.setAttribute("hocky",hocky1);
			String namhoc1= request.getParameter("namhoc");
			session.setAttribute("namhoc",namhoc1);
			System.out.print(hocky1);
			StaffArray=staffBo.TimkiemPhiThuePhong(namhoc1, hocky1);
			request.setAttribute("StaffArray",StaffArray);
			break;
		case "Cập nhật":
			String []masv1 = request.getParameterValues("check");
			String []ngaynop1 = request.getParameterValues("check1");

			String ngaynop="";
			String masv="";
			for(String i:masv1) {
				masv=masv+i+",";
				System.out.println(masv);
				}
				
			for(String i:ngaynop1) {
				if(i.equals("")) continue;
				ngaynop=ngaynop+i+",";
				System.out.println(ngaynop);	
				}	
			staffBo.UpdatePhiThuePhong(ngaynop, masv);
			String message= "Bạn đã xác nhận thành công";
			request.setAttribute("message",message);
			StaffArray=staffBo.PhiThuePhong();
			request.setAttribute("StaffArray",StaffArray);
			
			break;
		default:
			break;
	}
		RequestDispatcher rd = getServletContext().getRequestDispatcher(destinationString);
		rd.forward(request, response);
		}

}}
