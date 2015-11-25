package co.edu.uniandes.umbrella.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Criptografia {
	/****
	 * Convierte una cadena a md5
	 * @param toEnc cadena a convertir
	 * @return
	 */
	public static String md5(String toEnc)
	{
		
		try {
			MessageDigest mdEnc = MessageDigest.getInstance("MD5");
			mdEnc.update(toEnc.getBytes(), 0, toEnc.length());
			String md5 = new BigInteger(1, mdEnc.digest()).toString(16);
			return md5;
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		} 
			
	}
}
