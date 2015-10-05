package co.edu.uniandes.umbrella.ejb;

import java.math.BigDecimal;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import co.edu.uniandes.umbrella.dto.UsuarioDTO;
import co.edu.uniandes.umbrella.entidades.Usuario;
import co.edu.uniandes.umbrella.interfaces.UsuarioEJBLocal;
import co.edu.uniandes.umbrella.interfaces.UsuarioEJBRemote;
import co.edu.uniandes.umbrella.utils.ResultadoOperacion;

/**
 * Session Bean implementation class UsuarioEJB
 */
@Stateless
public class UsuarioEJB implements UsuarioEJBRemote, UsuarioEJBLocal {
	
	@PersistenceContext(unitName = "UBox-Persistencia")
	private EntityManager entityManager;
	
	
	public void crearUsuario(UsuarioDTO usuarioDto) {

		Usuario usuario = new Usuario();

		usuario.setPrimerApellido(usuarioDto.getPrimerApellido());
		usuario.setPrimerNombre(usuarioDto.getPrimerNombre());
		usuario.setSegundoApellido(usuarioDto.getSegundoApellido());
		usuario.setSegundoNombre(usuarioDto.getSegundoNombre());
		usuario.setActivo(usuarioDto.getActivo());
		usuario.setCorreo(usuarioDto.getCorreo());
		usuario.setIdentificacion(usuarioDto.getIdentificacion());
		usuario.setLogin(usuarioDto.getLogin());
		usuario.setPassword(usuarioDto.getPassword());
		usuario.setIdStormpath(usuarioDto.getIdStormpath());

		entityManager.persist(usuario);
	}
	
	public void actualizarUsuario(UsuarioDTO usuario)
	{
		
	}

	public UsuarioDTO consultarUsuario(String tipoDoc, String nroDoc) {

		/*Query query = entityManager.createNamedQuery("Usuario.findByTipoNroDoc",
				Usuario.class).setParameter("tipoDoc", tipoDoc).setParameter("nroDoc", new BigDecimal(nroDoc));*/
		
		Query query = entityManager.createNamedQuery("Usuario.findByTipoNroDoc",
				Usuario.class).setParameter("identificacion", nroDoc);
		
		Usuario usuarioEncontrado = (Usuario) query.getSingleResult();

		UsuarioDTO usuario = new UsuarioDTO();
		
		usuario.setActivo(usuarioEncontrado.getActivo());
		usuario.setCorreo(usuarioEncontrado.getCorreo());
		usuario.setIdentificacion(usuarioEncontrado.getIdentificacion());
		usuario.setIdUsuario(usuarioEncontrado.getIdUsuario());
		usuario.setLogin(usuarioEncontrado.getLogin());
		usuario.setPassword(usuarioEncontrado.getPassword());
		usuario.setPrimerApellido(usuarioEncontrado.getPrimerApellido());
		usuario.setPrimerNombre(usuarioEncontrado.getPrimerNombre());
		usuario.setSegundoApellido(usuarioEncontrado.getSegundoApellido());
		usuario.setSegundoNombre(usuarioEncontrado.getSegundoNombre());
		
		
		return usuario;
	}
	
	/****
	 * Realiza las validaciones para generar el traslado de un usuario de un operador a otro
	 * @param tipoDocumento
	 * @param numDocumento
	 * @return
	 */
	public  ResultadoOperacion generarTraslado(String tipoDocumento, String numDocumento)
	{
		ResultadoOperacion respuesta = new ResultadoOperacion();
		
		if(usuarioEstaAPazYSalvo(tipoDocumento, numDocumento))
		{
			UsuarioDTO usuario = this.consultarUsuario(tipoDocumento, numDocumento);
			this.actualizarUsuario(usuario);
			respuesta.setOperacionExitosa(true);
		}
		else
		{
			respuesta.setOperacionExitosa(false);
			respuesta.setResultadoOperacion("El usuario no se encuentra a paz y salvo");
		}
		
		return respuesta;
	}
	
	/****
	 * Valida si un usuario est� o no al d�a en pagos
	 * @param tipoDocument
	 * @param numeroDocumento
	 * @return
	 */
	public boolean usuarioEstaAPazYSalvo(String tipoDocumento, String numeroDocumento)
	{
		return true;
	}

    /**
     * Default constructor. 
     */
    public UsuarioEJB() {
        // TODO Auto-generated constructor stub
    }

}
