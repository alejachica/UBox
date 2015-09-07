package co.edu.uniandes.umbrella.interfaces;

import javax.ejb.Local;
import javax.ejb.Remote;

import co.edu.uniandes.umbrella.dto.UsuarioDTO;
import co.edu.uniandes.umbrella.utils.ResultadoOperacion;

@Local
public interface UsuarioEJBRemote {
	
	void crearUsuario(UsuarioDTO usuarioDto);
	
	 UsuarioDTO consultarUsuario(String tipoDoc, String nroDoc);
	 
	 ResultadoOperacion generarTraslado(String tipoDocumento, String numeroDocumento);

}
