package co.edu.uniandes.umbrella.interfaces;

import javax.ejb.Remote;

import co.edu.uniandes.umbrella.dto.UsuarioDTO;

@Remote
public interface UsuarioEJBRemote {
	
	void crearUsuario(UsuarioDTO usuarioDto);
	
	 UsuarioDTO consultarUsuario(String tipoDoc, String nroDoc);

}
