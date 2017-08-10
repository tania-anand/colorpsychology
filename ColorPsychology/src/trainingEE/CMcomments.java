package trainingEE;

public class CMcomments 
{
	String username;
	String comment;
	

	public CMcomments( String username,String comment) 
	{
		super();
		this.username = username;
		this.comment = comment;
		
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getComment() 
	{
		return comment;
	}

	public void setComment(String comment)
	{
		this.comment = comment;
	}


	public CMcomments() 
	{
		super();
	}
}
