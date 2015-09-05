package co.edu.uniandes.managedbeans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import co.edu.uniandes.umbrella.dto.DatosOperadorDTO;
import co.edu.uniandes.umbrella.interfaces.OperadoresEJBRemote;

@ManagedBean
@ViewScoped
public class CrearOperadorBean {
	
	private DatosOperadorDTO datosOperador;
	
	
	@EJB
	private OperadoresEJBRemote operadores;
	
	
	public String crearOperador() {
		
		datosOperador = new DatosOperadorDTO(); 
		datosOperador.setDireccion("Dir op 2");
		datosOperador.setEmail("operador2@uniandes.edu.co");
		datosOperador.setNit("nit 2");
		datosOperador.setRazonSocial("Operador 2");
		datosOperador.setTelefono("3333333");

		operadores.crearOperador(datosOperador);
		
		return "";
	}

}
