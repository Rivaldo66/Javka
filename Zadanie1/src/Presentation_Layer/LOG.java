package Presentation_Layer;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LOG {
	
	private JFrame frame1;
	private JPanel panel1;
	private JButton button1;
	private JLabel label1;
	private JTextField text1;
	private JLabel label2;
	private JTextField text2;
	
	public LOG(){
		
		frame1 = new JFrame();
		frame1.setVisible(true);
		frame1.setResizable(false);
		frame1.setSize(300,400);
		frame1.setName("LOGOWANIE");
		
		panel1 = new JPanel(new GridBagLayout());
		panel1.setOpaque(false);
		
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		
		frame1.setContentPane(new Background("LOGbackground.jpg"));
		
		c.gridx = 0;
		c.gridy = 0;
		label1 = new JLabel("User name: ");
		panel1.add(label1, c);
		
		c.gridx = 1;
		c.gridy = 0;
		text1 = new JTextField(15);
		panel1.add(text1, c);
		
		c.gridx = 0;
		c.gridy = 1;
		label2 = new JLabel("Password: ");
		panel1.add(label2, c);
		
		c.gridx = 1;
		c.gridy = 1;
		text2 = new JTextField(15);
		panel1.add(text2, c);
		
		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = 2;
		c.insets = new Insets(20,0,0,0);
		button1 = new JButton("Zaloguj");
		panel1.add(button1,c);	
		
		frame1.add(panel1);		
	}

}
