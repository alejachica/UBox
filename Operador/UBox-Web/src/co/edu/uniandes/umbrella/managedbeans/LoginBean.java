package co.edu.uniandes.umbrella.managedbeans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;

import umbrella.ubox.seguridad.ManejoSesiones;

@ManagedBean(name = "LoginBean")
public class LoginBean implements Serializable {

		private String usuario;
		private String clave;
		private String error;
		

		public String getError() {
			return error;
		}

		public void setError(String error) {
			this.error = error;
		}

		public String getUsuario() {
			return usuario;
		}

		public void setUsuario(String usuario) {
			this.usuario = usuario;
		}

		public String getClave() {
			return clave;
		}

		public void setClave(String clave) {
			this.clave = clave;
		}

		public LoginBean()
		{
			
		}
		
		public String validarAutenticacion()
		{
			ManejoSesiones objSesion = new ManejoSesiones();
			if(objSesion.validarAutenticacion(this.usuario,  this.clave, "127.0.0.1"))
			{
				return "documentosPersonales.xhtml";
			}
			else
			{
				this.error = "Los datos son incorrectos";
				return "";
			}
		}
	
}
