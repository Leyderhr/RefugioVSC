package util;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JTextField;

public class JTextFieldSoloLetras extends JTextField{

	private static final long serialVersionUID = 1L;

	public JTextFieldSoloLetras() {
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				
				char caracter = e.getKeyChar();
				
				if(!Character.isLetter(caracter) && caracter != ' ')
					e.consume();
			}
		});
	}
}
