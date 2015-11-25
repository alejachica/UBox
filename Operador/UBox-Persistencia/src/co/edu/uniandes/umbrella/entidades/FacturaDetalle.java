package co.edu.uniandes.umbrella.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the factura_detalle database table.
 * 
 */
@Entity
@Table(name="FACTURA_DETALLE")
@NamedQuery(name="FacturaDetalle.findAll", query="SELECT f FROM FacturaDetalle f")
public class FacturaDetalle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_detalle")
	private int idDetalle;

	private BigDecimal cantidad;

	private String concepto;

	private BigDecimal impuesto;

	@Column(name="valor_bruto")
	private BigDecimal valorBruto;

	@Column(name="valor_neto")
	private BigDecimal valorNeto;

	//bi-directional many-to-one association to Factura
	@ManyToOne
	@JoinColumn(name="fk_factura")
	private Factura factura;

	public FacturaDetalle() {
	}

	public int getIdDetalle() {
		return this.idDetalle;
	}

	public void setIdDetalle(int idDetalle) {
		this.idDetalle = idDetalle;
	}

	public BigDecimal getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(BigDecimal cantidad) {
		this.cantidad = cantidad;
	}

	public String getConcepto() {
		return this.concepto;
	}

	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}

	public BigDecimal getImpuesto() {
		return this.impuesto;
	}

	public void setImpuesto(BigDecimal impuesto) {
		this.impuesto = impuesto;
	}

	public BigDecimal getValorBruto() {
		return this.valorBruto;
	}

	public void setValorBruto(BigDecimal valorBruto) {
		this.valorBruto = valorBruto;
	}

	public BigDecimal getValorNeto() {
		return this.valorNeto;
	}

	public void setValorNeto(BigDecimal valorNeto) {
		this.valorNeto = valorNeto;
	}

	public Factura getFactura() {
		return this.factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

}