package co.edu.uniandes.umbrella.entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tipodoc_x_permisos database table.
 * 
 */
@Entity
@Table(name="tipodoc_x_permisos")
@NamedQuery(name="TipodocXPermiso.findAll", query="SELECT t FROM TipodocXPermiso t")
public class TipodocXPermiso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_tipo_doc_x_permisos")
	private int idTipoDocXPermisos;

	@Column(name="id_permiso")
	private String idPermiso;

	@Column(name="id_tipo_doc")
	private String idTipoDoc;

	public TipodocXPermiso() {
	}

	public int getIdTipoDocXPermisos() {
		return this.idTipoDocXPermisos;
	}

	public void setIdTipoDocXPermisos(int idTipoDocXPermisos) {
		this.idTipoDocXPermisos = idTipoDocXPermisos;
	}

	public String getIdPermiso() {
		return this.idPermiso;
	}

	public void setIdPermiso(String idPermiso) {
		this.idPermiso = idPermiso;
	}

	public String getIdTipoDoc() {
		return this.idTipoDoc;
	}

	public void setIdTipoDoc(String idTipoDoc) {
		this.idTipoDoc = idTipoDoc;
	}

}