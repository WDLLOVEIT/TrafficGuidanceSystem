package pack.interceptor;

import pack.beans.Admin;

import java.util.Map;

import com.opensymphony.xwork2.*;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

//权限检查拦截器，用于登录验证
public class LoginCheckInterceptor 
	extends AbstractInterceptor{
	public String intercept(ActionInvocation invocation)
		throws Exception{
		ActionContext ctx=invocation.getInvocationContext();
		Map session=ctx.getSession();
		Admin admin=(Admin)session.get("admin");
		if(admin!=null){
			return invocation.invoke();
		}
		return Action.LOGIN;
	}
}
