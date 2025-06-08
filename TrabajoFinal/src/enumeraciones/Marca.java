package enumeraciones;

/**
 * Enumeración que representa las diferentes marcas disponibles. Cada marca
 * tiene un nombre legible y un valor numérico asociado.
 */
public enum Marca {

	// Definición de cada marca con nombre legible y valor numérico
	SinMarca("Sin Marca", 404), Nestle("Nestle", 0), CocaCola("Coca cola", 1), Pepsi("Pepsi", 2), Danone("Danone", 3),
	Loreal("Loreal", 4), Nike("Nike", 5), Adidas("Adidas", 6), Samsung("Samsung", 7), Apple("Apple", 8),
	Sony("Sony", 9), Unilever("Unilever", 11), Lego("Lego", 12), Henkel("Henkel", 13), Oralb("Oralb", 14),
	Philips("Philips", 15), Bosch("Bosch", 16), Zara("Zara", 17), Ikea("Ikea", 18), Honda("Honda", 19);

	private final String nombreMarca; // Nombre visible de la marca
	private final int valor; // Valor entero asociado (útil en lógica o base de datos)

	/**
	 * Constructor de la enumeración.
	 *
	 * @param nombreMarca nombre legible de la marca
	 * @param valor       valor entero identificador de la marca
	 */
	Marca(String nombreMarca, int valor) {
		this.nombreMarca = nombreMarca;
		this.valor = valor;
	}

	/**
	 * Obtiene el nombre legible de la marca.
	 *
	 * @return nombre de la marca
	 */
	public String getNombreMarca() {
		return nombreMarca;
	}

	/**
	 * Obtiene el valor numérico asociado a la marca.
	 *
	 * @return valor entero de la marca
	 */
	public int getValor() {
		return valor;
	}
}
