package Controller.Student;

import java.io.IOException;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.ElectricityWaterCharge;
import model.bean.Notification;
import model.bean.RegisterRoom;
import model.bean.Room;
import model.bean.Student;
import model.bo.student.ElectricityWaterChargeBO;
import model.bo.student.PersonalInfomationBO;
import model.bo.student.RegisterRoomBO;
import model.bo.student.RoomBO;

@WebServlet("/phidiennuoc")
public class ElectricityWaterChargeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ElectricityWaterChargeController() {
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
			RoomBO roomBO=new RoomBO();
			Student student = personalInfomationBO.getPersonalInfo((String) session.getAttribute("user"));
			Room room=roomBO.getRoomInfo(student.getIDPhong());
			ElectricityWaterChargeBO electricityWaterChargeBO=new ElectricityWaterChargeBO();
			ElectricityWaterCharge electricityWaterCharge=new ElectricityWaterCharge();
			//TO DO
			electricityWaterCharge=electricityWaterChargeBO.getRentalFeeInfo(student.getIDPhong(), "2022-01");
			request.setAttribute("charge", electricityWaterCharge);
			Locale localeVN = new Locale("vi", "VN");
			NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
			String str1 = currencyVN.format(electricityWaterCharge.getTongTien());
			request.setAttribute("tongtien", str1);
			request.setAttribute("room", room);
			if (request.getParameter("httt") != null) {
				request.setAttribute("httt", request.getParameter("httt"));
				System.out.println("co");
				electricityWaterCharge.setHinhThucNop(request.getParameter("httt"));
				electricityWaterCharge.setNguoiNop(request.getParameter("daidien"));
				electricityWaterChargeBO.updateElectricityWaterCharge(electricityWaterCharge);
				request.setAttribute("message", "Bạn đã cập nhật thông tin thành công!");
			}
			destinationString = "/views/Student/electricityWaterCharge.jsp";
		}

		RequestDispatcher rd = getServletContext().getRequestDispatcher(destinationString);
		rd.forward(request, response);
	}

}
