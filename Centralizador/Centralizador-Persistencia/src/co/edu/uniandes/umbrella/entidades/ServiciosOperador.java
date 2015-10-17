package co.edu.uniandes.umbrella.entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the SERVICIOS_OPERADOR database table.
 * 
 */
@Entity
@Table(name="SERVICIOS_OPERADOR")
@NamedQueries({
		
	@NamedQuery(name = "ServiciosOperador.findAll", query = "SELECT s FROM ServiciosOperador s"),
		
	@NamedQuery(name = "ServiciosOperador.urlParaCompartirDocumentos", query = "select s from ServiciosOperador s where s.idOperador = :idOperador") 
})
public class ServiciosOperador implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_servicio_operador")
	private int idServicioOperador;

	@Column(name="id_operador")
	private int idOperador;

	@Column(name="id_tipo_servicio")
	private int idTipoServicio;

	private String url;

	public ServiciosOperador() {
	}

	public int getIdServicioOperador() {
		return this.idServicioOperador;
	}

	public void setIdServicioOperador(int idServicioOperador) {
		this.idServicioOperador = idServicioOperador;
	}

	public int getIdOperador() {
		return this.idOperador;
	}

	public void setIdOperador(int idOperador) {
		this.idOperador = idOperador;
	}

	public int getIdTipoServicio() {
		return this.idTipoServicio;
	}

	public void setIdTipoServicio(int idTipoServicio) {
		this.idTipoServicio = idTipoServicio;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}