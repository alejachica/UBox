package umbrella.ubox.seguridad;

import java.util.Map;

public class UsuarioAutenticado {
	private int id;
	private String idStormpath;
	private String usuario;
	private String correo;
	
	public UsuarioAutenticado(Map<String, String> userAttributes)
	{
		this.idStormpath = userAttributes.get("id");
		this.usuario = userAttributes.get("username");
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
