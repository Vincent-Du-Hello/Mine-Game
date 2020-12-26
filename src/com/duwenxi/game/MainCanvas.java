package com.duwenxi.game1;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Arrays;
 
public class MainCanvas extends Canvas {
	private static final long serialVersionUID = 1L;

	public int[] types = {};
	
	public MainCanvas(int[] gameBoard) {
		types = Arrays.copyOf(types, 100);
		for(int i = 0; i < 100; i++) {
			types[i] = Config.EMPTY;
		}
		this.addMouseListener(new Clicker(this, gameBoard));
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
					case Config.EMPTY:
						g.setColor(new Color(200, 200, 200));
						g.fillRect(i * 50 + 6, j * 50 + 6, 46, 3);
						g.fillRect(i * 50 + 6, j * 50 + 6, 3, 46);
						g.fillRect(i * 50 + 52, j * 50 + 6, 3, 1);
						g.fillRect(i * 50 + 52, j * 50 + 7, 2, 1);
						g.fillRect(i * 50 + 52, j * 50 + 8, 1, 1);
						g.fillRect(i * 50 + 6, j * 50 + 52, 1, 3);
						g.fillRect(i * 50 + 7, j * 50 + 52, 1, 2);
						g.fillRect(i * 50 + 8, j * 50 + 52, 1, 1);
						g.setColor(new Color(100, 100, 100));
						g.fillRect(i * 50 + 9, j * 50 + 52, 46, 3);
						g.fillRect(i * 50 + 52, j * 50 + 9, 3, 46);
						g.fillRect(i * 50 + 53, j * 50 + 8, 2, 1);
						g.fillRect(i * 50 + 54, j * 50 + 7, 1, 1);
						g.fillRect(i * 50 + 8, j * 50 + 53, 1, 2);
						g.fillRect(i * 50 + 7, j * 50 + 54, 1, 1);
						g.setColor(new Color(160, 160, 160));
						g.fillRect(i * 50 + 9, j * 50 + 9, 43, 43);
						break;
					
					case Config.CLICKED:
						g.setColor(new Color(100, 100, 100));
						g.fillRect(i * 50 + 6, j * 50 + 6, 46, 3);
						g.fillRect(i * 50 + 6, j * 50 + 6, 3, 46);
						g.fillRect(i * 50 + 52, j * 50 + 6, 3, 1);
						g.fillRect(i * 50 + 52, j * 50 + 7, 2, 1);
						g.fillRect(i * 50 + 52, j * 50 + 8, 1, 1);
						g.fillRect(i * 50 + 6, j * 50 + 52, 1, 3);
						g.fillRect(i * 50 + 7, j * 50 + 52, 1, 2);
						g.fillRect(i * 50 + 8, j * 50 + 52, 1, 1);
						g.setColor(new Color(200, 200, 200));
						g.fillRect(i * 50 + 9, j * 50 + 52, 46, 3);
						g.fillRect(i * 50 + 52, j * 50 + 9, 3, 46);
						g.fillRect(i * 50 + 53, j * 50 + 8, 2, 1);
						g.fillRect(i * 50 + 54, j * 50 + 7, 1, 1);
						g.fillRect(i * 50 + 8, j * 50 + 53, 1, 2);
						g.fillRect(i * 50 + 7, j * 50 + 54, 1, 1);
						g.setColor(new Color(160, 160, 160));
						g.fillRect(i * 50 + 9, j * 50 + 9, 43, 43);
						break;
					
					case Config.NOTHING:
						g.setColor(new Color(100, 100, 100));
						g.fillRect(i * 50 + 6, j * 50 + 6, 46, 3);
						g.fillRect(i * 50 + 6, j * 50 + 6, 3, 46);
						g.fillRect(i * 50 + 52, j * 50 + 6, 3, 1);
						g.fillRect(i * 50 + 52, j * 50 + 7, 2, 1);
						g.fillRect(i * 50 + 52, j * 50 + 8, 1, 1);
						g.fillRect(i * 50 + 6, j * 50 + 52, 1, 3);
						g.fillRect(i * 50 + 7, j * 50 + 52, 1, 2);
						g.fillRect(i * 50 + 8, j * 50 + 52, 1, 1);
						g.setColor(new Color(200, 200, 200));
						g.fillRect(i * 50 + 9, j * 50 + 52, 46, 3);
						g.fillRect(i * 50 + 52, j * 50 + 9, 3, 46);
						g.fillRect(i * 50 + 53, j * 50 + 8, 2, 1);
						g.fillRect(i * 50 + 54, j * 50 + 7, 1, 1);
						g.fillRect(i * 50 + 8, j * 50 + 53, 1, 2);
						g.fillRect(i * 50 + 7, j * 50 + 54, 1, 1);
						g.setColor(new Color(190, 190, 190));
						g.fillRect(i * 50 + 9, j * 50 + 9, 43, 43);
						break;
					
					case Config.BOOM:
						g.setColor(new Color(100, 0, 0));
						g.fillRect(i * 50 + 6, j * 50 + 6, 46, 3);
						g.fillRect(i * 50 + 6, j * 50 + 6, 3, 46);
						g.fillRect(i * 50 + 52, j * 50 + 6, 3, 1);
						g.fillRect(i * 50 + 52, j * 50 + 7, 2, 1);
						g.fillRect(i * 50 + 52, j * 50 + 8, 1, 1);
						g.fillRect(i * 50 + 6, j * 50 + 52, 1, 3);
						g.fillRect(i * 50 + 7, j * 50 + 52, 1, 2);
						g.fillRect(i * 50 + 8, j * 50 + 52, 1, 1);
						g.setColor(new Color(200, 0, 0));
						g.fillRect(i * 50 + 9, j * 50 + 52, 46, 3);
						g.fillRect(i * 50 + 52, j * 50 + 9, 3, 46);
						g.fillRect(i * 50 + 53, j * 50 + 8, 2, 1);
						g.fillRect(i * 50 + 54, j * 50 + 7, 1, 1);
						g.fillRect(i * 50 + 8, j * 50 + 53, 1, 2);
						g.fillRect(i * 50 + 7, j * 50 + 54, 1, 1);
						g.setColor(new Color(190, 0, 0));
						g.fillRect(i * 50 + 9, j * 50 + 9, 43, 43);
						break;
						
					case Config.N1:
						g.setColor(new Color(200, 200, 200));
						g.fillRect(i * 50 + 6, j * 50 + 6, 46, 3);
						g.fillRect(i * 50 + 6, j * 50 + 6, 3, 46);
						g.fillRect(i * 50 + 52, j * 50 + 6, 3, 1);
						g.fillRect(i * 50 + 52, j * 50 + 7, 2, 1);
						g.fillRect(i * 50 + 52, j * 50 + 8, 1, 1);
						g.fillRect(i * 50 + 6, j * 50 + 52, 1, 3);
						g.fillRect(i * 50 + 7, j * 50 + 52, 1, 2);
						g.fillRect(i * 50 + 8, j * 50 + 52, 1, 1);
						g.setColor(new Color(100, 100, 100));
						g.fillRect(i * 50 + 9, j * 50 + 52, 46, 3);
						g.fillRect(i * 50 + 52, j * 50 + 9, 3, 46);
						g.fillRect(i * 50 + 53, j * 50 + 8, 2, 1);
						g.fillRect(i * 50 + 54, j * 50 + 7, 1, 1);
						g.fillRect(i * 50 + 8, j * 50 + 53, 1, 2);
						g.fillRect(i * 50 + 7, j * 50 + 54, 1, 1);
						g.setColor(new Color(160, 160, 160));
						g.fillRect(i * 50 + 9, j * 50 + 9, 43, 43);
						g.setColor(new Color(0, 0, 200));
						g.drawString("1", i * 50 + 25, j * 50 + 35);
						break;
						
					case Config.N2:
						g.setColor(new Color(200, 200, 200));
						g.fillRect(i * 50 + 6, j * 50 + 6, 46, 3);
						g.fillRect(i * 50 + 6, j * 50 + 6, 3, 46);
						g.fillRect(i * 50 + 52, j * 50 + 6, 3, 1);
						g.fillRect(i * 50 + 52, j * 50 + 7, 2, 1);
						g.fillRect(i * 50 + 52, j * 50 + 8, 1, 1);
						g.fillRect(i * 50 + 6, j * 50 + 52, 1, 3);
						g.fillRect(i * 50 + 7, j * 50 + 52, 1, 2);
						g.fillRect(i * 50 + 8, j * 50 + 52, 1, 1);
						g.setColor(new Color(100, 100, 100));
						g.fillRect(i * 50 + 9, j * 50 + 52, 46, 3);
						g.fillRect(i * 50 + 52, j * 50 + 9, 3, 46);
						g.fillRect(i * 50 + 53, j * 50 + 8, 2, 1);
						g.fillRect(i * 50 + 54, j * 50 + 7, 1, 1);
						g.fillRect(i * 50 + 8, j * 50 + 53, 1, 2);
						g.fillRect(i * 50 + 7, j * 50 + 54, 1, 1);
						g.setColor(new Color(160, 160, 160));
						g.fillRect(i * 50 + 9, j * 50 + 9, 43, 43);
						g.setColor(new Color(0, 200, 0));
						g.drawString("2", i * 50 + 25, j * 50 + 35);
						break;
						
					case Config.N3:
						g.setColor(new Color(200, 200, 200));
						g.fillRect(i * 50 + 6, j * 50 + 6, 46, 3);
						g.fillRect(i * 50 + 6, j * 50 + 6, 3, 46);
						g.fillRect(i * 50 + 52, j * 50 + 6, 3, 1);
						g.fillRect(i * 50 + 52, j * 50 + 7, 2, 1);
						g.fillRect(i * 50 + 52, j * 50 + 8, 1, 1);
						g.fillRect(i * 50 + 6, j * 50 + 52, 1, 3);
						g.fillRect(i * 50 + 7, j * 50 + 52, 1, 2);
						g.fillRect(i * 50 + 8, j * 50 + 52, 1, 1);
						g.setColor(new Color(100, 100, 100));
						g.fillRect(i * 50 + 9, j * 50 + 52, 46, 3);
						g.fillRect(i * 50 + 52, j * 50 + 9, 3, 46);
						g.fillRect(i * 50 + 53, j * 50 + 8, 2, 1);
						g.fillRect(i * 50 + 54, j * 50 + 7, 1, 1);
						g.fillRect(i * 50 + 8, j * 50 + 53, 1, 2);
						g.fillRect(i * 50 + 7, j * 50 + 54, 1, 1);
						g.setColor(new Color(160, 160, 160));
						g.fillRect(i * 50 + 9, j * 50 + 9, 43, 43);
						g.setColor(new Color(200, 0, 0));
						g.drawString("3", i * 50 + 25, j * 50 + 35);
						break;
						
					case Config.N4:
						g.setColor(new Color(200, 200, 200));
						g.fillRect(i * 50 + 6, j * 50 + 6, 46, 3);
						g.fillRect(i * 50 + 6, j * 50 + 6, 3, 46);
						g.fillRect(i * 50 + 52, j * 50 + 6, 3, 1);
						g.fillRect(i * 50 + 52, j * 50 + 7, 2, 1);
						g.fillRect(i * 50 + 52, j * 50 + 8, 1, 1);
						g.fillRect(i * 50 + 6, j * 50 + 52, 1, 3);
						g.fillRect(i * 50 + 7, j * 50 + 52, 1, 2);
						g.fillRect(i * 50 + 8, j * 50 + 52, 1, 1);
						g.setColor(new Color(100, 100, 100));
						g.fillRect(i * 50 + 9, j * 50 + 52, 46, 3);
						g.fillRect(i * 50 + 52, j * 50 + 9, 3, 46);
						g.fillRect(i * 50 + 53, j * 50 + 8, 2, 1);
						g.fillRect(i * 50 + 54, j * 50 + 7, 1, 1);
						g.fillRect(i * 50 + 8, j * 50 + 53, 1, 2);
						g.fillRect(i * 50 + 7, j * 50 + 54, 1, 1);
						g.setColor(new Color(160, 160, 160));
						g.fillRect(i * 50 + 9, j * 50 + 9, 43, 43);
						g.setColor(new Color(0, 200, 200));
						g.drawString("4", i * 50 + 25, j * 50 + 35);
						break;
						
					case Config.N5:
						g.setColor(new Color(200, 200, 200));
						g.fillRect(i * 50 + 6, j * 50 + 6, 46, 3);
						g.fillRect(i * 50 + 6, j * 50 + 6, 3, 46);
						g.fillRect(i * 50 + 52, j * 50 + 6, 3, 1);
						g.fillRect(i * 50 + 52, j * 50 + 7, 2, 1);
						g.fillRect(i * 50 + 52, j * 50 + 8, 1, 1);
						g.fillRect(i * 50 + 6, j * 50 + 52, 1, 3);
						g.fillRect(i * 50 + 7, j * 50 + 52, 1, 2);
						g.fillRect(i * 50 + 8, j * 50 + 52, 1, 1);
						g.setColor(new Color(100, 100, 100));
						g.fillRect(i * 50 + 9, j * 50 + 52, 46, 3);
						g.fillRect(i * 50 + 52, j * 50 + 9, 3, 46);
						g.fillRect(i * 50 + 53, j * 50 + 8, 2, 1);
						g.fillRect(i * 50 + 54, j * 50 + 7, 1, 1);
						g.fillRect(i * 50 + 8, j * 50 + 53, 1, 2);
						g.fillRect(i * 50 + 7, j * 50 + 54, 1, 1);
						g.setColor(new Color(160, 160, 160));
						g.fillRect(i * 50 + 9, j * 50 + 9, 43, 43);
						g.setColor(new Color(200, 200, 0));
						g.drawString("5", i * 50 + 25, j * 50 + 35);
						break;
						
					case Config.N6:
						g.setColor(new Color(200, 200, 200));
						g.fillRect(i * 50 + 6, j * 50 + 6, 46, 3);
						g.fillRect(i * 50 + 6, j * 50 + 6, 3, 46);
						g.fillRect(i * 50 + 52, j * 50 + 6, 3, 1);
						g.fillRect(i * 50 + 52, j * 50 + 7, 2, 1);
						g.fillRect(i * 50 + 52, j * 50 + 8, 1, 1);
						g.fillRect(i * 50 + 6, j * 50 + 52, 1, 3);
						g.fillRect(i * 50 + 7, j * 50 + 52, 1, 2);
						g.fillRect(i * 50 + 8, j * 50 + 52, 1, 1);
						g.setColor(new Color(100, 100, 100));
						g.fillRect(i * 50 + 9, j * 50 + 52, 46, 3);
						g.fillRect(i * 50 + 52, j * 50 + 9, 3, 46);
						g.fillRect(i * 50 + 53, j * 50 + 8, 2, 1);
						g.fillRect(i * 50 + 54, j * 50 + 7, 1, 1);
						g.fillRect(i * 50 + 8, j * 50 + 53, 1, 2);
						g.fillRect(i * 50 + 7, j * 50 + 54, 1, 1);
						g.setColor(new Color(160, 160, 160));
						g.fillRect(i * 50 + 9, j * 50 + 9, 43, 43);
						g.setColor(new Color(200, 0, 200));
						g.drawString("6", i * 50 + 25, j * 50 + 35);
						break;
						
					case Config.N7:
						g.setColor(new Color(200, 200, 200));
						g.fillRect(i * 50 + 6, j * 50 + 6, 46, 3);
						g.fillRect(i * 50 + 6, j * 50 + 6, 3, 46);
						g.fillRect(i * 50 + 52, j * 50 + 6, 3, 1);
						g.fillRect(i * 50 + 52, j * 50 + 7, 2, 1);
						g.fillRect(i * 50 + 52, j * 50 + 8, 1, 1);
						g.fillRect(i * 50 + 6, j * 50 + 52, 1, 3);
						g.fillRect(i * 50 + 7, j * 50 + 52, 1, 2);
						g.fillRect(i * 50 + 8, j * 50 + 52, 1, 1);
						g.setColor(new Color(100, 100, 100));
						g.fillRect(i * 50 + 9, j * 50 + 52, 46, 3);
						g.fillRect(i * 50 + 52, j * 50 + 9, 3, 46);
						g.fillRect(i * 50 + 53, j * 50 + 8, 2, 1);
						g.fillRect(i * 50 + 54, j * 50 + 7, 1, 1);
						g.fillRect(i * 50 + 8, j * 50 + 53, 1, 2);
						g.fillRect(i * 50 + 7, j * 50 + 54, 1, 1);
						g.setColor(new Color(160, 160, 160));
						g.fillRect(i * 50 + 9, j * 50 + 9, 43, 43);
						g.setColor(new Color(200, 200, 200));
						g.drawString("7", i * 50 + 25, j * 50 + 35);
						break;
						
					case Config.N8:
						g.setColor(new Color(200, 200, 200));
						g.fillRect(i * 50 + 6, j * 50 + 6, 46, 3);
						g.fillRect(i * 50 + 6, j * 50 + 6, 3, 46);
						g.fillRect(i * 50 + 52, j * 50 + 6, 3, 1);
						g.fillRect(i * 50 + 52, j * 50 + 7, 2, 1);
						g.fillRect(i * 50 + 52, j * 50 + 8, 1, 1);
						g.fillRect(i * 50 + 6, j * 50 + 52, 1, 3);
						g.fillRect(i * 50 + 7, j * 50 + 52, 1, 2);
						g.fillRect(i * 50 + 8, j * 50 + 52, 1, 1);
						g.setColor(new Color(100, 100, 100));
						g.fillRect(i * 50 + 9, j * 50 + 52, 46, 3);
						g.fillRect(i * 50 + 52, j * 50 + 9, 3, 46);
						g.fillRect(i * 50 + 53, j * 50 + 8, 2, 1);
						g.fillRect(i * 50 + 54, j * 50 + 7, 1, 1);
						g.fillRect(i * 50 + 8, j * 50 + 53, 1, 2);
						g.fillRect(i * 50 + 7, j * 50 + 54, 1, 1);
						g.setColor(new Color(160, 160, 160));
						g.fillRect(i * 50 + 9, j * 50 + 9, 43, 43);
						g.setColor(new Color(255, 200, 200));
						g.drawString("8", i * 50 + 25, j * 50 + 35);
						break;
						
					case Config.MARKED:
						g.setColor(new Color(0, 200, 0));
						g.fillRect(i * 50 + 6, j * 50 + 6, 46, 3);
						g.fillRect(i * 50 + 6, j * 50 + 6, 3, 46);
						g.fillRect(i * 50 + 52, j * 50 + 6, 3, 1);
						g.fillRect(i * 50 + 52, j * 50 + 7, 2, 1);
						g.fillRect(i * 50 + 52, j * 50 + 8, 1, 1);
						g.fillRect(i * 50 + 6, j * 50 + 52, 1, 3);
						g.fillRect(i * 50 + 7, j * 50 + 52, 1, 2);
						g.fillRect(i * 50 + 8, j * 50 + 52, 1, 1);
						g.setColor(new Color(0, 100, 0));
						g.fillRect(i * 50 + 9, j * 50 + 52, 46, 3);
						g.fillRect(i * 50 + 52, j * 50 + 9, 3, 46);
						g.fillRect(i * 50 + 53, j * 50 + 8, 2, 1);
						g.fillRect(i * 50 + 54, j * 50 + 7, 1, 1);
						g.fillRect(i * 50 + 8, j * 50 + 53, 1, 2);
						g.fillRect(i * 50 + 7, j * 50 + 54, 1, 1);
						g.setColor(new Color(0, 160, 0));
						g.fillRect(i * 50 + 9, j * 50 + 9, 43, 43);
						break;
						
					default:
						break;
				}
			}
		}
	}
	
	public void board(Graphics g) {
		paint(g);
	}
}
