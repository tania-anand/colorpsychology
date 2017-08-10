package trainingEE;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;


public class JDBChelper 
{
	Connection conn;
	Statement stmnt;
	PreparedStatement pstmnt;
	ResultSet rsSet;

	CallableStatement cstmnt;
	
public JDBChelper()
	{
	try
	{
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("+++Driver Loaded+++");
		
	}
	catch(Exception e)
	{
		System.out.println("Exception is :"+e);
	}
	}

public void openConnection()
	{
	String url ="jdbc:mysql://localhost/db";
	String user ="root";
	String password="root";
	
	try 
	{
		conn = DriverManager.getConnection(url, user, password);
		System.out.println("+++Connection Created +++");
	} 
	catch (SQLException e) 
	{
		
		System.out.println("Exception is :"+e);
	}
	}

public void closeConnection()
	{
	try 
	{
		conn.close();
		System.out.println("++Connection Closed++");
	} 
	catch (Exception e) 
	{
		System.out.println("Exception is: "+e);
	}
}
public void insert(UserBean u)
{
	try
	{
		
		String sql = "insert into psychologycolor values(null,?,?,?,?,?,?,?)" ;
		pstmnt = conn.prepareStatement(sql);
		
		pstmnt.setString(1,u.getName());
		pstmnt.setString(2,u.getPhoneNo());
		pstmnt.setString(3,u.getGender());
		pstmnt.setString(4,u.getDate());
		pstmnt.setString(5,u.getEmail());
		pstmnt.setString(6,u.getUname());
		pstmnt.setString(7,u.getPassword());
	    pstmnt.executeUpdate();
		
		System.out.println("+++User Inserted++ ");
	} 
	  catch (Exception e) 
	{
		System.out.println("Exception is: "+e);
	}
}

public int insert(CMcomments cmt)
{
	int i=0;
	try {
		String sql="insert into comments_table values(null,?,?)";	
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1,cmt.getUsername());
		pstm.setString(2,cmt.getComment());
		

	    i=pstm.executeUpdate();


	    System.out.println("--Comment saved--"+ ""+i);
		
		
	} 
	catch (Exception e)
	{
		System.out.println("Exception is: "+e);
	}
	return i;
}

public ArrayList<CMcomments> retrievecomments(){
	
	ArrayList<CMcomments> cmtlist = new ArrayList<CMcomments>();
	

		String sql = "select * from carmaniacscomment";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			
			String n="",p="";

			while(rs.next())
			{
				
				n = rs.getString("username");
				p = rs.getString("comment");
	
				System.out.println(n+" - "+p);
		       System.out.println("--------------------------------");
			
				CMcomments cmt = new CMcomments(n,p);
				cmtlist.add(cmt);
			}
		}
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cmtlist;
		}


public boolean authenticate(UserBean u)
{
	boolean flag = false;
	
	try
	{
		String sql = "select * from  psychologycolor  where uname =? and password=?";
		pstmnt = conn.prepareStatement(sql);
		pstmnt.setString(1, u.getUname());
		pstmnt.setString(2,u.getPassword());
		
		ResultSet rs = pstmnt.executeQuery();
		
		flag = rs.next();
		
	}
	catch(Exception e)
	{
		System.out.println("Exception is: "+e);
		
	}
	
	return flag;
	
}

public boolean checkUname(UserBean u)
{
	boolean flag = false;
	
	try
	{
		String sql = "select * from  psychologycolor  where uname =? ";
		pstmnt = conn.prepareStatement(sql);
		pstmnt.setString(1, u.getUname());
		
		ResultSet rs = pstmnt.executeQuery();
		
		flag = rs.next();
		
	}
	catch(Exception e)
	{
		System.out.println("Exception is: "+e);
		
	}
	
	return flag;
	
}





	

}
