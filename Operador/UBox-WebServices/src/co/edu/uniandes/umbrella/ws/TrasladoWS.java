package co.edu.uniandes.umbrella.ws;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import co.edu.uniandes.umbrella.interfaces.ITrasladoWS;
import co.edu.uniandes.umbrella.interfaces.UsuarioEJBRemote;
import co.edu.uniandes.umbrella.utils.ResultadoOperacion;


@Path("/api/traslado")
public class TrasladoWS  implements ITrasladoWS {
	
	@EJB
	private UsuarioEJBRemote usuarioEjb;
	
	@GET
	@Path("{documento}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response iniciarTraslado(@PathParam("documento") String documento) {
    	
		String[] partesDocumento = documento.split("-");
		
		if(partesDocumento.length == 2)
		{
			ResultadoOperacion respuesta = usuarioEjb.generarTraslado(partesDocumento[0], partesDocumento[1]);
			if(respuesta.isOperacionExitosa())
			{
				return Response.status(200).entity(respuesta).build();
			}
			else
			{
				return Response.status(400).entity(respuesta).build();
			}
		}
		else
		{
			ResultadoOperacion respuesta = new ResultadoOperacion();
			respuesta.setOperacionExitosa(false);
			respuesta.setResultadoOperacion("El documento proporcionado no está bien formado");
			return Response.status(400).entity(respuesta).build();
		}
		
    }
}
