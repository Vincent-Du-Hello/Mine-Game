package com.duwenxi.game1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.duwenxi.input.IntInput;
import com.duwenxi.listener.IntListener;

public class BoomSetter implements ActionListener{
	private Game game;
	
	public BoomSetter(Game game) {
		this.game = game;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		IntInput in = new IntInput();
		in.setListener(new IntListener() {

			@Override
			public void onGet(int result) {
				Config.BOOMCOUNT = result;
				game.reset();
			}
			
		});
	}
	
}
