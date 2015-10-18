package co.edu.uniandes.umbrella.ejb;

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

}
