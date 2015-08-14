package co.edu.uniandes.umbrella.ejb;

import java.math.BigDecimal;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import co.edu.uniandes.umbrella.entidades.Operador;
import co.edu.uniandes.umbrella.interfaces.OperadoresEJBLocal;
import co.edu.uniandes.umbrella.interfaces.OperadoresEJBRemote;

/**
 * Session Bean implementation class OperadoresEJB
 */
@Stateless
public class OperadoresEJB implements OperadoresEJBRemote, OperadoresEJBLocal {
	
	@PersistenceContext(unitName="Centralizador-Persistencia")
	private EntityManager entityManager;

    /**
     * Default constructor. 
     */
    public OperadoresEJB() {
        // TODO Auto-generated constructor stub
    }
    
    public void consultarOperador(){
    	
    	Operador operador = new Operador();
		operador.setIdOperador(3L);
		operador.setDireccion("Dir op 2");
		operador.setEmail("operador2@uniandes.edu.co");
		operador.setNit("nit 2");
		operador.setRazonSocial("Operador 2");
		operador.setTelefono(BigDecimal.valueOf(3333333));
		
		entityManager.persist(operador);
    }

}
