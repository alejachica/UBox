package co.edu.uniandes.umbrella.ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import co.edu.uniandes.umbrella.entidades.FormaComparticion;
import co.edu.uniandes.umbrella.interfaces.FormaComparticionEJBLocal;

/**
 * Session Bean implementation class FormaComparticionEJB
 */
@Stateless
public class FormaComparticionEJB implements FormaComparticionEJBLocal {

	@PersistenceContext(unitName = "UBox-Persistencia")
	private EntityManager entityManager;
	
    /**
     * Default constructor. 
     */
    public FormaComparticionEJB() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public FormaComparticion obtenerFormaComparticionPorId(int id) {
		Query query = entityManager.createNamedQuery("FormaComparticion.findById", FormaComparticion.class)
		.setParameter("id", id);
		try {
			return (FormaComparticion)query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
		
	}

	@Override
	public List<FormaComparticion> obtenerFormasComparticion() {
		Query query = entityManager.createNamedQuery("FormaComparticion.findAll", FormaComparticion.class);
		try{
			return query.getResultList();
		}
		catch(NoResultException e){
			return null;	
		}
	}

}
