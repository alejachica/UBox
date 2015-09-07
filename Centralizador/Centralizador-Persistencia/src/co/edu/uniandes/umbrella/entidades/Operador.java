package co.edu.uniandes.umbrella.entidades;

import java.io.Serializable;
import javax.persistence.*;
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
	@OneToMany(mappedBy="operador1")
	private List<HistoricoOperadoresUsuario> historicoOperadoresUsuarios1;

	//bi-directional many-to-one association to HistoricoOperadoresUsuario
	@OneToMany(mappedBy="operador2")
	private List<HistoricoOperadoresUsuario> historicoOperadoresUsuarios2;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="operador")
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

	public List<HistoricoOperadoresUsuario> getHistoricoOperadoresUsuarios1() {
		return this.historicoOperadoresUsuarios1;
	}

	public void setHistoricoOperadoresUsuarios1(List<HistoricoOperadoresUsuario> historicoOperadoresUsuarios1) {
		this.historicoOperadoresUsuarios1 = historicoOperadoresUsuarios1;
	}

	public HistoricoOperadoresUsuario addHistoricoOperadoresUsuarios1(HistoricoOperadoresUsuario historicoOperadoresUsuarios1) {
		getHistoricoOperadoresUsuarios1().add(historicoOperadoresUsuarios1);
		historicoOperadoresUsuarios1.setOperador1(this);

		return historicoOperadoresUsuarios1;
	}

	public HistoricoOperadoresUsuario removeHistoricoOperadoresUsuarios1(HistoricoOperadoresUsuario historicoOperadoresUsuarios1) {
		getHistoricoOperadoresUsuarios1().remove(historicoOperadoresUsuarios1);
		historicoOperadoresUsuarios1.setOperador1(null);

		return historicoOperadoresUsuarios1;
	}

	public List<HistoricoOperadoresUsuario> getHistoricoOperadoresUsuarios2() {
		return this.historicoOperadoresUsuarios2;
	}

	public void setHistoricoOperadoresUsuarios2(List<HistoricoOperadoresUsuario> historicoOperadoresUsuarios2) {
		this.historicoOperadoresUsuarios2 = historicoOperadoresUsuarios2;
	}

	public HistoricoOperadoresUsuario addHistoricoOperadoresUsuarios2(HistoricoOperadoresUsuario historicoOperadoresUsuarios2) {
		getHistoricoOperadoresUsuarios2().add(historicoOperadoresUsuarios2);
		historicoOperadoresUsuarios2.setOperador2(this);

		return historicoOperadoresUsuarios2;
	}

	public HistoricoOperadoresUsuario removeHistoricoOperadoresUsuarios2(HistoricoOperadoresUsuario historicoOperadoresUsuarios2) {
		getHistoricoOperadoresUsuarios2().remove(historicoOperadoresUsuarios2);
		historicoOperadoresUsuarios2.setOperador2(null);

		return historicoOperadoresUsuarios2;
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