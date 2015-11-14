package co.edu.uniandes.umbrella.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import co.edu.uniandes.umbrella.entidades.ZonaGeografica;
import co.edu.uniandes.umbrella.interfaces.ZonaGeograficaEJBLocal;
import co.edu.uniandes.umbrella.interfaces.ZonaGeograficaEJBRemote;

@Stateless
public class ZonaGeograficaEJB implements ZonaGeograficaEJBLocal, ZonaGeograficaEJBRemote{
	/**
	 * Entity manager
	 */
	@PersistenceContext(unitName = "Centralizador-Persistencia")
	private EntityManager entityManager;
	
	@Override
	public List<ZonaGeografica> getZonasGeograficas() {
		Query query = entityManager.createNamedQuery("ZonaGeografica.findAll",ZonaGeografica.class);
		List<ZonaGeografica> respuesta = new ArrayList<ZonaGeografica>();
		respuesta = (List<ZonaGeografica>) query.getResultList();
		return respuesta;
	}

	@Override
	public List<ZonaGeografica> buscarZonaGeograficaPorDepartamento(int idZonaGeografica) {

		Query query = entityManager.createNamedQuery("ZonaGeografica.findCiudadesByDepartamentos",
				ZonaGeografica.class)
				.setParameter("id_padre", idZonaGeografica);
				
		
		List<ZonaGeografica> respuesta = new ArrayList<ZonaGeografica>();
		
		try {
			respuesta = (List<ZonaGeografica>) query.getResultList();
		} catch (NoResultException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return respuesta;
		
	}
	
	
	@Override
	public ZonaGeografica buscarCiudad(int idZonaGeografica) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ZonaGeografica> buscarTodosDepartamento() {
		Query query = entityManager.createNamedQuery("ZonaGeografica.findAllDepartamentos",
				ZonaGeografica.class);
		
		List<ZonaGeografica> respuesta = new ArrayList<ZonaGeografica>();
		
		try {
			respuesta = (List<ZonaGeografica>) query.getResultList();
		} catch (NoResultException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return respuesta;
	}
}
