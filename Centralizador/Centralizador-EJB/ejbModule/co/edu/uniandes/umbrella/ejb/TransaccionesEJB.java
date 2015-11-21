package co.edu.uniandes.umbrella.ejb;

import static co.edu.uniandes.umbrella.utils.CodigosRespuesta.*;

import java.util.logging.Logger;

import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import co.edu.uniandes.umbrella.dto.DatosOperadorDTO;
import co.edu.uniandes.umbrella.dto.ServiciosOperadorUsuarioDTO;
import co.edu.uniandes.umbrella.entidades.ServiciosOperador;
import co.edu.uniandes.umbrella.entidades.Usuario;
import co.edu.uniandes.umbrella.interfaces.TransaccionesEJBLocal;
import co.edu.uniandes.umbrella.interfaces.TransaccionesEJBRemote;

/**
 * Session Bean implementation class InstitucionesEJB
 */
@DeclareRoles("admin")
@Stateless
@WebService
public class TransaccionesEJB implements TransaccionesEJBRemote, TransaccionesEJBLocal {
	
	/**
	 * Entity manager
	 */
	@PersistenceContext(unitName = "Centralizador-Persistencia")
	private EntityManager entityManager;
	
	/**
	 * Log del servidor para registrar eventos
	 */
	private Logger logger = Logger.getLogger(this.getClass().getName());

	/**
	 * Servicio que permite consultar los datos del operador de un usuario al que se le compartira un documento
	 * @param datos Filtro para la consulta
	 * @return DatosOperadorDTO Datos del operador para compartir documentos
	 */
	@RolesAllowed("admin")
	@WebMethod
	public DatosOperadorDTO consultarOperadorUsuarioParaCompartir(String tipoDoc, String nroDoc) {
		try {
		
			Query usuarioQuery = entityManager.createNamedQuery("Usuario.findByTipoNroDoc",
					Usuario.class).setParameter("tipoDoc", tipoDoc).setParameter("nroDoc", nroDoc);
			
			Usuario usuarioEncontrado = (Usuario) usuarioQuery.getSingleResult();
			Query query = entityManager.createNamedQuery("ServiciosOperador.urlParaCompartirDocumentos",
					ServiciosOperador.class).setParameter("idOperador", usuarioEncontrado.getIdOperador());
			
	
			ServiciosOperador resultado = (ServiciosOperador) query.getSingleResult();
	
			DatosOperadorDTO datosOperador = new DatosOperadorDTO();
			datosOperador.setIdOperador(resultado.getIdOperador());
			datosOperador.setEmail(usuarioEncontrado.getOperador().getEmail());
			datosOperador.setDireccion(usuarioEncontrado.getOperador().getDireccion());
			datosOperador.setNit(usuarioEncontrado.getOperador().getNit());
			datosOperador.setRazonSocial(usuarioEncontrado.getOperador().getRazonSocial());
			datosOperador.setTelefono(usuarioEncontrado.getOperador().getTelefono());
			datosOperador.setUrlServicio(resultado.getUrl());
			
			logger.info(COD_012.getIdCodigo() + COD_012.getMensaje() );
			
			return datosOperador;
		
		} catch (NoResultException nre) {

			logger.severe(COD_013.getIdCodigo());
			logger.severe(nre.getMessage());
			return null;
			
		} catch (NonUniqueResultException nue) {

			logger.severe(COD_014.getIdCodigo());
			logger.severe(nue.getMessage());
			return null;
			
		} catch (Exception e) {

			logger.severe(COD_015.getIdCodigo());
			logger.severe(e.getMessage());
			return null;
		}
	}
	
	/**
	 * Servicio que permite realizar el traslado de un usuario a un nuevo operador
	 * @param tipoDocUsuario Tipo de documento del usuario	
	 * @param nroDocUsuario Numero de documento del usuario
	 * @param idNuevoOperador Id del nuevo operador al que se trasladara el usuario
	 * @return String codigo de respuesta
	 */
	public String trasladarUsuarioDeOperador(String tipoDocUsuario,
			String nroDocUsuario, int idNuevoOperador) {
		
		try {
		
			Query query = entityManager.createNamedQuery("Usuario.findByTipoNroDoc",
					Usuario.class).setParameter("tipoDoc", tipoDocUsuario).setParameter("nroDoc", nroDocUsuario);
			
			Usuario usuarioEncontrado = (Usuario) query.getSingleResult();
			
			if(usuarioEncontrado != null && usuarioEncontrado.getIdUsuario() > 0){
				
				logger.info(COD_016.getIdCodigo() + COD_016.getMensaje());
				
				/*
				 * Se actualiza el operador del usuario
				 */
				usuarioEncontrado.setIdOperador(idNuevoOperador);
				entityManager.merge(usuarioEncontrado);
		
				logger.info(COD_017.getIdCodigo() + COD_017.getMensaje());
				
				return COD_017.getIdCodigo();
				
			}else {
				
				logger.info(COD_018.getIdCodigo() + COD_018.getMensaje());
				
				return COD_018.getIdCodigo();
			}
		
		} catch (NoResultException nre) {

			logger.severe(COD_018.getIdCodigo() + COD_018.getMensaje());
			logger.severe(nre.getMessage());
			return null;
			
		} catch (NonUniqueResultException nue) {

			logger.severe(COD_019.getIdCodigo());
			logger.severe(nue.getMessage());
			return null;
			
		} catch (Exception e) {

			logger.severe(COD_020.getIdCodigo());
			logger.severe(e.getMessage());
			return null;
		}
	}

}
