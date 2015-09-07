/**
 * 
 */
package co.edu.uniandes.umbrella.managedbeans;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import co.edu.uniandes.umbrella.dto.CarpetaDTO;
import co.edu.uniandes.umbrella.interfaces.CarpetaEJBRemote;

@ManagedBean(name="directorioBean")
public class DirectoriosBean {
	
	@EJB
	private CarpetaEJBRemote carpeta;
	
	private String descripcion;
	
	private String nombre;
	
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void crearCarpeta(){
		try{
		CarpetaDTO carpetaDTO = new CarpetaDTO();
		carpetaDTO.setDescripcion(descripcion);
		carpetaDTO.setNombreCarpeta(nombre);
		carpeta.crearCarpeta(carpetaDTO, 3);
		}
		catch(Exception e){
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Error creando carpeta", e.getMessage());
	        FacesContext.getCurrentInstance().addMessage(null, message);
		}
	}
	
	public void eliminarCarpeta(){
		try{
			carpeta.eliminarCarpeta(1);
			}
			catch(Exception e){
				FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Error eliminando carpeta", e.getMessage());
		        FacesContext.getCurrentInstance().addMessage(null, message);
			}
	}

}
