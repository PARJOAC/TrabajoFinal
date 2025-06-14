package bd;

// Importación de clases necesarias para manejar la conexión con la base de datos
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import util.MiExcepcion; // Excepción personalizada definida por el usuario

public class BDConnection {

	// URL que indica la ubicación de la base de datos MySQL (nombre: supermercado)
	private static final String URL = "jdbc:mysql://localhost:3306/supermercado";

	// Usuario con el que se accede a la base de datos
	private static final String USER = "AdministradorSupermercado";

	// Contraseña del usuario para acceder a la base de datos
	private static final String PASSWORD = "AdministradorSupermercado";

	/**
	 * Método estático que devuelve un objeto Connection para establecer
	 * comunicación con la base de datos.
	 * 
	 * @return Connection: conexión abierta a la base de datos
	 * @throws SQLException:           si ocurre un error SQL al conectar
	 * @throws ClassNotFoundException: si el driver de MySQL no está disponible
	 * @throws MiExcepcion:            excepción personalizada si no se puede
	 *                                 conectar
	 */
	public static Connection getConnection() throws SQLException, ClassNotFoundException, MiExcepcion {
		// Carga el driver JDBC de MySQL (solo necesario en algunas versiones de Java)
		Class.forName("com.mysql.cj.jdbc.Driver");

		try {
			// Intenta establecer una conexión
			Connection conexion = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("Se ha registrado una conexión."); // Mensaje de confirmación por consola
			return conexion; // Devuelve la conexión abierta
		} catch (Exception e) {
			// Si falla la conexión, lanza una excepción personalizada con un mensaje
			// amigable
			throw new MiExcepcion("No se ha podido conectar a la base de datos.");
		}
	}
}
