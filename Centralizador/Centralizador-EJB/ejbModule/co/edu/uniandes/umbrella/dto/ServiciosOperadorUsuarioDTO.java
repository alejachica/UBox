/**
 * 
 */
package co.edu.uniandes.umbrella.dto;

import java.io.Serializable;

/**
 * DTO con los datos para consultar la informacion del operador 
 * del usuario al que se le va a compartir un documento.
 * @author Aleja Chica
 *
 */
public class ServiciosOperadorUsuarioDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long idOperador;
	
	private String tipoDocUsuario;
	
	private String nroDocUsuario;

	/**
	 * @return the idOperador
	 */
	public Long getIdOperador() {
		return idOperador;
	}

	/**
	 * @param idOperador the idOperador to set
	 */
	public void setIdOperador(Long idOperador) {
		this.idOperador = idOperador;
	}

	/**
	 * @return the tipoDocUsuario
	 */
	public String getTipoDocUsuario() {
		return tipoDocUsuario;
	}

	/**
	 * @param tipoDocUsuario the tipoDocUsuario to set
	 */
	public void setTipoDocUsuario(String tipoDocUsuario) {
		this.tipoDocUsuario = tipoDocUsuario;
	}

	/**
	 * @return the nroDocUsuario
	 */
	public String getNroDocUsuario() {
		return nroDocUsuario;
	}

	/**
	 * @param nroDocUsuario the nroDocUsuario to set
	 */
	public void setNroDocUsuario(String nroDocUsuario) {
		this.nroDocUsuario = nroDocUsuario;
	}

}
