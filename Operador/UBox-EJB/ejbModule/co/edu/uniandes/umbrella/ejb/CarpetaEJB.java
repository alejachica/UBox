package co.edu.uniandes.umbrella.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
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
	public Carpeta crearCarpeta(CarpetaDTO carpetaDTO) {
		Carpeta carpeta = new Carpeta();
		
		carpeta.setIdCarpeta(carpetaDTO.getIdCarpeta());
		carpeta.setNombreCarpeta(carpetaDTO.getNombreCarpeta());
		carpeta.setDescripcion(carpetaDTO.getDescripcion());
		
		entityManager.persist(carpeta);
		return carpeta;
	}
	
	/**
     * Metodo para crear una carpeta y persistirla en BD
     * @param carpetaDTO
     * @param idUsuario
     */
    public Carpeta crearCarpeta(CarpetaDTO carpetaDTO, int idUsuario)throws Exception {
    	try{
	        Carpeta carpeta = new Carpeta();
	        carpeta.setNombreCarpeta(carpetaDTO.getNombreCarpeta());
	        carpeta.setDescripcion(carpetaDTO.getDescripcion());
	        Query query = entityManager.createNamedQuery("Usuario.findById", Usuario.class).setParameter("idUsuario", idUsuario);
	        Usuario usuarioEncontrado = (Usuario) query.getSingleResult();
	        carpeta.setUsuario(usuarioEncontrado);
	        if(carpetaDTO.getCarpetaPadre() != -1){
		        Query query2 = entityManager.createNamedQuery("Carpeta.findByID", Carpeta.class).setParameter("idCarpeta", carpetaDTO.getCarpetaPadre());
		        Carpeta carpetaEncontrada = (Carpeta) query2.getSingleResult();
		        List<Carpeta> carpetaPadre = new ArrayList<Carpeta>();
		        carpeta.setCarpetas(carpetaPadre);
		        carpeta.addCarpeta(carpetaEncontrada);
	        }
	        entityManager.persist(carpeta);
	        return carpeta;
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
				CarpetaDTO carpetaDTO = new CarpetaDTO(lista.getIdCarpeta(),lista.getDescripcion(), lista.getNombreCarpeta());
				if(lista.getCarpeta()!=null)
					carpetaDTO.setCarpetaPadre(lista.getCarpeta().getIdCarpeta());
				listaCarpetaDTO.add(carpetaDTO);
			}
			return listaCarpetaDTO;
		}
		catch(Exception e){
			throw new Exception("Fallo eliminado la carpeta");
		}
	}
	
	/***
	 * Retorna el listado de carpetas raiz de un usuario
	 * @param idUsuario
	 * @return
	 * @throws Exception
	 */
	public List<Carpeta> obtenerCarpetasRaizXUsuario(int idUsuario) {
		try{
			Query query = entityManager.createNamedQuery("Carpeta.findByUserIDAndRootFolder", Carpeta.class).setParameter("idUsuario", idUsuario);
			List<Carpeta> resultList = (List<Carpeta>)query.getResultList();
			
			return  resultList;
		}
		catch(NoResultException e){
			return new ArrayList<Carpeta>();
		}
	}
	
	/***
	 * Retorna la carpeta raiz de un usuario, sino tiene la crea
	 * @param idUsuario
	 * @return
	 */
	
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public Carpeta obtenerCarpetaRaizPorUsuario(int idUsuario)
	{
		List<Carpeta> carpetasRaiz =  (List<Carpeta>) obtenerCarpetasRaizXUsuario(idUsuario);
		
		if(carpetasRaiz.size() > 0)
			return carpetasRaiz.get(0);
		else
		{
			CarpetaDTO carpetaDTO = new CarpetaDTO();
			carpetaDTO.setDescripcion("Carpeta por defecto");
			carpetaDTO.setNombreCarpeta("root");
			try {
				return crearCarpeta(carpetaDTO, idUsuario);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		}
	}

}
