package co.edu.uniandes.umbrella.ejb;

import javax.ejb.Stateless;

import co.edu.uniandes.umbrella.interfaces.FirmaDigitalEJBLocal;
import co.edu.uniandes.umbrella.interfaces.FirmaDigitalEJBRemote;

/**
 * Session Bean implementation class FirmaDigitalEJB
 */
@Stateless
public class FirmaDigitalEJB implements FirmaDigitalEJBRemote, FirmaDigitalEJBLocal {

    /**
     * Default constructor. 
     */
    public FirmaDigitalEJB() {
        // TODO Auto-generated constructor stub
    }

}
