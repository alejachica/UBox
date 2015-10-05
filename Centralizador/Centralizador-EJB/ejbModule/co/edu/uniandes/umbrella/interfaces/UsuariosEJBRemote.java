package co.edu.uniandes.umbrella.interfaces;

import javax.ejb.Remote;
import javax.jws.WebService;

import co.edu.uniandes.umbrella.dto.DatosBasicosUsuarioDTO;

@Remote
public interface UsuariosEJBRemote {
		
	public DatosBasicosUsuarioDTO consultarUsuario(String tipoDoc, String nroDoc);

}
