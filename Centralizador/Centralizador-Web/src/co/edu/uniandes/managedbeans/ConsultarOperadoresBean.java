package co.edu.uniandes.managedbeans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import co.edu.uniandes.umbrella.interfaces.OperadoresEJBRemote;

@ManagedBean
@ViewScoped
public class ConsultarOperadoresBean {
	
	@EJB
	private OperadoresEJBRemote operadores;
	
	private String nit;
	
	public String consultarOperador() {

		operadores.consultarOperador(nit);
		
		return "";
	}

	public String getNit() {
		return nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}

}
