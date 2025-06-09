package test;

import java.sql.SQLException;

import controlador.ControladorLogin;
import controlador.ControladorTema;
import util.MiExcepcion;
import vista.VistaLogin;

/**
 * Clase principal que lanza la aplicación. Aplica el estilo visual y muestra la
 * pantalla de login.
 */
public class Main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, MiExcepcion {
		// Crear la ventana de login para luego iniciar las vistas y controladores
		// pertinentes
		VistaLogin vistaInicial = new VistaLogin();

		// Aplicar el controlador de los eventos a la vista de login
		ControladorLogin controlador = new ControladorLogin(vistaInicial);
		ControladorTema controladorTema = new ControladorTema();
		vistaInicial.control(controlador);
		vistaInicial.controlTema(controladorTema);
		
		vistaInicial.pack();
		vistaInicial.setVisible(true);
		
	}
}
