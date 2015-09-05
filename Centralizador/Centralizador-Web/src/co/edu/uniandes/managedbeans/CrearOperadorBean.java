package co.edu.uniandes.managedbeans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import co.edu.uniandes.umbrella.interfaces.OperadoresEJBRemote;

@ManagedBean
@ViewScoped
public class CrearOperadorBean {
	
	
	@EJB
	private OperadoresEJBRemote operadores;
	
	
	public String crearOperador() {

		operadores.crearOperador();
		
		return "";
	}

}
