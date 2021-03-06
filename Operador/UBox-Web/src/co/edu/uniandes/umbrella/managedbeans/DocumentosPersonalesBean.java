/**
 * 
 */
package co.edu.uniandes.umbrella.managedbeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.model.UploadedFile;

import co.edu.uniandes.umbrella.dto.DocumentoDTO;
import co.edu.uniandes.umbrella.interfaces.DocumentosEJBRemote;

/**
 * @author Usuario
 *
 */
@ManagedBean(name="documentosPersonalesBean")
@SessionScoped
public class DocumentosPersonalesBean {
	
	@EJB
	private DocumentosEJBRemote documentosEJB;
	
	private UploadedFile file;
	
	private int carpetaId;
	 
    public UploadedFile getFile() {
        return file;
    }
 
    public void setFile(UploadedFile file) {
        this.file = file;
    }
     
    public int getCarpetaId() {
		return carpetaId;
	}

	public void setCarpetaId(int carpetaId) {
		this.carpetaId = carpetaId;
	}

	public void upload() {
    	try{
	        if(file != null) {
	        	DocumentoDTO documentoDTO = new DocumentoDTO();
	        	documentoDTO.setDocumento(file.getContents());
	        	//documentoDTO.setFecha(""); TODO ajustar fecha
	        	documentoDTO.setFirmado(false);
	        	documentoDTO.setFkCarpeta(carpetaId);
	        	documentoDTO.setFkUsuario(3);
	        	//documentoDTO.setIdTipoDocumento(new BigDecimal(1)); TODO seleccionar el tipo adecuado
	        	documentoDTO.setIdTipoMime(file.getContentType());
	        	documentoDTO.setNombre(file.getFileName());
	        	documentoDTO.setPalabrasClave("archivo1");
	        	documentoDTO.setVersion("version1");
	        	documentoDTO.setPapelera(false);
	        	documentoDTO.setSize((int)file.getSize());
	        	documentosEJB.crearDocumento(documentoDTO);
	            FacesMessage message = new FacesMessage("Succesful", file.getFileName() + " is uploaded.");
	            FacesContext.getCurrentInstance().addMessage(null, message);
	        }
    	}
    	catch(Exception e){
    		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Error eliminando carpeta", e.getMessage());
	        FacesContext.getCurrentInstance().addMessage(null, message);
    	}
    }

}
