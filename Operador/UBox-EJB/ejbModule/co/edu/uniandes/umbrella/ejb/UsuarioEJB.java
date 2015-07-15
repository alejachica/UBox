package co.edu.uniandes.umbrella.ejb;

import javax.ejb.Stateless;

import co.edu.uniandes.umbrella.interfaces.UsuarioEJBLocal;
import co.edu.uniandes.umbrella.interfaces.UsuarioEJBRemote;

/**
 * Session Bean implementation class UsuarioEJB
 */
@Stateless
public class UsuarioEJB implements UsuarioEJBRemote, UsuarioEJBLocal {

    /**
     * Default constructor. 
     */
    public UsuarioEJB() {
        // TODO Auto-generated constructor stub
    }

}
