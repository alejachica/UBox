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

	//public static final int IDLISTA_TIPODOCUMENTO = 1;
	//public static final int IDLISTA_TIPOCARPETA = 2;
	//public static final int IDLISTA_PERMISOSDOCUMENTO = 3;
	//public static final int IDLISTA_PERMISOSCARPETA = 4;
	//public static final int IDLISTA_TIPOPQR = 5;
	//public static final int IDLISTA_TIPOTRAMITE = 6;
	
	@PersistenceContext(unitName = "UBox-Persistencia")
	private EntityManager entityManager;
	
	@Override
	public ListaValor buscarLista(int idLista) {
		Query query = entityManager.createNamedQuery("ListaValor.findByIdLista",
				ListaValor.class)
				.setParameter("idLista", idLista);
		
		ListaValor respuesta = null;
		
		try {
			respuesta = (ListaValor) query.getSingleResult();
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

    

}
