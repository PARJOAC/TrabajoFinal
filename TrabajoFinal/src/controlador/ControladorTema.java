package controlador;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import util.EstiloVista;

public class ControladorTema implements KeyListener {

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {

	}

	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println("El tema ha cambiado");
		if (e.getKeyCode() == KeyEvent.VK_F12) {

			EstiloVista.cambiarTema();
		}
	}

}
