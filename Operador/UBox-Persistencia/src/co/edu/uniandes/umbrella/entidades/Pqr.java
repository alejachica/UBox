package co.edu.uniandes.umbrella.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the pqr database table.
 * 
 */
@Entity
@NamedQuery(name="Pqr.findAll", query="SELECT p FROM Pqr p")
public class Pqr implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_pqr")
	private int idPqr;

	@Lob
	private String descripcion;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	@Column(name="id_estado_pqr")
	private BigDecimal idEstadoPqr;

	@Column(name="id_tipo_pqr")
	private BigDecimal idTipoPqr;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="fk_usuario")
	private Usuario usuario;

	public Pqr() {
	}

	public int getIdPqr() {
		return this.idPqr;
	}

	public void setIdPqr(int idPqr) {
		this.idPqr = idPqr;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public BigDecimal getIdEstadoPqr() {
		return this.idEstadoPqr;
	}

	public void setIdEstadoPqr(BigDecimal idEstadoPqr) {
		this.idEstadoPqr = idEstadoPqr;
	}

	public BigDecimal getIdTipoPqr() {
		return this.idTipoPqr;
	}

	public void setIdTipoPqr(BigDecimal idTipoPqr) {
		this.idTipoPqr = idTipoPqr;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}