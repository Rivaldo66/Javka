package Presentation_Layer;

import javax.swing.SwingUtilities;

public class GUI {
	
	public GUI(){
		
	}

	public GUI(LOG log, GAME game, REJESTR rejestr) {
		super();
		this.log = log;
		this.game = game;
		this.rejestr = rejestr;
	}

	private LOG log;
	private GAME game;
	private REJESTR rejestr;

	public void runLogFrame() {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				log = new LOG();
			}
		});
	}

	public void runRejestrFrame() {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				rejestr = new REJESTR();
			}
		});
	}

	public void runGameFrame() {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				game = new GAME();
			}
		});

	}

	public LOG getLog() {
		return log;
	}

	public void setLog(LOG log) {
		this.log = log;
	}

	public GAME getGame() {
		return game;
	}

	public void setGame(GAME game) {
		this.game = game;
	}

	public REJESTR getRejestr() {
		return rejestr;
	}

	public void setRejestr(REJESTR rejestr) {
		this.rejestr = rejestr;
	}

}
