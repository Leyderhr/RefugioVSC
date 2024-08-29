package util;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JTextField;

public class JTextFieldNumerosFlotantes extends JTextField{

	private static final long serialVersionUID = 1L;
	private boolean existPoint;
	
	public JTextFieldNumerosFlotantes(){
		existPoint = false;
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e){
				char caracter = e.getKeyChar();
				int size = getText().length();
				
				if(!Character.isDigit(caracter)){
					if(caracter == '.' && (size == 0 || existPoint))
						e.consume();
					else if (caracter == '.')
						existPoint = true;
					else
						e.consume();
						
				}
			}
		});
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e){
				if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE){
					String text = getText();
					int caretPosition = getCaretPosition();
					
					if(caretPosition > 0){
						char deletedChar = text.charAt(caretPosition - 1);
						if(deletedChar == '.')
							existPoint = false;
					}else if(caretPosition == 0)
						existPoint = false;
				}
				
			}
		});
	}
}

