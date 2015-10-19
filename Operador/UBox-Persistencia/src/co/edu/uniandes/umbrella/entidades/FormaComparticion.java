package co.edu.uniandes.umbrella.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the forma_comparticion database table.
 * 
 */
@Entity
@Table(name="forma_comparticion")


@NamedQueries({ 
	@NamedQuery(name="FormaComparticion.findAll", query="SELECT f FROM FormaComparticion f"),
	@NamedQuery(name="FormaComparticion.findById", query="SELECT f FROM FormaComparticion f where f.idFormaComparticion = :id")
})
public class FormaComparticion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_forma_comparticion")
	private int idFormaComparticion;

	private String descripcion;

	private String entidadesPrivadasaUsuario;

	private boolean entidadesPublicasaUsuario;

	private boolean entreOperadores;

	private boolean mismoOperador;
	
	private boolean aplicaFechaExpiracion;

	public boolean isAplicaFechaExpiracion() {
		return aplicaFechaExpiracion;
	}

	public void setAplicaFechaExpiracion(boolean aplicaFechaExpiracion) {
		this.aplicaFechaExpiracion = aplicaFechaExpiracion;
	}

	private String nombre;

	private boolean simple;

	//bi-directional many-to-one association to DocumentoXUsuarioCompartido
	@OneToMany(mappedBy="formaComparticion")
	private List<DocumentoXUsuarioCompartido> documentoXUsuarioCompartidos;

	public FormaComparticion() {
	}

	public int getIdFormaComparticion() {
		return this.idFormaComparticion;
	}

	public void setIdFormaComparticion(int idFormaComparticion) {
		this.idFormaComparticion = idFormaComparticion;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEntidadesPrivadasaUsuario() {
		return this.entidadesPrivadasaUsuario;
	}

	public void setEntidadesPrivadasaUsuario(String entidadesPrivadasaUsuario) {
		this.entidadesPrivadasaUsuario = entidadesPrivadasaUsuario;
	}

	public boolean getEntidadesPublicasaUsuario() {
		return this.entidadesPublicasaUsuario;
	}

	public void setEntidadesPublicasaUsuario(boolean entidadesPublicasaUsuario) {
		this.entidadesPublicasaUsuario = entidadesPublicasaUsuario;
	}

	public boolean getEntreOperadores() {
		return this.entreOperadores;
	}

	public void setEntreOperadores(boolean entreOperadores) {
		this.entreOperadores = entreOperadores;
	}

	public boolean getMismoOperador() {
		return this.mismoOperador;
	}

	public void setMismoOperador(boolean mismoOperador) {
		this.mismoOperador = mismoOperador;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean getSimple() {
		return this.simple;
	}

	public void setSimple(boolean simple) {
		this.simple = simple;
	}

	public List<DocumentoXUsuarioCompartido> getDocumentoXUsuarioCompartidos() {
		return this.documentoXUsuarioCompartidos;
	}

	public void setDocumentoXUsuarioCompartidos(List<DocumentoXUsuarioCompartido> documentoXUsuarioCompartidos) {
		this.documentoXUsuarioCompartidos = documentoXUsuarioCompartidos;
	}

	public DocumentoXUsuarioCompartido addDocumentoXUsuarioCompartido(DocumentoXUsuarioCompartido documentoXUsuarioCompartido) {
		getDocumentoXUsuarioCompartidos().add(documentoXUsuarioCompartido);
		documentoXUsuarioCompartido.setFormaComparticion(this);

		return documentoXUsuarioCompartido;
	}

	public DocumentoXUsuarioCompartido removeDocumentoXUsuarioCompartido(DocumentoXUsuarioCompartido documentoXUsuarioCompartido) {
		getDocumentoXUsuarioCompartidos().remove(documentoXUsuarioCompartido);
		documentoXUsuarioCompartido.setFormaComparticion(null);

		return documentoXUsuarioCompartido;
	}

}