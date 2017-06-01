package Presentation_Layer;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GAME {
	
	private JPanel panel1;
	private JFrame frame1;
	
	public GAME(){
		
		frame1 = new JFrame();
		frame1.setVisible(true);
		frame1.setResizable(false);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.setSize(800,400);
		frame1.setName("TAMAGOTCHI");
		
		panel1 = new JPanel(new GridBagLayout());
		
		new GridBagConstraints();
		
		frame1.setContentPane(new Background("GAMEbackground.jpg"));
		
		frame1.add(panel1);	
	}

}
