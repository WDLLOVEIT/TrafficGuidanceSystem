package pack.service;

public interface UserService {
	/*param:admin 管理员对象
	 * return 登陆管理员的详细信息
	 */
	public boolean check(String userName,String password);
	
	
}