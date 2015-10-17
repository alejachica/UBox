package co.edu.uniandes.umbrella.interfaces;

import javax.ejb.Local;

import co.edu.uniandes.umbrella.dto.ServiciosOperadorUsuarioDTO;
import co.edu.uniandes.umbrella.entidades.Operador;

@Local
public interface TransaccionesEJBLocal {
	
	public Operador consultarOperadorUsuarioParaCompartir(
			ServiciosOperadorUsuarioDTO datos);

}
