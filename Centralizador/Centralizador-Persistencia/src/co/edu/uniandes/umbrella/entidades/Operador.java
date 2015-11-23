package co.edu.uniandes.umbrella.entidades;

import java.io.Serializable;

import javax.persistence.*;

import org.eclipse.persistence.jpa.config.Cascade;

import java.util.List;


/**
 * The persistent class for the OPERADOR database table.
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name = "Operador.findAll", query = "SELECT o FROM Operador o"),
	@NamedQuery(name = "Operador.findByNit", query = "SELECT o FROM Operador o where o.nit = :nit") })
public class Operador implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_operador")
	private int idOperador;

	private String direccion;

	private String email;

	private String nit;

	@Column(name="razon_social")
	private String razonSocial;

	private String telefono;

	//bi-directional many-to-one association to HistoricoOperadoresUsuario
	@OneToMany(mappedBy="operador")
	private List<HistoricoOperadoresUsuario> historicoOperadoresUsuario;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="operador", cascade=CascadeType.PERSIST)
	private List<Usuario> usuarios;

	public Operador() {
	}

	public int getIdOperador() {
		return this.idOperador;
	}

	public void setIdOperador(int idOperador) {
		this.idOperador = idOperador;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNit() {
		return this.nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}

	public String getRazonSocial() {
		return this.razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<HistoricoOperadoresUsuario> getHistoricoOperadoresUsuario() {
		return this.historicoOperadoresUsuario;
	}

	public void setHistoricoOperadoresUsuario(List<HistoricoOperadoresUsuario> historicoOperadoresUsuario) {
		this.historicoOperadoresUsuario = historicoOperadoresUsuario;
	}

	public HistoricoOperadoresUsuario addHistoricoOperadoresUsuario(HistoricoOperadoresUsuario historicoOperadoresUsuario) {
		getHistoricoOperadoresUsuario().add(historicoOperadoresUsuario);
		historicoOperadoresUsuario.setOperador(this);

		return historicoOperadoresUsuario;
	}

	public HistoricoOperadoresUsuario removeHistoricoOperadoresUsuario(HistoricoOperadoresUsuario historicoOperadoresUsuario) {
		getHistoricoOperadoresUsuario().remove(historicoOperadoresUsuario);
		historicoOperadoresUsuario.setOperador(null);

		return historicoOperadoresUsuario;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario addUsuario(Usuario usuario) {
		getUsuarios().add(usuario);
		usuario.setOperador(this);

		return usuario;
	}

	public Usuario removeUsuario(Usuario usuario) {
		getUsuarios().remove(usuario);
		usuario.setOperador(null);

		return usuario;
	}

}