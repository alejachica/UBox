package co.edu.uniandes.umbrella.interfaces;

import javax.ejb.Remote;

import co.edu.uniandes.umbrella.dto.DatosOperadorDTO;
import co.edu.uniandes.umbrella.dto.ServiciosOperadorUsuarioDTO;

@Remote
public interface TransaccionesEJBRemote {

	public DatosOperadorDTO consultarOperadorUsuarioParaCompartir(
			ServiciosOperadorUsuarioDTO datos);
	
}
