package co.edu.uniandes.umbrella.ejb;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import co.edu.uniandes.umbrella.dto.DocumentoDTO;
import co.edu.uniandes.umbrella.entidades.Carpeta;
import co.edu.uniandes.umbrella.entidades.Documento;
import co.edu.uniandes.umbrella.entidades.DocumentoXUsuarioCompartido;
import co.edu.uniandes.umbrella.entidades.FormaComparticionEnum;
import co.edu.uniandes.umbrella.entidades.Usuario;
import co.edu.uniandes.umbrella.interfaces.CarpetaEJBRemote;
import co.edu.uniandes.umbrella.interfaces.DocumentosEJBLocal;
import co.edu.uniandes.umbrella.interfaces.DocumentosEJBRemote;
import co.edu.uniandes.umbrella.interfaces.FormaComparticionEJBLocal;
import co.edu.uniandes.umbrella.interfaces.UsuarioEJBRemote;
import co.edu.uniandes.umbrella.utils.ResultadoOperacion;

import javax.persistence.*;

/**
 * Session Bean implementation class DocumentosEJB
 */
@Stateless
public class DocumentosEJB implements DocumentosEJBRemote, DocumentosEJBLocal {
	
	@PersistenceContext(unitName = "UBox-Persistencia")
	private EntityManager entityManager;
	
	@EJB
	private UsuarioEJBRemote ejbUsuario;
	
	@EJB
	private CarpetaEJBRemote ejbCarpeta;
	
	@EJB
	private FormaComparticionEJBLocal ejbFormaComparticion;

