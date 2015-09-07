package co.edu.uniandes.umbrella.ejb;

import java.util.List;

import javax.ejb.Stateless;

import co.edu.uniandes.umbrella.dto.DocumentoDTO;
import co.edu.uniandes.umbrella.entidades.Carpeta;
import co.edu.uniandes.umbrella.entidades.Documento;
import co.edu.uniandes.umbrella.entidades.Usuario;
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

	/**
     * Metodo para crear una carpeta y persistirla en BD
     * @param carpetaDTO
     * @param idUsuario
     */
	public void crearDocumento(DocumentoDTO documentoDTO) throws Exception{
    	try{
	        Documento documento = new Documento();
	        documento.setDocumento(documentoDTO.getDocumento());
	        documento.setFecha(documentoDTO.getFecha());
	        documento.setFirmado(documentoDTO.getFirmado());
	        documento.setIdTipoDocumento(documentoDTO.getIdTipoDocumento());
	        documento.setIdTipoMime(documentoDTO.getIdTipoMime());
	        documento.setNombre(documentoDTO.getNombre());
	        documento.setPalabrasClave(documentoDTO.getPalabrasClave());
	        documento.setVersion(documentoDTO.getVersion());
	        documento.setPapelera(documentoDTO.getPapelera());
	        documento.setSize(documentoDTO.getSize());
	        documento.setRuta(documentoDTO.getRuta());
	        Query query = entityManager.createNamedQuery("Carpeta.findByID", Carpeta.class).setParameter("idCarpeta", documentoDTO.getFkCarpeta());
	        Carpeta carpetaEncontrada = (Carpeta) query.getSingleResult();
	        documento.setCarpeta(carpetaEncontrada);
	        Query query1 = entityManager.createNamedQuery("Usuario.findById", Usuario.class).setParameter("idUsuario", documentoDTO.getFkUsuario());
	        Usuario usuarioEncontrado = (Usuario) query1.getSingleResult();
	        documento.setUsuario(usuarioEncontrado);
	        entityManager.persist(documento);
    	}
	    catch(Exception e){
	    	throw new Exception("Fallo persistiendo el documento");
	    }
    }

	public Documento consultarDocumento(String id) {

		Query query
		 = entityManager.createNamedQuery("Documento.findById", Documento.class).setParameter("id", id);
		Documento documento = (Documento) query.getSingleResult();
		System.out.println(documento.getIdDocumento());
		return documento;
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
