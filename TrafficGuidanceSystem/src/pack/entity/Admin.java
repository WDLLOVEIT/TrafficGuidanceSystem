package pack.entity;

public class Admin {
	private Integer adminId;
	public Integer getAdminId() {
		return adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	private String userName;
	private String passWord;
	
	//Admin类的构造方法
	public Admin(){}
	
	public Admin(String userName,String passWord){
		this.userName=userName;
		this.passWord=passWord;
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
