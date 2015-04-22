package edu.umkc.idbmscc.utils;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

import com.sun.mail.util.BASE64DecoderStream;
import com.sun.mail.util.BASE64EncoderStream;

public class PassWordEncryp {

	private static Cipher ecipher;
	private static Cipher dcipher;

	private static SecretKey key;

	public String getEncryptPass(String pass) {

		String encrypted = "";
		try {
			// generate secret key using DES algorithm
			key = KeyGenerator.getInstance("DES").generateKey();

			ecipher = Cipher.getInstance("DES");
			dcipher = Cipher.getInstance("DES");

			// initialize the ciphers with the given key

			ecipher.init(Cipher.ENCRYPT_MODE, key);

			dcipher.init(Cipher.DECRYPT_MODE, key);

			encrypted = encrypt(pass);
		} catch (NoSuchAlgorithmException e) {
			System.out.println("No Such Algorithm:" + e.getMessage());
		} catch (NoSuchPaddingException e) {
			System.out.println("No Such Padding:" + e.getMessage());
		} catch (InvalidKeyException e) {
			System.out.println("Invalid Key:" + e.getMessage());
		}
		return encrypted;
	}

	public String getDecryptPass(String pass) {

		String decrypted = decrypt(pass);
		return decrypted;
	}

	public String encrypt(String str) {

		try {

			// encode the string into a sequence of bytes using the named
			// charset

			// storing the result into a new byte array.

			byte[] utf8 = str.getBytes("UTF8");
			byte[] enc = ecipher.doFinal(utf8);

			// encode to base64

			enc = BASE64EncoderStream.encode(enc);
			return new String(enc);

		}

		catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}

	public static String decrypt(String str) {

		try {

			// decode with base64 to get bytes

			byte[] dec = BASE64DecoderStream.decode(str.getBytes());

			byte[] utf8 = dcipher.doFinal(dec);

			// create new string based on the specified charset

			return new String(utf8, "UTF8");

		}

		catch (Exception e) {

			e.printStackTrace();

		}

		return null;

	}

}