	/**
     * Metodo para crear una documento y persistirlo en BD
     * @param documentoDTO
     */
	public Documento crearDocumento(DocumentoDTO documentoDTO) throws Exception{
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
	        documento.setArchivoCompartidoTemporal(documentoDTO.isArchivoCompartidoTemporal());
	        documento.setArchivoCompartidoTipoLink(documentoDTO.isArchivoCompartidoTipoLink());
	        Query query = entityManager.createNamedQuery("Carpeta.findByID", Carpeta.class).setParameter("idCarpeta", documentoDTO.getFkCarpeta());
	        Carpeta carpetaEncontrada = (Carpeta) query.getSingleResult();
	        documento.setCarpeta(carpetaEncontrada);
	        Query query1 = entityManager.createNamedQuery("Usuario.findById", Usuario.class).setParameter("idUsuario", documentoDTO.getFkUsuario());
	        Usuario usuarioEncontrado = (Usuario) query1.getSingleResult();
	        documento.setUsuario(usuarioEncontrado);
	        entityManager.persist(documento);
	        return documento;
    	}
	    catch(Exception e){
	    	throw new Exception("Fallo persistiendo el documento");
	    }
    }

	public DocumentoDTO consultarDocumento(int documentoId) {
		DocumentoDTO docDTO = new DocumentoDTO();
		Query query = entityManager.createNamedQuery("Documento.findById", Documento.class).setParameter("id", documentoId);
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
		docDTO.setArchivoCompartidoTemporal(documento.isArchivoCompartidoTemporal());
		docDTO.setArchivoCompartidoTipoLink(documento.isArchivoCompartidoTipoLink());
		return docDTO;
	}

	@Override
	public List<DocumentoDTO> listarDocumentosPapelera(int usuarioId) {
		List<DocumentoDTO> docDTOList = new ArrayList<DocumentoDTO>();
		Query query = entityManager.createNamedQuery("Documento.findInTrash", Documento.class).setParameter("idUsuario", usuarioId);
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
			docDTO.setArchivoCompartidoTemporal(documento.get(i).isArchivoCompartidoTemporal());
			docDTO.setArchivoCompartidoTipoLink(documento.get(i).isArchivoCompartidoTipoLink());
			docDTOList.add(docDTO);
			
		}
		return docDTOList;
	}

	@Override
	public List<DocumentoDTO> listarDocumentosCarpeta(int carpetaId) {
		List<DocumentoDTO> docDTOList = new ArrayList<DocumentoDTO>();
		Query query = entityManager.createNamedQuery("Documento.findByCarpeta", Documento.class).setParameter("idCarpeta", carpetaId);
		List<Documento> documento =  (List<Documento>) query.getResultList();
		for(int i = 0; i< documento.size();i++){
			DocumentoDTO docDTO = new DocumentoDTO();
			docDTO.setDocumento(documento.get(i).getDocumento());
			docDTO.setFecha(documento.get(i).getFecha());
			docDTO.setFirmado(documento.get(i).getFirmado());
			docDTO.setFkCarpeta(documento.get(i).getCarpeta().getIdCarpeta());
			//docDTO.setFkUsuario(documento.get(i).getUsuario().getIdUsuario());
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
	


	@Override
	public void recibirDocumentoCompartido(String tipoIdentificacionOrigen, String identificacionOrigen, boolean esEmpresaPublica, String tipoIdentificacionDestino,
 
			String identificacionDestino, String idOperadorExterno, DocumentoDTO documentoDto) {
		
		//Busca el usuario al que se le va compartir el archivo
		Query query = entityManager.createNamedQuery("Usuario.findByTipoNroDoc",
				Usuario.class).setParameter("identificacion", identificacionDestino);
		Usuario usuarioDestino = (Usuario) query.getSingleResult();
		
		//Carga los datos basicos del documento
		Documento documento = new Documento();
		documento.setUsuario(usuarioDestino);
		//Si no existe la carpeta raiz la crea
		documento.setCarpeta(ejbCarpeta.obtenerCarpetaRaizPorUsuario(usuarioDestino.getIdUsuario()));
		documento.setNombre(documentoDto.getNombre());
		documento.setIdTipoDocumento(documentoDto.getIdTipoDocumento());
		documento.setIdTipoMime(documentoDto.getIdTipoMime());
		documento.setFecha(documentoDto.getFecha());
		documento.setVersion("1");
		documento.setFirmado(documentoDto.getFirmado());
		documento.setPapelera(false);
		documento.setPalabrasClave(documentoDto.getPalabrasClave());
		documento.setDocumento(documentoDto.getDocumento());
		documento.setSize(documentoDto.getDocumento().length);
		
		
		//Despues de crear el documento agrega la comparticion del mismo
		DocumentoXUsuarioCompartido compartido = new DocumentoXUsuarioCompartido();
		compartido.setUsuario(usuarioDestino);
		//Le asigna el tipo de comparticion
		//En este caso solo puede ser de entidad publica o de entidad privada desde otro operador
		compartido.setFormaComparticion(ejbFormaComparticion.obtenerFormaComparticionPorId(esEmpresaPublica ? FormaComparticionEnum.DE_PUBLICA.getValue() : FormaComparticionEnum.DE_PRIVADA.getValue()));
		compartido.setLectura(true);
		compartido.setEscritura(true);
		compartido.setDescarga(true);
		compartido.setIdentificacionComparticion(identificacionOrigen);
		compartido.setRecibido(true);
		compartido.setEnviado(false);
		compartido.setIdOperadorExterno(idOperadorExterno);
		documento.setDocumentoXUsuarioCompartidos(new ArrayList<DocumentoXUsuarioCompartido>());
		
		documento.addDocumentoXUsuarioCompartido(compartido);
		
		
		entityManager.persist(documento);
	}
	
	public ResultadoOperacion compartirDocumentoInterno(int idUsuarioOrigen, int idUsuarioDestino, boolean soloLectura, int idDocumento, Date fechaExpiracion) 
	{
		ResultadoOperacion respuesta = new ResultadoOperacion();
		
		//Consulta el usuario origen
		Usuario usuarioOrigen = ejbUsuario.consultarUsuarioPorId(idUsuarioOrigen);
		
		if(usuarioOrigen == null)
		{
			respuesta.setOperacionExitosa(false);
			respuesta.setResultadoOperacion("El usuario origen no existe");
			return respuesta;
		}
			
		//Consulta el usuario destino
		Usuario usuarioDestino = ejbUsuario.consultarUsuarioPorId(idUsuarioDestino);
		
		if(usuarioDestino == null)
		{
			respuesta.setOperacionExitosa(false);
			respuesta.setResultadoOperacion("El usuario destino no existe");
			return respuesta;
		}
		
		//Reasigna al documento los valores del usuario dueño, la carpeta y el tipo de archivo que se va compartir
		DocumentoDTO documentoDto = consultarDocumento(idDocumento);
		//documentoDto.setFkUsuario(idUsuarioDestino);
		documentoDto.setArchivoCompartidoTemporal(true);
		documentoDto.setArchivoCompartidoTemporal(false);
		//documentoDto.setFkCarpeta(ejbCarpeta.obtenerCarpetaRaizPorUsuario(idUsuarioDestino).getIdCarpeta());

		//Copia el documento en persistencia 
		Documento documento = new Documento();
		documento.setUsuario(usuarioDestino);
		documento.setDocumento(documentoDto.getDocumento());
        documento.setFecha(documentoDto.getFecha());
        documento.setFirmado(documentoDto.getFirmado());
        documento.setIdTipoDocumento(documentoDto.getIdTipoDocumento());
        documento.setIdTipoMime(documentoDto.getIdTipoMime());
        documento.setNombre(documentoDto.getNombre());
        documento.setPalabrasClave(documentoDto.getPalabrasClave());
        documento.setVersion(documentoDto.getVersion());
        documento.setPapelera(documentoDto.getPapelera());
        documento.setSize(documentoDto.getSize());
        documento.setRuta(documentoDto.getRuta());
        documento.setCarpeta(ejbCarpeta.obtenerCarpetaRaizPorUsuario(idUsuarioDestino));
        documento.setArchivoCompartidoTemporal(true);
        documento.setArchivoCompartidoTipoLink(false);
		
		//Despues de copiar el documento agrega la comparticion del mismo
		DocumentoXUsuarioCompartido compartido = new DocumentoXUsuarioCompartido();
		compartido.setUsuario(usuarioDestino);
		//Le asigna el tipo de comparticion
		//En este caso solo puede ser de entidad publica o de entidad privada desde otro operador
		compartido.setFormaComparticion(ejbFormaComparticion.obtenerFormaComparticionPorId(soloLectura ? FormaComparticionEnum.VISTA_PREVIA_SIN_DESCARGA.getValue() : FormaComparticionEnum.VISTA_PREVIA_CON_DESCARGA.getValue()));
		compartido.setLectura(true);
		compartido.setEscritura(false);
		compartido.setDescarga(!soloLectura);
		compartido.setIdentificacionComparticion(usuarioOrigen.getIdentificacion());
		compartido.setFechaExpiracion(fechaExpiracion);
		compartido.setRecibido(true);
		compartido.setEnviado(false);
		documento.setDocumentoXUsuarioCompartidos(new ArrayList<DocumentoXUsuarioCompartido>());
		documento.addDocumentoXUsuarioCompartido(compartido);
		
		entityManager.persist(documento);
		
		respuesta.setOperacionExitosa(true);
		return respuesta;
		
	}
	
	@Override
	public boolean eliminarDocumento(int id){
		try{
			Query query= entityManager.createNamedQuery("Documento.findById", Documento.class).setParameter("id", id);
			Documento doc = (Documento) query.getSingleResult();
			entityManager.remove(doc);
		}
		catch(Exception e){
			return false;
		}
		return true;
	}
	
	@Override
	public boolean enviarAPapelera(int documentoId){
		try{
			Query query= entityManager.createNamedQuery("Documento.findById", Documento.class).setParameter("id", documentoId);
			Documento doc = (Documento) query.getSingleResult();
			doc.setPapelera(true);
			entityManager.merge(doc);
		}
		catch(Exception e){
			return false;
		}
		return true;
	}
	
	@Override
	public boolean vaciarPapelera(int usuarioId){
		try{
			Query query = entityManager.createNamedQuery("Documento.findInTrash", Documento.class).setParameter("idUsuario", usuarioId);
			List<Documento> documento =  (List<Documento>) query.getResultList();
			for(Documento doc : documento){
				entityManager.remove(doc);
			}
		}
		catch(Exception e){
			return false;
		}
		return true;
	}

}
