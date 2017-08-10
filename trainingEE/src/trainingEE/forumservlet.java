
package trainingEE;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class forumservlet
 */
@WebServlet("/forumservlet")
public class forumservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public forumservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	HttpSession session=request.getSession();
	session.getAttribute("keyusername");
	
	String username=(String)session.getAttribute("keyusername");
	String comment=request.getParameter("comment");
	
	System.out.println(comment);
	
    CMcomments cmt=new CMcomments();
	cmt.setComment(comment);
	cmt.setUsername(username);
	JDBChelper helper=new JDBChelper();
	helper.openConnection();
	
	helper.insert(cmt);
	
	
	helper.closeConnection();
	
	RequestDispatcher dispatcher=request.getRequestDispatcher("forum.jsp");
	dispatcher.forward(request, response);
	

	}

}
