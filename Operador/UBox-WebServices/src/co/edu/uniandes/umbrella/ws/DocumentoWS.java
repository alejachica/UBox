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
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
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
import co.edu.uniandes.umbrella.utils.Criptografia;
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
    public Response compartirDocumento(RecibirDocumentoRequest dataRequest, @Context HttpHeaders headers) {
		ResultadoOperacion respuesta = new ResultadoOperacion();
		
		try	{
			
			
			String hash = "";
			
			try {
				hash = headers.getRequestHeader("X-Carpeta-Integrity").get(0);	
			} catch (Exception e) {
				// TODO: handle exception
				respuesta.setOperacionExitosa(false);
				respuesta.setResultadoOperacion("No viene la llave de integridad");
				return Response.status(400).entity(respuesta).build();
			}
			
			//Valida que el hash corresponda
			if(!hash.equals(Criptografia.md5(dataRequest.getDocumento().getArchivo())))
			{
				
				respuesta.setOperacionExitosa(false);
				respuesta.setResultadoOperacion("la llave de integridad no corresponde");
				return Response.status(400).entity(respuesta).build();
			}
			
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
			documento.setDocumento(Base64.decodeBase64(dataRequest.getDocumento().getArchivo().getBytes()));
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
    }
	
}
