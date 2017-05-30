package Presentation_Layer;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class LOG extends JFrame {

	public LOG() {

		setResizable(false);
		JFrame jframe = new JFrame("LOGOWANIE");
		jframe.setLayout(new FlowLayout());
		jframe.setSize(250, 350);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setVisible(true);
		setLocationRelativeTo(null);
		
		JLabel jlabelname = new JLabel("User name: ");
		jframe.add(jlabelname);	
		JTextField jtextfieldname = new JTextField(10); 
		jframe.add(jtextfieldname);
		
		JLabel jlabelpassword = new JLabel("Password: ");
		jframe.add(jlabelpassword);
		JTextField jtextfieldpassword = new JTextField(10); 
		jframe.add(jtextfieldpassword);
		
		JButton jbutton = new JButton("Logowanie");  
		jframe.add(jbutton); 

	}

}
