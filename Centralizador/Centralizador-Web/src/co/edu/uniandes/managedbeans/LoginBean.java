/**
 * 
 */
package co.edu.uniandes.managedbeans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import co.edu.uniandes.umbrella.interfaces.OperadoresEJBRemote;

/**
 * @author Usuario
 *
 */
@ManagedBean
@ViewScoped
public class LoginBean {

	@EJB
	private OperadoresEJBRemote operadores;

	public LoginBean() {

//		prueba();

	}

	public String prueba() {

		operadores.consultarOperador();
		
		return "";
	}

}
