package co.edu.uniandes.umbrella.interfaces;

import java.util.List;

import javax.ejb.Remote;
import co.edu.uniandes.umbrella.dto.CarpetaDTO;
import co.edu.uniandes.umbrella.entidades.Carpeta;

@Remote
public interface CarpetaEJBRemote {
	
	Carpeta crearCarpeta(CarpetaDTO carpetaDTO);
	
	Carpeta consultarCarpetao(String id);
	
	public void eliminarCarpeta(int idCarpeta) throws Exception;
	
	public Carpeta crearCarpeta(CarpetaDTO carpetaDTO, int idUsuario)throws Exception;
	
	public List<CarpetaDTO> carpetasXUsuario(int idUsuario) throws Exception;
	
	public Carpeta obtenerCarpetaRaizPorUsuario(int idUsuario);
	
}
