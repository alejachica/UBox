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

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;

import org.primefaces.model.UploadedFile;

import co.edu.uniandes.umbrella.dto.DocumentoDTO;
import co.edu.uniandes.umbrella.interfaces.DocumentosEJBRemote;

@ManagedBean
@SessionScoped
public class DescargarDocumentoBean implements Serializable{
	
	@EJB
	private DocumentosEJBRemote documentoEJB;
	
	private DocumentoDTO documentoActual;
	
	@PostConstruct
	public void validarDocumento()
	{
		String a = "";
	}
	
	public void descargarArchivo() throws FileNotFoundException, IOException {
		
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
