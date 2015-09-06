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
@NamedQuery(name="FormaComparticion.findAll", query="SELECT f FROM FormaComparticion f")
public class FormaComparticion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_forma_comparticion")
	private int idFormaComparticion;

	private String descripcion;

	private String entidadesPrivadasaUsuario;

	private byte entidadesPublicasaUsuario;

	private byte entreOperadores;

	private byte mismoOperador;

	private String nombre;

	private String simple;

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

	public byte getEntidadesPublicasaUsuario() {
		return this.entidadesPublicasaUsuario;
	}

	public void setEntidadesPublicasaUsuario(byte entidadesPublicasaUsuario) {
		this.entidadesPublicasaUsuario = entidadesPublicasaUsuario;
	}

	public byte getEntreOperadores() {
		return this.entreOperadores;
	}

	public void setEntreOperadores(byte entreOperadores) {
		this.entreOperadores = entreOperadores;
	}

	public byte getMismoOperador() {
		return this.mismoOperador;
	}

	public void setMismoOperador(byte mismoOperador) {
		this.mismoOperador = mismoOperador;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSimple() {
		return this.simple;
	}

	public void setSimple(String simple) {
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