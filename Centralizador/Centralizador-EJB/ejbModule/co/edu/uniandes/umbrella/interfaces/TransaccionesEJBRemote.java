package co.edu.uniandes.umbrella.interfaces;

import javax.ejb.Remote;

import co.edu.uniandes.umbrella.dto.ServiciosOperadorUsuarioDTO;
import co.edu.uniandes.umbrella.entidades.Operador;

@Remote
public interface TransaccionesEJBRemote {

	public Operador consultarOperadorUsuarioParaCompartir(
			ServiciosOperadorUsuarioDTO datos);
	
}
