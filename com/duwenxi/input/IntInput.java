package com.duwenxi.input;

import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.duwenxi.listener.IntListener;

public class IntInput extends Frame {
	private static final long serialVersionUID = 5232886503394997035L;
	
	IntListener l;
	
	IntInput in = this;
	
	public IntInput(){
		TextField input;
		input = new TextField();
		input.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode() == KeyEvent.VK_ENTER) {
					l.onGet(Integer.parseInt(input.getText()));
					in.setVisible(false);
				}
			}

			@Override
			public void keyReleased(KeyEvent arg0) { }

			@Override
			public void keyTyped(KeyEvent arg0) { }
			
		});
		this.add(input);
		this.setSize(200,100);
		this.setResizable(false);
		this.setVisible(true);
	}
	
	public void setListener(IntListener l) {
		this.l = l;
	}
}
