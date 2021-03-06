package co.edu.uniandes.umbrella.ejb;

import static co.edu.uniandes.umbrella.utils.CodigosRespuesta.*;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.sun.xml.ws.rx.rm.runtime.sequence.persistent.PersistenceException;

import co.edu.uniandes.umbrella.dto.DatosBasicosUsuarioDTO;
import co.edu.uniandes.umbrella.dto.DatosOperadorDTO;
import co.edu.uniandes.umbrella.entidades.Operador;
import co.edu.uniandes.umbrella.entidades.Usuario;
import co.edu.uniandes.umbrella.entidades.ZonaGeografica;
import co.edu.uniandes.umbrella.interfaces.UsuariosEJBLocal;
import co.edu.uniandes.umbrella.interfaces.UsuariosEJBRemote;

/**
 * EJB con los servicios necesarios para el usuario 
 * Session Bean implementation class UsuariosEJB
 */
@Stateless
@WebService
public class UsuariosEJB implements UsuariosEJBRemote, UsuariosEJBLocal {

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
	 * Servicio que permite registrar un usuario en el centralizador
	 * @param usuarioDto Datos del usuario a registrar
	 * @return codigo de respuesta
	 */
	@Override
	@WebMethod
	public String crearUsuario(DatosBasicosUsuarioDTO usuarioDto) {
		
		try {
			
			if(existeUsuario(usuarioDto.getIdTipoIdentificacion(), usuarioDto.getNroIdentificacion())){
				
				logger.severe(COD_002.getIdCodigo() + COD_002.getMensaje() 
						+ usuarioDto.getIdTipoIdentificacion() +  usuarioDto.getNroIdentificacion());
				
				return COD_002.getIdCodigo();
				
			}else {
				
				Usuario usuario = new Usuario();
	
				/*
				 * Datos personales
				 */
				usuario.setPrimerApellido(usuarioDto.getPrimerApellido());
				usuario.setPrimerNombre(usuarioDto.getPrimerNombre());
				usuario.setSegundoApellido(usuarioDto.getSegundoApellido());
				usuario.setSegundoNombre(usuarioDto.getSegundoNombre());
				usuario.setIdTipoIdentificacion(usuarioDto.getIdTipoIdentificacion());
				usuario.setNroIdentificacion(usuarioDto.getNroIdentificacion());
				usuario.setIdNacionalidad(usuarioDto.getIdNacionalidad());
				usuario.setEmailPersonal(usuarioDto.getEmailPersonal());
				usuario.setFechaNacimiento(usuarioDto.getFechaNacimiento());
				usuario.setGenero(usuarioDto.getGenero());
				usuario.setIdEstadoCivil(usuarioDto.getIdEstadoCivil());
				
				/*
				 * Operador del usuario
				 */
				usuario.setIdOperador(usuarioDto.getIdOperador());
				usuario.setOperador(configurarOperadorUsuario(usuarioDto.getIdOperador()));
		
				/*
				 * Datos de contacto
				 */
				usuario.setTelefono(usuarioDto.getTelefono());
				usuario.setDireccionNotificacion(usuarioDto.getDireccionNotificacion());
				usuario.setFechaExpediciionIdentificacion(usuarioDto
						.getFechaExpediciionIdentificacion());
				usuario.setIdDireccionResidencia(usuarioDto.getIdDireccionResidencia());
				usuario.setMunicipioExpedicionDoc(configurarZonaGeograficaUsuario(usuarioDto
						.getIdMunicipioExpedicionIdentificacion()));
				usuario.setMunicipioLaboral(configurarZonaGeograficaUsuario(usuarioDto
						.getIdMunicipioLaboral()));
				usuario.setMunicipioNacimiento(configurarZonaGeograficaUsuario(usuarioDto
						.getIdMunicipioNacimiento()));
				usuario.setMunicipioNotificacion(configurarZonaGeograficaUsuario(usuarioDto
						.getIdMunicipioNotificacion()));
				usuario.setMunicipioResidencia(configurarZonaGeograficaUsuario(usuarioDto
						.getIdMunicipioResidencia()));
		
				entityManager.persist(usuario);
				
				logger.info(COD_001.getIdCodigo() + COD_001.getMensaje() );
				
				return COD_001.getIdCodigo();
			}
		} catch (EntityExistsException eex) {

			logger.severe(COD_002.getIdCodigo() + COD_002.getMensaje());
			logger.severe(eex.getMessage());

			return COD_002.getIdCodigo();

		} catch (PersistenceException pex) {

			logger.severe(COD_002.getIdCodigo() + COD_002.getMensaje());
			logger.severe(pex.getMessage());

			return COD_002.getIdCodigo();

		} catch (EJBException ejbe) {

			logger.severe(COD_002.getIdCodigo() + COD_002.getMensaje());
			logger.severe(ejbe.getMessage());

			return COD_002.getIdCodigo();
			
		} catch (Exception e) {

			logger.severe(COD_003.getIdCodigo() + COD_003.getMensaje());
			logger.severe(e.getMessage());

			return COD_003.getIdCodigo();
		}
	}

