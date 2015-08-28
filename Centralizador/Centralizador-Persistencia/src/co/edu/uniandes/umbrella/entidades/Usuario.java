package co.edu.uniandes.umbrella.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * The persistent class for the USUARIO database table.
 * 
 */
@Entity
@NamedQueries({
		@NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
		@NamedQuery(name = "Usuario.findByTipoNroDoc", query = "SELECT u FROM Usuario u where u.idTipoIdentificacion = :tipoDoc and u.nroIdentificacion =  :nroDoc") })
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	private int idUsuario;

	@Column(name = "direccion_notificacion")
	private String direccionNotificacion;

	@Column(name = "email_personal")
	private String emailPersonal;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_expediciion_identificacion")
	private Date fechaExpediciionIdentificacion;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_nacimiento")
	private Date fechaNacimiento;

	private String genero;

	@Column(name = "id_direccion_residencia")
	private String idDireccionResidencia;

	@Column(name = "id_estado_civil")
	private int idEstadoCivil;

	@Column(name = "id_nacionalidad")
	private int idNacionalidad;

	@Column(name = "id_operador")
	private int idOperador;

	@Column(name = "id_tipo_identificacion")
	private String idTipoIdentificacion;

	@Column(name = "nro_identificacion")
	private BigDecimal nroIdentificacion;

	@Column(name = "primer_apellido")
	private String primerApellido;

	@Column(name = "primer_nombre")
	private String primerNombre;

	@Column(name = "segundo_apellido")
	private String segundoApellido;

	@Column(name = "segundo_nombre")
	private String segundoNombre;

	@Column(name = "telefono")
	private int telefono;

	// bi-directional many-to-one association to HistoricoOperadoresUsuario
	@OneToMany(mappedBy = "usuario")
	private List<HistoricoOperadoresUsuario> historicoOperadoresUsuarios;

	// bi-directional many-to-one association to Operador
	@ManyToOne
	@JoinColumn(name = "id_operador_actual")
	private Operador idOperadorActual;

	// bi-directional many-to-one association to ZonaGeografica
	@ManyToOne
	@JoinColumn(name = "id_municipio_nacimiento")
	private ZonaGeografica idMunicipioNacimiento;

	// bi-directional many-to-one association to ZonaGeografica
	@ManyToOne
	@JoinColumn(name = "id_municipio_expedicion_identificacion")
	private ZonaGeografica idMunicipioExpedicionIdentificacion;

	// bi-directional many-to-one association to ZonaGeografica
	@ManyToOne
	@JoinColumn(name = "id_municipio_residencia")
	private ZonaGeografica idMunicipioResidencia;

	// bi-directional many-to-one association to ZonaGeografica
	@ManyToOne
	@JoinColumn(name = "id_municipio_notificacion")
	private ZonaGeografica idMunicipioNotificacion;

	// bi-directional many-to-one association to ZonaGeografica
	@ManyToOne
	@JoinColumn(name = "id_municipio_laboral")
	private ZonaGeografica idMunicipioLaboral;

	public Usuario() {
	}

	public int getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getDireccionNotificacion() {
		return this.direccionNotificacion;
	}

	public void setDireccionNotificacion(String direccionNotificacion) {
		this.direccionNotificacion = direccionNotificacion;
	}

	public String getEmailPersonal() {
		return this.emailPersonal;
	}

	public void setEmailPersonal(String emailPersonal) {
		this.emailPersonal = emailPersonal;
	}

	public Date getFechaExpediciionIdentificacion() {
		return this.fechaExpediciionIdentificacion;
	}

	public void setFechaExpediciionIdentificacion(
			Date fechaExpediciionIdentificacion) {
		this.fechaExpediciionIdentificacion = fechaExpediciionIdentificacion;
	}

	public Date getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getGenero() {
		return this.genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getIdDireccionResidencia() {
		return this.idDireccionResidencia;
	}

	public void setIdDireccionResidencia(String idDireccionResidencia) {
		this.idDireccionResidencia = idDireccionResidencia;
	}

	public int getIdEstadoCivil() {
		return this.idEstadoCivil;
	}

	public void setIdEstadoCivil(int idEstadoCivil) {
		this.idEstadoCivil = idEstadoCivil;
	}

	public int getIdNacionalidad() {
		return this.idNacionalidad;
	}

	public void setIdNacionalidad(int idNacionalidad) {
		this.idNacionalidad = idNacionalidad;
	}

	public int getIdOperador() {
		return this.idOperador;
	}

	public void setIdOperador(int idOperador) {
		this.idOperador = idOperador;
	}

	public String getIdTipoIdentificacion() {
		return this.idTipoIdentificacion;
	}

	public void setIdTipoIdentificacion(String idTipoIdentificacion) {
		this.idTipoIdentificacion = idTipoIdentificacion;
	}

	public BigDecimal getNroIdentificacion() {
		return this.nroIdentificacion;
	}

	public void setNroIdentificacion(BigDecimal nroIdentificacion) {
		this.nroIdentificacion = nroIdentificacion;
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

	public int getTelefono() {
		return this.telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public List<HistoricoOperadoresUsuario> getHistoricoOperadoresUsuarios() {
		return this.historicoOperadoresUsuarios;
	}

	public void setHistoricoOperadoresUsuarios(
			List<HistoricoOperadoresUsuario> historicoOperadoresUsuarios) {
		this.historicoOperadoresUsuarios = historicoOperadoresUsuarios;
	}

	public HistoricoOperadoresUsuario addHistoricoOperadoresUsuario(
			HistoricoOperadoresUsuario historicoOperadoresUsuario) {
		getHistoricoOperadoresUsuarios().add(historicoOperadoresUsuario);
		historicoOperadoresUsuario.setUsuario(this);

		return historicoOperadoresUsuario;
	}

	public HistoricoOperadoresUsuario removeHistoricoOperadoresUsuario(
			HistoricoOperadoresUsuario historicoOperadoresUsuario) {
		getHistoricoOperadoresUsuarios().remove(historicoOperadoresUsuario);
		historicoOperadoresUsuario.setUsuario(null);

		return historicoOperadoresUsuario;
	}

	public Operador getIdOperadorActual() {
		return idOperadorActual;
	}

	public void setIdOperadorActual(Operador idOperadorActual) {
		this.idOperadorActual = idOperadorActual;
	}

	public ZonaGeografica getIdMunicipioNacimiento() {
		return idMunicipioNacimiento;
	}

	public void setIdMunicipioNacimiento(ZonaGeografica idMunicipioNacimiento) {
		this.idMunicipioNacimiento = idMunicipioNacimiento;
	}

	public ZonaGeografica getIdMunicipioExpedicionIdentificacion() {
		return idMunicipioExpedicionIdentificacion;
	}

	public void setIdMunicipioExpedicionIdentificacion(
			ZonaGeografica idMunicipioExpedicionIdentificacion) {
		this.idMunicipioExpedicionIdentificacion = idMunicipioExpedicionIdentificacion;
	}

	public ZonaGeografica getIdMunicipioResidencia() {
		return idMunicipioResidencia;
	}

	public void setIdMunicipioResidencia(ZonaGeografica idMunicipioResidencia) {
		this.idMunicipioResidencia = idMunicipioResidencia;
	}

	public ZonaGeografica getIdMunicipioNotificacion() {
		return idMunicipioNotificacion;
	}

	public void setIdMunicipioNotificacion(
			ZonaGeografica idMunicipioNotificacion) {
		this.idMunicipioNotificacion = idMunicipioNotificacion;
	}

	public ZonaGeografica getIdMunicipioLaboral() {
		return idMunicipioLaboral;
	}

	public void setIdMunicipioLaboral(ZonaGeografica idMunicipioLaboral) {
		this.idMunicipioLaboral = idMunicipioLaboral;
	}

}