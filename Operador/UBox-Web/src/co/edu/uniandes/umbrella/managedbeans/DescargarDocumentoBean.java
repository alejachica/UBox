package co.edu.uniandes.umbrella.managedbeans;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;

@ManagedBean
@SessionScoped
public class DescargarDocumentoBean implements Serializable{
	
	public void downloadFile() throws FileNotFoundException, IOException {
	      File file = new File("C:\\docs\\instructions.txt");
	      InputStream fis = new FileInputStream(file);
	      byte[] buf = new byte[fis.available()];
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
