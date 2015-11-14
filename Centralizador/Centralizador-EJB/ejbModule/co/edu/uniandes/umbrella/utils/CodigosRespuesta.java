/**
 * 
 */
package co.edu.uniandes.umbrella.utils;

/**
 * Enum para manejar los codigos de respuesta
 * @author Aleja Chica
 *
 */
public enum CodigosRespuesta {
	
	COD_001("001", "Usuario creado exitosamente"), 
	COD_002("002", "Usuario ya existe"), 
	COD_003("003", "Error desconocido al crear el usuario"),
	COD_004("004", "No se encontro usuario con el tipo y nro de documento enviado"),
	COD_005("005", "Se encontraron varios usuarios con el tipo y nro de documento enviado"),
	COD_006("006", "Error desconocido al consultar usuario"),
	;
	
	/**
	 * Id del codigo de mensaje
	 */
	String idCodigo;
	
	/**
	 * Mensaje de respuesta
	 */
	String mensaje;
	
	/**
	 * Metodo constructot
	 * @param idCodigo Id del codigo de mensaje
	 * @param mensaje Mensaje de respuesta
	 */
	private CodigosRespuesta(String idCodigo, String mensaje) {
		
		this.idCodigo = idCodigo;
		this.mensaje =  mensaje;
	}

	/**
	 * @return the idCodigo
	 */
	public String getIdCodigo() {
		return idCodigo;
	}

	/**
	 * @param idCodigo the idCodigo to set
	 */
	public void setIdCodigo(String idCodigo) {
		this.idCodigo = idCodigo;
	}

	/**
	 * @return the mensaje
	 */
	public String getMensaje() {
		return mensaje;
	}

	/**
	 * @param mensaje the mensaje to set
	 */
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	

}
