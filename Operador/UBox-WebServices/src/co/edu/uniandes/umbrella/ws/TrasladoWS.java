package co.edu.uniandes.umbrella.ws;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import co.edu.uniandes.umbrella.interfaces.ITrasladoWS;

@Path("/api/traslado")
public class TrasladoWS implements ITrasladoWS {
	

	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response iniciarTraslado(String documento) {
    	
    	System.out.println("rest traslado ws get");

    	return Response.status(200).header("Access-Control-Allow-Origin", "*")
				.entity("prueba").build();
    }
}
