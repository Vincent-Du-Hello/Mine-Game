package com.duwenxi.game1;

import java.awt.Canvas;
import java.awt.Graphics;
import java.util.Arrays;
 
public class MainCanvas extends Canvas {
	private static final long serialVersionUID = 1L;

	public GridType[] types = {};
	
	public boolean firstclick = true;
	public boolean win = false;
	public boolean lose = false;
	
	public MainCanvas(GridType[] gameBoard) {
		types = Arrays.copyOf(types, 100);
		for(int i = 0; i < 100; i++) {
			types[i] = GridType.EMPTY;
		}
		this.addMouseListener(new Clicker(this, gameBoard));
	}
	
	public void reset() {
		firstclick = true;
		for(int i = 0; i < 100; i++) {
			types[i] = GridType.EMPTY;
		}
		win = false;
		lose = false;
	}
	
	@Override
	public void repaint() {
		Graphics g = this.getGraphics();
		update(g);
	}
 
	@Override
	public void paint(Graphics g) {
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				switch(types[i * 10 + j]) {
					case EMPTY:
						g.drawImage(Config.EMPTYIMG, i*50+6, j*50+6, 50, 50, null);
						break;
					
					case CLICKED:
						g.drawImage(Config.CLICKEDIMG, i*50+6, j*50+6, 50, 50, null);
						break;
					
					case NOTHING:
						g.drawImage(Config.NOTHINGIMG, i*50+6, j*50+6, 50, 50, null);
						break;
					
					case BOOM:
						g.drawImage(Config.BOOMIMG, i*50+6, j*50+6, 50, 50, null);
						break;
						
					case N1:
						g.drawImage(Config.N1IMG, i*50+6, j*50+6, 50, 50, null);
						break;
						
					case N2:
						g.drawImage(Config.N2IMG, i*50+6, j*50+6, 50, 50, null);
						break;
						
					case N3:
						g.drawImage(Config.N3IMG, i*50+6, j*50+6, 50, 50, null);
						break;
						
					case N4:
						g.drawImage(Config.N4IMG, i*50+6, j*50+6, 50, 50, null);
						break;
						
					case N5:
						g.drawImage(Config.N5IMG, i*50+6, j*50+6, 50, 50, null);
						break;
						
					case N6:
						g.drawImage(Config.N6IMG, i*50+6, j*50+6, 50, 50, null);
						break;
						
					case N7:
						g.drawImage(Config.N7IMG, i*50+6, j*50+6, 50, 50, null);
						break;
						
					case N8:
						g.drawImage(Config.N8IMG, i*50+6, j*50+6, 50, 50, null);
						break;
						
					case MARKED:
						g.drawImage(Config.MARKEDIMG, i*50+6, j*50+6, 50, 50, null);
						break;
						
					default:
						break;
				}
			}
		}
		if(win) {
			g.drawImage(Config.WINIMG, 6, 6, 500, 500, null);
		}
		if(lose) {
			g.drawImage(Config.LOSEIMG, 6, 6, 500, 500, null);
		}
	}
	
	public void board(Graphics g) {
		paint(g);
	}
}
