package trainingEE;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet({ "/RegisterServlet", "/Register" })
public class RegisterServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String name="",phoneNo="",gender="",date="",email="",uname="",password="";
		
		name = request.getParameter("name");
		phoneNo = request.getParameter("phoneNo");
		gender = request.getParameter("gender");
		date=request.getParameter("date");
		uname= request.getParameter("uname");
		email=request.getParameter("email");
		password= request.getParameter("password");
		
		UserBean u = new UserBean(name, phoneNo,gender, date, email, uname, password);
		
		JDBChelper helper = new JDBChelper();
		helper.openConnection();
		helper.insert(u);
		helper.closeConnection();
		
		
        RequestDispatcher dispatcher = request.getRequestDispatcher("login1.jsp");
		dispatcher.include(request, response);
	}

}
