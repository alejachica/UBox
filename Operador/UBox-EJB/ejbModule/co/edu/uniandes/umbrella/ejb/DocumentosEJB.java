package co.edu.uniandes.umbrella.ejb;

import javax.ejb.Stateless;

import co.edu.uniandes.umbrella.interfaces.DocumentosEJBLocal;
import co.edu.uniandes.umbrella.interfaces.DocumentosEJBRemote;

/**
 * Session Bean implementation class DocumentosEJB
 */
@Stateless
public class DocumentosEJB implements DocumentosEJBRemote, DocumentosEJBLocal {

    /**
     * Default constructor. 
     */
    public DocumentosEJB() {
        // TODO Auto-generated constructor stub
    }

}
