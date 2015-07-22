package co.edu.uniandes.umbrella.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the servicios_operador database table.
 * 
 */
@Entity
@Table(name="servicios_operador")
@NamedQuery(name="ServiciosOperador.findAll", query="SELECT s FROM ServiciosOperador s")
public class ServiciosOperador implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_servicio_operador", unique=true, nullable=false)
	private int idServicioOperador;

	@Column(name="id_operador", nullable=false, precision=10, scale=2)
	private BigDecimal idOperador;

	@Column(name="id_tipo_servicio", precision=10, scale=2)
	private BigDecimal idTipoServicio;

	@Column(nullable=false, length=50)
	private String url;

	public ServiciosOperador() {
	}

	public int getIdServicioOperador() {
		return this.idServicioOperador;
	}

	public void setIdServicioOperador(int idServicioOperador) {
		this.idServicioOperador = idServicioOperador;
	}

	public BigDecimal getIdOperador() {
		return this.idOperador;
	}

	public void setIdOperador(BigDecimal idOperador) {
		this.idOperador = idOperador;
	}

	public BigDecimal getIdTipoServicio() {
		return this.idTipoServicio;
	}

	public void setIdTipoServicio(BigDecimal idTipoServicio) {
		this.idTipoServicio = idTipoServicio;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}