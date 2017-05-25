import javax.swing.SwingUtilities;

public class GUI {

	public void runLogFrame() {
		// ODPALA NASZE SUPI OKIENKO GRAFICZNE
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new LOG();
			}
		});
	}

	public void runGameFrame() {
		// ODPALA NASZE SUPI OKIENKO GRAFICZNE
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new GAME();
			}
		});
		
	}
}
