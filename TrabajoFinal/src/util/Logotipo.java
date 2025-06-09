package util;

import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Logotipo {

	/**
	 * Método que carga y devuelve una imagen sin escalar desde la ruta
	 * /logos/logoCabecera.png del proyecto, usando el contexto del frame dado.
	 * 
	 * @param frame El JFrame desde el cual se obtiene la ruta del recurso.
	 * @return La imagen obtenida, o null si no se encontró el recurso.
	 */
	public static Image logotipoCabecera(JFrame frame) {

		// Busca el recurso (imagen) en la ruta indicada dentro del classpath
		File archivo = new File("img/logoCabecera.png");
		Image imagenEscalada = null;

		// Si encontró la ruta, crea un ImageIcon y obtiene la imagen
		if (archivo.exists()) {
			imagenEscalada = new ImageIcon(archivo.getAbsolutePath()).getImage();
		}

		// Devuelve la imagen o null si no se encontró
		return imagenEscalada;
	}

	/**
	 * Método que carga y devuelve una imagen escalada a 150x150 píxeles.
	 * Se utiliza la misma ruta que el método anterior.
	 * 
	 * @param frame El JFrame desde el cual se obtiene la ruta del recurso.
	 * @return La imagen escalada, o null si no se encontró el recurso.
	 */
	public static Image logotipoMediano(JFrame frame) {

		File archivo = new File("img/logoInicial.png");
		Image imagenEscalada = null;

		// Si encontró la ruta, crea un ImageIcon y obtiene la imagen
		if (archivo.exists()) {
			imagenEscalada = new ImageIcon(archivo.getAbsolutePath()).getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
		}

		// Devuelve la imagen escalada o null si no fue encontrada
		return imagenEscalada;
	}
}
