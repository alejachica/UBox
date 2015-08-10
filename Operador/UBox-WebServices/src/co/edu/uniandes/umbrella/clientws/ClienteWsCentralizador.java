/**
 * 
 */
package co.edu.uniandes.umbrella.clientws;

import java.util.List;

import javax.swing.JOptionPane;
import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

/**
 * @author Usuario
 *
 */
public class ClienteWsCentralizador {
	
	private static final String URL_REST = "http://localhost:8080/Centralizador-WS";
	private static final String PATH = "/centralizador";

	/**
	 * @param args
	 */
	public static void main(String[] args) {

			crearPeticion();
	}
	
	private static void crearPeticion() {
		
		
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		WebResource service = client.resource(URL_REST);
		
		ClientResponse response = service.path(PATH)
				.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);

		String codigo = response.getClientResponseStatus().getStatusCode() + "";
		
		String respuesta = response.getEntity(String.class);
		System.out.println(respuesta);
		
		JOptionPane.showMessageDialog(null, "Codigo respuesta: " + codigo + "\n Resultado de la consulta: " + respuesta);

	}

}
