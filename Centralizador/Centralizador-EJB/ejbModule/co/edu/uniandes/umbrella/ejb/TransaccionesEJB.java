package co.edu.uniandes.umbrella.ejb;

import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import co.edu.uniandes.umbrella.dto.DatosOperadorDTO;
import co.edu.uniandes.umbrella.dto.ServiciosOperadorUsuarioDTO;
import co.edu.uniandes.umbrella.entidades.ServiciosOperador;
import co.edu.uniandes.umbrella.interfaces.TransaccionesEJBLocal;
import co.edu.uniandes.umbrella.interfaces.TransaccionesEJBRemote;

/**
 * Session Bean implementation class InstitucionesEJB
 */
@DeclareRoles("admin")
@Stateless
@WebService
public class TransaccionesEJB implements TransaccionesEJBRemote, TransaccionesEJBLocal {
	
	/**
	 * Entity manager
	 */
	@PersistenceContext(unitName = "Centralizador-Persistencia")
	private EntityManager entityManager;

	/**
	 * Servicio que permite consultar los datos del operador de un usuario al que se le compartira un documento
	 * @param datos Filtro para la consulta
	 * @return DatosOperadorDTO Datos del operador para compartir documentos
	 */
	@RolesAllowed("admin")
	public DatosOperadorDTO consultarOperadorUsuarioParaCompartir(
			ServiciosOperadorUsuarioDTO datos) {
		
		Query query = entityManager.createNamedQuery("ServiciosOperador.urlParaCompartirDocumentos",
				ServiciosOperador.class).setParameter("idOperador", datos.getIdOperador());
		
		ServiciosOperador resultado = (ServiciosOperador) query.getSingleResult();

		DatosOperadorDTO datosOperador = new DatosOperadorDTO();
		datosOperador.setIdOperador(resultado.getIdOperador());
		datosOperador.setUrlServicio(resultado.getUrl());
		
		return datosOperador;
	}
	
	/**
	 * Servicio que permite realizar el traslado de un usuario a un nuevo operador
	 * @param tipoDocUsuario Tipo de documento del usuario	
	 * @param nroDocUsuario Numero de documento del usuario
	 * @param idNuevoOperador Id del nuevo operador al que se trasladara el usuario
	 * @return true si el traslado fue exitoso, false en caso contrario.
	 */
	public boolean trasladarUsuarioDeOperador(String tipoDocUsuario,
			String nroDocUsuario, long idNuevoOperador) {

		return false;
	}

}
