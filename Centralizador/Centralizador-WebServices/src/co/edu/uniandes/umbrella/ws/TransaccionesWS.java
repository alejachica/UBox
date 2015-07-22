package co.edu.uniandes.umbrella.ws;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

import co.edu.uniandes.umbrella.interfaces.ITransaccionesWS;

@Path("centralizador")
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
     * Retrieves representation of an instance of InstitucionesWS
     * @return an instance of String
     */
    @GET
    @Produces("application/json")
    public String getJson() {
        // TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of InstitucionesWS
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }

}