package umbrella.ubox.seguridad;

import java.util.Map;

import javax.ejb.EJB;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import co.edu.uniandes.umbrella.interfaces.UsuarioEJBRemote;

public class UsuarioAutenticado {
	private int id;
	private String idStormpath;
	private String usuario;
	private String correo;
	private boolean admin; 
	
	@EJB
	public UsuarioEJBRemote usuarioEjb;
	
	public UsuarioAutenticado(Map<String, String> userAttributes)
	{
		//Id de stormpath que se saca con la url del usuario
		String[] hrefSplit = userAttributes.get("href").split("/"); 
		
		this.idStormpath = hrefSplit[hrefSplit.length - 1];
		this.usuario = userAttributes.get("username");
		
		try {
			Context ctx = new InitialContext();
			usuarioEjb = (UsuarioEJBRemote)ctx.lookup("java:comp/env/usuariosEjb");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int idUsuario = usuarioEjb.consultarUsuarioPorStormpathId(this.idStormpath);
		this.id = idUsuario;
	}
	
	
	public boolean isAdmin() {
		return admin;
	}


	public void setAdmin(boolean admin) {
		this.admin = admin;
	}


	public int getId() {
		return id;
	}

	public String getIdStormpath() {
		return idStormpath;
	}

	public String getUsuario() {
		return usuario;
	}

	public String getCorreo() {
		return correo;
	}

	
	
	
	
	
}
