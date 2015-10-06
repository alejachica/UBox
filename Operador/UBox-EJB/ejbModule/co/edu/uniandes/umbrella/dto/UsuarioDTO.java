/**
 * 
 */
package co.edu.uniandes.umbrella.dto;

/**
 * @author Erica
 *
 */
public class UsuarioDTO {
	
	
	private int idUsuario;
	
	private boolean activo;

	private String correo;

	private String identificacion;

	private String login;

	private String password;

	private String primerApellido;

	private String primerNombre;

	private String segundoApellido;

	private String segundoNombre;
	
	private String idStormpath;
	
	private boolean estaPazYSalvo;

	public boolean isEstaPazYSalvo() {
		return estaPazYSalvo;
	}

	public void setEstaPazYSalvo(boolean estaPazYSalvo) {
		this.estaPazYSalvo = estaPazYSalvo;
	}

	/**
	 * @return the idUsuario
	 */
	public int getIdUsuario() {
		return idUsuario;
	}



	/**
	 * @param idUsuario the idUsuario to set
	 */
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}



	/**
	 * @return the activo
	 */
	public boolean getActivo() {
		return activo;
	}



	/**
	 * @param activo the activo to set
	 */
	public void setActivo(boolean activo) {
		this.activo = activo;
	}



	/**
	 * @return the correo
	 */
	public String getCorreo() {
		return correo;
	}



	/**
	 * @param correo the correo to set
	 */
	public void setCorreo(String correo) {
		this.correo = correo;
	}



	/**
	 * @return the identificacion
	 */
	public String getIdentificacion() {
		return identificacion;
	}



	/**
	 * @param identificacion the identificacion to set
	 */
	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}



	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}



	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}



	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}



	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}



	/**
	 * @return the primerApellido
	 */
	public String getPrimerApellido() {
		return primerApellido;
	}



	/**
	 * @param primerApellido the primerApellido to set
	 */
	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}



	/**
	 * @return the primerNombre
	 */
	public String getPrimerNombre() {
		return primerNombre;
	}



	/**
	 * @param primerNombre the primerNombre to set
	 */
	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}



	/**
	 * @return the segundoApellido
	 */
	public String getSegundoApellido() {
		return segundoApellido;
	}



	/**
	 * @param segundoApellido the segundoApellido to set
	 */
	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}



	/**
	 * @return the segundoNombre
	 */
	public String getSegundoNombre() {
		return segundoNombre;
	}



	/**
	 * @param segundoNombre the segundoNombre to set
	 */
	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}



	/**
	 * 
	 */
	public UsuarioDTO() {
		// TODO Auto-generated constructor stub
	}



	/**
	 * @return the idStormpath
	 */
	public String getIdStormpath() {
		return idStormpath;
	}



	/**
	 * @param idStormpath the idStormpath to set
	 */
	public void setIdStormpath(String idStormpath) {
		this.idStormpath = idStormpath;
	}

}
