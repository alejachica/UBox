package co.edu.uniandes.umbrella.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@Table(name = "usuario")
@NamedQueries({
	@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u"),
	@NamedQuery(name="Usuario.findByTipoNroDoc", query="SELECT u FROM Usuario u where u.identificacion = :identificacion"),
	
	@NamedQuery(name="Usuario.findById", query="SELECT u FROM Usuario u where u.idUsuario = :idUsuario") })
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_usuario")
	private int idUsuario;

	private byte activo;

	private String correo;

	@Column(name="id_stormpath")
	private String idStormpath;

	private String identificacion;

	private String login;

	private String password;

	@Column(name="primer_apellido")
	private String primerApellido;

	@Column(name="primer_nombre")
	private String primerNombre;

	@Column(name="segundo_apellido")
	private String segundoApellido;

	@Column(name="segundo_nombre")
	private String segundoNombre;

	//bi-directional many-to-one association to Carpeta
	@OneToMany(mappedBy="usuario")
	private List<Carpeta> carpetas;

	//bi-directional many-to-one association to Contrato
	@OneToMany(mappedBy="usuario")
	private List<Contrato> contratos;

	//bi-directional many-to-one association to Documento
	@OneToMany(mappedBy="usuario")
	private List<Documento> documentos;

	//bi-directional many-to-one association to DocumentoXUsuarioCompartido
	@OneToMany(mappedBy="usuario")
	private List<DocumentoXUsuarioCompartido> documentoXUsuarioCompartidos;

	//bi-directional many-to-one association to Notificacion
	@OneToMany(mappedBy="usuario")
	private List<Notificacion> notificacions;

	//bi-directional many-to-one association to Pqr
	@OneToMany(mappedBy="usuario")
	private List<Pqr> pqrs;

	//bi-directional many-to-one association to TramiteUsuario
	@OneToMany(mappedBy="usuario")
	private List<TramiteUsuario> tramiteUsuarios;

	public Usuario() {
	}

	public int getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public byte getActivo() {
		return this.activo;
	}

	public void setActivo(byte activo) {
		this.activo = activo;
	}

	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getIdStormpath() {
		return this.idStormpath;
	}

	public void setIdStormpath(String idStormpath) {
		this.idStormpath = idStormpath;
	}

	public String getIdentificacion() {
		return this.identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPrimerApellido() {
		return this.primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public String getPrimerNombre() {
		return this.primerNombre;
	}

	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}

	public String getSegundoApellido() {
		return this.segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	public String getSegundoNombre() {
		return this.segundoNombre;
	}

	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}

	public List<Carpeta> getCarpetas() {
		return this.carpetas;
	}

	public void setCarpetas(List<Carpeta> carpetas) {
		this.carpetas = carpetas;
	}

	public Carpeta addCarpeta(Carpeta carpeta) {
		getCarpetas().add(carpeta);
		carpeta.setUsuario(this);

		return carpeta;
	}

	public Carpeta removeCarpeta(Carpeta carpeta) {
		getCarpetas().remove(carpeta);
		carpeta.setUsuario(null);

		return carpeta;
	}

	public List<Contrato> getContratos() {
		return this.contratos;
	}

	public void setContratos(List<Contrato> contratos) {
		this.contratos = contratos;
	}

	public Contrato addContrato(Contrato contrato) {
		getContratos().add(contrato);
		contrato.setUsuario(this);

		return contrato;
	}

	public Contrato removeContrato(Contrato contrato) {
		getContratos().remove(contrato);
		contrato.setUsuario(null);

		return contrato;
	}

	public List<Documento> getDocumentos() {
		return this.documentos;
	}

	public void setDocumentos(List<Documento> documentos) {
		this.documentos = documentos;
	}

	public Documento addDocumento(Documento documento) {
		getDocumentos().add(documento);
		documento.setUsuario(this);

		return documento;
	}

	public Documento removeDocumento(Documento documento) {
		getDocumentos().remove(documento);
		documento.setUsuario(null);

		return documento;
	}

	public List<DocumentoXUsuarioCompartido> getDocumentoXUsuarioCompartidos() {
		return this.documentoXUsuarioCompartidos;
	}

	public void setDocumentoXUsuarioCompartidos(List<DocumentoXUsuarioCompartido> documentoXUsuarioCompartidos) {
		this.documentoXUsuarioCompartidos = documentoXUsuarioCompartidos;
	}

	public DocumentoXUsuarioCompartido addDocumentoXUsuarioCompartido(DocumentoXUsuarioCompartido documentoXUsuarioCompartido) {
		getDocumentoXUsuarioCompartidos().add(documentoXUsuarioCompartido);
		documentoXUsuarioCompartido.setUsuario(this);

		return documentoXUsuarioCompartido;
	}

	public DocumentoXUsuarioCompartido removeDocumentoXUsuarioCompartido(DocumentoXUsuarioCompartido documentoXUsuarioCompartido) {
		getDocumentoXUsuarioCompartidos().remove(documentoXUsuarioCompartido);
		documentoXUsuarioCompartido.setUsuario(null);

		return documentoXUsuarioCompartido;
	}

	public List<Notificacion> getNotificacions() {
		return this.notificacions;
	}

	public void setNotificacions(List<Notificacion> notificacions) {
		this.notificacions = notificacions;
	}

	public Notificacion addNotificacion(Notificacion notificacion) {
		getNotificacions().add(notificacion);
		notificacion.setUsuario(this);

		return notificacion;
	}

	public Notificacion removeNotificacion(Notificacion notificacion) {
		getNotificacions().remove(notificacion);
		notificacion.setUsuario(null);

		return notificacion;
	}

	public List<Pqr> getPqrs() {
		return this.pqrs;
	}

	public void setPqrs(List<Pqr> pqrs) {
		this.pqrs = pqrs;
	}

	public Pqr addPqr(Pqr pqr) {
		getPqrs().add(pqr);
		pqr.setUsuario(this);

		return pqr;
	}

	public Pqr removePqr(Pqr pqr) {
		getPqrs().remove(pqr);
		pqr.setUsuario(null);

		return pqr;
	}

	public List<TramiteUsuario> getTramiteUsuarios() {
		return this.tramiteUsuarios;
	}

	public void setTramiteUsuarios(List<TramiteUsuario> tramiteUsuarios) {
		this.tramiteUsuarios = tramiteUsuarios;
	}

	public TramiteUsuario addTramiteUsuario(TramiteUsuario tramiteUsuario) {
		getTramiteUsuarios().add(tramiteUsuario);
		tramiteUsuario.setUsuario(this);

		return tramiteUsuario;
	}

	public TramiteUsuario removeTramiteUsuario(TramiteUsuario tramiteUsuario) {
		getTramiteUsuarios().remove(tramiteUsuario);
		tramiteUsuario.setUsuario(null);

		return tramiteUsuario;
	}

}