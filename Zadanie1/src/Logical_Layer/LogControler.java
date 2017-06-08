package Logical_Layer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Data_Layer.User;
import Presentation_Layer.GAME;
import Presentation_Layer.GUI;
import Presentation_Layer.LOG;

public class LogControler {
	
	public LogControler(DataRepository repo, LOG log, GAME game) {
		super();
		this.repo = repo;
		this.log = log;
		this.game = game;
	}
	
	private DataRepository repo;
	private LOG log;
	private GAME game;
	
	public boolean checkLog(){
		boolean log;
		User atempt = new User();
		String login;
		String pswd;
		
		login = this.log.getText1().getText();
		pswd = this.log.getText2().getText();
		
		atempt = repo.GetUser(login);
		
		if(atempt.getPassword()==pswd){
			log=true;
		}
		else{
			log=false;
		}
		
		return log;
	}
	
	public void addListener(){
		log.getButton1().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(checkLog()){
					GUI gra = new GUI();
					gra.runGameFrame();
				}
				else{
					log.setText1("");
					log.setText2("");
				}
			}
		});
	}

}
