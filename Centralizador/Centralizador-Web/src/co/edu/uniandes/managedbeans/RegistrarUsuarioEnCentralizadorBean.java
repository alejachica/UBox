package co.edu.uniandes.managedbeans;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import co.edu.uniandes.umbrella.dto.DatosBasicosUsuarioDTO;
import co.edu.uniandes.umbrella.interfaces.UsuariosEJBRemote;

@ManagedBean
@ViewScoped
public class RegistrarUsuarioEnCentralizadorBean {
	
	@EJB
	private UsuariosEJBRemote usuario;
	
	private DatosBasicosUsuarioDTO usuarioDto;
	

	public String registrarUsuario() {

		usuarioDto = new DatosBasicosUsuarioDTO();
		usuarioDto.setIdTipoIdentificacion("1");
		usuarioDto.setNroIdentificacion(new BigDecimal(1111));
		usuarioDto.setPrimerNombre("Nombre1");
		usuarioDto.setSegundoNombre("Nombre1");
		usuarioDto.setPrimerApellido("Apellido1");
		usuarioDto.setSegundoApellido("Apellido1");
		usuarioDto.setIdNacionalidad(1);
		usuarioDto.setEmailPersonal("usuario@email.com");
		usuarioDto.setFechaNacimiento(Calendar.getInstance().getTime());
		usuarioDto.setGenero("F");
		usuarioDto.setIdEstadoCivil(1);
		usuarioDto.setTelefono(3111111);
		usuarioDto.setDireccionNotificacion("cra 19A 84*47");
		usuarioDto.setFechaExpediciionIdentificacion(Calendar.getInstance().getTime());
		usuarioDto.setIdDireccionResidencia("direccion 1");
		usuarioDto.setIdMunicipioExpedicionIdentificacion(1);
		usuarioDto.setIdMunicipioLaboral(1);
		usuarioDto.setIdMunicipioNacimiento(1);
		usuarioDto.setIdMunicipioNotificacion(1);
		usuarioDto.setIdMunicipioResidencia(1);
		
		usuario.crearUsuario(usuarioDto);
		
		return "";
	}


	public DatosBasicosUsuarioDTO getUsuarioDto() {
		return usuarioDto;
	}


	public void setUsuarioDto(DatosBasicosUsuarioDTO usuarioDto) {
		this.usuarioDto = usuarioDto;
	}

}
