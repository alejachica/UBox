package co.edu.uniandes.umbrella.ejb;

import javax.ejb.Stateless;

import co.edu.uniandes.umbrella.interfaces.OperadoresEJBLocal;
import co.edu.uniandes.umbrella.interfaces.OperadoresEJBRemote;

/**
 * Session Bean implementation class OperadoresEJB
 */
@Stateless
public class OperadoresEJB implements OperadoresEJBRemote, OperadoresEJBLocal {

    /**
     * Default constructor. 
     */
    public OperadoresEJB() {
        // TODO Auto-generated constructor stub
    }

}
