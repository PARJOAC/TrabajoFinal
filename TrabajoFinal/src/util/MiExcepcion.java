package util;

import java.io.Serializable;

/**
 * Clase personalizada de excepción para manejar errores específicos en la
 * aplicación. Hereda de Exception y permite mensajes personalizados.
 */
public class MiExcepcion extends Exception implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructor por defecto sin mensaje.
	 */
	public MiExcepcion() {
		super();
	}

	/**
	 * Constructor que permite especificar un mensaje de error.
	 *
	 * @param mensaje texto descriptivo del error
	 */
	public MiExcepcion(String mensaje) {
		super(mensaje);
	}
}
