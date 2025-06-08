package enumeraciones;

/**
 * Enumeración que define ventanas emergentes del sistema. Cada tipo tiene una
 * descripción legible.
 */
public enum Emergente {

	Error("Error"), Advertencia("Advertencia"), Informacion("Información");

	private final String descripcion; // Descripción legible para mostrar en la interfaz

	/**
	 * Constructor de la enumeración.
	 *
	 * @param descripcion descripción legible del tipo
	 */
	Emergente(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * Obtiene la descripción legible del tipo de emergencia.
	 *
	 * @return descripción del tipo
	 */
	public String getDescripcionEmergente() {
		return descripcion;
	}

}
