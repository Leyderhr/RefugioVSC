package util;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JTextField;

public class JTextFieldNumerosFlotantes extends JTextField{

	private static final long serialVersionUID = 1L;
	
	public JTextFieldNumerosFlotantes(){
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e){
				char caracter = e.getKeyChar();
				int size = getText().length();
				
				if((!Character.isDigit(caracter) && caracter != '.') || (caracter == '.' && (size == 0 || getText().contains("."))))
						e.consume();	
			}
		});
	}
}

