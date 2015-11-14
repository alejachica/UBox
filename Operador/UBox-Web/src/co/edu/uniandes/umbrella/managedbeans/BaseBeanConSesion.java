package co.edu.uniandes.umbrella.managedbeans;

import co.edu.uniandes.umbrella.entidades.Usuario;
import umbrella.ubox.seguridad.ManejoSesiones;
import umbrella.ubox.seguridad.UsuarioAutenticado;

/***
 * Clase base para ser usada en los ManagedBeans que trabajan con sesion
 * @author Gabriel
 *
 */
public class BaseBeanConSesion {
	

	/***
	 * Datos del usuario auteticado
	 */
	private UsuarioAutenticado usuarioAuntenticado;
	
	public UsuarioAutenticado getUsuarioAutenticado()
	{
		if(this.usuarioAuntenticado != null)
			return this.usuarioAuntenticado;
		else
		{
			
			return ManejoSesiones.getUsuarioAutenticado();
		} 
	}
	
	public BaseBeanConSesion()
	{
		
	}
}
