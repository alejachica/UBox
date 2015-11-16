package co.edu.uniandes.managedbeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import co.edu.uniandes.umbrella.entidades.ZonaGeografica;
import co.edu.uniandes.umbrella.interfaces.ZonaGeograficaEJBLocal;
import co.edu.uniandes.umbrella.interfaces.ZonaGeograficaEJBRemote;

@ManagedBean
public class PruebaBean {
	
	@EJB
	private ZonaGeograficaEJBRemote zonaGeograficaEJB;
	
	private ZonaGeografica prueba;
	private String tipoIdentificacion = "";
	private String departamentoExpedicionDoc = "";
	private String ciudadExpedicionDoc = "";
	private List<ZonaGeografica> departamentos;
	public List<ZonaGeografica> ciudadesExpDocumento;
	
	public PruebaBean(){		
		
		this.departamentos = new ArrayList<ZonaGeografica>();
		this.ciudadesExpDocumento = new ArrayList<ZonaGeografica>();
		//this.cargarDatos();
	}
	
	@PostConstruct
	public void init(){
	
		cargarDatos();
	}

	public ZonaGeografica getPrueba(){
		prueba = zonaGeograficaEJB.getZonasGeograficas().get(0);
		return prueba;
	}
	
	public String getCiudadExpedicionDoc() {
		return ciudadExpedicionDoc;
	}

	public void setCiudadExpedicionDoc(String ciudadExpedicionDoc) {
		this.ciudadExpedicionDoc = ciudadExpedicionDoc;
	}
	public String getDepartamentoExpedicionDoc() {
		return departamentoExpedicionDoc;
	}

	public void setDepartamentoExpedicionDoc(String departamentoExpedicionDoc) {
		this.departamentoExpedicionDoc = departamentoExpedicionDoc;
	}
	public List<ZonaGeografica> getDepartamentos() {
		return departamentos;
	}

	public void setDepartamentos(List<ZonaGeografica> departamentos) {
		this.departamentos = departamentos;
	}
	public List<ZonaGeografica> getCiudadesExpDocumento() {
		return ciudadesExpDocumento;
	}

	public void setCiudadesExpDocumento(List<ZonaGeografica> ciudadesExpDocumento) {
		this.ciudadesExpDocumento = ciudadesExpDocumento;
	}
	
	
public void cargarDatos(){
		
		try {
			this.departamentos = new ArrayList<ZonaGeografica>();
			departamentos = zonaGeograficaEJB.getZonasGeograficas();
			//List<ZonaGeografica> lista = zonaGeograficaEJB.getZonasGeograficas();
			//ZonaGeografica ciudad = zonaGeograficaEJB.buscarCiudad(1);
			//System.out.println("cacacacacacacacac" + zonaGeograficaEJB.buscarCiudad(1).getNombre() );
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		 

	}
	
}
