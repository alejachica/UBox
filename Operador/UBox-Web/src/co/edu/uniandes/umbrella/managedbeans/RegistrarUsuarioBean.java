package co.edu.uniandes.umbrella.managedbeans;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;

import co.edu.uniandes.umbrella.dto.UsuarioDTO;
import co.edu.uniandes.umbrella.entidades.ListaValor;
import co.edu.uniandes.umbrella.entidades.ZonaGeografica;
import co.edu.uniandes.umbrella.interfaces.ListaValorEJBLocal;
import co.edu.uniandes.umbrella.interfaces.UsuarioEJBRemote;
import co.edu.uniandes.umbrella.interfaces.ZonaGeograficaEJBRemote;
import co.edu.uniandes.umbrella.utils.ResultadoOperacion;
import umbrella.ubox.seguridad.FuncionesStormpath;

@ManagedBean
@SessionScoped
public class RegistrarUsuarioBean {

	public RegistrarUsuarioBean() {

		this.usuario = new UsuarioDTO();
		this.tiposDocumento = new ArrayList<ListaValor>();
		this.departamentos = new ArrayList<ZonaGeografica>();
		this.ciudadesExpDocumento = new ArrayList<ZonaGeografica>();
		
	}
	
	@PostConstruct
	public void init(){
	
		cargarDatos();
	}

	@EJB
	private UsuarioEJBRemote usuarioEJB;
	
	@EJB
	private ZonaGeograficaEJBRemote zonaGeograficaEJB;
	
	@EJB
	private ListaValorEJBLocal listaValorEJB;
	

	private UsuarioDTO usuario;
	
	private List<ListaValor> tiposDocumento;
	
	private List<ZonaGeografica> departamentos;
	
	public List<ZonaGeografica> ciudadesExpDocumento;
	
	public List<ZonaGeografica> ciudadesNacimiento;
	
	public List<ZonaGeografica> ciudadesResidencia;
	
	public List<ZonaGeografica> ciudadesCorrespondencia;
	
	public List<ZonaGeografica> ciudadesSitioLaboral;
	
	private String tipoIdentificacion = "";
	private String departamentoExpedicionDoc = "";
	private String ciudadExpedicionDoc = "";
	
	

	public UsuarioDTO getUsuario() {
		return usuario;
	}
	
	public void setUsuario(UsuarioDTO usuario)
	{
		this.usuario = usuario;
	}

	private String error;

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
	
	

	public List<ListaValor> getTiposDocumento() {
		return tiposDocumento;
	}

	public void setTiposDocumento(List<ListaValor> tiposDocumento) {
		this.tiposDocumento = tiposDocumento;
	}

	public String getTipoIdentificacion() {
		return tipoIdentificacion;
	}

	public void setTipoIdentificacion(String tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}		

	public String getDepartamentoExpedicionDoc() {
		return departamentoExpedicionDoc;
	}

	public void setDepartamentoExpedicionDoc(String departamentoExpedicionDoc) {
		this.departamentoExpedicionDoc = departamentoExpedicionDoc;
	}

	public String getCiudadExpedicionDoc() {
		return ciudadExpedicionDoc;
	}

	public void setCiudadExpedicionDoc(String ciudadExpedicionDoc) {
		this.ciudadExpedicionDoc = ciudadExpedicionDoc;
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

	
	public void cambioDepto(){
		System.out.println("ID: " );
	}
	
	public String registrarUsuario() {

		// usuarioDto = new UsuarioDTO();
		DateFormat dateFormat = new SimpleDateFormat("ss");
		Calendar cal = Calendar.getInstance();
		String segundosPrueba = dateFormat.format(cal.getTime()); //2014/08/06 16:00:22
		

		
		this.usuario.setActivo(true);
		this.usuario.setCorreo("usuario"+segundosPrueba+"@email.com");
		this.usuario.setIdentificacion("1013587449"+segundosPrueba);
		this.usuario.setLogin("ee.prado"+segundosPrueba);
		this.usuario.setPassword("Temporal1");
		this.usuario.setPrimerNombre("Erica");
		this.usuario.setSegundoNombre("Nombre1");
		this.usuario.setPrimerApellido("Apellido1");
		this.usuario.setSegundoApellido("Apellido1");

		//Realiza el registro en stormpath 
		ResultadoOperacion respuesta = new FuncionesStormpath().crearUsuario(this.usuario.getPrimerNombre(),
				this.usuario.getIdentificacion(), this.usuario.getCorreo(), this.usuario.getPassword());
		

		//Si quedó registrado, actualiza el id de strmpath y guarda el usuario
		if (respuesta.isOperacionExitosa()) {
			this.usuario.setIdStormpath(respuesta.getResultadoOperacion());
			usuarioEJB.crearUsuario(this.usuario);
			return "documentosPersonales.xhtml";
		} else {
			this.error = respuesta.getResultadoOperacion();
			return "";
		}
	}
	
	public void cargarDatos(){
		
		try {
			
			tiposDocumento = listaValorEJB.buscarLista(7);
			
			
			
			
			
			ZonaGeografica dep1 = new ZonaGeografica();
			dep1.setIdZonaGeografica(1);
			dep1.setNombre("Antioquia");
			
			ZonaGeografica dep2 = new ZonaGeografica();
			dep2.setIdZonaGeografica(2);
			dep2.setNombre("Cundinamarca");
			
			departamentos.add(dep1);
			departamentos.add(dep2);
			
			
			ZonaGeografica ciu1 = new ZonaGeografica();
			ciu1.setIdZonaGeografica(3);
			ciu1.setNombre("Medellin");
			
			ZonaGeografica ciu2 = new ZonaGeografica();
			ciu2.setIdZonaGeografica(2);
			ciu2.setNombre("Bogota");
			
			ciudadesExpDocumento.add(ciu1);
			ciudadesExpDocumento.add(ciu2);
			
			
			
			
			
			
//			ZonaGeografica prueba2 = zonaGeograficaEJB.buscarZonaGeograficaPorDepartamento(5);
			
	//		List<ZonaGeografica> lista = zonaGeograficaEJB.getZonasGeograficas();
			
	//		ZonaGeografica ciudad = zonaGeograficaEJB.buscarCiudad(1);
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		 

	}

	 public void onCountryChange(ValueChangeEvent event) {
	       System.out.println("prueba");
	    }
	
}
