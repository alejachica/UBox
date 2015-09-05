package co.edu.uniandes.umbrella.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the plan database table.
 * 
 */
@Entity
@NamedQuery(name="Plan.findAll", query="SELECT p FROM Plan p")
public class Plan implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_plan")
	private int idPlan;

	private byte activo;

	@Lob
	private String características;

	@Column(name="id_tipo_plan")
	private BigDecimal idTipoPlan;

	private String nombre;

	//bi-directional many-to-one association to Contrato
	@OneToMany(mappedBy="plan")
	private List<Contrato> contratos;

	public Plan() {
	}

	public int getIdPlan() {
		return this.idPlan;
	}

	public void setIdPlan(int idPlan) {
		this.idPlan = idPlan;
	}

	public byte getActivo() {
		return this.activo;
	}

	public void setActivo(byte activo) {
		this.activo = activo;
	}

	public String getCaracterísticas() {
		return this.características;
	}

	public void setCaracterísticas(String características) {
		this.características = características;
	}

	public BigDecimal getIdTipoPlan() {
		return this.idTipoPlan;
	}

	public void setIdTipoPlan(BigDecimal idTipoPlan) {
		this.idTipoPlan = idTipoPlan;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Contrato> getContratos() {
		return this.contratos;
	}

	public void setContratos(List<Contrato> contratos) {
		this.contratos = contratos;
	}

	public Contrato addContrato(Contrato contrato) {
		getContratos().add(contrato);
		contrato.setPlan(this);

		return contrato;
	}

	public Contrato removeContrato(Contrato contrato) {
		getContratos().remove(contrato);
		contrato.setPlan(null);

		return contrato;
	}

}
