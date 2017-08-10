package trainingEE;

public class UserBean
{

	public UserBean() {
		
	}
	String name;
	String phoneNo;
	String gender;
	String date;
	String email;
	
	public UserBean(String name, String phoneNo, String gender, String date, String email, String uname,String password)
	{
	
		this.name = name;
		this.phoneNo = phoneNo;
		this.gender = gender;
		this.date = date;
		this.email = email;
		this.uname = uname;
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	String uname;
	String password;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
