package Controller.Student;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

import model.bean.Password;
import model.bean.Student;
import model.bo.student.PasswordBO;
import model.bo.student.PersonalInfomationBO;
import model.dao.student.PasswordDao;

@WebServlet("/resetpassword")
public class ResetPasswordProcessController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ResetPasswordProcessController() {
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
		Password password=new Password();
		password.setHoVaTen(request.getParameter("hovaten").trim());
		password.setMssv(request.getParameter("mssv").trim());
		password.setLop(request.getParameter("lop").trim());
		password.setEmail(request.getParameter("email").trim());
		password.setKhu(request.getParameter("khu").trim());
		password.setPhong(request.getParameter("phong").trim());
		String destinationString = null;
		PasswordBO passwordBo=new PasswordBO();
		boolean check=passwordBo.checkInfo(password);
		if(check) {
			 Random rand = new Random();
			 int ranNum = rand.nextInt(100000)+100000;
			 passwordBo.resetPassword(password.getMssv(),String.valueOf(ranNum));
			final String usernameString="ktxbachkhoa@gmail.com";
			final String mkString="ktxbachkhoa2801";
			Properties prop=new Properties();
			   String subject1 = "Reset Password";
		       String message1 = "<!DOCTYPE html>\n"
		                + "<html lang=\"en\">\n"
		                + "\n"
		                + "<head>\n"
		                + "</head>\n"
		                + "\n"
		                + "<body>\n"
		                + "    <h3 style=\"color: green;\">Đặt lại mật khẩu thành công.</h3>\n"
		                + "    <div>Ký túc xá bách khoa xin thông báo: bạn đã đặt lại mật khẩu thành công.</div>\n"
		                + " Mật khẩu mới của bạn là: "+ String.valueOf(ranNum)+"</div>\n"
		                + "    <div>Bạn nên đổi lại mật khẩu của bạn càng sớm càng tốt.</div>\n"
		                + "    <div>  </div>\n"
		                + "    <h3 style=\"color: green;\">Xin chân thành cảm ơn!</h3>\n"
		                + "\n"
		                + "</body>\n"
		                + "\n"
		                + "</html>";
			prop.setProperty("mail.transport.protocol", "smtp");     
		    prop.setProperty("mail.host", "smtp.gmail.com");  
		    prop.put("mail.smtp.auth", "true");  
		    prop.put("mail.smtp.port", "465");  
//		    prop.put("mail.debug", "true");  
		    prop.put("mail.smtp.socketFactory.port", "465");  
		    prop.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");  
		    prop.put("mail.smtp.socketFactory.fallback", "false");
			Session session=Session.getInstance(prop,new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					System.out.print("DONE1");
					return new PasswordAuthentication(usernameString, mkString);
				}
			});
			String emailToString=password.getEmail();
			
			try {
				Message message=new MimeMessage(session);
				message.setFrom(new InternetAddress(usernameString));
				message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailToString));
				message.setSubject(subject1);
				message.setContent(message1,"text/html; charset=utf-8"); 
				Transport.send(message);
				System.out.print("DONE");
			} catch (Exception e) {
				// TODO: handle exception
				System.out.print(e);
			}
			request.setAttribute("detail", password);
			request.setAttribute("message", "Bạn đã đổi mật khẩu thành công! Vui lòng kiểm tra email mà bạn đã đăng ký để lấy mật khẩu mới!");
		}
		else {
			request.setAttribute("detail", password);
			request.setAttribute("message", "Thông tin bạn nhập vào chưa chính xác!");
		}
		destinationString = "/views/Student/passwordRetrieval.jsp";
		RequestDispatcher rd = getServletContext().getRequestDispatcher(destinationString);
		rd.forward(request, response);
	}

}
