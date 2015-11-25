package co.edu.uniandes.umbrella.entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tramite_usuario database table.
 * 
 */
@Entity
@Table(name="TRAMITE_USUARIO")
@NamedQuery(name="TramiteUsuario.findAll", query="SELECT t FROM TramiteUsuario t")
public class TramiteUsuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_estado_tramite")
	private int idEstadoTramite;

	//bi-directional many-to-one association to Tramite
	@ManyToOne
	@JoinColumn(name="fk_tramite")
	private Tramite tramite;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="fk_usuario")
	private Usuario usuario;

	public TramiteUsuario() {
	}

	public int getIdEstadoTramite() {
		return this.idEstadoTramite;
	}

	public void setIdEstadoTramite(int idEstadoTramite) {
		this.idEstadoTramite = idEstadoTramite;
	}

	public Tramite getTramite() {
		return this.tramite;
	}

	public void setTramite(Tramite tramite) {
		this.tramite = tramite;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}