package util;

import java.sql.SQLException;

import bd.CrearTablas;
import bd.InsertarDatosTablas;

public class InicioTablas {

	public static void iniciar() throws ClassNotFoundException, SQLException, MiExcepcion {
		// Crear todas las tablas si no existen
		CrearTablas.crearTablas();
		InsertarDatosTablas.crearDatos();
	}
}
