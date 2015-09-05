package co.edu.uniandes.umbrella.interfaces;

import javax.ejb.Remote;

import co.edu.uniandes.umbrella.dto.DatosOperadorDTO;
import co.edu.uniandes.umbrella.entidades.Operador;

@Remote
public interface OperadoresEJBRemote {
	
	Operador consultarOperador(String nit);
	
	void crearOperador(DatosOperadorDTO datosOperador);

}
