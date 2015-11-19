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
@NamedQueries({
	@NamedQuery(name="DocumentoXUsuarioCompartido.findAll", query="SELECT d FROM DocumentoXUsuarioCompartido d"),
	@NamedQuery(name="DocumentoXUsuarioCompartido.findByLink", query="SELECT d FROM DocumentoXUsuarioCompartido d where d.link = :link")
})	
public class DocumentoXUsuarioCompartido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_compartido")
	private int idCompartido;

	private boolean compartir;

	private boolean descarga;

	private boolean enviado;

	private boolean escritura;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_expiracion")
	private Date fechaExpiracion;

	private String identificacionComparticion;

	private boolean lectura;

	private String link;

	private String idOperadorExterno;

	@Column(name="permiso_acitvo")
	private boolean permisoAcitvo;

	private boolean recibido;
	
	
	private String clave;

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

	public boolean getCompartir() {
		return this.compartir;
	}

	public void setCompartir(boolean compartir) {
		this.compartir = compartir;
	}

	public boolean getDescarga() {
		return this.descarga;
	}

	public void setDescarga(boolean descarga) {
		this.descarga = descarga;
	}

	public boolean getEnviado() {
		return this.enviado;
	}

	public void setEnviado(boolean enviado) {
		this.enviado = enviado;
	}

	public boolean getEscritura() {
		return this.escritura;
	}

	public void setEscritura(boolean escritura) {
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

	public boolean getLectura() {
		return this.lectura;
	}

	public void setLectura(boolean lectura) {
		this.lectura = lectura;
	}

	public String getLink() {
		return this.link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getIdOperadorExterno() {
		return this.idOperadorExterno;
	}

	public void setIdOperadorExterno(String idOperadorExterno) {
		this.idOperadorExterno = idOperadorExterno;
	}
	
	

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public boolean getPermisoAcitvo() {
		return this.permisoAcitvo;
	}

	public void setPermisoAcitvo(boolean permisoAcitvo) {
		this.permisoAcitvo = permisoAcitvo;
	}

	public boolean getRecibido() {
		return this.recibido;
	}

	public void setRecibido(boolean recibido) {
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