package co.edu.uniandes.umbrella.utils;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Email {
	
	/****
	 * Realiza el envio de un correo por un link
	 * @param destinatario
	 * @param urlArchivo
	 * @param clave
	 * @throws MessagingException 
	 * @throws UnsupportedEncodingException 
	 */
	public void enviarCorreoArchivoPorLink(String destinatario, String urlArchivo, String clave) throws MessagingException, UnsupportedEncodingException
	{
		String mensaje = "Le compartieron el archivo http://172.24.99.239:8080/UBox-Web/descargarDocumento.jsf?f="+urlArchivo;
		if(clave != null && !clave.equals(""))
			mensaje += "\n La clave del archivo es "+clave;
		
		enviarCorreo(destinatario, "Le han compartido un archivo", mensaje);
	}
	
	
	/****
	 * Realiza envío de la clave
	 * @param destinatario
	 * @param clave	 
	 * @throws UnsupportedEncodingException 
	 */
	public void enviarCorreoClave(String destinatario, String clave) throws MessagingException, UnsupportedEncodingException
	{
		String mensaje = "";
		
		if(clave != null && !clave.equals(""))
			mensaje = "Su clave para ingresar al operador Ubox es: " + clave;
		
		enviarCorreo(destinatario, "Clave Ingreso Ubox", mensaje);
	}
	
	
	/****
	 * Realiza el envio de un correo
	 * @param destinatario
	 * @param asunto
	 * @param mensaje
	 * @throws MessagingException 
	 * @throws UnsupportedEncodingException 
	 */
	private void enviarCorreo(String destinatario, String asunto, String mensaje) throws MessagingException, UnsupportedEncodingException
	{
		Properties props = new Properties();
		props.put("mail.smtp.starttls.enable", "true");
		//props.put("mail.smtp.host", "smtp.office365.com");
		props.put("mail.smtp.host", "m.outlook.com");
		//props.put("mail.smtp.socketFactory.port", "587");
		//props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "587");
		//props.
		/*
		Session session = Session.getDefaultInstance(props,
			new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("ga.castillo12@uniandes.edu.co","betolin86");
				}
			});*/
		Session session = Session.getInstance(props, new Authenticator() {
			@Override
	        protected PasswordAuthentication getPasswordAuthentication() {
	            return new PasswordAuthentication("ga.castillo12@uniandes.edu.co", "betolin86");
	        }
	    });

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("info@ubox.com", "Ubox"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(destinatario));
			message.setSubject(asunto);
			message.setText(mensaje);

			Transport.send(message);

			System.out.println("Email enviado correctamente Destinatario:"+destinatario );

		} catch (MessagingException e) {
			//throw new RuntimeException(e);
			e.printStackTrace();
			System.out.println(e.getMessage());
			throw e;
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
			throw e;
		}
	}
	
}
