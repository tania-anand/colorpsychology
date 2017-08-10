package trainingEE;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class userCheck
 */
@WebServlet("/userCheck")
public class userCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		String uname=request.getParameter("loginId");
		
		
	
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		UserBean u = new UserBean();
		u.setUname(uname);
	
		
		JDBChelper helper = new JDBChelper();
		helper.openConnection();
		
		boolean flag = helper.checkUname(u);
		
		response.setHeader("flag", String.valueOf(flag));
		
	
	}

}
