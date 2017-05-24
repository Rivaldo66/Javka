import javax.swing.JFrame;
import javax.swing.JLabel;

public class GUI extends JFrame {
	
	public GUI() {
		
		setResizable(false);
		JFrame jfrm = new JFrame("Prosta aplikacja Swing");
		jfrm.setSize(1800,800);
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel jlab = new JLabel("Swing w Javie.");
		jfrm.add(jlab);
		jfrm.setVisible(true);
		setLocationRelativeTo(null);
		
	}
}
