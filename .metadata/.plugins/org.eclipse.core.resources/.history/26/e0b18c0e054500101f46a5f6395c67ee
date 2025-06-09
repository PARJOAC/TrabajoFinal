package util;

import java.awt.Image;
import java.net.URL;

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
		URL ruta = frame.getClass().getResource("/logos/logoCabecera.png");
		Image imagenEscalada = null;

		// Si encontró la ruta, crea un ImageIcon y obtiene la imagen
		if (ruta != null) {
			ImageIcon icono = new ImageIcon(ruta);
			imagenEscalada = icono.getImage(); // Devuelve la imagen sin escalar
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

		// Obtiene el recurso desde el mismo path
		URL ruta = frame.getClass().getResource("/logos/logoCabecera.png");
		Image imagenEscalada = null;

		// Si existe la ruta, obtiene y escala la imagen
		if (ruta != null) {
			ImageIcon icono = new ImageIcon(ruta);
			// Escala suavemente a 150x150 píxeles
			imagenEscalada = icono.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
		}

		// Devuelve la imagen escalada o null si no fue encontrada
		return imagenEscalada;
	}
}
