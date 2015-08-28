package co.edu.uniandes.umbrella.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the documento database table.
 * 
 */
@Entity
@NamedQuery(name="Documento.findAll", query="SELECT d FROM Documento d")
public class Documento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_documento")
	private int idDocumento;

	private String fecha;

	private byte firmado;

	@Column(name="id_tipo_documento")
	private BigDecimal idTipoDocumento;

	@Column(name="id_tipo_mime")
	private String idTipoMime;

	private String nombre;

	@Column(name="palabras_clave")
	private String palabrasClave;

	private byte papelera;

	private String version;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuario usuario;

	//bi-directional many-to-one association to Carpeta
	@ManyToOne
	@JoinColumn(name="id_carpeta")
	private Carpeta carpeta;

	//bi-directional many-to-one association to HistorialDocumento
	@OneToMany(mappedBy="documento")
	private List<HistorialDocumento> historialDocumentos;

	//bi-directional many-to-one association to Notificacion
	@OneToMany(mappedBy="documento")
	private List<Notificacion> notificacions;

	//bi-directional many-to-one association to Pago
	@OneToMany(mappedBy="documento")
	private List<Pago> pagos;

	//bi-directional many-to-one association to Permiso
	@OneToMany(mappedBy="documento")
	private List<Permiso> permisos;

	public Documento() {
	}

	public int getIdDocumento() {
		return this.idDocumento;
	}

	public void setIdDocumento(int idDocumento) {
		this.idDocumento = idDocumento;
	}

	public String getFecha() {
		return this.fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public byte getFirmado() {
		return this.firmado;
	}

	public void setFirmado(byte firmado) {
		this.firmado = firmado;
	}

	public BigDecimal getIdTipoDocumento() {
		return this.idTipoDocumento;
	}

	public void setIdTipoDocumento(BigDecimal idTipoDocumento) {
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

	public byte getPapelera() {
		return this.papelera;
	}

	public void setPapelera(byte papelera) {
		this.papelera = papelera;
	}

	public String getVersion() {
		return this.version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Carpeta getCarpeta() {
		return this.carpeta;
	}

	public void setCarpeta(Carpeta carpeta) {
		this.carpeta = carpeta;
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

	public List<Permiso> getPermisos() {
		return this.permisos;
	}

	public void setPermisos(List<Permiso> permisos) {
		this.permisos = permisos;
	}

	public Permiso addPermiso(Permiso permiso) {
		getPermisos().add(permiso);
		permiso.setDocumento(this);

		return permiso;
	}

	public Permiso removePermiso(Permiso permiso) {
		getPermisos().remove(permiso);
		permiso.setDocumento(null);

		return permiso;
	}

}