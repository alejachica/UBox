package co.edu.uniandes.umbrella.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the historial_documento database table.
 * 
 */
@Entity
@Table(name="HISTORIAL_DOCUMENTO")
@NamedQuery(name="HistorialDocumento.findAll", query="SELECT h FROM HistorialDocumento h")
public class HistorialDocumento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_historial")
	private int idHistorial;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	@Column(name="id_tipo_operacion")
	private String idTipoOperacion;

	private String operacion;

	//bi-directional many-to-one association to Documento
	@ManyToOne
	@JoinColumn(name="fk_documento")
	private Documento documento;

	public HistorialDocumento() {
	}

	public int getIdHistorial() {
		return this.idHistorial;
	}

	public void setIdHistorial(int idHistorial) {
		this.idHistorial = idHistorial;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getIdTipoOperacion() {
		return this.idTipoOperacion;
	}

	public void setIdTipoOperacion(String idTipoOperacion) {
		this.idTipoOperacion = idTipoOperacion;
	}

	public String getOperacion() {
		return this.operacion;
	}

	public void setOperacion(String operacion) {
		this.operacion = operacion;
	}

	public Documento getDocumento() {
		return this.documento;
	}

	public void setDocumento(Documento documento) {
		this.documento = documento;
	}

}