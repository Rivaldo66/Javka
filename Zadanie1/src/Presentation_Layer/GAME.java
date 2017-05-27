package Presentation_Layer;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class GAME {
	
	public GAME() {

		JFrame jfrm = new JFrame("GRA");
		jfrm.setSize(800, 600);
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel jlab = new JLabel("Swing w Javie.");
		jfrm.add(jlab);
		jfrm.setVisible(true);

	}
}
