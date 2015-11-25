package co.edu.uniandes.umbrella.managedbeans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="usuarioSession")
@SessionScoped
public class UsuarioSesion  extends BaseBeanConSesion implements  Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String identificadorUsuario;

	public String getIdentificadorUsuario() {
		return identificadorUsuario;
	}
	
	@PostConstruct
	public void init(){
		identificadorUsuario = this.getUsuarioAutenticado().getUsuario();
	}

}
