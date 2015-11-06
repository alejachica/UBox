package co.edu.uniandes.umbrella.ejb;

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
	
	@PersistenceContext(unitName = "UBox-Persistencia")
	private EntityManager entityManager;
	
	public List<ZonaGeografica> getZonasGeograficas(){
		Query query = entityManager.createNamedQuery("ZonaGeografica.findAll",ZonaGeografica.class);
		List<ZonaGeografica> respuesta = null;
		
		try {
			respuesta = (List<ZonaGeografica>) query.getSingleResult();
		} catch (NoResultException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return respuesta;
		
	}
	public ZonaGeografica buscarZonaGeograficaPorDepartamento(int idZonaGeografica){
		Query query = entityManager.createNamedQuery("ZonaGeografica.findByDepartamento",
				ZonaGeografica.class)
				.setParameter("id_padre", idZonaGeografica);
		
		ZonaGeografica respuesta = null;
		
		try {
			respuesta = (ZonaGeografica) query.getSingleResult();
		} catch (NoResultException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return respuesta;

	}
	public ZonaGeografica buscarCiudad(int idZonaGeografica){
		Query query = entityManager.createNamedQuery("ZonaGeografica.findCiudad",
				ZonaGeografica.class)
				.setParameter("id_zona_geografica", idZonaGeografica);
		
		ZonaGeografica respuesta = null;
		
		try {
			respuesta = (ZonaGeografica) query.getSingleResult();
		} catch (NoResultException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return respuesta;
	}
}
