/**
 * 
 */
package co.edu.uniandes.umbrella.managedbeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import co.edu.uniandes.umbrella.dto.DocumentoDTO;
import co.edu.uniandes.umbrella.interfaces.DocumentosEJBRemote;

/**
 * @author Usuario
 *
 */
@ManagedBean(name="papeleraBean")
@ViewScoped
public class PapeleraDocumentosBean {
	
	//------------------ATRIBUTOS------------------//
	
	@EJB
	private DocumentosEJBRemote documentoEJB;
	
	private List<DocumentoDTO> documentos;
	
	private int documentoId;
	
	//-------------------METODOS GET Y SET-------------------//
	
	public List<DocumentoDTO> getDocumentos() {
		return documentos;
	}

	public void setDocumentos(List<DocumentoDTO> documentos) {
		this.documentos = documentos;
	}
	
	public int getDocumentoId() {
		return documentoId;
	}

	public void setDocumentoId(int documentoId) {
		this.documentoId = documentoId;
	}
	
	//-------------------OTROS METODOS-------------------//

	@PostConstruct
	public void init(){
		documentos = crearArbol();
	}
	
	public List<DocumentoDTO> crearArbol(){
		List<DocumentoDTO> listaDocs = new ArrayList<DocumentoDTO>();
		try {
			List<DocumentoDTO> docsDTO = documentoEJB.listarDocumentosPapelera(3); //TODO dejar de utilizar usuario quemado
			for(DocumentoDTO doc: docsDTO){
				listaDocs.add(doc);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaDocs;
	}
	
	public void eliminarDocumento(){
		try{
			documentoEJB.eliminarDocumento(this.documentoId);
			documentos = crearArbol();
		}
		catch(Exception e){
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Error eliminando documento", e.getMessage());
	        FacesContext.getCurrentInstance().addMessage(null, message);
		}
	}
	
	public void restaurarDocumento(){
		try{
			documentoEJB.manejoPapelera(this.documentoId, false);
			documentos = crearArbol();
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Documento restaurado", null);
	        FacesContext.getCurrentInstance().addMessage(null, message);
		}
		catch(Exception e){
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Error restaurando documento", e.getMessage());
	        FacesContext.getCurrentInstance().addMessage(null, message);
		}
	}
	
	public void vaciarPapelera(){
		try{
			documentoEJB.vaciarPapelera(3);//TODO cambiar el usuario quemado
			documentos = crearArbol();
		}
		catch(Exception e){
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Error vaciando la papelera", e.getMessage());
	        FacesContext.getCurrentInstance().addMessage(null, message);
		}
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Error vaciando la papelera", "asdfasf");
        FacesContext.getCurrentInstance().addMessage(null, message);
	}
	
	public void restaurarPapelera(){
		try{
			documentoEJB.restaurarPapelera(3);//TODO cambiar el usuario quemado
			documentos = crearArbol();
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Se restuaran todos los elementos exitosamente", null);
	        FacesContext.getCurrentInstance().addMessage(null, message);
		}
		catch(Exception e){
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error restaurando la papelera", e.getMessage());
	        FacesContext.getCurrentInstance().addMessage(null, message);
		}
	}

}
