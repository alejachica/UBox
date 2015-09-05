package co.edu.uniandes.managedbeans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import co.edu.uniandes.umbrella.dto.DatosBasicosUsuarioDTO;
import co.edu.uniandes.umbrella.interfaces.UsuariosEJBRemote;

@ManagedBean
@ViewScoped
public class ConsultarInformacionUsuarioBean {
	
	@EJB
	private UsuariosEJBRemote usuario;
	
	private String tipoDoc;
	
	private String nroDoc;
	
	private DatosBasicosUsuarioDTO datosUsuario;
	
	public String consultarUsuario(){
		
		datosUsuario = usuario.consultarUsuario(tipoDoc, nroDoc);
		System.out.println(datosUsuario.getIdUsuario());
		
		return "";
	}

	public String getTipoDoc() {
		return tipoDoc;
	}

	public void setTipoDoc(String tipoDoc) {
		this.tipoDoc = tipoDoc;
	}

	public String getNroDoc() {
		return nroDoc;
	}

	public void setNroDoc(String nroDoc) {
		this.nroDoc = nroDoc;
	}

}
