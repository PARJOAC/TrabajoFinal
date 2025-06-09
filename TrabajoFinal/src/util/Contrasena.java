package util;

import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 * Clase utilitaria para cifrar y descifrar contraseñas utilizando el algoritmo
 * AES. Usa una clave simétrica fija de 128 bits.
 */
public class Contrasena implements Serializable {

	private static final long serialVersionUID = 1L;

	// Clave secreta de 128 bits (16 caracteres)
	private static final String CLAVE_SECRETA = "z8L#rV93f@1!qTcD";

	// Algoritmo de cifrado con modo y padding
	private static final String ALGORITMO = "AES/ECB/PKCS5Padding";

	/**
	 * Cifra un texto y devuelve el resultado en Base64.
	 *
	 * @param textoPlano texto sin cifrar
	 * @return texto cifrado en formato Base64
	 * @throws MiExcepcion si ocurre un error durante el cifrado
	 */
	public static String cifrar(String textoPlano) throws MiExcepcion {
		try {
			// Crea la clave AES a partir de la clave secreta
			SecretKeySpec key = new SecretKeySpec(CLAVE_SECRETA.getBytes(StandardCharsets.UTF_8), "AES");

			// Configura el cifrador
			Cipher cipher = Cipher.getInstance(ALGORITMO);
			cipher.init(Cipher.ENCRYPT_MODE, key);

			// Realiza el cifrado y lo convierte a Base64
			byte[] cifrado = cipher.doFinal(textoPlano.getBytes(StandardCharsets.UTF_8));
			return Base64.getEncoder().encodeToString(cifrado);

		} catch (Exception e) {
			throw new MiExcepcion("Error al cifrar la contraseña: " + e.getMessage());
		}
	}

	/**
	 * Descifra un texto cifrado en Base64 y devuelve el texto original.
	 *
	 * @param textoCifrado texto cifrado en formato Base64
	 * @return texto plano original
	 * @throws MiExcepcion si ocurre un error durante el descifrado
	 */
	public static String descifrar(String textoCifrado) throws MiExcepcion {
		try {
			// Crea la clave AES a partir de la clave secreta
			SecretKeySpec key = new SecretKeySpec(CLAVE_SECRETA.getBytes(StandardCharsets.UTF_8), "AES");

			// Configura el descifrador
			Cipher cipher = Cipher.getInstance(ALGORITMO);
			cipher.init(Cipher.DECRYPT_MODE, key);

			// Realiza el descifrado desde Base64
			byte[] descifrado = cipher.doFinal(Base64.getDecoder().decode(textoCifrado));
			return new String(descifrado, StandardCharsets.UTF_8);

		} catch (Exception e) {
			throw new MiExcepcion("Error al descifrar la contraseña: " + e.getMessage());
		}
	}
}
