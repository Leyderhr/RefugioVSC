package util;

import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class JTextFieldSoloNumeros extends JTextField{

	private static final long serialVersionUID = 1L;

	public JTextFieldSoloNumeros() {
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				
				JTextField cadena = (JTextField)e.getSource();
				char caracter = e.getKeyChar();
				
				if(cadena.getText().length() == limite)
					e.consume();
				else if(!Character.isDigit(caracter))
					e.consume();

			}
		});
	}

	private int limite = -1;

	public int getLimite() {
		return this.limite;
	}

	public void setLimite(int limite) {
		if (limite >= -1)
			this.limite = limite;
	}






}
