package co.edu.uniandes.umbrella.ejb;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import co.edu.uniandes.umbrella.dto.CarpetaDTO;
import co.edu.uniandes.umbrella.entidades.Carpeta;
import co.edu.uniandes.umbrella.entidades.Documento;
import co.edu.uniandes.umbrella.interfaces.CarpetaEJBLocal;
import co.edu.uniandes.umbrella.interfaces.CarpetaEJBRemote;

public class CarpetaEJB implements CarpetaEJBRemote,CarpetaEJBLocal{
	
	@PersistenceContext(unitName = "UBox-Persistencia")
	private EntityManager entityManager;
	
	@Override
	public void crearCarpeta(CarpetaDTO carpetaDTO) {
		Carpeta carpeta = new Carpeta();
		
		carpeta.setIdCarpeta(carpetaDTO.getIdCarpeta());
		carpeta.setNombreCarpeta(carpetaDTO.getNombreCarpeta());
		carpeta.setDescripcion(carpetaDTO.getDescripcion());
		
		entityManager.persist(carpeta);			
	}

	@Override
	public Carpeta consultarCarpetao(String id) {
		Query query
		 = entityManager.createNamedQuery("Carpeta.findById", Documento.class).setParameter("idCarpeta", id);
		Carpeta carpeta = (Carpeta) query.getSingleResult();
		System.out.println(carpeta.getIdCarpeta());
		return carpeta;
	}
	

}
