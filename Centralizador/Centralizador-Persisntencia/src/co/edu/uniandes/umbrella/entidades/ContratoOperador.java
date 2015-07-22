package co.edu.uniandes.umbrella.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the contrato_operador database table.
 * 
 */
@Entity
@Table(name="contrato_operador")
@NamedQuery(name="ContratoOperador.findAll", query="SELECT c FROM ContratoOperador c")
public class ContratoOperador implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_operador", unique=true, nullable=false, precision=10, scale=2)
	private long idOperador;

	@Column(nullable=false, precision=10, scale=2)
	private BigDecimal estado;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_fin")
	private Date fechaFin;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_inicio", nullable=false)
	private Date fechaInicio;

	@Column(name="nro_contrato", nullable=false, precision=10, scale=2)
	private BigDecimal nroContrato;

	public ContratoOperador() {
	}

	public long getIdOperador() {
		return this.idOperador;
	}

	public void setIdOperador(long idOperador) {
		this.idOperador = idOperador;
	}

	public BigDecimal getEstado() {
		return this.estado;
	}

	public void setEstado(BigDecimal estado) {
		this.estado = estado;
	}

	public Date getFechaFin() {
		return this.fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Date getFechaInicio() {
		return this.fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public BigDecimal getNroContrato() {
		return this.nroContrato;
	}

	public void setNroContrato(BigDecimal nroContrato) {
		this.nroContrato = nroContrato;
	}

}