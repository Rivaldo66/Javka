package Logical_Layer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Data_Layer.User;
import Presentation_Layer.GAME;
import Presentation_Layer.GUI;
import Presentation_Layer.LOG;

public class LogControler extends JDialog {

	public LogControler(DataRepository repo, GUI gui) {
		super();
		this.repo = repo;
		this.gui = gui;
		addListener();
	}

	private DataRepository repo;
	private GUI gui;

	public boolean checkLog() {
		boolean isgood;
		User atempt = new User();
		String login = gui.getLog().getText1().getText();
		String pswd = gui.getLog().getText2().getText();

		atempt = repo.GetUser(login);

		if (atempt.getPassword() == pswd) {
			isgood = true;
		} else {
			isgood = false;
		}

		return isgood;
	}

	public void addListener() {
		gui.getLog().getButton1().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (checkLog()) {
					gui.runGameFrame();;
					dispose();
				} else {
					JOptionPane.showMessageDialog(LogControler.this, "Invalid username or password", "Login",
							JOptionPane.ERROR_MESSAGE);
					gui.getLog().setText1("");
					gui.getLog().setText2("");
				}
			}
		});
	}

}
