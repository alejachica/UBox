package co.edu.uniandes.umbrella.managedbeans;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import co.edu.uniandes.umbrella.dto.UsuarioDTO;
import co.edu.uniandes.umbrella.interfaces.UsuarioEJBRemote;
import co.edu.uniandes.umbrella.utils.ResultadoOperacion;
import umbrella.ubox.seguridad.FuncionesStormpath;

@ManagedBean
@ViewScoped
public class RegistrarUsuarioBean {

	public RegistrarUsuarioBean() {
		this.usuario = new UsuarioDTO();
	}

	@EJB
	private UsuarioEJBRemote usuarioEJB;

	private UsuarioDTO usuario;

	public UsuarioDTO getUsuario() {
		return usuario;
	}
	
	public void setUsuario(UsuarioDTO usuario)
	{
		this.usuario = usuario;
	}

	private String error;

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String registrarUsuario() {

		// usuarioDto = new UsuarioDTO();
		DateFormat dateFormat = new SimpleDateFormat("ss");
		Calendar cal = Calendar.getInstance();
		String segundosPrueba = dateFormat.format(cal.getTime()); //2014/08/06 16:00:22
		

		
		this.usuario.setActivo(true);
		this.usuario.setCorreo("usuario"+segundosPrueba+"@email.com");
		this.usuario.setIdentificacion("1013587449"+segundosPrueba);
		this.usuario.setLogin("ee.prado"+segundosPrueba);
		this.usuario.setPassword("Temporal1");
		this.usuario.setPrimerNombre("Erica");
		this.usuario.setSegundoNombre("Nombre1");
		this.usuario.setPrimerApellido("Apellido1");
		this.usuario.setSegundoApellido("Apellido1");

		//Realiza el registro en stormpath 
		ResultadoOperacion respuesta = new FuncionesStormpath().crearUsuario(this.usuario.getPrimerNombre(),
				this.usuario.getIdentificacion(), this.usuario.getCorreo(), this.usuario.getPassword());
		

		//Si quedó registrado, actualiza el id de strmpath y guarda el usuario
		if (respuesta.isOperacionExitosa()) {
			this.usuario.setIdStormpath(respuesta.getResultadoOperacion());
			usuarioEJB.crearUsuario(this.usuario);
			return "documentosPersonales.xhtml";
		} else {
			this.error = respuesta.getResultadoOperacion();
			return "";
		}
	}

}
