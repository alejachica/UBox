package co.edu.uniandes.umbrella.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import co.edu.uniandes.umbrella.dto.DatosOperadorDTO;
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


	public Operador consultarOperador(String nit) {

		Query query
		 = entityManager.createNamedQuery("Operador.findByNit", Operador.class).setParameter("nit", nit);
		
		Operador operador = (Operador) query.getSingleResult();
		
		System.out.println(operador.getIdOperador());
		
		return operador;
	}

	public void crearOperador(DatosOperadorDTO datosOperador) {

		Operador operador = new Operador();
		operador.setDireccion(datosOperador.getDireccion());
		operador.setEmail(datosOperador.getEmail());
		operador.setNit(datosOperador.getNit());
		operador.setRazonSocial(datosOperador.getRazonSocial());
		operador.setTelefono(datosOperador.getTelefono());

		entityManager.persist(operador);
	}

}
