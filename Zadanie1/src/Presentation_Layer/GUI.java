package Presentation_Layer;

import javax.swing.SwingUtilities;

public class GUI {

	public void runLogFrame() {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new LOG();
			}
		});
	}

	public void runRejestrFrame() {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new REJESTR();
			}
		});
	}
		
	public void runGameFrame() {
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					new GAME();
				}
		});
		
	}
}
