package co.edu.uniandes.umbrella.ws;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.codec.binary.Base64;

import co.edu.uniandes.umbrella.interfaces.DocumentosEJBRemote;
import co.edu.uniandes.umbrella.models.RecibirDocumentoRequest;
import co.edu.uniandes.umbrella.utils.ResultadoOperacion;


@Stateless
@Path("/api/documentos")
public class DocumentoWS {
	@EJB
	private DocumentosEJBRemote documentoEjb;
	
	@GET
	@Path("recibir")
	@Produces(MediaType.APPLICATION_JSON)
	public Response probar()
	{
		return Response.status(200).entity("ok").build();
	}
	
	
	@POST
	@Path("recibirCompartido")
    @Produces(MediaType.APPLICATION_JSON)
    public Response iniciarTraslado(RecibirDocumentoRequest documento) {
		ResultadoOperacion respuesta = new ResultadoOperacion();
		/*
		byte[] data = Base64.decodeBase64(documento.getDocumento().getArchivo());
		try (OutputStream stream = new FileOutputStream("c:/decode/abc.bmp")) {
		    stream.write(data);
		}*/
		String completeImageData = documento.getDocumento().getArchivo();
		String imageDataBytes = completeImageData.substring(completeImageData.indexOf(",")+1);
		
		byte[] buffer = new byte[8 * 1024];
		InputStream stream = new ByteArrayInputStream(Base64.decodeBase64(imageDataBytes.getBytes()));
		try {
		try {
			  OutputStream output;
			
				output = new FileOutputStream("D:\\Temp\\prueba.png");
			
			  try {
			    int bytesRead;
			    while ((bytesRead = stream.read(buffer)) != -1) {
			      output.write(buffer, 0, bytesRead);
			    }
			  } finally {
			    output.close();
			  }
			} finally {
				stream.close();
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//http://stackoverflow.com/questions/17506428/convert-base64-string-to-image-in-java
		
		return Response.status(200).entity(respuesta).build();
    }
	
}
