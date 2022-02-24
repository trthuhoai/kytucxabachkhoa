package Controller.Home;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Contact;
import model.bo.CheckSaveContactBO;

/**
 * Servlet implementation class SaveContact
 */
@WebServlet("/SaveContact")
public class SaveContact extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveContact() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		// TODO Auto-generated method stub
		String destinationString = null;
		String name = request.getParameter("name");
		String mssv = request.getParameter("mssv");
		String phone = request.getParameter("phone");
		String content = request.getParameter("content");
		Contact contact = new Contact();
		contact.setHoten(name);
		contact.setMaSV(mssv);
		contact.setSDT(phone);
		contact.setContent(content);
		CheckSaveContactBO checkSaveContactBO = new CheckSaveContactBO();
		if(checkSaveContactBO.isSaveSuccess(contact))
		{
			String result = "Chúng tôi đã lưu thông tin và sẽ liên hệ với bạn sau!!!";
			destinationString = "/123.jsp";
			request.setAttribute("thongbao", result);
			
		}
		else
		{
			String result = "LLỗi kết nối cơ sở dữ liệu, vui lòng thử lại!!!";
			destinationString = "/123.jsp";
			request.setAttribute("thongbao", result);
		}
		RequestDispatcher rd=getServletContext().getRequestDispatcher(destinationString);
		rd.forward(request, response);
	}

}
