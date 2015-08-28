package co.edu.uniandes.umbrella.ejb;

import java.math.BigDecimal;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import co.edu.uniandes.umbrella.dto.DatosBasicosUsuarioDTO;
import co.edu.uniandes.umbrella.entidades.Usuario;
import co.edu.uniandes.umbrella.entidades.ZonaGeografica;
import co.edu.uniandes.umbrella.interfaces.UsuariosEJBLocal;
import co.edu.uniandes.umbrella.interfaces.UsuariosEJBRemote;

/**
 * Session Bean implementation class UsuariosEJB
 */
@Stateless
public class UsuariosEJB implements UsuariosEJBRemote, UsuariosEJBLocal {

	@PersistenceContext(unitName = "Centralizador-Persistencia")
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public UsuariosEJB() {
		// TODO Auto-generated constructor stub
	}

	public void crearUsuario(DatosBasicosUsuarioDTO usuarioDto) {

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
		usuario.setIdMunicipioExpedicionIdentificacion(configurarZonaGeograficaUsuario(usuarioDto
				.getIdMunicipioExpedicionIdentificacion()));
		usuario.setIdMunicipioLaboral(configurarZonaGeograficaUsuario(usuarioDto
				.getIdMunicipioLaboral()));
		usuario.setIdMunicipioNacimiento(configurarZonaGeograficaUsuario(usuarioDto
				.getIdMunicipioNacimiento()));
		usuario.setIdMunicipioNotificacion(configurarZonaGeograficaUsuario(usuarioDto
				.getIdMunicipioNotificacion()));
		usuario.setIdMunicipioResidencia(configurarZonaGeograficaUsuario(usuarioDto
				.getIdMunicipioResidencia()));

		entityManager.persist(usuario);
	}

	public DatosBasicosUsuarioDTO consultarUsuario(String tipoDoc, String nroDoc) {

		Query query = entityManager.createNamedQuery("Usuario.findByTipoNroDoc",
				Usuario.class).setParameter("tipoDoc", tipoDoc).setParameter("nroDoc", new BigDecimal(nroDoc));
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

	private ZonaGeografica configurarZonaGeograficaUsuario(int idZonaConfigurar) {

		ZonaGeografica zona = new ZonaGeografica();
		zona.setIdZonaGeografica(idZonaConfigurar);

		return zona;
	}
}
