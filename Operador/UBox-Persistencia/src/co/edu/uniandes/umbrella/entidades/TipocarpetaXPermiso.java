package co.edu.uniandes.umbrella.entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tipocarpeta_x_permisos database table.
 * 
 */
@Entity
@Table(name="TIPOCARPETA_X_PERMISOS")
@NamedQuery(name="TipocarpetaXPermiso.findAll", query="SELECT t FROM TipocarpetaXPermiso t")
public class TipocarpetaXPermiso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_tipo_carpeta_x_permisos")
	private int idTipoCarpetaXPermisos;

	@Column(name="id_permiso")
	private String idPermiso;

	@Column(name="id_tipo_carpeta")
	private String idTipoCarpeta;

	public TipocarpetaXPermiso() {
	}

	public int getIdTipoCarpetaXPermisos() {
		return this.idTipoCarpetaXPermisos;
	}

	public void setIdTipoCarpetaXPermisos(int idTipoCarpetaXPermisos) {
		this.idTipoCarpetaXPermisos = idTipoCarpetaXPermisos;
	}

	public String getIdPermiso() {
		return this.idPermiso;
	}

	public void setIdPermiso(String idPermiso) {
		this.idPermiso = idPermiso;
	}

	public String getIdTipoCarpeta() {
		return this.idTipoCarpeta;
	}

	public void setIdTipoCarpeta(String idTipoCarpeta) {
		this.idTipoCarpeta = idTipoCarpeta;
	}

}