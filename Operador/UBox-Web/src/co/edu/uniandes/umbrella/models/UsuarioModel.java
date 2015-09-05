/**
 * 
 */
package co.edu.uniandes.umbrella.models;

import javax.persistence.Column;

/**
 * @author Erica
 *
 */
public class UsuarioModel {
	
	
	private String identificacion;
	private String primerNombre;
	private String segundoNombre;
	private String primerApellido;
	private String segundoApellido;
	private String correo;
	private String login;
	private String password;
	private byte activo;
	
	
	

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
	 * @return the activo
	 */
	public byte getActivo() {
		return activo;
	}






	/**
	 * @param activo the activo to set
	 */
	public void setActivo(byte activo) {
		this.activo = activo;
	}






	/**
	 * 
	 */
	public UsuarioModel() {

			}

}
