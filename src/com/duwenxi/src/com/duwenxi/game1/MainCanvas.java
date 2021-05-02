package com.duwenxi.game1;

import java.awt.Canvas;
import java.awt.Graphics;
import java.util.ArrayList;
 
public class MainCanvas extends Canvas {
	private static final long serialVersionUID = -196445182727927965L;

	public ArrayList<ArrayList<GridType>> types = new ArrayList<ArrayList<GridType>>();
	
	public boolean firstclick = true;
	public boolean win = false;
	public boolean lose = false;
	
	public MainCanvas(ArrayList<ArrayList<GridType>> gameBoard) {
		types.clear();
		for(int i = 0; i < Config.WIDTH; i++) {
			ArrayList<GridType> col = new ArrayList<GridType>();
			for(int j = 0; j < Config.HEIGHT; j++) {
				col.add(GridType.EMPTY);
			}
			types.add(col);
		}
		for(int i = 0; i < Config.WIDTH; i++) {
			for(int j = 0; j < Config.HEIGHT; j++) {
				types.get(i).set(j, GridType.EMPTY);
			}
		}
		this.addMouseListener(new Clicker(this, gameBoard));
	}
	
	public void reset() {
		types.clear();
		for(int i = 0; i < Config.WIDTH; i++) {
			ArrayList<GridType> col = new ArrayList<GridType>();
			for(int j = 0; j < Config.HEIGHT; j++) {
				col.add(GridType.EMPTY);
			}
			types.add(col);
		}
		firstclick = true;
		for(int i = 0; i < Config.WIDTH; i++) {
			for(int j = 0; j < Config.HEIGHT; j++) {
				types.get(i).set(j, GridType.EMPTY);
			}
		}
		win = false;
		lose = false;
		reload();
	}
	
	public void reload() {
		this.setSize(Config.WIDTH * Config.GRIDSIZE + 12, Config.HEIGHT * Config.GRIDSIZE + 12);
		paint(this.getGraphics());
	}
	
	@Override
	public void repaint() {
		Graphics g = this.getGraphics();
		update(g);
	}
 
	@Override
	public void paint(Graphics g) {
		for(int i = 0; i < Config.WIDTH; i++) {
			for(int j = 0; j < Config.HEIGHT; j++) {
				switch(types.get(i).get(j)) {
					case EMPTY:
						g.drawImage(Config.EMPTYIMG, i*Config.GRIDSIZE+6, j*Config.GRIDSIZE+6, Config.GRIDSIZE, Config.GRIDSIZE, null);
						break;
					
					case CLICKED:
						g.drawImage(Config.CLICKEDIMG, i*Config.GRIDSIZE+6, j*Config.GRIDSIZE+6, Config.GRIDSIZE, Config.GRIDSIZE, null);
						break;
					
					case NOTHING:
						g.drawImage(Config.NOTHINGIMG, i*Config.GRIDSIZE+6, j*Config.GRIDSIZE+6, Config.GRIDSIZE, Config.GRIDSIZE, null);
						break;
					
					case BOOM:
						g.drawImage(Config.BOOMIMG, i*Config.GRIDSIZE+6, j*Config.GRIDSIZE+6, Config.GRIDSIZE, Config.GRIDSIZE, null);
						break;
						
					case N1:
						g.drawImage(Config.N1IMG, i*Config.GRIDSIZE+6, j*Config.GRIDSIZE+6, Config.GRIDSIZE, Config.GRIDSIZE, null);
						break;
						
					case N2:
						g.drawImage(Config.N2IMG, i*Config.GRIDSIZE+6, j*Config.GRIDSIZE+6, Config.GRIDSIZE, Config.GRIDSIZE, null);
						break;
						
					case N3:
						g.drawImage(Config.N3IMG, i*Config.GRIDSIZE+6, j*Config.GRIDSIZE+6, Config.GRIDSIZE, Config.GRIDSIZE, null);
						break;
						
					case N4:
						g.drawImage(Config.N4IMG, i*Config.GRIDSIZE+6, j*Config.GRIDSIZE+6, Config.GRIDSIZE, Config.GRIDSIZE, null);
						break;
						
					case N5:
						g.drawImage(Config.N5IMG, i*Config.GRIDSIZE+6, j*Config.GRIDSIZE+6, Config.GRIDSIZE, Config.GRIDSIZE, null);
						break;
						
					case N6:
						g.drawImage(Config.N6IMG, i*Config.GRIDSIZE+6, j*Config.GRIDSIZE+6, Config.GRIDSIZE, Config.GRIDSIZE, null);
						break;
						
					case N7:
						g.drawImage(Config.N7IMG, i*Config.GRIDSIZE+6, j*Config.GRIDSIZE+6, Config.GRIDSIZE, Config.GRIDSIZE, null);
						break;
						
					case N8:
						g.drawImage(Config.N8IMG, i*Config.GRIDSIZE+6, j*Config.GRIDSIZE+6, Config.GRIDSIZE, Config.GRIDSIZE, null);
						break;
						
					case MARKED:
						g.drawImage(Config.MARKEDIMG, i*Config.GRIDSIZE+6, j*Config.GRIDSIZE+6, Config.GRIDSIZE, Config.GRIDSIZE, null);
						break;
						
					default:
						break;
				}
			}
		}
		if(win) {
			g.drawImage(Config.WINIMG, 6, 6, Config.GRIDSIZE * Config.WIDTH, Config.GRIDSIZE * Config.HEIGHT, null);
		}
		if(lose) {
			g.drawImage(Config.LOSEIMG, 6, 6, Config.GRIDSIZE * Config.WIDTH, Config.GRIDSIZE * Config.HEIGHT, null);
		}
	}
}
