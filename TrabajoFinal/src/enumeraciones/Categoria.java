package enumeraciones;

/**
 * Enumeración que representa las diferentes categorías posibles para los
 * productos. Cada categoría tiene una descripción legible y un valor numérico
 * asociado.
 */
public enum Categoria {

	// Definición de cada categoría con descripción y valor numérico asociado
	SinCategoria("Sin Categoria", 404), Limpieza("Limpieza", 0), Alimentacion("Alimentación", 1), Bebidas("Bebidas", 2),
	Panaderia("Panadería", 3), Carniceria("Carnicería", 4), Pescaderia("Pescadería", 5), Congelados("Congelados", 6),
	Lacteos("Lácteos", 7), FrutasVerduras("Frutas y Verduras", 8), HigienePersonal("Higiene Personal", 9),
	CuidadoBebe("Cuidado del Bebé", 10), Perfumeria("Perfumería", 11), Mascotas("Mascotas", 12),
	Drogueria("Droguería", 13), Papeleria("Papelería", 14), Electrodomesticos("Electrodomésticos", 15),
	Ropa("Ropa", 16), Ferreteria("Ferretería", 17), Jugueteria("Juguetería", 18), Tecnologia("Tecnología", 19);

	private final String descripcionCategoria; // Nombre legible de la categoría
	private final int valor; // Valor numérico asociado (puede usarse en BBDD o lógica interna)

	/**
	 * Constructor privado usado por cada valor del enum.
	 *
	 * @param descripcionCategoria descripción legible de la categoría
	 * @param valor                valor entero asociado a la categoría
	 */
	Categoria(String descripcionCategoria, int valor) {
		this.descripcionCategoria = descripcionCategoria;
		this.valor = valor;
	}

	/**
	 * Devuelve la descripción legible de la categoría.
	 *
	 * @return nombre de la categoría
	 */
	public String getDescripcionCategoria() {
		return descripcionCategoria;
	}

	/**
	 * Devuelve el valor numérico asociado a la categoría.
	 *
	 * @return valor de la categoría
	 */
	public int getValor() {
		return valor;
	}
}
