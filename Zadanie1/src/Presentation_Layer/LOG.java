package Presentation_Layer;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class LOG extends JFrame {

	public LOG() {

		setResizable(false);
		JFrame jfrm = new JFrame("LOGOWANIE");
		jfrm.setSize(400, 550);
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel jlab = new JLabel("Swing w Javie.");
		jfrm.add(jlab);
		jfrm.setVisible(true);
		setLocationRelativeTo(null);

	}
}
