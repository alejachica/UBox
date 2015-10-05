package co.edu.uniandes.umbrella.managedbeans;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;

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
	private DocumentosEJBRemote documentosEJB;
	
	
	public void downloadFile(int id) throws FileNotFoundException, IOException {
	      
		  FileOutputStream fileOuputStream = new FileOutputStream("C:\\docs\\instructions.txt"); 
	      //byte[] buf = new byte[fis.available()];
		  byte[] buf = documentosEJB.consultarDocumento(id).getDocumento();
		  fileOuputStream.write(buf);
		  File file = new File("C:\\docs\\instructions.txt");
		  InputStream fis = new FileInputStream(file);
	      int offset = 0;
	      int numRead = 0;
	      while ((offset < buf.length) && ((numRead = fis.read(buf, offset, buf.length -offset)) >= 0)) 
	      {
	        offset += numRead;
	      }
	      fis.close();
	      HttpServletResponse response =
	         (HttpServletResponse) FacesContext.getCurrentInstance()
	        .getExternalContext().getResponse();

	     response.setContentType("application/octet-stream");
	     response.setHeader("Content-Disposition", "attachment;filename=instructions.txt");
	     response.getOutputStream().write(buf);
	     response.getOutputStream().flush();
	     response.getOutputStream().close();
	     FacesContext.getCurrentInstance().responseComplete();
	}
}
