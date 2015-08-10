package co.edu.uniandes.umbrella.ejb;

import javax.ejb.Stateless;

import co.edu.uniandes.umbrella.interfaces.TransaccionesUboxEJBLocal;
import co.edu.uniandes.umbrella.interfaces.TransaccionesUboxEJBRemote;

/**
 * Session Bean implementation class TransaccionesEJB
 */
@Stateless
public class TransaccionesUboxEJB implements TransaccionesUboxEJBRemote, TransaccionesUboxEJBLocal {

    /**
     * Default constructor. 
     */
    public TransaccionesUboxEJB() {
        // TODO Auto-generated constructor stub
    }

}
