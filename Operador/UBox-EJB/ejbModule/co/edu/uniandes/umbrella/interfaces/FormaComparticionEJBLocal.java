package co.edu.uniandes.umbrella.interfaces;

import java.util.List;

import javax.ejb.Local;

import co.edu.uniandes.umbrella.entidades.FormaComparticion;

@Local
public interface FormaComparticionEJBLocal {

	/***
	 * Retorna una forma de comparticion por id
	 * @param id
	 * @return
	 */
	public FormaComparticion obtenerFormaComparticionPorId(int id);
	
	/**
	 * Trae todas las formas de comparticion.
	 * @return
	 */
	public List<FormaComparticion> obtenerFormasComparticion();
	
}
