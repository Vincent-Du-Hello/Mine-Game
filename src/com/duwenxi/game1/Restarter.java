package com.duwenxi.game1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Restarter implements ActionListener{
	
	private Game game;

	public Restarter(Game game) {
		this.game = game;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		game.reset();
	}

}
