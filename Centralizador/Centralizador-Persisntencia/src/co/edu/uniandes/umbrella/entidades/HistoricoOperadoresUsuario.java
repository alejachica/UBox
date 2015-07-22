package co.edu.uniandes.umbrella.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the historico_operadores_usuario database table.
 * 
 */
@Entity
@Table(name="historico_operadores_usuario")
@NamedQuery(name="HistoricoOperadoresUsuario.findAll", query="SELECT h FROM HistoricoOperadoresUsuario h")
public class HistoricoOperadoresUsuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date fecha;

	@Column(name="id_historico", nullable=false, precision=10, scale=2)
	private BigDecimal idHistorico;

	@Column(name="id_operador_destino", precision=10, scale=2)
	private BigDecimal idOperadorDestino;

	@Column(name="id_operador_origen", nullable=false, precision=10, scale=2)
	private BigDecimal idOperadorOrigen;

	@Column(name="id_tipo_operacion", nullable=false, precision=10, scale=2)
	private BigDecimal idTipoOperacion;

	@Column(name="id_usuario", nullable=false, precision=10, scale=2)
	private BigDecimal idUsuario;

	@Column(name="num_formulario", nullable=false, length=50)
	private String numFormulario;

	public HistoricoOperadoresUsuario() {
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public BigDecimal getIdHistorico() {
		return this.idHistorico;
	}

	public void setIdHistorico(BigDecimal idHistorico) {
		this.idHistorico = idHistorico;
	}

	public BigDecimal getIdOperadorDestino() {
		return this.idOperadorDestino;
	}

	public void setIdOperadorDestino(BigDecimal idOperadorDestino) {
		this.idOperadorDestino = idOperadorDestino;
	}

	public BigDecimal getIdOperadorOrigen() {
		return this.idOperadorOrigen;
	}

	public void setIdOperadorOrigen(BigDecimal idOperadorOrigen) {
		this.idOperadorOrigen = idOperadorOrigen;
	}

	public BigDecimal getIdTipoOperacion() {
		return this.idTipoOperacion;
	}

	public void setIdTipoOperacion(BigDecimal idTipoOperacion) {
		this.idTipoOperacion = idTipoOperacion;
	}

	public BigDecimal getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(BigDecimal idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNumFormulario() {
		return this.numFormulario;
	}

	public void setNumFormulario(String numFormulario) {
		this.numFormulario = numFormulario;
	}

}