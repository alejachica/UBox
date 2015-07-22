package co.edu.uniandes.umbrella.entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the operador_usuario database table.
 * 
 */
@Entity
@Table(name="operador_usuario")
@NamedQuery(name="OperadorUsuario.findAll", query="SELECT o FROM OperadorUsuario o")
public class OperadorUsuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private OperadorUsuarioPK id;

	public OperadorUsuario() {
	}

	public OperadorUsuarioPK getId() {
		return this.id;
	}

	public void setId(OperadorUsuarioPK id) {
		this.id = id;
	}

}