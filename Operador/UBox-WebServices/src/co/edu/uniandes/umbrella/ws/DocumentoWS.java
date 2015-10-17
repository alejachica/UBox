package co.edu.uniandes.umbrella.ws;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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
		return Response.status(200).entity(respuesta).build();
    }
	
}
