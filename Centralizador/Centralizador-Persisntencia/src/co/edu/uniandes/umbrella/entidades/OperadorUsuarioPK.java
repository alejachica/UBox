package co.edu.uniandes.umbrella.entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the operador_usuario database table.
 * 
 */
@Embeddable
public class OperadorUsuarioPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_usuario", unique=true, nullable=false, precision=10, scale=2)
	private long idUsuario;

	@Column(name="id_operador", unique=true, nullable=false, precision=10, scale=2)
	private long idOperador;

	public OperadorUsuarioPK() {
	}
	public long getIdUsuario() {
		return this.idUsuario;
	}
	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}
	public long getIdOperador() {
		return this.idOperador;
	}
	public void setIdOperador(long idOperador) {
		this.idOperador = idOperador;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof OperadorUsuarioPK)) {
			return false;
		}
		OperadorUsuarioPK castOther = (OperadorUsuarioPK)other;
		return 
			(this.idUsuario == castOther.idUsuario)
			&& (this.idOperador == castOther.idOperador);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.idUsuario ^ (this.idUsuario >>> 32)));
		hash = hash * prime + ((int) (this.idOperador ^ (this.idOperador >>> 32)));
		
		return hash;
	}
}