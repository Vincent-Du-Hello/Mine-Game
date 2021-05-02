package com.duwenxi.game1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextureSetter implements ActionListener{
	
	private Game game;

	public TextureSetter(Game game) {
		this.game = game;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Tool.changeTexture();
		game.c.reload();
	}
	
}
