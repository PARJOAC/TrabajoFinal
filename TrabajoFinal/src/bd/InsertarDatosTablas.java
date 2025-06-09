package bd;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import util.MiExcepcion;

public class InsertarDatosTablas {

	public static void crearDatos() throws ClassNotFoundException, SQLException, MiExcepcion {
		addDatosTablaUsuario();
	}

	/**
	 * Insertar Datos a Tabla USUARIOS
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws MiExcepcion
	 */
	private static void addDatosTablaUsuario() throws ClassNotFoundException, SQLException, MiExcepcion {

		String tablaUsuarios = """
				INSERT INTO usuarios (idUsuario, nombreUsuario, contrasena, tipo)
								    SELECT 1, 'admin', '8Ob2XvduFmzvi/MCYZyTPw==', 'Administrador'
								    WHERE NOT EXISTS (
								        SELECT 1 FROM usuarios WHERE nombreUsuario = 'admin'
								    );
								""";

		try (Connection con = BDConnection.getConnection(); Statement stmt = con.createStatement()) {
			stmt.executeUpdate(tablaUsuarios);
			System.out.println("Se ha añadido el usuario por defecto a la tabla USUARIOS en el caso de que no exista.");
		}
	}
}
