package co.edu.uniandes.umbrella.managedbeans;

import java.rmi.RemoteException;
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

import org.netbeans.j2ee.wsdl.CrearUsuario.UserProcess.newWSDL.CrearUsuarioWsdlPortProxy;

import co.edu.uniandes.umbrella.dto.UsuarioDTO;
import co.edu.uniandes.umbrella.ejb.DatosBasicosUsuarioDTO;
import co.edu.uniandes.umbrella.entidades.ListaValor;
import co.edu.uniandes.umbrella.entidades.ListaValoresEnum;
import co.edu.uniandes.umbrella.entidades.ZonaGeografica;
import co.edu.uniandes.umbrella.interfaces.ListaValorEJBRemote;
import co.edu.uniandes.umbrella.interfaces.UsuarioEJBRemote;
import co.edu.uniandes.umbrella.interfaces.ZonaGeograficaEJBRemote;
import co.edu.uniandes.umbrella.utils.ResultadoOperacion;
import umbrella.ubox.seguridad.FuncionesStormpath;

@ManagedBean
@SessionScoped
public class RegistrarUsuarioBean {


	public static final String ID_CBO_DPTO_EXP = "dptoExp";
	public static final String ID_CBO_DPTO_NAC = "dptoNac";
	public static final String ID_CBO_DPTO_RES = "dptoRes";
	public static final String ID_CBO_DPTO_COR = "dptoCor";
	public static final String ID_CBO_DPTO_LAB = "dptoLab";
	
	
	@EJB
	private UsuarioEJBRemote usuarioEJB;
	
	@EJB
	private ZonaGeograficaEJBRemote zonaGeograficaEJB;
	
	@EJB
	private ListaValorEJBRemote listaValorEJB;
	

	private UsuarioDTO usuario;
	
	private DatosBasicosUsuarioDTO usuarioCentralizador;
	
	private String error;
	
	private List<ListaValor> tiposDocumento;
	
	private List<ListaValor> nacionalidades;
	
	private List<ZonaGeografica> departamentos;
	
	public List<ZonaGeografica> ciudadesExpDocumento;
	
	public List<ZonaGeografica> ciudadesNacimiento;
	
	public List<ZonaGeografica> ciudadesResidencia;
	
	public List<ZonaGeografica> ciudadesCorrespondencia;
	
	public List<ZonaGeografica> ciudadesLaboral;
	
	private String fechaExpedicionDoc = "";
	
	private String fechaNacimiento = "";
	
	private String departamentoExpedicionDoc = "";	
	
	private String departamentoNacimiento = "";	
	
	private String departamentoResidencia = "";	
	
	private String departamentoCorrespondencia = "";
		
	private String departamentoLaboral = "";
	
