package co.edu.uniandes.umbrella.interfaces;

import javax.ejb.Remote;

import co.edu.uniandes.umbrella.dto.DocumentoDTO;
import co.edu.uniandes.umbrella.entidades.Documento;

@Remote
public interface DocumentosEJBRemote {
	void crearDocumento(DocumentoDTO documentoDTO);
	Documento consultarDocumento(String id);
}
