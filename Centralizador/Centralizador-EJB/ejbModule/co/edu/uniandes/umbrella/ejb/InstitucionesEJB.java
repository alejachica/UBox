package co.edu.uniandes.umbrella.ejb;

import javax.ejb.Stateless;

import co.edu.uniandes.umbrella.interfaces.InstitucionesEJBLocal;
import co.edu.uniandes.umbrella.interfaces.InstitucionesEJBRemote;

/**
 * Session Bean implementation class InstitucionesEJB
 */
@Stateless
public class InstitucionesEJB implements InstitucionesEJBRemote, InstitucionesEJBLocal {

    /**
     * Default constructor. 
     */
    public InstitucionesEJB() {
        // TODO Auto-generated constructor stub
    }

}
