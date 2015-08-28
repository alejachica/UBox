package co.edu.uniandes.umbrella.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import co.edu.uniandes.umbrella.entidades.Operador;
import co.edu.uniandes.umbrella.interfaces.OperadoresEJBLocal;
import co.edu.uniandes.umbrella.interfaces.OperadoresEJBRemote;

/**
 * Session Bean implementation class OperadoresEJB
 */
@Stateless
public class OperadoresEJB implements OperadoresEJBRemote, OperadoresEJBLocal {

	@PersistenceContext(unitName = "Centralizador-Persistencia")
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public OperadoresEJB() {
		// TODO Auto-generated constructor stub
	}

	public Operador consultarOperador(String nit) {

		Query query
		 = entityManager.createNamedQuery("Operador.findByNit", Operador.class).setParameter("nit", nit);
		
		Operador operador = (Operador) query.getSingleResult();
		
		System.out.println(operador.getIdOperador());
		
		return operador;
	}

	public void crearOperador() {

		Operador operador = new Operador();
		operador.setDireccion("Dir op 2");
		operador.setEmail("operador2@uniandes.edu.co");
		operador.setNit("nit 2");
		operador.setRazonSocial("Operador 2");
		operador.setTelefono("3333333");

		entityManager.persist(operador);
	}

}
