package umbrella.ubox.seguridad;
import org.apache.shiro.mgt.RealmSecurityManager;
import org.apache.shiro.SecurityUtils;

import com.stormpath.sdk.account.Account;
import com.stormpath.sdk.application.Application;
import com.stormpath.sdk.application.ApplicationList;
import com.stormpath.sdk.application.Applications;
import com.stormpath.sdk.client.Client;
import com.stormpath.sdk.resource.ResourceException;
import com.stormpath.sdk.tenant.Tenant;
import com.stormpath.shiro.realm.ApplicationRealm;

import co.edu.uniandes.umbrella.utils.ResultadoOperacion;

public class FuncionesStormpath {
	
	/***
	 * Retorna el actual cliente de stormpath
	 */
	private Client client = null;
	private Client getClient()
	{
		if(client == null)
		{
			ApplicationRealm realm = ((ApplicationRealm)((RealmSecurityManager) SecurityUtils.getSecurityManager()).getRealms().iterator().next());
			client = realm.getClient();
		}
		
		return client;
	}
	
	/***
	 * Retorna la aplication actual de stormpath
	 */
	private Application application;
	private Application getApplication()
	{
		if(application == null)
		{
			Tenant tenant = getClient().getCurrentTenant();
			ApplicationList applications = tenant.getApplications(
			        Applications.where(Applications.name().eqIgnoreCase("Proyecto 3"))
			);

			this.application = applications.iterator().next();
		}
		
		return this.application;
		
	}
	
	/***
	 * Crea un usuario en stormpath de acuerdo a los datos enviados
	 * @param nombres
	 * @param documento
	 * @param correo
	 * @param clave
	 * @return
	 */
	public ResultadoOperacion crearUsuario(String nombres, String documento, String correo, String clave)
	{
		ResultadoOperacion respuesta = new ResultadoOperacion();
		Client client = this.getClient();
		
		Account account = client.instantiate(Account.class);
	
		//Set the account properties
		account.setGivenName(nombres);
		account.setSurname(nombres);
		account.setUsername(documento); 
		account.setEmail(correo);
		account.setPassword(clave);
		
		try
		{
			//Create the account using the existing Application object
			account = getApplication().createAccount(account);
			respuesta.setOperacionExitosa(true);
			String key = account.getHref().split("/")[account.getHref().split("/").length - 1];
			respuesta.setResultadoOperacion(key);
		}
		catch(ResourceException e)
		{
			respuesta.setOperacionExitosa(false);
			String error = e.getMessage();
			//Poner todos los errrores posibles
			if(error.indexOf("Account password minimum length not satisfied") > 0)
				error = "La clave es demasiado corta, intente con una más compleja";
			else if(error.indexOf("Account email address cannot be null, empty, or blank") > 0)
				error = "El correo es invalido";
			else if(error.indexOf("Account with that email already exists.  Please choose another email") > 0)
				error = "Este usuario ya existe";
			
			
			
			
			respuesta.setResultadoOperacion(error);
		}
		
		return respuesta;
	}
}
