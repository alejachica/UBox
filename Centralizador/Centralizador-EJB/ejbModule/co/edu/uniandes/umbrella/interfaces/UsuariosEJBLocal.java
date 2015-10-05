package co.edu.uniandes.umbrella.interfaces;

import javax.ejb.Local;

import co.edu.uniandes.umbrella.dto.DatosBasicosUsuarioDTO;

@Local
public interface UsuariosEJBLocal {
	
	public void crearUsuario(DatosBasicosUsuarioDTO usuarioDto);
	public DatosBasicosUsuarioDTO consultarUsuario(String tipoDoc, String nroDoc);
	
}
