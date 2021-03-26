package com.duwenxi.game1;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import com.duwenxi.log.Level;
import com.duwenxi.log.StaticLog;

public class Clicker implements MouseListener {
	
	private MainCanvas c;
	private GridType[] gameBoard;

	public Clicker(MainCanvas c, GridType[] gameBoard) {
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
				int block = (int)((arg0.getX() - 6) / 50) * 10 + (int)((arg0.getY() - 6) / 50);
				if(c.types[block] == GridType.EMPTY) {
					c.types[block] = GridType.CLICKED;
					c.paint(c.getGraphics());
				}
			}
		} catch(ArrayIndexOutOfBoundsException e) {
			StaticLog.log(Level.WARN, "Clicked out of the girds");
		}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		try {
			if(arg0.getButton() == MouseEvent.BUTTON1) {
				int block = (int)((arg0.getX() - 6) / 50) * 10 + (int)((arg0.getY() - 6) / 50);
				if(c.types[block] == GridType.MARKED) {
					return;
				}
				c.types[block] = GridType.NOTHING;
				if(gameBoard[block] == GridType.BOOM) {
					if(c.firstclick) {
						for(int i = 0; i < 100; i++) {
							gameBoard[i] = GridType.NOTHING;
						}
						Tool.newBoard(gameBoard);
						c.reset();
						c.paint(c.getGraphics());
						again(block);
						return;
					} else {
						c.types[block] = GridType.BOOM;
						Tool.clickBoom(gameBoard, c.types);
						c.lose = true;
						c.paint(c.getGraphics());
						return;
					}
				}
				c.firstclick = false;
				for(int i = 0; i < 8; i++) {
					if(block % 10 == 0) {
						if(i == 0 || i == 3 || i == 5) {
							continue;
						}
					}
					if(block % 10 == 9) {
						if(i == 2 || i == 4 || i == 7) {
							continue;
						}
					}
					if(block + Config.AROUND[i] >= 0 && block + Config.AROUND[i] < 100) {
						if(gameBoard[block + Config.AROUND[i]] == GridType.BOOM) {
							c.types[block] = GridType.values()[c.types[block].ordinal() + 1];
						}
					}
				}
				if(c.types[block] == GridType.NOTHING) {
					for(int i = 0; i < 8; i++) {
						if(block % 10 == 0) {
							if(i == 0 || i == 3 || i == 5) {
								continue;
							}
						}
						if(block % 10 == 9) {
							if(i == 2 || i == 4 || i == 7) {
								continue;
							}
						}
						if(block + Config.AROUND[i] >= 0 && block + Config.AROUND[i] < 100) {
							if(c.types[block + Config.AROUND[i]] != GridType.NOTHING) {
								this.again(block + Config.AROUND[i]);
							}
						}
					}
				}
				c.win = Tool.isWin(gameBoard, c.types);
			} else if(arg0.getButton() == MouseEvent.BUTTON3) {
				int block = (int)((arg0.getX() - 6) / 50) * 10 + (int)((arg0.getY() - 6) / 50);
				if(c.types[block] == GridType.EMPTY) {
					c.types[block] = GridType.MARKED;
				} else if(c.types[block] == GridType.MARKED) {
					c.types[block] = GridType.EMPTY;
				}
			}
			StaticLog.log(Level.LOG, String.format("Block %d loaded: %s", (int)((arg0.getX() - 6) / 50) * 10 + (int)((arg0.getY() - 6) / 50), c.types[(int)((arg0.getX() - 6) / 50) * 10 + (int)((arg0.getY() - 6) / 50)].name()));
			c.paint(c.getGraphics());
		} catch(ArrayIndexOutOfBoundsException e) {
			StaticLog.log(Level.WARN, "Clicked out of the girds");
		}
	}
	
	private void again(int block) {
		if(c.types[block] == GridType.MARKED) {
			return;
		}
		c.types[block] = GridType.NOTHING;
		for(int i = 0; i < 8; i++) {
			if(block % 10 == 0) {
				if(i == 0 || i == 3 || i == 5) {
					continue;
				}
			}
			if(block % 10 == 9) {
				if(i == 2 || i == 4 || i == 7) {
					continue;
				}
			}
			if(block + Config.AROUND[i] >= 0 && block + Config.AROUND[i] < 100) {
				if(gameBoard[block + Config.AROUND[i]] == GridType.BOOM) {
					c.types[block] = GridType.values()[c.types[block].ordinal() + 1];
				}
			}
		}
		if(c.types[block] == GridType.NOTHING) {
			for(int i = 0; i < 8; i++) {
				if(block % 10 == 0) {
					if(i == 0 || i == 3 || i == 5) {
						continue;
					}
				}
				if(block % 10 == 9) {
					if(i == 2 || i == 4 || i == 7) {
						continue;
					}
				}
				if(block + Config.AROUND[i] >= 0 && block + Config.AROUND[i] < 100) {
					if(c.types[block + Config.AROUND[i]] != GridType.NOTHING) {
						this.again(block + Config.AROUND[i]);
					}
				}
			}
		}
		c.win = Tool.isWin(gameBoard, c.types);
		StaticLog.log(Level.LOG, String.format("Block %d loaded: %s", block, c.types[block].name()));
	}
}
