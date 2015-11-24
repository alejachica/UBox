package co.edu.uniandes.umbrella.utils;

import java.util.Properties;

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
	 */
	public void enviarCorreoArchivoPorLink(String destinatario, String urlArchivo, String clave) throws MessagingException
	{
		String mensaje = "Le compartieron el archivo http://172.24.99.239:8080/UBox-Web/descargarDocumento.jsf?f="+urlArchivo;
		if(clave != null && !clave.equals(""))
			mensaje += "\n La clave del archivo es "+clave;
		
		enviarCorreo(destinatario, "Le han compartido un archivo", mensaje);
	}
	
	/****
	 * Realiza el envio de un correo
	 * @param destinatario
	 * @param asunto
	 * @param mensaje
	 * @throws MessagingException 
	 */
	private void enviarCorreo(String destinatario, String asunto, String mensaje) throws MessagingException
	{
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(props,
			new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("mototuils@gmail.com","tuils123456");
				}
			});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("mototuils@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(destinatario));
			message.setSubject(asunto);
			message.setText(mensaje);

			Transport.send(message);

			System.out.println("Email enviado correctamente");

		} catch (MessagingException e) {
			//throw new RuntimeException(e);
			e.printStackTrace();
			System.out.println(e.getMessage());
			throw e;
		}
	}
	
}
