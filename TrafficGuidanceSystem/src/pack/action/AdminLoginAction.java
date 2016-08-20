package pack.action;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import pack.entity.Admin;
import pack.service.AdminService;


public class AdminLoginAction extends ActionSupport {

	private Admin admin;

	private AdminService adminService;
	
	public String execute()
			throws Exception{
			ActionContext ctx=ActionContext.getContext();
			//���ݲ�����ȡ����Ա����
		
			boolean adminflag=adminService.check(admin.getUserName(),admin.getPassWord());
			if(!adminflag){
				ctx.put("tip","�û��������벻ƥ�䣡");
				return "loginPage";
			}else{
				return "success";
			}
		}

	public Admin getAdmin() {
		return admin;
	}

	public AdminService getAdminService() {
		return adminService;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

}
