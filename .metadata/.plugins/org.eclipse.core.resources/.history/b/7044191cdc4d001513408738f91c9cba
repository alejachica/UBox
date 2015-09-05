package co.edu.uniandes.umbrella.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the lista database table.
 * 
 */
@Entity
@NamedQuery(name="Lista.findAll", query="SELECT l FROM Lista l")
public class Lista implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_lista")
	private int idLista;

	private byte activo;

	private String descripcion;

	private String nombre;

	//bi-directional many-to-one association to ListaValor
	@OneToMany(mappedBy="lista")
	private List<ListaValor> listaValors;

	public Lista() {
	}

	public int getIdLista() {
		return this.idLista;
	}

	public void setIdLista(int idLista) {
		this.idLista = idLista;
	}

	public byte getActivo() {
		return this.activo;
	}

	public void setActivo(byte activo) {
		this.activo = activo;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<ListaValor> getListaValors() {
		return this.listaValors;
	}

	public void setListaValors(List<ListaValor> listaValors) {
		this.listaValors = listaValors;
	}

	public ListaValor addListaValor(ListaValor listaValor) {
		getListaValors().add(listaValor);
		listaValor.setLista(this);

		return listaValor;
	}

	public ListaValor removeListaValor(ListaValor listaValor) {
		getListaValors().remove(listaValor);
		listaValor.setLista(null);

		return listaValor;
	}

}