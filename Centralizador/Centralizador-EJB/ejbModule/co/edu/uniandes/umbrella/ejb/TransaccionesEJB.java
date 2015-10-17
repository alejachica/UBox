package co.edu.uniandes.umbrella.ejb;

import javax.ejb.Stateless;
import javax.jws.WebService;

import co.edu.uniandes.umbrella.dto.DatosOperadorDTO;
import co.edu.uniandes.umbrella.dto.ServiciosOperadorUsuarioDTO;
import co.edu.uniandes.umbrella.interfaces.TransaccionesEJBLocal;
import co.edu.uniandes.umbrella.interfaces.TransaccionesEJBRemote;

/**
 * Session Bean implementation class InstitucionesEJB
 */
@Stateless
@WebService
public class TransaccionesEJB implements TransaccionesEJBRemote, TransaccionesEJBLocal {

	public DatosOperadorDTO consultarOperadorUsuarioParaCompartir(
			ServiciosOperadorUsuarioDTO datos) {

		return null;
	}

}
