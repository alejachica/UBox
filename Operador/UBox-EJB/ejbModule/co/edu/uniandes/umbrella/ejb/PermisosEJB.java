package co.edu.uniandes.umbrella.ejb;

import javax.ejb.Stateless;

import co.edu.uniandes.umbrella.interfaces.PermisosEJBLocal;
import co.edu.uniandes.umbrella.interfaces.PermisosEJBRemote;

/**
 * Session Bean implementation class PermisosEJB
 */
@Stateless
public class PermisosEJB implements PermisosEJBRemote, PermisosEJBLocal {

    /**
     * Default constructor. 
     */
    public PermisosEJB() {
        // TODO Auto-generated constructor stub
    }

}
