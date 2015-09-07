package co.edu.uniandes.umbrella.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the tramite database table.
 * 
 */
@Entity
@NamedQuery(name="Tramite.findAll", query="SELECT t FROM Tramite t")
public class Tramite implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_tramite")
	private int idTramite;

	private byte activo;

	@Column(name="id_tipo_tramite")
	private BigDecimal idTipoTramite;

	private String nombre;

	//bi-directional many-to-one association to Institucion
	@ManyToOne
	@JoinColumn(name="fk_institucion")
	private Institucion institucion;

	//bi-directional many-to-one association to TramiteUsuario
	@OneToMany(mappedBy="tramite")
	private List<TramiteUsuario> tramiteUsuarios;

	public Tramite() {
	}

	public int getIdTramite() {
		return this.idTramite;
	}

	public void setIdTramite(int idTramite) {
		this.idTramite = idTramite;
	}

	public byte getActivo() {
		return this.activo;
	}

	public void setActivo(byte activo) {
		this.activo = activo;
	}

	public BigDecimal getIdTipoTramite() {
		return this.idTipoTramite;
	}

	public void setIdTipoTramite(BigDecimal idTipoTramite) {
		this.idTipoTramite = idTipoTramite;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Institucion getInstitucion() {
		return this.institucion;
	}

	public void setInstitucion(Institucion institucion) {
		this.institucion = institucion;
	}

	public List<TramiteUsuario> getTramiteUsuarios() {
		return this.tramiteUsuarios;
	}

	public void setTramiteUsuarios(List<TramiteUsuario> tramiteUsuarios) {
		this.tramiteUsuarios = tramiteUsuarios;
	}

	public TramiteUsuario addTramiteUsuario(TramiteUsuario tramiteUsuario) {
		getTramiteUsuarios().add(tramiteUsuario);
		tramiteUsuario.setTramite(this);

		return tramiteUsuario;
	}

	public TramiteUsuario removeTramiteUsuario(TramiteUsuario tramiteUsuario) {
		getTramiteUsuarios().remove(tramiteUsuario);
		tramiteUsuario.setTramite(null);

		return tramiteUsuario;
	}

}