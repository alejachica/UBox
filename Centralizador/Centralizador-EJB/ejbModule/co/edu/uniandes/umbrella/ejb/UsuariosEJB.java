package co.edu.uniandes.umbrella.ejb;

import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import co.edu.uniandes.umbrella.dto.DatosBasicosUsuarioDTO;
import co.edu.uniandes.umbrella.dto.DatosOperadorDTO;
import co.edu.uniandes.umbrella.entidades.Usuario;
import co.edu.uniandes.umbrella.entidades.ZonaGeografica;
import co.edu.uniandes.umbrella.interfaces.UsuariosEJBLocal;
import co.edu.uniandes.umbrella.interfaces.UsuariosEJBRemote;
import static co.edu.uniandes.umbrella.utils.CodigosRespuesta.*;

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
	 * Servicio que permite registrar un usuario en el centralizador
	 * @param usuarioDto Datos del usuario a registrar
	 * @return codigo de respuesta
	 */
	@Override
	@WebMethod
	public String crearUsuario(DatosBasicosUsuarioDTO usuarioDto) {
		
		try {
			

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
		
		return COD_001.getIdCodigo() + COD_001.getMensaje();
		
		} catch(EntityExistsException eex){
			
			return COD_002.getIdCodigo() + COD_002.getMensaje();
		}
		catch (Exception e) {
			
			return COD_003.getIdCodigo() + COD_003.getMensaje();
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

		Query query = entityManager.createNamedQuery("Usuario.findByTipoNroDoc",
				Usuario.class).setParameter("tipoDoc", tipoDoc).setParameter("nroDoc", nroDoc);
		
		Usuario usuarioEncontrado = (Usuario) query.getSingleResult();

		DatosBasicosUsuarioDTO usuario = new DatosBasicosUsuarioDTO();
		usuario.setIdUsuario(usuarioEncontrado.getIdUsuario());
		usuario.setIdTipoIdentificacion(usuarioEncontrado
				.getIdTipoIdentificacion());
		usuario.setNroIdentificacion(usuarioEncontrado.getNroIdentificacion());
		usuario.setPrimerNombre(usuarioEncontrado.getPrimerNombre());
		usuario.setSegundoNombre(usuarioEncontrado.getSegundoNombre());
		usuario.setPrimerApellido(usuarioEncontrado.getPrimerApellido());
		usuario.setSegundoApellido(usuarioEncontrado.getSegundoApellido());

		return usuario;
	}
	
	/**
	 * Servicio que permite consultar el operador en el que esta registrado un usuario en el centralizador
	 * @param TipoDoc tipo de documento del usuario
	 * @param NroDoc nro de document del usuario
	 * @return DatosOperadorDTO Datos del operador donde esta registrado el usuario
	 */
	@Override
	public DatosOperadorDTO consultarOperadorUsuario(String tipoDoc, String nroDoc) {

		Query query = entityManager.createNamedQuery("Usuario.findByTipoNroDoc",
				Usuario.class).setParameter("tipoDoc", tipoDoc).setParameter("nroDoc", nroDoc);
		Usuario usuarioEncontrado = (Usuario) query.getSingleResult();

		DatosOperadorDTO datosOperador = new DatosOperadorDTO();
		datosOperador.setIdOperador(usuarioEncontrado.getOperador().getIdOperador());
		datosOperador.setNit(usuarioEncontrado.getOperador().getNit());
		
		return datosOperador;
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
	
}
