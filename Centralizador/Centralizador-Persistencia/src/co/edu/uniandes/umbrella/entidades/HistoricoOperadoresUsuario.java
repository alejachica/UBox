package co.edu.uniandes.umbrella.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the HISTORICO_OPERADORES_USUARIO database table.
 * 
 */
@Entity
@Table(name="HISTORICO_OPERADORES_USUARIO")
@NamedQuery(name="HistoricoOperadoresUsuario.findAll", query="SELECT h FROM HistoricoOperadoresUsuario h")
public class HistoricoOperadoresUsuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	@Id
	@Column(name="id_historico")
	private int idHistorico;

	@Column(name="id_tipo_operacion")
	private int idTipoOperacion;

	@Column(name="num_formulario")
	private String numFormulario;

	//bi-directional many-to-one association to Operador
	@ManyToOne
	@JoinColumn(name="id_operador_destino")
	private Operador operador1;

	//bi-directional many-to-one association to Operador
	@ManyToOne
	@JoinColumn(name="id_operador_origen")
	private Operador operador2;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuario usuario;

	public HistoricoOperadoresUsuario() {
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getIdHistorico() {
		return this.idHistorico;
	}

	public void setIdHistorico(int idHistorico) {
		this.idHistorico = idHistorico;
	}

	public int getIdTipoOperacion() {
		return this.idTipoOperacion;
	}

	public void setIdTipoOperacion(int idTipoOperacion) {
		this.idTipoOperacion = idTipoOperacion;
	}

	public String getNumFormulario() {
		return this.numFormulario;
	}

	public void setNumFormulario(String numFormulario) {
		this.numFormulario = numFormulario;
	}

	public Operador getOperador1() {
		return this.operador1;
	}

	public void setOperador1(Operador operador1) {
		this.operador1 = operador1;
	}

	public Operador getOperador2() {
		return this.operador2;
	}

	public void setOperador2(Operador operador2) {
		this.operador2 = operador2;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}