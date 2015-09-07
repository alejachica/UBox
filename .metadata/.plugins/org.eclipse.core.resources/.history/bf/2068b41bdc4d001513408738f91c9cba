package co.edu.uniandes.umbrella.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the carpeta database table.
 * 
 */
@Entity
@NamedQuery(name="Carpeta.findAll", query="SELECT c FROM Carpeta c")
public class Carpeta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_carpeta")
	private int idCarpeta;

	private String descripcion;

	@Column(name="nombre_carpeta")
	private String nombreCarpeta;

	//bi-directional many-to-one association to Carpeta
	@ManyToOne
	@JoinColumn(name="id_carpeta_padre")
	private Carpeta carpeta;

	//bi-directional many-to-one association to Carpeta
	@OneToMany(mappedBy="carpeta")
	private List<Carpeta> carpetas;

	//bi-directional many-to-one association to Documento
	@OneToMany(mappedBy="carpeta")
	private List<Documento> documentos;

	public Carpeta() {
	}

	public int getIdCarpeta() {
		return this.idCarpeta;
	}

	public void setIdCarpeta(int idCarpeta) {
		this.idCarpeta = idCarpeta;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombreCarpeta() {
		return this.nombreCarpeta;
	}

	public void setNombreCarpeta(String nombreCarpeta) {
		this.nombreCarpeta = nombreCarpeta;
	}

	public Carpeta getCarpeta() {
		return this.carpeta;
	}

	public void setCarpeta(Carpeta carpeta) {
		this.carpeta = carpeta;
	}

	public List<Carpeta> getCarpetas() {
		return this.carpetas;
	}

	public void setCarpetas(List<Carpeta> carpetas) {
		this.carpetas = carpetas;
	}

	public Carpeta addCarpeta(Carpeta carpeta) {
		getCarpetas().add(carpeta);
		carpeta.setCarpeta(this);

		return carpeta;
	}

	public Carpeta removeCarpeta(Carpeta carpeta) {
		getCarpetas().remove(carpeta);
		carpeta.setCarpeta(null);

		return carpeta;
	}

	public List<Documento> getDocumentos() {
		return this.documentos;
	}

	public void setDocumentos(List<Documento> documentos) {
		this.documentos = documentos;
	}

	public Documento addDocumento(Documento documento) {
		getDocumentos().add(documento);
		documento.setCarpeta(this);

		return documento;
	}

	public Documento removeDocumento(Documento documento) {
		getDocumentos().remove(documento);
		documento.setCarpeta(null);

		return documento;
	}

}