package co.edu.uniandes.umbrella.interfaces;

import java.util.List;

import javax.ejb.Remote;

import co.edu.uniandes.umbrella.dto.DocumentoDTO;
import co.edu.uniandes.umbrella.entidades.Documento;

@Remote
public interface DocumentosEJBRemote {
	void crearDocumento(DocumentoDTO documentoDTO);
	Documento consultarDocumento(String id);
	List<Documento> listarDocumentosUsuario(String id);
}
