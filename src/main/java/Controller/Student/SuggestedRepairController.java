package Controller.Student;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.Notification;
import model.bean.RegisterRoom;
import model.bean.Student;
import model.bean.SuggestedRepair;
import model.bo.student.PersonalInfomationBO;
import model.bo.student.RegisterRoomBO;
import model.bo.student.SuggestedRepairBO;
import model.dao.student.SuggestedRepairDao;

@WebServlet("/dexuatsuachua")
public class SuggestedRepairController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SuggestedRepairController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		String destinationString = null;
		HttpSession session = request.getSession();
		if (session.getAttribute("user") == null) {
			destinationString = "/login.jsp";
		} else {
			System.out.println("ko");
			if (request.getParameter("noidung") != null) {
				System.out.println("co");
				SuggestedRepair suggestedRepair=new SuggestedRepair();
				SuggestedRepairBO suggestedRepairBO=new SuggestedRepairBO();
				PersonalInfomationBO personalInfomationBO=new PersonalInfomationBO();
				Student student=personalInfomationBO.getPersonalInfo((String) session.getAttribute("user"));
				suggestedRepair.setNoiDung(request.getParameter("noidung"));
				suggestedRepair.setDeXuat(request.getParameter("dexuat"));
				suggestedRepair.setGhiChu(request.getParameter("ghichu"));
				suggestedRepair.setChapNhan("0");
				suggestedRepair.setMaSV((String) session.getAttribute("user"));
				suggestedRepair.setiDPhong(student.getIDPhong());
				Date date = new Date();
				SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss a");
				String strDate = formatter.format(date);
				suggestedRepair.setThoiGianDK(strDate);
				suggestedRepairBO.AddSuggestedRepair(suggestedRepair);
				request.setAttribute("detail",suggestedRepair);
				request.setAttribute("message", "Bạn đã gửi đề xuất sửa chữa thành công!");
			}
			destinationString = "/views/Student/suggestedRepair.jsp";
		}

		RequestDispatcher rd = getServletContext().getRequestDispatcher(destinationString);
		rd.forward(request, response);
	}

}
