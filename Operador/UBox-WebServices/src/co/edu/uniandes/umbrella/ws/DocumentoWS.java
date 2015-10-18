package co.edu.uniandes.umbrella.ws;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Calendar;

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

import co.edu.uniandes.umbrella.dto.DocumentoDTO;
import co.edu.uniandes.umbrella.dto.UsuarioDTO;
import co.edu.uniandes.umbrella.entidades.ListaValor;
import co.edu.uniandes.umbrella.interfaces.DocumentosEJBRemote;
import co.edu.uniandes.umbrella.interfaces.ListaValorEJBLocal;
import co.edu.uniandes.umbrella.interfaces.UsuarioEJBRemote;
import co.edu.uniandes.umbrella.models.RecibirDocumentoRequest;
import co.edu.uniandes.umbrella.utils.ResultadoOperacion;


@Stateless
@Path("/api/documentos")
public class DocumentoWS {
	@EJB
	private DocumentosEJBRemote documentoEjb;
	
	@EJB
	private UsuarioEJBRemote usuarioEjb;
	
	@EJB
	private ListaValorEJBLocal listaValorEjb;
	
	/***
	 * Metodo encargado de recibir un documento para ser compartido a un usuario existente en el operador
	 * @param dataRequest Estructura de datos con el documento, el remitente y el destinatario
	 * @return
	 */
	@POST
	@Path("recibirCompartido")
    @Produces(MediaType.APPLICATION_JSON)
    public Response compartirDocumento(RecibirDocumentoRequest dataRequest) {
		ResultadoOperacion respuesta = new ResultadoOperacion();
		
		try	{
			
			UsuarioDTO usuarioDestino = usuarioEjb.consultarUsuario(dataRequest.getTipoIdentificacionDestino(), dataRequest.getIdentificacionDestino());
			if(usuarioDestino == null)
			{
				respuesta.setOperacionExitosa(false);
				respuesta.setResultadoOperacion("El usuario al que va destinado el documento no esta registrado en el operador");
				return Response.status(400).entity(respuesta).build();
			}
			
			
			//Si el tipo documental no se encuentra retorna error
			ListaValor tipoDocumento = listaValorEjb.buscarListaValorPorCodigoExterno(1, dataRequest.getDocumento().getTipoDocumento());
			if(tipoDocumento == null)
			{
				respuesta.setOperacionExitosa(false);
				respuesta.setResultadoOperacion("El tipo documental no existe. Verifique el codigo");
				return Response.status(400).entity(respuesta).build();
			}
			
			//Actualiza los datos del DTO para actualizar los datos
			DocumentoDTO documento = new DocumentoDTO();
			documento.setDocumento(dataRequest.getDocumento().getArchivo().getBytes());
			documento.setNombre(dataRequest.getDocumento().getNombre());
			documento.setIdTipoDocumento(tipoDocumento.getIdListaValor());
			documento.setIdTipoMime(dataRequest.getDocumento().getTipoMime());
			documento.setFirmado(dataRequest.getDocumento().isFirmado());
			documento.setPalabrasClave("");
			documentoEjb.recibirDocumentoCompartido(dataRequest.getIdentificacionOrigen(), dataRequest.getIdentificacionOrigen(), dataRequest.isEmpresaPublica(), dataRequest.getIdentificacionDestino(), dataRequest.getIdentificacionDestino(), dataRequest.getIdOperadorExterno(), documento);
			
			respuesta.setOperacionExitosa(true);
			
			//Retorna respuesta exitosa
			return Response.status(200).entity(respuesta).build();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			respuesta.setOperacionExitosa(false);
			respuesta.setResultadoOperacion(e.toString());
			return Response.status(500).entity(respuesta).build();
		}
		
		
		
		
		
		/*
		byte[] data = Base64.decodeBase64(documento.getDocumento().getArchivo());
		try (OutputStream stream = new FileOutputStream("c:/decode/abc.bmp")) {
		    stream.write(data);
		}*/
		/*String completeImageData = documento.getDocumento().getArchivo();
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
		
		//http://stackoverflow.com/questions/17506428/convert-base64-string-to-image-in-java*/
    }
	
}
