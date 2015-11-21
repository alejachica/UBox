package umbrella.ubox.seguridad;

import java.util.Map;

import javax.ejb.EJB;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.RealmSecurityManager;
import org.apache.shiro.subject.Subject;
import org.primefaces.expression.impl.ThisExpressionResolver;

import com.stormpath.sdk.client.Client;
import com.stormpath.sdk.group.Group;
import com.stormpath.shiro.realm.ApplicationRealm;

import co.edu.uniandes.umbrella.interfaces.UsuarioEJBRemote;

/***
 * Clase encargada de conectarse con stormpath y realizar operaciones sobre los usuarios
 * @author Gabriel
 *
 */
public class ManejoSesiones {
	
	/**
	 * Valida la autenticacion de un usuario por medio de usuario y clave y crea la sesion
	 * @param usuario
	 * @param clave
	 * @param host url del usuario para auditoría
	 * @return true: Usuario autenticado false: datos invalidos
	 */
	public boolean validarAutenticacion(String usuario, String clave, String host)
	{
		UsernamePasswordToken token = new UsernamePasswordToken(usuario, clave, host);
		try
		{
			Subject currentUser = SecurityUtils.getSubject();
			currentUser.login(token);
			return true;
		}
		catch(AuthenticationException e)
		{
			return false;
		}
	}
	
	
	
	
	
	/***
	 * Valida si hay un usuario autenticado y retorna la información del mismo en una estructura de tpo UsuarioAutenticado
	 * @return
	 */
	public static UsuarioAutenticado getUsuarioAutenticado()
	{
		Subject currentUser = SecurityUtils.getSubject();
		if(currentUser.isAuthenticated())
		{
			//Si esta autenicado instancia un nuevo UsuarioAutenticado
			Map<String, String> userAttributes = SecurityUtils.getSubject().getPrincipals().oneByType(java.util.Map.class);
			
			
			UsuarioAutenticado usuario = new UsuarioAutenticado(userAttributes);
			usuario.setAdmin(validateAdmin());
			return usuario;
			
			
		}
		else
		{
			return null;
		}
	}
	
	/***
	 * Valida si el usuario es administrador o no
	 * @return
	 */
	private static boolean validateAdmin()
	{
		/*String roleAdmin = "https://api.stormpath.com/v1/groups/5Es4MmkD1O3iJ7JTDejBGK";
		//Consulta el grupo de Amdinistrador para saber si el usuario pertenece a el o no
		ApplicationRealm realm = ((ApplicationRealm)((RealmSecurityManager) SecurityUtils.getSecurityManager()).getRealms().iterator().next());
		Client client = realm.getClient();
		Group group = client.getResource("https://api.stormpath.com/v1/groups/5Es4MmkD1O3iJ7JTDejBGK", Group.class);
		String groupHref = group.getHref();*/
		return SecurityUtils.getSubject().hasRole("admin");
	}
}
