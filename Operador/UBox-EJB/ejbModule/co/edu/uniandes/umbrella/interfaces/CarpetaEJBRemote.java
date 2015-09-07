package co.edu.uniandes.umbrella.interfaces;

import javax.ejb.Remote;
import co.edu.uniandes.umbrella.dto.CarpetaDTO;
import co.edu.uniandes.umbrella.entidades.Carpeta;

@Remote
public interface CarpetaEJBRemote {
	void crearCarpeta(CarpetaDTO carpetaDTO);
	Carpeta consultarCarpetao(String id);
}
