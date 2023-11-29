package presentacion;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Fothello extends JFrame {
	private Pothello pothello;
	
	public Fothello() {
		this.setTitle("Othello");
		this.setSize(400,400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		
		this.pothello = new Pothello();
		this.add(this.pothello, BorderLayout.CENTER);
	}
	public static void main(String[] args) {
		Fothello fothello = new Fothello();
		fothello.setVisible(true);
	}
}
