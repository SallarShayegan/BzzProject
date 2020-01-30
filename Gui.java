import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Gui extends JFrame implements KeyListener {

	JLabel label = new JLabel("Key");
	Sound sound = new Sound();
	KeyBoard kb = new KeyBoard();
	
	public Gui() {
		label.addKeyListener(this);
		this.setVisible(true);
		this.setSize(500, 500);
		this.add(label);
		label.setFocusable(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void keyPressed(KeyEvent e) {
		char c = e.getKeyChar();
		label.setText(Character.toString(c));
		int key = kb.getKeyInteger(c);
		sound.active = true;
		if (!kb.isActive(key)) {
			kb.activateKey(key);
			sound.setKey(key);
			Thread t = new Thread(sound);
			t.start();
		}
	}
	
	public void keyDown(KeyEvent e) {
		
	}

	public void keyTyped(KeyEvent e) {

	}

	public void keyReleased(KeyEvent e) {
		char c = e.getKeyChar();
		sound.active = false;
		int key = kb.getKeyInteger(c);
		kb.deactivateKey(key);
	}

	public static void main(String[] args) {
		JFrame gui = new Gui();
	}
	
}
