package co.edu.uniandes.umbrella.ejb;

import java.math.BigDecimal;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
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
	
	public void actualizarUsuario(Usuario usuario)
	{
		entityManager.merge(usuario);
	}

	
	private Usuario consultarUsuarioEntity(String tipoDoc, String nroDoc)
	{
		Query query = entityManager.createNamedQuery("Usuario.findByTipoNroDoc",
				Usuario.class).setParameter("identificacion", nroDoc);
		
		Usuario respuesta = null;
		
		try {
			
			respuesta = (Usuario) query.getSingleResult();
			
		} catch (NoResultException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return respuesta;
	}
	
	public UsuarioDTO consultarUsuario(String tipoDoc, String nroDoc) {


		Usuario usuarioEncontrado = consultarUsuarioEntity(tipoDoc, nroDoc);
		
		if(usuarioEncontrado == null)
			return null;
		
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
		usuario.setEstaPazYSalvo(usuarioEncontrado.isEstaPazYSalvo());
		
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
		
		Usuario usuario = this.consultarUsuarioEntity(tipoDocumento, numDocumento);
		if(usuario == null)
		{
			respuesta.setOperacionExitosa(false);
			respuesta.setResultadoOperacion("El usuario no está registrado en nuestro operador");
		}
		else if(!usuario.getActivo())
		{
			respuesta.setOperacionExitosa(false);
			respuesta.setResultadoOperacion("Error usuario no se encuentra activo en nuestro operador");
		}
		else if(usuarioEstaAPazYSalvo(tipoDocumento, numDocumento))
		{
			
			try
			{
				
				usuario.setActivo(false);
				this.actualizarUsuario(usuario);
				respuesta.setOperacionExitosa(true);
			}
			catch(Exception e)
			{
				respuesta.setOperacionExitosa(false);
				respuesta.setResultadoOperacion("Error guardando al usuario, intente de nuevo");
			}
			
		}
		else
		{
			respuesta.setOperacionExitosa(false);
			respuesta.setResultadoOperacion("El usuario no se encuentra a paz y salvo");
		}
		
		return respuesta;
	}
	
	/****
	 * Valida si un usuario está o no al día en pagos
	 * Inicialmente solo consulta el usuario y retorna la propiedad
	 * el metodo puede evolucionar para realizar más funcionalidades
	 * @param tipoDocument
	 * @param numeroDocumento
	 * @return
	 */
	public boolean usuarioEstaAPazYSalvo(String tipoDocumento, String numeroDocumento)
	{
		UsuarioDTO usuario = consultarUsuario(tipoDocumento, numeroDocumento);
		if(usuario == null)
			//throw new Exception("El usuario no se encuentra registrador en el sistema");
			return false;
		
		return usuario.isEstaPazYSalvo();
	}

    /**
     * Default constructor. 
     */
    public UsuarioEJB() {
        // TODO Auto-generated constructor stub
    }

}
