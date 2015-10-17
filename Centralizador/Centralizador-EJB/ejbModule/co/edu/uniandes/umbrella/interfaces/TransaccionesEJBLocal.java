package co.edu.uniandes.umbrella.interfaces;

import javax.ejb.Local;

import co.edu.uniandes.umbrella.dto.DatosOperadorDTO;
import co.edu.uniandes.umbrella.dto.ServiciosOperadorUsuarioDTO;

@Local
public interface TransaccionesEJBLocal {
	
	public DatosOperadorDTO consultarOperadorUsuarioParaCompartir(
			ServiciosOperadorUsuarioDTO datos);

}
