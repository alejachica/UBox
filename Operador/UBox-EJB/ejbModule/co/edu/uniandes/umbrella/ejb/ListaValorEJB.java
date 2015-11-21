package co.edu.uniandes.umbrella.ejb;


import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import co.edu.uniandes.umbrella.entidades.ListaValor;
import co.edu.uniandes.umbrella.interfaces.ListaValorEJBLocal;
import co.edu.uniandes.umbrella.interfaces.ListaValorEJBRemote;

/**
 * Session Bean implementation class ListaValorEJB
 */
@Stateless
public class ListaValorEJB implements ListaValorEJBLocal, ListaValorEJBRemote{

	//public static final int IDLISTA_TIPODOCUMENTO = 1;
	//public static final int IDLISTA_TIPOCARPETA = 2;
	//public static final int IDLISTA_PERMISOSDOCUMENTO = 3;
	//public static final int IDLISTA_PERMISOSCARPETA = 4;
	//public static final int IDLISTA_TIPOPQR = 5;
	//public static final int IDLISTA_TIPOTRAMITE = 6;
	
	@PersistenceContext(unitName = "UBox-Persistencia")
	private EntityManager entityManager;
	
	@Override
	public List<ListaValor> buscarLista(int idLista) {
		Query query = entityManager.createNamedQuery("ListaValor.findByIdLista",
				ListaValor.class)
				.setParameter("idLista", idLista);
		
		List<ListaValor> respuesta = new ArrayList<ListaValor>();
		
		try {
			respuesta = (List<ListaValor>) query.getResultList();
		} catch (NoResultException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return respuesta;
	}
	
	@Override
	public ListaValor buscarListaValorPorCodigoExterno(int idLista, String codigoExterno) {
		Query query = entityManager.createNamedQuery("ListaValor.findByExternalCode",
				ListaValor.class)
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
	
	public ListaValor buscarListaValor(int idListaValor)
	{
		Query query = entityManager.createNamedQuery("ListaValor.findById",
				ListaValor.class)
				.setParameter("idListaValor", idListaValor);
		
		try {
			return (ListaValor)query.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}

    

}
