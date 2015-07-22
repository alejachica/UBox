package co.edu.uniandes.umbrella.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the operador database table.
 * 
 */
@Entity
@Table(name="operador")
@NamedQuery(name="Operador.findAll", query="SELECT o FROM Operador o")
public class Operador implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_operador", unique=true, nullable=false, precision=10, scale=2)
	private long idOperador;

	@Column(length=50)
	private String direccion;

	@Column(nullable=false, length=50)
	private String email;

	@Column(nullable=false, length=50)
	private String nit;

	@Column(name="razon_social", nullable=false, length=50)
	private String razonSocial;

	@Column(precision=10, scale=2)
	private BigDecimal telefono;

	public Operador() {
	}

	public long getIdOperador() {
		return this.idOperador;
	}

	public void setIdOperador(long idOperador) {
		this.idOperador = idOperador;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNit() {
		return this.nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}

	public String getRazonSocial() {
		return this.razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public BigDecimal getTelefono() {
		return this.telefono;
	}

	public void setTelefono(BigDecimal telefono) {
		this.telefono = telefono;
	}

}