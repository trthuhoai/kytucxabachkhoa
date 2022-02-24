package Controller.Student;

import java.io.IOException;
import java.text.Format;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.Notification;
import model.bean.RegisterRoom;
import model.bean.RentalFee;
import model.bean.Student;
import model.bo.student.PersonalInfomationBO;
import model.bo.student.RegisterRoomBO;
import model.bo.student.RentalFeeBO;

@WebServlet("/phithuephong")
public class RentalFeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RentalFeeController() {
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
		PersonalInfomationBO personalInfomationBO = new PersonalInfomationBO();
		if (session.getAttribute("user") == null) {
			destinationString = "/login.jsp";
		} else {
			String ms=(String)session.getAttribute("user");
			RentalFeeBO rentalFeeBO=new RentalFeeBO();
			RentalFee rentalFee=rentalFeeBO.getRentalFeeInfo(ms , "1");
			Locale localeVN = new Locale("vi", "VN");
		    NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
		    String str1 = currencyVN.format(rentalFee.getPhiMoiThang());
		    request.setAttribute("phimoithang", str1);
		    String str2 = currencyVN.format(rentalFee.getTongPhi());
		    request.setAttribute("tongphi", str2);
			Date date=null;
			  try {
				date = new SimpleDateFormat("yyyy-MM-dd").parse(rentalFee.getThoiHan());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  Format formatter = new SimpleDateFormat("dd/MM/yyyy");
			  rentalFee.setThoiHan(formatter.format(date));
			request.setAttribute("fee", rentalFee);
			Student student = personalInfomationBO.getPersonalInfo((String) session.getAttribute("user"));
			request.setAttribute("student", student);
			System.out.println("ko");
			if (request.getParameter("httt") != null) {
				request.setAttribute("httt", request.getParameter("httt"));
				System.out.println("co");
				rentalFee.setHinhThucNop(request.getParameter("httt"));
				rentalFee.setHocKy("1");
				rentalFeeBO.updateRentalFeeInfo(rentalFee);
				request.setAttribute("message", "Bạn đã cập nhật thông tin thành công!");
			}
			destinationString = "/views/Student/rentalFee.jsp";
		}

		RequestDispatcher rd = getServletContext().getRequestDispatcher(destinationString);
		rd.forward(request, response);
	}

}
