package com.duwenxi.game1;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Clicker implements MouseListener {
	
	private MainCanvas c;
	private int[] gameBoard;

	public Clicker(MainCanvas c, int[] gameBoard) {
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
		if(arg0.getButton() == MouseEvent.BUTTON1) {
			int block = (int)((arg0.getX() - 6) / 50) * 10 + (int)((arg0.getY() - 6) / 50);
			if(c.types[block] == Config.EMPTY) {
				c.types[block] = Config.CLICKED;
				c.paint(c.getGraphics());
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		if(arg0.getButton() == MouseEvent.BUTTON1) {
			int block = (int)((arg0.getX() - 6) / 50) * 10 + (int)((arg0.getY() - 6) / 50);
			if(c.types[block] == Config.MARKED) {
				return;
			}
			c.types[block] = Config.NOTHING;
			if(gameBoard[block] == Config.BOOM) {
				c.types[block] = Config.BOOM;
				c.paint(c.getGraphics());
				return;
			}
			for(int i = 0; i < 8; i++) {
				if(block % 10 == 0) {
					if(Config.AROUND[i] == -11 || Config.AROUND[i] == -1 || Config.AROUND[i] == 9) {
						continue;
					}
				}
				if(block % 10 == 9) {
					if(Config.AROUND[i] == -9 || Config.AROUND[i] == 1 || Config.AROUND[i] == 11) {
						continue;
					}
				}
				if(block + Config.AROUND[i] >= 0 && block + Config.AROUND[i] < 100) {
					if(gameBoard[block + Config.AROUND[i]] == Config.BOOM) {
						c.types[block]++;
					}
				}
			}
			if(c.types[block] == Config.NOTHING) {
				for(int i = 0; i < 8; i++) {
					if(block % 10 == 0) {
						if(Config.AROUND[i] == -11 || Config.AROUND[i] == -1 || Config.AROUND[i] == 9) {
							continue;
						}
					}
					if(block % 10 == 9) {
						if(Config.AROUND[i] == -9 || Config.AROUND[i] == 1 || Config.AROUND[i] == 11) {
							continue;
						}
					}
					if(block + Config.AROUND[i] >= 0 && block + Config.AROUND[i] < 100) {
						if(c.types[block + Config.AROUND[i]] != Config.NOTHING) {
							this.again(block + Config.AROUND[i]);
						}
					}
				}
			}
		} else if(arg0.getButton() == MouseEvent.BUTTON3) {
			int block = (int)((arg0.getX() - 6) / 50) * 10 + (int)((arg0.getY() - 6) / 50);
			if(c.types[block] == Config.EMPTY) {
				c.types[block] = Config.MARKED;
			} else if(c.types[block] == Config.MARKED) {
				c.types[block] = Config.EMPTY;
			}
		}
		c.paint(c.getGraphics());
	}
	
	private void again(int block) {
		if(c.types[block] == Config.MARKED) {
			return;
		}
		c.types[block] = Config.NOTHING;
		if(gameBoard[block] == Config.BOOM) {
			c.types[block] = Config.BOOM;
			c.paint(c.getGraphics());
			return;
		}
		for(int i = 0; i < 8; i++) {
			if(block % 10 == 0) {
				if(Config.AROUND[i] == -11 || Config.AROUND[i] == -1 || Config.AROUND[i] == 9) {
					continue;
				}
			}
			if(block % 10 == 9) {
				if(Config.AROUND[i] == -9 || Config.AROUND[i] == 1 || Config.AROUND[i] == 11) {
					continue;
				}
			}
			if(block + Config.AROUND[i] >= 0 && block + Config.AROUND[i] < 100) {
				if(gameBoard[block + Config.AROUND[i]] == Config.BOOM) {
					c.types[block]++;
				}
			}
		}
		if(c.types[block] == Config.NOTHING) {
			for(int i = 0; i < 8; i++) {
				if(block % 10 == 0) {
					if(Config.AROUND[i] == -11 || Config.AROUND[i] == -1 || Config.AROUND[i] == 9) {
						continue;
					}
				}
				if(block % 10 == 9) {
					if(Config.AROUND[i] == -9 || Config.AROUND[i] == 1 || Config.AROUND[i] == 11) {
						continue;
					}
				}
				if(block + Config.AROUND[i] >= 0 && block + Config.AROUND[i] < 100) {
					if(c.types[block + Config.AROUND[i]] != Config.NOTHING) {
						this.again(block + Config.AROUND[i]);
					}
				}
			}
		}
	}
}
