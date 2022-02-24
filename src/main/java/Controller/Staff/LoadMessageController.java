package Controller.Staff;

import java.io.IOException;
import java.io.PrintWriter;
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

import model.bean.Chat;
import model.bean.Notification;
import model.bean.RegisterRoom;
import model.bean.Student;
import model.bo.student.ChatBO;
import model.bo.student.PersonalInfomationBO;
import model.bo.student.RegisterRoomBO;
import model.dao.student.ChatDao;

@WebServlet("/loadtn")
public class LoadMessageController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoadMessageController() {
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
			ChatBO chatBO=new ChatBO();
			HttpSession session = request.getSession(false);
			ArrayList<Chat> chat =chatBO.getChatList((String) session.getAttribute("user"));
			
			PrintWriter out = response.getWriter();
//			out.println("<h4  style=\" color: green; font-size:22px; \">Nhắn tin</h4>\r\n"
//					+ "				<hr class=\"soften\" />	");	
			
			for (Chat c:chat) {
				out.println("<div class=\"row\" align=\"center\">"+c.getThoiGian()+"</div>");
				if(c.getMaNV().equals(c.getNguoiGui())) {
					if(c.getLenNoiDung()<8) {
						out.println("<div class=\"row\" >\r\n"
								+ "									<div class=\"span10\"></div>\r\n"
								+ "									<div class=\"span1\" align=\"right\">\r\n"
								+ "										 <div class=\"well well-small\" style=\"padding: 9px;color: #ffffff; font-size: 16px; min-height: 0px; background: #6d4579; margin-bottom: 0px\">"+c.getNoiDung()+"\r\n"
								+ "											</div>\r\n"
								+ "										</div>\r\n"
								+ "								</div>");
					}
					
					else if(c.getLenNoiDung()>=8&&c.getLenNoiDung()<20) {
						out.println("	<div class=\"row\" >\r\n"
								+ "									<div class=\"span9\"></div>\r\n"
								+ "									<div class=\"span2\" align=\"right\">\r\n"
								+ "										 <div class=\"well well-small\"\r\n"
								+ "										style=\"padding: 9px;color: #ffffff; font-size: 16px; min-height: 0px; background: #6d4579; margin-bottom: 0px\">"+c.getNoiDung()+"\r\n"
								+ "										</div>\r\n"
								+ "										</div>\r\n"
								+ "								</div>");
					}
					else if(c.getLenNoiDung()>=20&&c.getLenNoiDung()<40) {
						out.println("<div class=\"row\" >\r\n"
								+ "									<div class=\"span8\"></div>\r\n"
								+ "									<div class=\"span3\" align=\"right\">\r\n"
								+ "										 <div class=\"well well-small\"\r\n"
								+ "										style=\"padding: 9px;color: #ffffff; font-size: 16px; min-height: 0px; background: #6d4579; margin-bottom: 0px\">"+c.getNoiDung()+"\r\n"
								+ "												</div>\r\n"
								+ "										</div>\r\n"
								+ "								</div>");
					}
					else if(c.getLenNoiDung()>=40&&c.getLenNoiDung()<60) {
						out.println("<div class=\"row\" >\r\n"
								+ "									<div class=\"span7\"></div>\r\n"
								+ "									<div class=\"span4\" align=\"right\">\r\n"
								+ "										 <div class=\"well well-small\"\r\n"
								+ "										style=\"padding: 9px;color: #ffffff; font-size: 16px; min-height: 0px; background: #6d4579; margin-bottom: 0px\">$"+c.getNoiDung()+"\r\n"
								+ "												</div>\r\n"
								+ "										</div>\r\n"
								+ "								</div>");
					}
					else {
						out.println("<div class=\"row\" >\r\n"
								+ "									<div class=\"span6\"></div>\r\n"
								+ "									<div class=\"span5\" align=\"right\">\r\n"
								+ "										 <div class=\"well well-small\"\r\n"
								+ "										style=\"padding: 9px;color: #ffffff; font-size: 16px; min-height: 0px; background: #6d4579; margin-bottom: 0px\">"+c.getNoiDung()+"\r\n"
								+ "												</div>\r\n"
								+ "										</div>\r\n"
								+ "								</div>");
					}
				}
				else {
					if(c.getLenNoiDung()<8) {
						out.println("<div class=\"row\">\r\n"
								+ "										<div class=\"span1\">					\r\n"
								+ "											<div class=\"well well-small\" style=\"padding: 9px;font-size: 16px;;min-height: 0px; background: #dbd2dc; margin-bottom:0px\">"+c.getNoiDung()+"</div>\r\n"
								+ "										</div>\r\n"
								+ "									</div>");
					}
					else if(c.getLenNoiDung()>=8&&c.getLenNoiDung()<25) {
						out.println("<div class=\"row\">\r\n"
								+ "										<div class=\"span2\">					\r\n"
								+ "											<div class=\"well well-small\" style=\"padding: 9px;font-size: 16px;;min-height: 0px; background: #dbd2dc; margin-bottom:0px\">"+c.getNoiDung()+"</div>\r\n"
								+ "										</div>\r\n"
								+ "									</div>");
					}
					else if(c.getLenNoiDung()>=25&&c.getLenNoiDung()<20) {
						out.println("<div class=\"row\">\r\n"
								+ "										<div class=\"span3\">					\r\n"
								+ "											<div class=\"well well-small\" style=\"padding: 9px;font-size: 16px;;min-height: 0px; background: #dbd2dc; margin-bottom:0px\">"+c.getNoiDung()+"</div>\r\n"
								+ "										</div>\r\n"
								+ "									</div>");
					}
					else if(c.getLenNoiDung()>=20&&c.getLenNoiDung()<60) {
						out.println("<div class=\"row\">\r\n"
								+ "										<div class=\"span4\">					\r\n"
								+ "											<div class=\"well well-small\" style=\"padding: 9px;font-size: 16px;;min-height: 0px; background: #dbd2dc; margin-bottom:0px\">"+c.getNoiDung()+"</div>\r\n"
								+ "										</div>\r\n"
								+ "									</div>");
					}
					else {
						out.println("<div class=\"row\">\r\n"
								+ "										<div class=\"span5\">					\r\n"
								+ "											<div class=\"well well-small\" style=\"padding: 9px;font-size: 16px;;min-height: 0px; background: #dbd2dc; margin-bottom:0px\">"+c.getNoiDung()+"</div>\r\n"
								+ "										</div>\r\n"
								+ "									</div>");
					}
				}
				
			}
			out.println("<div id=\"nt\" class=\"row\" ></div>\r\n");
			
			}

}
