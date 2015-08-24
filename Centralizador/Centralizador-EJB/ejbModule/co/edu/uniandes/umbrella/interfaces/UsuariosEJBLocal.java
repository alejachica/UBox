package co.edu.uniandes.umbrella.interfaces;

import javax.ejb.Local;

import co.edu.uniandes.umbrella.dto.DatosBasicosUsuarioDTO;

@Local
public interface UsuariosEJBLocal {
	
	void crearUsuario(DatosBasicosUsuarioDTO usuarioDto);

}
