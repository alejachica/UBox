package co.edu.uniandes.umbrella.ws;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import co.edu.uniandes.umbrella.interfaces.ITransaccionesWS;

@Path("/ubox")
public class TransaccionesWS implements ITransaccionesWS{
    @Context
    private UriInfo context;

    /**
     * Default constructor. 
     */
    public TransaccionesWS() {
        // TODO Auto-generated constructor stub
    }

    /**
     * Retrieves representation of an instance of TransaccionesWS
     * @return an instance of String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJson() {
    	
    	System.out.println("rest ws get");

    	return Response.status(200).header("Access-Control-Allow-Origin", "*")
				.entity("prueba").build();
    }


}