package co.edu.uniandes.umbrella.ejb;

import javax.ejb.Stateless;

import co.edu.uniandes.umbrella.dto.ServiciosOperadorUsuarioDTO;
import co.edu.uniandes.umbrella.entidades.Operador;
import co.edu.uniandes.umbrella.interfaces.TransaccionesEJBLocal;
import co.edu.uniandes.umbrella.interfaces.TransaccionesEJBRemote;

/**
 * Session Bean implementation class InstitucionesEJB
 */
@Stateless
public class TransaccionesEJB implements TransaccionesEJBRemote, TransaccionesEJBLocal {

	public Operador consultarOperadorUsuarioParaCompartir(
			ServiciosOperadorUsuarioDTO datos) {

		return null;
	}

}
