package co.edu.uniandes.umbrella.ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import co.edu.uniandes.umbrella.entidades.ListaValor;
import co.edu.uniandes.umbrella.entidades.Usuario;
import co.edu.uniandes.umbrella.interfaces.ListaValorEJBLocal;

/**
 * Session Bean implementation class ListaValorEJB
 */
@Stateless
public class ListaValorEJB implements ListaValorEJBLocal{

	
	@PersistenceContext(unitName = "UBox-Persistencia")
	private EntityManager entityManager;
	
	@Override
	public ListaValor buscarListaValorPorCodigoExterno(int idLista, String codigoExterno) {
		Query query = entityManager.createNamedQuery("ListaValor.findByExternalCode",
				Usuario.class)
				.setParameter("idLista", idLista)
				.setParameter("codigoExterno", codigoExterno);
		
		ListaValor respuesta = null;
		
		try {
			respuesta = (ListaValor) query.getSingleResult();
		} catch (NoResultException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return respuesta;
	}

    

}
