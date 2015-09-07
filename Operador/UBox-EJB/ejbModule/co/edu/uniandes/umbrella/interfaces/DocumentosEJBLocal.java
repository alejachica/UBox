package co.edu.uniandes.umbrella.interfaces;

import java.util.List;

import javax.ejb.Local;

import co.edu.uniandes.umbrella.dto.DocumentoDTO;
import co.edu.uniandes.umbrella.entidades.Documento;


@Local
public interface DocumentosEJBLocal {
	void crearDocumento(DocumentoDTO documentoDTO);
	Documento consultarDocumento(String id);
	List<Documento> listarDocumentosUsuario(String id);
}
