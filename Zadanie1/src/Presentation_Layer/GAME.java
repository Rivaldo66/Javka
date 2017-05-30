package Presentation_Layer;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class GAME {
	
	public GAME() {

		JFrame jframe = new JFrame("GRA");
		jframe.setLayout(new FlowLayout());
		jframe.setSize(800, 600);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel jlabel = new JLabel("Swing w Javie.");
		jframe.add(jlabel);
		jframe.setVisible(true);

	}
}
