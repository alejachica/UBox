package co.edu.uniandes.umbrella.interfaces;

import javax.ejb.Local;

import co.edu.uniandes.umbrella.dto.CarpetaDTO;
import co.edu.uniandes.umbrella.entidades.Carpeta;

@Local
public interface CarpetaEJBLocal {
	void crearCarpeta(CarpetaDTO carpetaDTO);
	Carpeta consultarCarpetao(String id);
}
