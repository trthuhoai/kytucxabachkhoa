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
		                + "    <h3 style=\"color: green;\">?????t l???i m???t kh???u th??nh c??ng.</h3>\n"
		                + "    <div>K?? t??c x?? b??ch khoa xin th??ng b??o: b???n ???? ?????t l???i m???t kh???u th??nh c??ng.</div>\n"
		                + " M???t kh???u m???i c???a b???n l??: "+ String.valueOf(ranNum)+"</div>\n"
		                + "    <div>B???n n??n ?????i l???i m???t kh???u c???a b???n c??ng s???m c??ng t???t.</div>\n"
		                + "    <div>  </div>\n"
		                + "    <h3 style=\"color: green;\">Xin ch??n th??nh c???m ??n!</h3>\n"
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
			request.setAttribute("message", "B???n ???? ?????i m???t kh???u th??nh c??ng! Vui l??ng ki???m tra email m?? b???n ???? ????ng k?? ????? l???y m???t kh???u m???i!");
		}
		else {
			request.setAttribute("detail", password);
			request.setAttribute("message", "Th??ng tin b???n nh???p v??o ch??a ch??nh x??c!");
		}
		destinationString = "/views/Student/passwordRetrieval.jsp";
		RequestDispatcher rd = getServletContext().getRequestDispatcher(destinationString);
		rd.forward(request, response);
	}

}
