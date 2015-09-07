package co.edu.uniandes.umbrella.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the documento_x_usuario_compartido database table.
 * 
 */
@Entity
@Table(name="documento_x_usuario_compartido")
@NamedQuery(name="DocumentoXUsuarioCompartido.findAll", query="SELECT d FROM DocumentoXUsuarioCompartido d")
public class DocumentoXUsuarioCompartido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_compartido")
	private int idCompartido;

	private byte compartir;

	private byte descarga;

	private byte enviado;

	private byte escritura;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_expiracion")
	private Date fechaExpiracion;

	private String identificacionComparticion;

	private byte lectura;

	private String link;

	private String operadorComparticion;

	@Column(name="permiso_acitvo")
	private byte permisoAcitvo;

	private byte recibido;

	//bi-directional many-to-one association to Documento
	@ManyToOne
	@JoinColumn(name="fk_documento")
	private Documento documento;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="fk_usuario")
	private Usuario usuario;

	//bi-directional many-to-one association to FormaComparticion
	@ManyToOne
	@JoinColumn(name="fk_forma_comparticion")
	private FormaComparticion formaComparticion;

	public DocumentoXUsuarioCompartido() {
	}

	public int getIdCompartido() {
		return this.idCompartido;
	}

	public void setIdCompartido(int idCompartido) {
		this.idCompartido = idCompartido;
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

	public byte getEnviado() {
		return this.enviado;
	}

	public void setEnviado(byte enviado) {
		this.enviado = enviado;
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

	public String getIdentificacionComparticion() {
		return this.identificacionComparticion;
	}

	public void setIdentificacionComparticion(String identificacionComparticion) {
		this.identificacionComparticion = identificacionComparticion;
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

	public String getOperadorComparticion() {
		return this.operadorComparticion;
	}

	public void setOperadorComparticion(String operadorComparticion) {
		this.operadorComparticion = operadorComparticion;
	}

	public byte getPermisoAcitvo() {
		return this.permisoAcitvo;
	}

	public void setPermisoAcitvo(byte permisoAcitvo) {
		this.permisoAcitvo = permisoAcitvo;
	}

	public byte getRecibido() {
		return this.recibido;
	}

	public void setRecibido(byte recibido) {
		this.recibido = recibido;
	}

	public Documento getDocumento() {
		return this.documento;
	}

	public void setDocumento(Documento documento) {
		this.documento = documento;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public FormaComparticion getFormaComparticion() {
		return this.formaComparticion;
	}

	public void setFormaComparticion(FormaComparticion formaComparticion) {
		this.formaComparticion = formaComparticion;
	}

}