package co.edu.uniandes.umbrella.interfaces;

import javax.ejb.Local;

import co.edu.uniandes.umbrella.dto.DatosOperadorDTO;
import co.edu.uniandes.umbrella.entidades.Operador;

@Local
public interface OperadoresEJBLocal {

	/**
	 * Servicio que permite consultar un operador
	 * @param nit Nit del operador a consulta
	 * @return Operador Operador encontrado
	 */
	Operador consultarOperador(String nit);
	
	/**
	 * Servicio que permite registrar un operador ante el centralizador
	 * @param datosOperador Datos del operador a registrar
	 */
	void crearOperador(DatosOperadorDTO datosOperador);
}
