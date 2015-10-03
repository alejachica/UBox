package co.edu.uniandes.umbrella.ejb;

import java.util.ArrayList;
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
     * Metodo para crear una documento y persistirlo en BD
     * @param documentoDTO
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

	public DocumentoDTO consultarDocumento(int id) {
		DocumentoDTO docDTO = new DocumentoDTO();
		Query query = entityManager.createNamedQuery("Documento.findById", Documento.class).setParameter("id", id);
		Documento documento = (Documento) query.getSingleResult();
		docDTO.setDocumento(documento.getDocumento());
		docDTO.setFecha(documento.getFecha());
		docDTO.setFirmado(documento.getFirmado());
		docDTO.setFkCarpeta(documento.getCarpeta().getIdCarpeta());
		docDTO.setFkUsuario(documento.getUsuario().getIdUsuario());
		docDTO.setIdDocumento(documento.getIdDocumento());
		docDTO.setIdTipoDocumento(documento.getIdTipoDocumento());
		docDTO.setIdTipoMime(documento.getIdTipoMime());
		docDTO.setNombre(documento.getNombre());
		docDTO.setPalabrasClave(documento.getPalabrasClave());
		docDTO.setPapelera(documento.getPapelera());
		docDTO.setRuta(documento.getRuta());
		docDTO.setSize(documento.getSize());
		docDTO.setVersion(documento.getVersion());
		return docDTO;
	}

	@Override
	public List<DocumentoDTO> listarDocumentosUsuario(String id) {
		List<DocumentoDTO> docDTOList = new ArrayList<DocumentoDTO>();
		Query query = entityManager.createNamedQuery("Documento.findByUsuario", Documento.class).setParameter("idUsuario", id);
		List<Documento> documento =  (List<Documento>) query.getSingleResult();
		
		for(int i = 0; i< documento.size();i++){
			DocumentoDTO docDTO = new DocumentoDTO();
			docDTO.setDocumento(documento.get(i).getDocumento());
			docDTO.setFecha(documento.get(i).getFecha());
			docDTO.setFirmado(documento.get(i).getFirmado());
			docDTO.setFkCarpeta(documento.get(i).getCarpeta().getIdCarpeta());
			docDTO.setFkUsuario(documento.get(i).getUsuario().getIdUsuario());
			docDTO.setIdDocumento(documento.get(i).getIdDocumento());
			docDTO.setIdTipoDocumento(documento.get(i).getIdTipoDocumento());
			docDTO.setIdTipoMime(documento.get(i).getIdTipoMime());
			docDTO.setNombre(documento.get(i).getNombre());
			docDTO.setPalabrasClave(documento.get(i).getPalabrasClave());
			docDTO.setPapelera(documento.get(i).getPapelera());
			docDTO.setRuta(documento.get(i).getRuta());
			docDTO.setSize(documento.get(i).getSize());
			docDTO.setVersion(documento.get(i).getVersion());
			docDTOList.add(docDTO);
			
		}
		//System.out.println(documento.getIdDocumento());
		return docDTOList;
	}

	@Override
	public List<DocumentoDTO> listarDocumentosCarpeta(int id) {
		List<DocumentoDTO> docDTOList = new ArrayList<DocumentoDTO>();
		Query query = entityManager.createNamedQuery("Documento.findByCarpeta", Documento.class).setParameter("idCarpeta", id);
		List<Documento> documento =  (List<Documento>) query.getResultList();
		for(int i = 0; i< documento.size();i++){
			DocumentoDTO docDTO = new DocumentoDTO();
			docDTO.setDocumento(documento.get(i).getDocumento());
			docDTO.setFecha(documento.get(i).getFecha());
			docDTO.setFirmado(documento.get(i).getFirmado());
			docDTO.setFkCarpeta(documento.get(i).getCarpeta().getIdCarpeta());
			docDTO.setFkUsuario(documento.get(i).getUsuario().getIdUsuario());
			docDTO.setIdDocumento(documento.get(i).getIdDocumento());
			docDTO.setIdTipoDocumento(documento.get(i).getIdTipoDocumento());
			docDTO.setIdTipoMime(documento.get(i).getIdTipoMime());
			docDTO.setNombre(documento.get(i).getNombre());
			docDTO.setPalabrasClave(documento.get(i).getPalabrasClave());
			docDTO.setPapelera(documento.get(i).getPapelera());
			docDTO.setRuta(documento.get(i).getRuta());
			docDTO.setSize(documento.get(i).getSize());
			docDTO.setVersion(documento.get(i).getVersion());
			docDTOList.add(docDTO);
			
		}
		return docDTOList;
	}

}
