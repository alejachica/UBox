package co.edu.uniandes.umbrella.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the documento database table.
 * 
 */
@Entity
@NamedQueries({ 
	@NamedQuery(name = "Documento.findAll", query = "SELECT d FROM Documento d"), 
	@NamedQuery(name = "Documento.findById", query = "SELECT d FROM Documento d where d.idDocumento = :id"),
	@NamedQuery(name = "Documento.findInTrash", query = "SELECT d FROM Documento d where d.usuario.idUsuario = :idUsuario and d.papelera = true"),
	@NamedQuery(name = "Documento.findByCarpeta", query = "SELECT d FROM Documento d where d.carpeta.idCarpeta = :idCarpeta and d.papelera = false")
})

public class Documento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_documento")
	private int idDocumento;

	@Lob
	private byte[] documento;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;

	private boolean firmado;

	@Column(name="id_tipo_documento")
	private int idTipoDocumento;

	@Column(name="id_tipo_mime")
	private String idTipoMime;

	private String nombre;

	@Column(name="palabras_clave")
	private String palabrasClave;

	private boolean papelera;

	private String ruta;

	private int size;

	private String version;

	//bi-directional many-to-one association to Carpeta
	@ManyToOne
	@JoinColumn(name="fk_carpeta")
	private Carpeta carpeta;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="fk_usuario")
	private Usuario usuario;

	//bi-directional many-to-one association to DocumentoXUsuarioCompartido
	@OneToMany(mappedBy="documento")
	private List<DocumentoXUsuarioCompartido> documentoXUsuarioCompartidos;

	//bi-directional many-to-one association to HistorialDocumento
	@OneToMany(mappedBy="documento")
	private List<HistorialDocumento> historialDocumentos;

	//bi-directional many-to-one association to Notificacion
	@OneToMany(mappedBy="documento")
	private List<Notificacion> notificacions;

	//bi-directional many-to-one association to Pago
	@OneToMany(mappedBy="documento")
	private List<Pago> pagos;

	public Documento() {
	}

	public int getIdDocumento() {
		return this.idDocumento;
	}

	public void setIdDocumento(int idDocumento) {
		this.idDocumento = idDocumento;
	}

	public byte[] getDocumento() {
		return this.documento;
	}

	public void setDocumento(byte[] documento) {
		this.documento = documento;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public boolean getFirmado() {
		return this.firmado;
	}

	public void setFirmado(boolean firmado) {
		this.firmado = firmado;
	}

	public int getIdTipoDocumento() {
		return this.idTipoDocumento;
	}

	public void setIdTipoDocumento(int idTipoDocumento) {
		this.idTipoDocumento = idTipoDocumento;
	}

	public String getIdTipoMime() {
		return this.idTipoMime;
	}

	public void setIdTipoMime(String idTipoMime) {
		this.idTipoMime = idTipoMime;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPalabrasClave() {
		return this.palabrasClave;
	}

	public void setPalabrasClave(String palabrasClave) {
		this.palabrasClave = palabrasClave;
	}

	public boolean getPapelera() {
		return this.papelera;
	}

	public void setPapelera(boolean papelera) {
		this.papelera = papelera;
	}

	public String getRuta() {
		return this.ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	public int getSize() {
		return this.size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getVersion() {
		return this.version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public Carpeta getCarpeta() {
		return this.carpeta;
	}

	public void setCarpeta(Carpeta carpeta) {
		this.carpeta = carpeta;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<DocumentoXUsuarioCompartido> getDocumentoXUsuarioCompartidos() {
		return this.documentoXUsuarioCompartidos;
	}

	public void setDocumentoXUsuarioCompartidos(List<DocumentoXUsuarioCompartido> documentoXUsuarioCompartidos) {
		this.documentoXUsuarioCompartidos = documentoXUsuarioCompartidos;
	}

	public DocumentoXUsuarioCompartido addDocumentoXUsuarioCompartido(DocumentoXUsuarioCompartido documentoXUsuarioCompartido) {
		getDocumentoXUsuarioCompartidos().add(documentoXUsuarioCompartido);
		documentoXUsuarioCompartido.setDocumento(this);

		return documentoXUsuarioCompartido;
	}

	public DocumentoXUsuarioCompartido removeDocumentoXUsuarioCompartido(DocumentoXUsuarioCompartido documentoXUsuarioCompartido) {
		getDocumentoXUsuarioCompartidos().remove(documentoXUsuarioCompartido);
		documentoXUsuarioCompartido.setDocumento(null);

		return documentoXUsuarioCompartido;
	}

	public List<HistorialDocumento> getHistorialDocumentos() {
		return this.historialDocumentos;
	}

	public void setHistorialDocumentos(List<HistorialDocumento> historialDocumentos) {
		this.historialDocumentos = historialDocumentos;
	}

	public HistorialDocumento addHistorialDocumento(HistorialDocumento historialDocumento) {
		getHistorialDocumentos().add(historialDocumento);
		historialDocumento.setDocumento(this);

		return historialDocumento;
	}

	public HistorialDocumento removeHistorialDocumento(HistorialDocumento historialDocumento) {
		getHistorialDocumentos().remove(historialDocumento);
		historialDocumento.setDocumento(null);

		return historialDocumento;
	}

	public List<Notificacion> getNotificacions() {
		return this.notificacions;
	}

	public void setNotificacions(List<Notificacion> notificacions) {
		this.notificacions = notificacions;
	}

	public Notificacion addNotificacion(Notificacion notificacion) {
		getNotificacions().add(notificacion);
		notificacion.setDocumento(this);

		return notificacion;
	}

	public Notificacion removeNotificacion(Notificacion notificacion) {
		getNotificacions().remove(notificacion);
		notificacion.setDocumento(null);

		return notificacion;
	}

	public List<Pago> getPagos() {
		return this.pagos;
	}

	public void setPagos(List<Pago> pagos) {
		this.pagos = pagos;
	}

	public Pago addPago(Pago pago) {
		getPagos().add(pago);
		pago.setDocumento(this);

		return pago;
	}

	public Pago removePago(Pago pago) {
		getPagos().remove(pago);
		pago.setDocumento(null);

		return pago;
	}

}