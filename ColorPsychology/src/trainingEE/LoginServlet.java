package trainingEE;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet({ "/LoginServlet", "/Login" })
public class LoginServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		
		String uname=request.getParameter("login_name");
		String password =request.getParameter("login_password");
		
	
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		UserBean u = new UserBean();
		u.setUname(uname);
		u.setPassword(password);
		
		JDBChelper helper = new JDBChelper();
		helper.openConnection();
		
		if(helper.authenticate(u))
		{
			
//			out.print("<html><body>");
//			out.print("<h3>Login is Success</h3>");
//			out.print("</body></html>");
			
//		    Cookie cookieU = new Cookie("cookieU",u.uname);
//			Cookie cookieP = new Cookie("cookieP",u.password);
//			
//		
//			response.addCookie(cookieU);
//			response.addCookie(cookieP);
//			
//			 out.print("Login Print UserN  "+cookieU.getValue()+"<br>");
//           out.print("Login Print Password  "+cookieP.getValue()+"<br>");
//			
//			
//			RequestDispatcher dispatcher = request.getRequestDispatcher("Home");
			
			HttpSession session = request.getSession();
			session.setAttribute("sessionU", u.getUname());
			session.setAttribute("sessionP", u.getPassword());
			
//			out.print("<h3 align='center'>Welcome User "+u.getUname()+"</h3>");
			
			
 
	        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.include(request, response);
			

//			out.print("<script>");
//			out.print("document.getElementbyId(\"user_name\").innerHTML=\"WELCOME\""+u.getUname()+"\"");
//          out.print("</script>");
            
			}
		
		else
		{
			 out.print("<script>");
			 out.print("alert('Login Failure')");
			 out.print("</script>");
			 
			 RequestDispatcher dispatcher = request.getRequestDispatcher("login1.jsp");
			 dispatcher.include(request, response);
		}
		
		helper.closeConnection();
		
	}

}
