package co.edu.uniandes.umbrella.interfaces;

import javax.ejb.Local;

import co.edu.uniandes.umbrella.dto.DatosOperadorDTO;
import co.edu.uniandes.umbrella.entidades.Operador;

@Local
public interface OperadoresEJBLocal {

	Operador consultarOperador(String nit);
	
	void crearOperador(DatosOperadorDTO datosOperador);
}
