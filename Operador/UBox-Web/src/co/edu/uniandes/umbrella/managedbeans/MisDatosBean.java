package co.edu.uniandes.umbrella.managedbeans;

import javax.faces.bean.ManagedBean;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import java.util.Map;

@ManagedBean(name="MisDatosBean")
public class MisDatosBean extends BaseBeanConSesion {
//	private String usuario;
//
//	public String getUsuario() {
//		
//		Subject currentUser = SecurityUtils.getSubject();
//		if(currentUser.isAuthenticated())
//		{
//			@SuppressWarnings("unused")
//			Object user = currentUser.getPrincipal();
//			Map<String, String> userAttributes = SecurityUtils.getSubject().getPrincipals().oneByType(java.util.Map.class);
//			return userAttributes.get("username");
//		}
//		
//		return usuario;
//	}


}
