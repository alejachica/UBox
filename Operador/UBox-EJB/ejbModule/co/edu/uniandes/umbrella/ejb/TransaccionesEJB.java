package co.edu.uniandes.umbrella.ejb;

import javax.ejb.Stateless;

import co.edu.uniandes.umbrella.interfaces.TransaccionesEJBLocal;
import co.edu.uniandes.umbrella.interfaces.TransaccionesEJBRemote;

/**
 * Session Bean implementation class TransaccionesEJB
 */
@Stateless
public class TransaccionesEJB implements TransaccionesEJBRemote, TransaccionesEJBLocal {

    /**
     * Default constructor. 
     */
    public TransaccionesEJB() {
        // TODO Auto-generated constructor stub
    }

}
