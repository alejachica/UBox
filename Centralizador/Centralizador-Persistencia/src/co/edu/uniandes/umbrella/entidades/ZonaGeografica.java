package co.edu.uniandes.umbrella.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ZONA_GEOGRAFICA database table.
 * 
 */
@Entity
@Table(name="ZONA_GEOGRAFICA")
@NamedQuery(name="ZonaGeografica.findAll", query="SELECT z FROM ZonaGeografica z")
public class ZonaGeografica implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_zona_geografica")
	private int idZonaGeografica;

	private String nombre;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="idMunicipioNacimiento")
	private List<Usuario> usuarios1;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="idMunicipioExpedicionIdentificacion")
	private List<Usuario> usuarios2;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="idMunicipioResidencia")
	private List<Usuario> usuarios3;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="idMunicipioNotificacion")
	private List<Usuario> usuarios4;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="idMunicipioLaboral")
	private List<Usuario> usuarios5;

	//bi-directional many-to-one association to ZonaGeografica
	@ManyToOne
	@JoinColumn(name="id_padre")
	private ZonaGeografica zonaGeografica;

	//bi-directional many-to-one association to ZonaGeografica
	@OneToMany(mappedBy="zonaGeografica")
	private List<ZonaGeografica> zonaGeograficas;

	public ZonaGeografica() {
	}

	public int getIdZonaGeografica() {
		return this.idZonaGeografica;
	}

	public void setIdZonaGeografica(int idZonaGeografica) {
		this.idZonaGeografica = idZonaGeografica;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Usuario> getUsuarios1() {
		return this.usuarios1;
	}

	public void setUsuarios1(List<Usuario> usuarios1) {
		this.usuarios1 = usuarios1;
	}

	public Usuario addUsuarios1(Usuario usuarios1) {
		getUsuarios1().add(usuarios1);
		usuarios1.setIdMunicipioNacimiento(this);

		return usuarios1;
	}

	public Usuario removeUsuarios1(Usuario usuarios1) {
		getUsuarios1().remove(usuarios1);
		usuarios1.setIdMunicipioNacimiento(null);

		return usuarios1;
	}

	public List<Usuario> getUsuarios2() {
		return this.usuarios2;
	}

	public void setUsuarios2(List<Usuario> usuarios2) {
		this.usuarios2 = usuarios2;
	}

	public Usuario addUsuarios2(Usuario usuarios2) {
		getUsuarios2().add(usuarios2);
		usuarios2.setIdMunicipioResidencia(this);

		return usuarios2;
	}

	public Usuario removeUsuarios2(Usuario usuarios2) {
		getUsuarios2().remove(usuarios2);
		usuarios2.setIdMunicipioResidencia(null);

		return usuarios2;
	}

	public List<Usuario> getUsuarios3() {
		return this.usuarios3;
	}

	public void setUsuarios3(List<Usuario> usuarios3) {
		this.usuarios3 = usuarios3;
	}

	public Usuario addUsuarios3(Usuario usuarios3) {
		getUsuarios3().add(usuarios3);
		usuarios3.setIdMunicipioNotificacion(this);

		return usuarios3;
	}

	public Usuario removeUsuarios3(Usuario usuarios3) {
		getUsuarios3().remove(usuarios3);
		usuarios3.setIdMunicipioNotificacion(null);

		return usuarios3;
	}

	public List<Usuario> getUsuarios4() {
		return this.usuarios4;
	}

	public void setUsuarios4(List<Usuario> usuarios4) {
		this.usuarios4 = usuarios4;
	}

	public Usuario addUsuarios4(Usuario usuarios4) {
		getUsuarios4().add(usuarios4);
		usuarios4.setIdMunicipioLaboral(this);

		return usuarios4;
	}

	public Usuario removeUsuarios4(Usuario usuarios4) {
		getUsuarios4().remove(usuarios4);
		usuarios4.setIdMunicipioLaboral(null);

		return usuarios4;
	}

	public List<Usuario> getUsuarios5() {
		return this.usuarios5;
	}

	public void setUsuarios5(List<Usuario> usuarios5) {
		this.usuarios5 = usuarios5;
	}

	public Usuario addUsuarios5(Usuario usuarios5) {
		getUsuarios5().add(usuarios5);
		usuarios5.setIdMunicipioExpedicionIdentificacion(this);

		return usuarios5;
	}

	public Usuario removeUsuarios5(Usuario usuarios5) {
		getUsuarios5().remove(usuarios5);
		usuarios5.setIdMunicipioExpedicionIdentificacion(null);

		return usuarios5;
	}

	public ZonaGeografica getZonaGeografica() {
		return this.zonaGeografica;
	}

	public void setZonaGeografica(ZonaGeografica zonaGeografica) {
		this.zonaGeografica = zonaGeografica;
	}

	public List<ZonaGeografica> getZonaGeograficas() {
		return this.zonaGeograficas;
	}

	public void setZonaGeograficas(List<ZonaGeografica> zonaGeograficas) {
		this.zonaGeograficas = zonaGeograficas;
	}

	public ZonaGeografica addZonaGeografica(ZonaGeografica zonaGeografica) {
		getZonaGeograficas().add(zonaGeografica);
		zonaGeografica.setZonaGeografica(this);

		return zonaGeografica;
	}

	public ZonaGeografica removeZonaGeografica(ZonaGeografica zonaGeografica) {
		getZonaGeograficas().remove(zonaGeografica);
		zonaGeografica.setZonaGeografica(null);

		return zonaGeografica;
	}

}