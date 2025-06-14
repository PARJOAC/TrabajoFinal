package enumeraciones;

/**
 * Enumeración que define los tipos de usuario del sistema. Cada tipo tiene un
 * valor numérico y una descripción legible.
 */
public enum TipoUsuario {

	Administrador(0, "Administrador"), Cajero(1, "Cajero");

	private final int valor; // Valor entero asociado al tipo (puede usarse en la BBDD)
	private final String descripcion; // Descripción legible para mostrar en la interfaz

	/**
	 * Constructor de la enumeración.
	 *
	 * @param valor       valor numérico del tipo de usuario
	 * @param descripcion descripción legible del tipo
	 */
	TipoUsuario(int valor, String descripcion) {
		this.valor = valor;
		this.descripcion = descripcion;
	}

	/**
	 * Obtiene el valor numérico asociado al tipo de usuario.
	 *
	 * @return valor del tipo
	 */
	public int getValor() {
		return valor;
	}

	/**
	 * Obtiene la descripción legible del tipo de usuario.
	 *
	 * @return descripción del tipo
	 */
	public String getDescripcionUsuario() {
		return descripcion;
	}

	/**
	 * Devuelve el tipo de usuario correspondiente al valor proporcionado.
	 *
	 * @param valor valor numérico buscado
	 * @return TipoUsuario correspondiente
	 * @throws IllegalArgumentException si el valor no corresponde a ningún tipo
	 */
	public static TipoUsuario fromValor(int valor) {
		for (TipoUsuario tipo : TipoUsuario.values()) {
			if (tipo.getValor() == valor)
				return tipo;
		}
		throw new IllegalArgumentException("TipoUsuario no válido: " + valor);
	}
}
