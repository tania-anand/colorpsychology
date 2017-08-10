package trainingEE;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Home
 */
@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Home()
    {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException
	{
	
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		

	    Cookie[] cookie  = request.getCookies();
	    
	    try
	    {
		for (Cookie ck : cookie)
		{
			
			out.print(ck.getName()+" - "+ck.getValue()+"<br/>");
//			switch(ck.getName())
//			{
//			case "cookieU":
//				out.print("user name "+ck.getValue()+"<br>");
//				break;
//			case "cookieP":
//				out.print("password "+ck.getValue()+"<br>");
//				break;
//			}
		}
	    }
	    catch(Exception e)
	    {
	    	out.println(e);
	    }
	    
		

}
}
