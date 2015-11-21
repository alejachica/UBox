package co.edu.uniandes.umbrella.managedbeans;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;

import org.primefaces.model.UploadedFile;

import co.edu.uniandes.umbrella.dto.CompartidoDTO;
import co.edu.uniandes.umbrella.dto.DocumentoDTO;
import co.edu.uniandes.umbrella.interfaces.DocumentosEJBRemote;

@ManagedBean(name="descargarDocumentoBean")
@ViewScoped
public class DescargarDocumentoBean implements Serializable{
	


	@EJB
	private DocumentosEJBRemote documentoEJB;
	
	/***
	 * True: el archivo fue encontrado, false: No fue encontrado
	 */
	private boolean fileFound;
	
	/****
	 * True: El archivo solo se puede ver si mete la clave
	 */
	private boolean withPassword;
	
	
	

	/***
	 * Id del archivo que se consulta por request
	 */
	private String fileId;
	
	//private String usuario;
	
	private String clave;
	
	private String errorClave;
	
	public boolean isWithPassword() {
		return withPassword;
	}

	public void setWithPassword(boolean withPassword) {
		this.withPassword = withPassword;
	}

	/*public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}*/

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getErrorClave() {
		return errorClave;
	}

	public void setErrorClave(String errorClave) {
		this.errorClave = errorClave;
	}
	
	
	private DocumentoDTO documentoActual;
	
	private String claveCompartido;
	
	
	public String getFileId() {
		return fileId;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId;
	}
	
	public boolean isFileFound() {
		return fileFound;
	}

	public void setFileFound(boolean fileFound) {
		this.fileFound = fileFound;
	}

	public void validarDocumento()
	{
		
		documentoEJB.compartirDocumento(9, "123456", "CC", 14, new Date());
		//documentoEJB.compartirDocumentoPorLink(3, 14, "566666", "gabriel.castillo86@hotmail.com", new Date(), "123");
		
		
		if(!getFileId().equals(""))
		{
			CompartidoDTO compartido = documentoEJB.ConsultarDocumentoPorLink(this.getFileId());
			if(compartido != null)
			{
				documentoActual = compartido.getDocumento();
				claveCompartido = compartido.getClave();
				if(compartido.getClave() != null)
					setWithPassword(!compartido.getClave().equals(""));
				setFileFound(true);
			}
		}
			
	}
	
	public void validarClave()
	{
		if(!getClave().equals(claveCompartido))
		{
			this.setErrorClave("La clave no es valida");
		}
		else
		{
			this.setErrorClave("");
			this.withPassword = false;
		}
	}
	
	public void descargarDocumento() throws FileNotFoundException, IOException {
		
		FacesContext context = FacesContext.getCurrentInstance();  
		HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();  
		response.reset();
		response.setBufferSize(documentoActual.getDocumento().length);  
		response.setContentType("application/octet-stream");  
		response.setHeader("Content-Length", String.valueOf(documentoActual.getDocumento().length));  
		response.setHeader("Content-Disposition", "attachment;filename=\"" + documentoActual.getNombre() + "\"");  
	    BufferedInputStream input = null;  
	    BufferedOutputStream output = null;  
	    try {  
	    	input = new BufferedInputStream(new ByteArrayInputStream(documentoActual.getDocumento()),documentoActual.getDocumento().length);  
	        output = new BufferedOutputStream(response.getOutputStream(),documentoActual.getDocumento().length);  
	        byte[] buffer = new byte[documentoActual.getDocumento().length];  
			int length;  
			while ((length = input.read(buffer)) > 0) {
				output.write(buffer, 0, length);  
			}  
		} 
	    finally {  
			input.close();  
			output.close();  
		}  
		context.responseComplete();
	}
	
	
	
}
