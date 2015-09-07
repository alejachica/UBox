package co.edu.uniandes.umbrella.entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the lista_valor database table.
 * 
 */
@Entity
@Table(name="lista_valor")
@NamedQuery(name="ListaValor.findAll", query="SELECT l FROM ListaValor l")
public class ListaValor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_lista_valor")
	private int idListaValor;

	private byte activo;

	private String descripcion;

	private String valor;

	//bi-directional many-to-one association to Lista
	@ManyToOne
	@JoinColumn(name="fk_lista")
	private Lista lista;

	public ListaValor() {
	}

	public int getIdListaValor() {
		return this.idListaValor;
	}

	public void setIdListaValor(int idListaValor) {
		this.idListaValor = idListaValor;
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

	public String getValor() {
		return this.valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public Lista getLista() {
		return this.lista;
	}

	public void setLista(Lista lista) {
		this.lista = lista;
	}

}