	private String direccionLaboral = "";
	
	
	
	
	public RegistrarUsuarioBean() {

		this.usuario = new UsuarioDTO();
		this.usuarioCentralizador = new DatosBasicosUsuarioDTO();
		this.tiposDocumento = new ArrayList<ListaValor>();
		this.nacionalidades = new ArrayList<ListaValor>();
		this.departamentos = new ArrayList<ZonaGeografica>();
		this.ciudadesExpDocumento = new ArrayList<ZonaGeografica>();
		this.ciudadesNacimiento = new ArrayList<ZonaGeografica>();
		this.ciudadesResidencia = new ArrayList<ZonaGeografica>();
		this.ciudadesLaboral = new ArrayList<ZonaGeografica>();
		this.ciudadesCorrespondencia = new ArrayList<ZonaGeografica>();
		
	}
	
	
	@PostConstruct
	public void init(){			
		cargarDatos();
	}
	
		
	public String registrarUsuario() {

		// usuarioDto = new UsuarioDTO();
		DateFormat dateFormat = new SimpleDateFormat("ss");
		Calendar cal = Calendar.getInstance();
		String segundosPrueba = dateFormat.format(cal.getTime()); //2014/08/06 16:00:22
				
//		this.usuarioCentralizador.setDireccionNotificacion("");
//		this.usuarioCentralizador.setEmailPersonal("");
//		this.usuarioCentralizador.setFechaExpediciionIdentificacion();
		this.usuarioCentralizador.setFechaNacimiento(Calendar.getInstance());
//		this.usuarioCentralizador.setGenero("");
//		this.usuarioCentralizador.setIdDireccionResidencia("");
//		this.usuarioCentralizador.setIdEstadoCivil(1);
//		this.usuarioCentralizador.setIdMunicipioExpedicionIdentificacion(1);
//		this.usuarioCentralizador.setIdMunicipioLaboral(1);
//		this.usuarioCentralizador.setIdMunicipioNacimiento(1);
//		this.usuarioCentralizador.setIdMunicipioNotificacion(1);
//		this.usuarioCentralizador.setIdMunicipioResidencia(1);
//		this.usuarioCentralizador.setIdNacionalidad(1);
		this.usuarioCentralizador.setIdOperador(1);
		this.usuarioCentralizador.setIdOperadorActual(1);
//		this.usuarioCentralizador.setIdTipoIdentificacion("CC");
//		this.usuarioCentralizador.setIdUsuario(1);
//		this.usuarioCentralizador.setNroIdentificacion("1013587555");
//		this.usuarioCentralizador.setPrimerApellido("");
//		this.usuarioCentralizador.setPrimerNombre("");
//		this.usuarioCentralizador.setSegundoApellido("");
//		this.usuarioCentralizador.setSegundoNombre("");
//		this.usuarioCentralizador.setTelefono(1);
		
		
		System.out.println("Antes de crear el proxy");	
		CrearUsuarioWsdlPortProxy proxy = new CrearUsuarioWsdlPortProxy();
		
		try {
			System.out.println("Respuesta Vrecion " + proxy.usuariosWSDLCrear(this.usuarioCentralizador)) ; 
		} catch (RemoteException e) {			
			e.printStackTrace();
		}
		
		System.out.println("Despues de crear el proxy");	
		
		
		
		this.usuario.setActivo(true);
		this.usuario.setCorreo(this.usuarioCentralizador.getEmailPersonal());
		this.usuario.setIdentificacion(this.usuarioCentralizador.getNroIdentificacion());
		this.usuario.setLogin(this.usuarioCentralizador.getNroIdentificacion());
		this.usuario.setPassword("");
		this.usuario.setPrimerNombre(this.usuarioCentralizador.getPrimerNombre());
		this.usuario.setSegundoNombre(this.usuarioCentralizador.getSegundoNombre());
		this.usuario.setPrimerApellido(this.usuarioCentralizador.getPrimerApellido());
		this.usuario.setSegundoApellido(this.usuarioCentralizador.getSegundoApellido());

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
			tiposDocumento = listaValorEJB.buscarLista(ListaValoresEnum.IDLISTA_TIPOIDENTIFICACION.getValue());
			nacionalidades = listaValorEJB.buscarLista(ListaValoresEnum.IDLISTA_NACIONALIDAD.getValue());			 
			departamentos = zonaGeograficaEJB.buscarTodosDepartamento();				
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	 public void onDptoChange(ValueChangeEvent event) {
		 
		 if(event.getNewValue() != null && !event.getNewValue().toString().isEmpty()){
			 
			 if(event.getComponent().getId().equals(ID_CBO_DPTO_EXP))			 
				 ciudadesExpDocumento = zonaGeograficaEJB.buscarZonaGeograficaPorDepartamento(Integer.parseInt(event.getNewValue().toString()));
				 			 
			 if(event.getComponent().getId().equals(ID_CBO_DPTO_NAC))
				 ciudadesNacimiento = zonaGeograficaEJB.buscarZonaGeograficaPorDepartamento(Integer.parseInt(event.getNewValue().toString()));
							 
			 if(event.getComponent().getId().equals(ID_CBO_DPTO_RES))
				 ciudadesResidencia = zonaGeograficaEJB.buscarZonaGeograficaPorDepartamento(Integer.parseInt(event.getNewValue().toString()));				 
				 			 
			 if(event.getComponent().getId().equals(ID_CBO_DPTO_COR))
				 ciudadesCorrespondencia = zonaGeograficaEJB.buscarZonaGeograficaPorDepartamento(Integer.parseInt(event.getNewValue().toString()));
			 
			 if(event.getComponent().getId().equals(ID_CBO_DPTO_LAB))
				 ciudadesLaboral = zonaGeograficaEJB.buscarZonaGeograficaPorDepartamento(Integer.parseInt(event.getNewValue().toString()));			 
			 
		 }
	       
	 }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	

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
	
	public String getDepartamentoNacimiento() {
		return departamentoNacimiento;
	}

	public void setDepartamentoNacimiento(String departamentoNacimiento) {
		this.departamentoNacimiento = departamentoNacimiento;
	}

	public String getDepartamentoResidencia() {
		return departamentoResidencia;
	}

	public void setDepartamentoResidencia(String departamentoResidencia) {
		this.departamentoResidencia = departamentoResidencia;
	}

	public String getDepartamentoCorrespondencia() {
		return departamentoCorrespondencia;
	}

	public void setDepartamentoCorrespondencia(String departamentoCorrespondencia) {
		this.departamentoCorrespondencia = departamentoCorrespondencia;
	}

	public String getDepartamentoLaboral() {
		return departamentoLaboral;
	}

	public void setDepartamentoLaboral(String departamentoLaboral) {
		this.departamentoLaboral = departamentoLaboral;
	}

	public List<ZonaGeografica> getCiudadesNacimiento() {
		return ciudadesNacimiento;
	}

	public void setCiudadesNacimiento(List<ZonaGeografica> ciudadesNacimiento) {
		this.ciudadesNacimiento = ciudadesNacimiento;
	}

	public List<ZonaGeografica> getCiudadesResidencia() {
		return ciudadesResidencia;
	}

	public void setCiudadesResidencia(List<ZonaGeografica> ciudadesResidencia) {
		this.ciudadesResidencia = ciudadesResidencia;
	}

	public List<ZonaGeografica> getCiudadesCorrespondencia() {
		return ciudadesCorrespondencia;
	}

	public void setCiudadesCorrespondencia(List<ZonaGeografica> ciudadesCorrespondencia) {
		this.ciudadesCorrespondencia = ciudadesCorrespondencia;
	}

	public List<ZonaGeografica> getCiudadesLaboral() {
		return ciudadesLaboral;
	}

	public void setCiudadesLaboral(List<ZonaGeografica> ciudadesLaboral) {
		this.ciudadesLaboral = ciudadesLaboral;
	}

	public List<ListaValor> getNacionalidades() {
		return nacionalidades;
	}

	public void setNacionalidades(List<ListaValor> nacionalidades) {
		this.nacionalidades = nacionalidades;
	}

	public String getFechaExpedicionDoc() {
		return fechaExpedicionDoc;
	}

	public void setFechaExpedicionDoc(String fechaExpedicionDoc) {
		this.fechaExpedicionDoc = fechaExpedicionDoc;
	}

	
	public String getDireccionLaboral() {
		return direccionLaboral;
	}


	public void setDireccionLaboral(String direccionLaboral) {
		this.direccionLaboral = direccionLaboral;
	}


	public UsuarioDTO getUsuario() {
		return usuario;
	}
	
	public void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
	}


	public DatosBasicosUsuarioDTO getUsuarioCentralizador() {
		return usuarioCentralizador;
	}


	public void setUsuarioCentralizador(DatosBasicosUsuarioDTO usuarioCentralizador) {
		this.usuarioCentralizador = usuarioCentralizador;
	}


	public String getFechaNacimiento() {
		return fechaNacimiento;
	}


	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	
	
	
	
}
