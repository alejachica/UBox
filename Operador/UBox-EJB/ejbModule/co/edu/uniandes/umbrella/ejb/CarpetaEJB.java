package co.edu.uniandes.umbrella.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import co.edu.uniandes.umbrella.dto.CarpetaDTO;
import co.edu.uniandes.umbrella.entidades.Carpeta;
import co.edu.uniandes.umbrella.entidades.Documento;
import co.edu.uniandes.umbrella.entidades.Usuario;
import co.edu.uniandes.umbrella.interfaces.CarpetaEJBLocal;
import co.edu.uniandes.umbrella.interfaces.CarpetaEJBRemote;

@Stateless
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
	
	/**
     * Metodo para crear una carpeta y persistirla en BD
     * @param carpetaDTO
     * @param idUsuario
     */
    public void crearCarpeta(CarpetaDTO carpetaDTO, int idUsuario)throws Exception {
    	try{
	        Carpeta carpeta = new Carpeta();
	        carpeta.setNombreCarpeta(carpetaDTO.getNombreCarpeta());
	        carpeta.setDescripcion(carpetaDTO.getDescripcion());
	        if(carpetaDTO.getCarpetaPadre() != -1){
		        Query query = entityManager.createNamedQuery("Carpeta.findById", Carpeta.class).setParameter("idCarpeta", carpetaDTO.getIdCarpeta());
		        Carpeta carpetaEncontrada = (Carpeta) query.getSingleResult();
		        carpeta.addCarpeta(carpetaEncontrada);
	        }
	        Query query = entityManager.createNamedQuery("Usuario.findById", Usuario.class).setParameter("idUsuario", idUsuario);
	        Usuario usuarioEncontrado = (Usuario) query.getSingleResult();
	        carpeta.setUsuario(usuarioEncontrado);
	        entityManager.persist(carpeta);
    	}
	    catch(Exception e){
	    	throw new Exception("Fallo persistiendo la carpeta");
	    }
    }

	@Override
	public Carpeta consultarCarpetao(String id) {
		Query query
		 = entityManager.createNamedQuery("Carpeta.findById", Documento.class).setParameter("idCarpeta", id);
		Carpeta carpeta = (Carpeta) query.getSingleResult();
		return carpeta;
	}
	
	@Override
	public void eliminarCarpeta(int idCarpeta) throws Exception {
		try{
			Query query = entityManager.createNamedQuery("Carpeta.findByID", Carpeta.class).setParameter("idCarpeta", idCarpeta);
	        Carpeta carpetaEliminar = (Carpeta) query.getSingleResult();
	        entityManager.remove(carpetaEliminar);
		}
		catch(Exception e){
			throw new Exception("Fallo eliminado la carpeta");
		}
	}
	
	public List<CarpetaDTO> carpetasXUsuario(int idUsuario) throws Exception{
		try{
			Query query = entityManager.createNamedQuery("Carpeta.findByUserID", Carpeta.class).setParameter("idUsuario", idUsuario);
			List<Carpeta> listaCarpeta = query.getResultList();
			List<CarpetaDTO> listaCarpetaDTO = new ArrayList<CarpetaDTO>();
			for(Carpeta lista : listaCarpeta){
				listaCarpetaDTO.add(new CarpetaDTO(lista.getIdCarpeta(),lista.getDescripcion(), lista.getNombreCarpeta()));
			}
			return listaCarpetaDTO;
		}
		catch(Exception e){
			throw new Exception("Fallo eliminado la carpeta");
		}
	}

}
