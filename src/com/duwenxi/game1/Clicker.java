package com.duwenxi.game1;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import com.duwenxi.log.Level;
import com.duwenxi.log.StaticLog;

public class Clicker implements MouseListener {
	
	private MainCanvas c;
	private ArrayList<ArrayList<GridType>> gameBoard;

	public Clicker(MainCanvas c, ArrayList<ArrayList<GridType>> gameBoard) {
		this.c = c;
		this.gameBoard = gameBoard;
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {}

	@Override
	public void mouseEntered(MouseEvent arg0) {}

	@Override
	public void mouseExited(MouseEvent arg0) {}

	@Override
	public void mousePressed(MouseEvent arg0) {
		try {
			if(arg0.getButton() == MouseEvent.BUTTON1) {
				int x = (int)((arg0.getX() - 6) / Config.GRIDSIZE);
				int y = (int)((arg0.getY() - 6) / Config.GRIDSIZE);
				if(c.types.get(x).get(y) == GridType.EMPTY) {
					c.types.get(x).set(y, GridType.CLICKED);
					c.paint(c.getGraphics());
				}
			}
		} catch(ArrayIndexOutOfBoundsException e) {
			StaticLog.log(Level.WARN, "Clicked out of the girds");
		}
	}

	@SuppressWarnings("deprecation")
	@Override
	public void mouseReleased(MouseEvent arg0) {
		try {
			Config.CLICKSND.play();
			if(arg0.getButton() == MouseEvent.BUTTON1) {
				int x = (int)((arg0.getX() - 6) / Config.GRIDSIZE);
				int y = (int)((arg0.getY() - 6) / Config.GRIDSIZE);
				if(c.types.get(x).get(y) == GridType.MARKED) {
					return;
				}
				c.types.get(x).set(y, GridType.NOTHING);
				if(gameBoard.get(x).get(y) == GridType.BOOM) {
					if(c.firstclick) {
						c.reset();
						c.paint(c.getGraphics());
						Tool.newBoard(gameBoard);
						again2(x, y);
						StaticLog.log(Level.INFO, String.format("Block at x:%s, y:%s loaded: %s", x, y, c.types.get(x).get(y).name()));
						return;
					} else {
						c.types.get(x).set(y, GridType.BOOM);
						Tool.clickBoom(gameBoard, c.types);
						c.win = false;
						c.lose = true;
						c.paint(c.getGraphics());
						StaticLog.log(Level.INFO, String.format("Block at x:%s, y:%s loaded: %s", x, y, c.types.get(x).get(y).name()));
						return;
					}
				}
				c.firstclick = false;
				for(int i = 0; i < 8; i++) {
					if(x + Consts.AROUND[i][0] < 0 || x + Consts.AROUND[i][0] >= Config.WIDTH || y + Consts.AROUND[i][1] < 0 || y + Consts.AROUND[i][1] >= Config.HEIGHT) {
						continue;
					}
					if(gameBoard.get(x + Consts.AROUND[i][0]).get(y + Consts.AROUND[i][1]) == GridType.BOOM) {
						c.types.get(x).set(y, GridType.values()[c.types.get(x).get(y).ordinal() + 1]);
					}
				}
				if(c.types.get(x).get(y) == GridType.NOTHING) {
					for(int i = 0; i < 8; i++) {
						if(x + Consts.AROUND[i][0] < 0 || x + Consts.AROUND[i][0] >= Config.WIDTH || y + Consts.AROUND[i][1] < 0 || y + Consts.AROUND[i][1] >= Config.HEIGHT) {
							continue;
						}
						if(c.types.get(x + Consts.AROUND[i][0]).get(y + Consts.AROUND[i][1]) != GridType.NOTHING) {
							this.again(x + Consts.AROUND[i][0], y + Consts.AROUND[i][1]);
						}
					}
				}
				c.win = Tool.isWin(gameBoard, c.types);
			} else if(arg0.getButton() == MouseEvent.BUTTON3) {
				int x = (int)((arg0.getX() - 6) / Config.GRIDSIZE);
				int y = (int)((arg0.getY() - 6) / Config.GRIDSIZE);
				if(c.types.get(x).get(y) == GridType.EMPTY) {
					c.types.get(x).set(y, GridType.MARKED);
				} else if(c.types.get(x).get(y) == GridType.MARKED) {
					c.types.get(x).set(y, GridType.EMPTY);
				}
			}
			int x = (int)((arg0.getX() - 6) / Config.GRIDSIZE);
			int y = (int)((arg0.getY() - 6) / Config.GRIDSIZE);
			StaticLog.log(Level.INFO, String.format("Block at x:%s, y:%s loaded: %s", x, y, c.types.get(x).get(y).name()));
			c.paint(c.getGraphics());
		} catch(ArrayIndexOutOfBoundsException e) {
			StaticLog.log(Level.WARN, "Clicked out of the girds");
		}
	}
	
	private void again(int x, int y) {
		if(c.types.get(x).get(y) == GridType.MARKED) {
			return;
		}
		c.types.get(x).set(y, GridType.NOTHING);
		for(int i = 0; i < 8; i++) {
			if(x + Consts.AROUND[i][0] < 0 || x + Consts.AROUND[i][0] >= Config.WIDTH || y + Consts.AROUND[i][1] < 0 || y + Consts.AROUND[i][1] >= Config.HEIGHT) {
				continue;
			}
			if(gameBoard.get(x + Consts.AROUND[i][0]).get(y + Consts.AROUND[i][1]) == GridType.BOOM) {
				c.types.get(x).set(y, GridType.values()[c.types.get(x).get(y).ordinal() + 1]);
			}
		}
		if(c.types.get(x).get(y) == GridType.NOTHING) {
			for(int i = 0; i < 8; i++) {
				if(x + Consts.AROUND[i][0] < 0 || x + Consts.AROUND[i][0] >= Config.WIDTH || y + Consts.AROUND[i][1] < 0 || y + Consts.AROUND[i][1] >= Config.HEIGHT) {
					continue;
				}
				if(c.types.get(x + Consts.AROUND[i][0]).get(y + Consts.AROUND[i][1]) != GridType.NOTHING) {
					this.again(x + Consts.AROUND[i][0], y + Consts.AROUND[i][1]);
				}
			}
		}
		c.win = Tool.isWin(gameBoard, c.types);
		StaticLog.log(Level.INFO, String.format("Block at x:%s, y:%s loaded: %s", x, y, c.types.get(x).get(y).name()));
	}
	
	private void again2(int x, int y) {
		if(c.types.get(x).get(y) == GridType.MARKED) {
			return;
		}
		c.types.get(x).set(y, GridType.NOTHING);
		if(gameBoard.get(x).get(y) == GridType.BOOM) {
			if(c.firstclick) {
				c.reset();
				Tool.newBoard(gameBoard);
				boolean ok = false;
				while(!ok) {
					ok = true;
					try {
						again2(x, y);
					} catch(StackOverflowError e) {
						StaticLog.log(Level.WARN, "Stack Overflow");
					}
				}
				c.paint(c.getGraphics());
				StaticLog.log(Level.INFO, String.format("Block at x:%s, y:%s loaded: %s", x, y, c.types.get(x).get(y).name()));
				return;
			} else {
				c.types.get(x).set(y, GridType.BOOM);
				Tool.clickBoom(gameBoard, c.types);
				c.win = false;
				c.lose = true;
				c.paint(c.getGraphics());
				StaticLog.log(Level.INFO, String.format("Block at x:%s, y:%s loaded: %s", x, y, c.types.get(x).get(y).name()));
				return;
			}
		}
		c.firstclick = false;
		for(int i = 0; i < 8; i++) {
			if(x + Consts.AROUND[i][0] < 0 || x + Consts.AROUND[i][0] >= Config.WIDTH || y + Consts.AROUND[i][1] < 0 || y + Consts.AROUND[i][1] >= Config.HEIGHT) {
				continue;
			}
			if(gameBoard.get(x + Consts.AROUND[i][0]).get(y + Consts.AROUND[i][1]) == GridType.BOOM) {
				c.types.get(x).set(y, GridType.values()[c.types.get(x).get(y).ordinal() + 1]);
			}
		}
		if(c.types.get(x).get(y) == GridType.NOTHING) {
			for(int i = 0; i < 8; i++) {
				if(x + Consts.AROUND[i][0] < 0 || x + Consts.AROUND[i][0] >= Config.WIDTH || y + Consts.AROUND[i][1] < 0 || y + Consts.AROUND[i][1] >= Config.HEIGHT) {
					continue;
				}
				if(c.types.get(x + Consts.AROUND[i][0]).get(y + Consts.AROUND[i][1]) != GridType.NOTHING) {
					this.again(x + Consts.AROUND[i][0], y + Consts.AROUND[i][1]);
				}
			}
		}
		c.win = Tool.isWin(gameBoard, c.types);
		StaticLog.log(Level.INFO, String.format("Block at x:%s, y:%s loaded: %s", x, y, c.types.get(x).get(y).name()));
	}
}
