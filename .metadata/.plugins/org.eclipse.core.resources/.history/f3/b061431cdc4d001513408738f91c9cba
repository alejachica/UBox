package co.edu.uniandes.umbrella.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the permiso database table.
 * 
 */
@Entity
@NamedQuery(name="Permiso.findAll", query="SELECT p FROM Permiso p")
public class Permiso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_permiso")
	private int idPermiso;

	private byte compartir;

	private byte descarga;

	private byte escritura;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_expiracion")
	private Date fechaExpiracion;

	private byte lectura;

	private String link;

	@Column(name="permiso_acitvo")
	private byte permisoAcitvo;

	//bi-directional many-to-one association to Documento
	@ManyToOne
	@JoinColumn(name="id_documento")
	private Documento documento;

	public Permiso() {
	}

	public int getIdPermiso() {
		return this.idPermiso;
	}

	public void setIdPermiso(int idPermiso) {
		this.idPermiso = idPermiso;
	}

	public byte getCompartir() {
		return this.compartir;
	}

	public void setCompartir(byte compartir) {
		this.compartir = compartir;
	}

	public byte getDescarga() {
		return this.descarga;
	}

	public void setDescarga(byte descarga) {
		this.descarga = descarga;
	}

	public byte getEscritura() {
		return this.escritura;
	}

	public void setEscritura(byte escritura) {
		this.escritura = escritura;
	}

	public Date getFechaExpiracion() {
		return this.fechaExpiracion;
	}

	public void setFechaExpiracion(Date fechaExpiracion) {
		this.fechaExpiracion = fechaExpiracion;
	}

	public byte getLectura() {
		return this.lectura;
	}

	public void setLectura(byte lectura) {
		this.lectura = lectura;
	}

	public String getLink() {
		return this.link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public byte getPermisoAcitvo() {
		return this.permisoAcitvo;
	}

	public void setPermisoAcitvo(byte permisoAcitvo) {
		this.permisoAcitvo = permisoAcitvo;
	}

	public Documento getDocumento() {
		return this.documento;
	}

	public void setDocumento(Documento documento) {
		this.documento = documento;
	}

}