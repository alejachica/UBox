package co.edu.uniandes.umbrella.interfaces;

import java.util.List;

import javax.ejb.Remote;
import co.edu.uniandes.umbrella.dto.CarpetaDTO;
import co.edu.uniandes.umbrella.entidades.Carpeta;

@Remote
public interface CarpetaEJBRemote {
	
	CarpetaDTO consultarCarpetao(int id);
	
	public void eliminarCarpeta(int idCarpeta) throws Exception;
	
	public Carpeta crearCarpeta(CarpetaDTO carpetaDTO, int idUsuario)throws Exception;
	
	public List<CarpetaDTO> carpetasXUsuario(int idUsuario) throws Exception;
	
	public List<CarpetaDTO> consultarCarpetasHijas(int idCarpetaId) throws Exception;
	
	public Carpeta obtenerCarpetaRaizPorUsuario(int idUsuario);
	
}
