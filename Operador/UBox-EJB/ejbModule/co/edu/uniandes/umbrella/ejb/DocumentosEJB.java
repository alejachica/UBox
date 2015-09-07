package co.edu.uniandes.umbrella.ejb;

import java.util.List;

import javax.ejb.Stateless;

import co.edu.uniandes.umbrella.dto.DocumentoDTO;
import co.edu.uniandes.umbrella.entidades.Documento;
import co.edu.uniandes.umbrella.interfaces.DocumentosEJBLocal;
import co.edu.uniandes.umbrella.interfaces.DocumentosEJBRemote;

import javax.persistence.*;

/**
 * Session Bean implementation class DocumentosEJB
 */
@Stateless
public class DocumentosEJB implements DocumentosEJBRemote, DocumentosEJBLocal {
	
	@PersistenceContext(unitName = "UBox-Persistencia")
	private EntityManager entityManager;


	public Documento consultarDocumento(String id) {

		Query query
		 = entityManager.createNamedQuery("Documento.findById", Documento.class).setParameter("id", id);
		Documento documento = (Documento) query.getSingleResult();
		System.out.println(documento.getIdDocumento());
		return documento;
	}


	@Override
	public void crearDocumento(DocumentoDTO documentoDTO) {
		Documento documento = new Documento();
		
		documento.setIdDocumento(documentoDTO.getIdDocumento());
		documento.setDocumento(documentoDTO.getDocumento());
		documento.setFecha(documentoDTO.getFecha());
		documento.setFirmado(documentoDTO.getFirmado());
		documento.setIdTipoDocumento(documentoDTO.getIdTipoDocumento());
		documento.setIdTipoMime(documentoDTO.getIdTipoMime());
		documento.setNombre(documentoDTO.getNombre());
		documento.setPalabrasClave(documentoDTO.getPalabrasClave());
		documento.setPapelera(documentoDTO.getPapelera());
		documento.setRuta(documentoDTO.getRuta());
		documento.setSize(documentoDTO.getSize());
		documento.setVersion(documentoDTO.getVersion());
		
		entityManager.persist(documento);
		
	}


	@Override
	public List<Documento> listarDocumentosUsuario(String id) {
		Query query
		 = entityManager.createNamedQuery("Documento.findByUsuario ", Documento.class).setParameter("idUsuario", id);
		List<Documento> documento =  (List<Documento>) query.getSingleResult();
		//System.out.println(documento.getIdDocumento());
		return documento;
	}
	
    

}
