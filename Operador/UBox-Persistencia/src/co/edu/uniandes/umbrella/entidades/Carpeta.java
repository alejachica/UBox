package co.edu.uniandes.umbrella.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the carpeta database table.
 * 
 */
@Entity
@Table(name="CARPETA")
@NamedQueries({ 
	@NamedQuery(name = "Carpeta.findAll", query = "SELECT c FROM Carpeta c"), 
	@NamedQuery(name = "Carpeta.findByID", query = "SELECT c FROM Carpeta c where c.idCarpeta = :idCarpeta"),
	@NamedQuery(name = "Carpeta.findByPadreID", query = "SELECT c FROM Carpeta c where c.carpeta.idCarpeta = :idCarpeta"),
	@NamedQuery(name = "Carpeta.findByUserID", query = "SELECT c FROM Carpeta c where c.usuario.idUsuario = :idUsuario and c.carpeta is null"),
	@NamedQuery(name = "Carpeta.findByUserIDAndRootFolder", query = "SELECT c FROM Carpeta c where c.usuario.idUsuario = :idUsuario and c.carpeta is null") 
})
@Cacheable(false)
public class Carpeta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuario usuario;

	//bi-directional many-to-one association to Documento
	@OneToMany(mappedBy="carpeta")
	private List<Documento> documentos;
	
	private boolean isCarpetaRaiz;

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

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Documento> getDocumentos() {
		return this.documentos;
	}

	public void setDocumentos(List<Documento> documentos) {
		this.documentos = documentos;
	}

	public boolean isCarpetaRaiz() {
		return isCarpetaRaiz;
	}

	public void setCarpetaRaiz(boolean isCarpetaRaiz) {
		this.isCarpetaRaiz = isCarpetaRaiz;
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