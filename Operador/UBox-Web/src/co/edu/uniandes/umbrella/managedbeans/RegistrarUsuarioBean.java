package co.edu.uniandes.umbrella.managedbeans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import co.edu.uniandes.umbrella.dto.UsuarioDTO;
import co.edu.uniandes.umbrella.interfaces.UsuarioEJBRemote;

@ManagedBean
@ViewScoped
public class RegistrarUsuarioBean {
	

@EJB
private UsuarioEJBRemote usuario;

private UsuarioDTO usuarioDto;

	

	public String registrarUsuario() {

		usuarioDto = new UsuarioDTO();
		usuarioDto.setActivo((byte)1);
		usuarioDto.setCorreo("usuario@email.com");
		usuarioDto.setIdentificacion("1013587449");
		usuarioDto.setLogin("ee.prado10");
		usuarioDto.setPassword("123");
		usuarioDto.setPrimerNombre("Nombre1");
		usuarioDto.setSegundoNombre("Nombre1");
		usuarioDto.setPrimerApellido("Apellido1");
		usuarioDto.setSegundoApellido("Apellido1");
		usuarioDto.setIdStormpath("id_stormpath_ale");
		
		usuario.crearUsuario(usuarioDto);
		
		return "";
	}

}
