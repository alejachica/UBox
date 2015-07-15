package co.edu.uniandes.umbrella.ejb;

import javax.ejb.Stateless;

import co.edu.uniandes.umbrella.interfaces.UsuariosEJBLocal;
import co.edu.uniandes.umbrella.interfaces.UsuariosEJBRemote;

/**
 * Session Bean implementation class UsuariosEJB
 */
@Stateless
public class UsuariosEJB implements UsuariosEJBRemote, UsuariosEJBLocal {

    /**
     * Default constructor. 
     */
    public UsuariosEJB() {
        // TODO Auto-generated constructor stub
    }

}
