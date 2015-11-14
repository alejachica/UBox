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
@NamedQueries({
	@NamedQuery(name="ZonaGeografica.findAll", query="SELECT z FROM ZonaGeografica z"),
	@NamedQuery(name="ZonaGeografica.findCiudadesByDepartamentos", query="SELECT z FROM ZonaGeografica z where z.zonaGeografica.idZonaGeografica" + " = :id_padre "),
	@NamedQuery(name="ZonaGeografica.findAllDepartamentos", query="SELECT z FROM ZonaGeografica z where z.zonaGeografica.idZonaGeografica is null")
})
public class ZonaGeografica implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_zona_geografica")
	private int idZonaGeografica;

	private String nombre;

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