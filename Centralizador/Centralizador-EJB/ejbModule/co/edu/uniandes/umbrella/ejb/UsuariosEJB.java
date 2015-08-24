package co.edu.uniandes.umbrella.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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

	@PersistenceContext(unitName="Centralizador-Persistencia")
	private EntityManager entityManager;
	
    /**
     * Default constructor. 
     */
    public UsuariosEJB() {
        // TODO Auto-generated constructor stub
    }
    
    
    public void crearUsuario(DatosBasicosUsuarioDTO usuarioDto){
    	
    	Usuario usuario = new Usuario();
    	
    	/*
    	 * Datos personales
    	 */
    	usuarioDto.setPrimerApellido(usuarioDto.getPrimerApellido());
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
    	usuario.setFechaExpediciionIdentificacion(usuarioDto.getFechaExpediciionIdentificacion());
    	usuario.setIdDireccionResidencia(usuarioDto.getIdDireccionResidencia());
//    	usuario.setIdMunicipioExpedicionIdentificacion(new ZonaGeografica().setIdZonaGeografica(usuarioDto.getIdMunicipioExpedicionIdentificacion()));
//    	usuario.setIdMunicipioLaboral(usuarioDto.getIdMunicipioLaboral());
//    	usuario.setIdMunicipioNacimiento(usuarioDto.getIdMunicipioNacimiento());
//    	usuario.setIdMunicipioNotificacion(usuarioDto.getIdMunicipioNotificacion());
//    	usuario.setIdMunicipioResidencia(usuarioDto.getIdMunicipioResidencia());
    	
    	entityManager.persist(usuario);
    }

}
