package umbrella.ubox.comun;

import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;

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
			return new UsuarioAutenticado(userAttributes);
		}
		else
		{
			return null;
		}
	}
}
