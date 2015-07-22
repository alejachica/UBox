package co.edu.uniandes.umbrella.ws;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response;

import co.edu.uniandes.umbrella.interfaces.IUsuarioWS;
import co.edu.uniandes.umbrella.interfaces.UsuariosEJBRemote;

@Path("/centralizador")
public class UsuarioWS implements IUsuarioWS {
	
    @Context
    private UriInfo context;
    
    @EJB
    private UsuariosEJBRemote usuarios;

    /**
     * Default constructor. 
     */
    public UsuarioWS() {
    	
    }
    
    @GET
    @Produces("application/json")
    public Response consultarUsuario() {
    	
    	return Response.status(200).header("Access-Control-Allow-Origin", "*")
				.entity(null).build();
    }

    /**
     * Retrieves representation of an instance of UsuarioWS
     * @return an instance of String
     */
    @GET
    @Produces("application/json")
    public String getJson() {
        // TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of UsuarioWS
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }

}