package pack.entity;

public class User{
	private Integer userId;
	private String userName;
	private String passWord;
	
	public User(){}
	public User(String userName,String passWord){
		this.userName=userName;
		this.passWord=passWord;
		
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	
	
}
