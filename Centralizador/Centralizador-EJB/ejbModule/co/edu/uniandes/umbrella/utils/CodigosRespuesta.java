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
	
	COD_001("001", " Usuario creado exitosamente"), 
	COD_002("002", " Usuario ya existe"), 
	COD_003("003", " Error desconocido al crear el usuario"),
	COD_004("004", " Usuario encontrado"),
	COD_005("005", " No se encontro usuario con el tipo y nro de documento enviado"),
	COD_006("006", " Se encontraron varios usuarios con el tipo y nro de documento enviado"),
	COD_007("007", " Error desconocido al consultar usuario"),
	COD_008("008", " Operador de usuario encontrado"),
	COD_009("009", " No se encontro operador de usuario con el tipo y nro de documento enviado"),
	COD_010("010", " Se encontraron varios operadores de usuarios con el tipo y nro de documento enviado"),
	COD_011("011", " Error desconocido al consultar el operador del  usuario"),
	COD_012("012", " Servicios de Operador de usuario encontrado"),
	COD_013("013", " No se encontro servicios del operador de usuario con el tipo y nro de documento enviado"),
	COD_014("014", " Se encontraron varios servicios del operadores de usuarios con el tipo y nro de documento enviado"),
	COD_015("015", " Error desconocido al consultar el servicio del operador del  usuario"),
	COD_016("016", " Usuario para cambio de operador encontrado"),
	COD_017("017", " Se ha actualizado el operador de usuario correctamente"),
	COD_018("018", " No se encontro el usuario para cambio de operador"),
	COD_019("019", " Se encontro mas de un usuario para cambio de operador"),
	COD_020("020", " Error desconocido actualizar el operador del  usuario"),
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
