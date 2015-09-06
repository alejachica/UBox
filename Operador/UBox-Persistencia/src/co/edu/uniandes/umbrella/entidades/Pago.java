package co.edu.uniandes.umbrella.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the pago database table.
 * 
 */
@Entity
@NamedQuery(name="Pago.findAll", query="SELECT p FROM Pago p")
public class Pago implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_pago")
	private int idPago;

	private String comprobante;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	@Column(name="id_estado_pago")
	private BigDecimal idEstadoPago;

	@Column(name="id_medio_pago")
	private BigDecimal idMedioPago;

	private BigDecimal monto;

	//bi-directional many-to-one association to Documento
	@ManyToOne
	@JoinColumn(name="fk_documento")
	private Documento documento;

	public Pago() {
	}

	public int getIdPago() {
		return this.idPago;
	}

	public void setIdPago(int idPago) {
		this.idPago = idPago;
	}

	public String getComprobante() {
		return this.comprobante;
	}

	public void setComprobante(String comprobante) {
		this.comprobante = comprobante;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public BigDecimal getIdEstadoPago() {
		return this.idEstadoPago;
	}

	public void setIdEstadoPago(BigDecimal idEstadoPago) {
		this.idEstadoPago = idEstadoPago;
	}

	public BigDecimal getIdMedioPago() {
		return this.idMedioPago;
	}

	public void setIdMedioPago(BigDecimal idMedioPago) {
		this.idMedioPago = idMedioPago;
	}

	public BigDecimal getMonto() {
		return this.monto;
	}

	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}

	public Documento getDocumento() {
		return this.documento;
	}

	public void setDocumento(Documento documento) {
		this.documento = documento;
	}

}