	/**
	 * Servicio que permite consultar un usuario en el centralizador
	 * @param TipoDoc tipo de documento del usuario
	 * @param NroDoc nro de document del usuario
	 * @return DatosBasicosUsuarioDTO Resultado de la consulta
	 */
	@Override
	@WebMethod
	public DatosBasicosUsuarioDTO consultarUsuario(String tipoDoc, String nroDoc) {
		
		try {
			
			Query query = entityManager.createNamedQuery("Usuario.findByTipoNroDoc",
					Usuario.class).setParameter("tipoDoc", tipoDoc).setParameter("nroDoc", nroDoc);
			
			Usuario usuarioEncontrado = (Usuario) query.getSingleResult();
	
			DatosBasicosUsuarioDTO usuario = new DatosBasicosUsuarioDTO();
			usuario.setIdUsuario(usuarioEncontrado.getIdUsuario());
			usuario.setIdTipoIdentificacion(usuarioEncontrado.getIdTipoIdentificacion());
			usuario.setNroIdentificacion(usuarioEncontrado.getNroIdentificacion());
			usuario.setPrimerNombre(usuarioEncontrado.getPrimerNombre());
			usuario.setSegundoNombre(usuarioEncontrado.getSegundoNombre());
			usuario.setPrimerApellido(usuarioEncontrado.getPrimerApellido());
			usuario.setSegundoApellido(usuarioEncontrado.getSegundoApellido());
	
			logger.info(COD_004.getIdCodigo() + COD_004.getMensaje() );
			
			return usuario;
		
		} catch (NoResultException nre) {

			logger.severe(COD_005.getIdCodigo());
			logger.severe(nre.getMessage());
			
			return null;
			
		} catch (NonUniqueResultException nue) {

			logger.severe(COD_006.getIdCodigo());
			logger.severe(nue.getMessage());
			
			return null;
			
		} catch (Exception e) {

			logger.severe(COD_007.getIdCodigo());
			logger.severe(e.getMessage());
			
			return null;
		}
	}
	
	/**
	 * Servicio que permite consultar el operador en el que esta registrado un usuario en el centralizador
	 * @param TipoDoc tipo de documento del usuario
	 * @param NroDoc nro de document del usuario
	 * @return DatosOperadorDTO Datos del operador donde esta registrado el usuario
	 */
	@Override
	@WebMethod
	public DatosOperadorDTO consultarOperadorUsuario(String tipoDoc, String nroDoc) {

		try {
			
			Query query = entityManager.createNamedQuery("Usuario.findByTipoNroDoc",
					Usuario.class).setParameter("tipoDoc", tipoDoc).setParameter("nroDoc", nroDoc);
			Usuario usuarioEncontrado = (Usuario) query.getSingleResult();
	
			DatosOperadorDTO datosOperador = new DatosOperadorDTO();
			datosOperador.setIdOperador(usuarioEncontrado.getOperador().getIdOperador());
			datosOperador.setNit(usuarioEncontrado.getOperador().getNit());
			
			
			logger.info("Operador " + usuarioEncontrado.getOperador().getNit() + " "+ COD_008.getIdCodigo() + COD_008.getMensaje() );
			
			return datosOperador;
		
		} catch (NoResultException nre) {

			logger.severe(COD_009.getIdCodigo());
			logger.severe(nre.getMessage());
			
			return null;
			
		} catch (NonUniqueResultException nue) {

			logger.severe(COD_010.getIdCodigo());
			logger.severe(nue.getMessage());
			
			return null;
			
		} catch (Exception e) {

			logger.severe(COD_011.getIdCodigo());
			logger.severe(e.getMessage());
			
			return null;
		}
	}
	

	/**
	 * Metodo que permite configurar la zona geografica
	 * @param idZonaConfigurar Id de la zona geografica
	 * @return ZonaGeografica Zona geografica creada
	 */
	private ZonaGeografica configurarZonaGeograficaUsuario(int idZonaConfigurar) {

		ZonaGeografica zona = new ZonaGeografica();
		zona.setIdZonaGeografica(idZonaConfigurar);

		return zona;
	}
	
	/**
	 * Metodo que permite asignar el id del operador del usuario
	 * @param idOperador Id del operador del usuario
	 * @return Operador operador del usuario
	 */
	private Operador configurarOperadorUsuario(int idOperador) {

		Operador operador = new Operador();
		operador.setIdOperador(idOperador);

		return operador;
	}
	
	/**
	 * Metodo que permite saber si un usuario ya esta registrado en el centralizador
	 * @param TipoDoc tipo de documento del usuario
	 * @param NroDoc nro de document del usuario
	 * @return true si existe, false en caso contrario
	 */
	private boolean existeUsuario(String tipoDoc, String nroDoc) {

		try {

			Query query = entityManager.createNamedQuery("Usuario.findByTipoNroDoc", Usuario.class)
					.setParameter("tipoDoc", tipoDoc)
					.setParameter("nroDoc", nroDoc);

			List<?> usuarios =  query.getResultList();
			
			if(usuarios != null && !usuarios.isEmpty()){
				
				logger.info(COD_004.getIdCodigo() + COD_004.getMensaje() );
				
				return true;
				
			}else {
				
				logger.info(COD_005.getIdCodigo() + COD_005.getMensaje() );
				
				return false;
			}

		} catch (Exception e) {

			logger.info(COD_007.getIdCodigo() + COD_007.getMensaje() );
			
			return true;
		}
	}
	
}
