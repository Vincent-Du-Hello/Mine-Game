package com.duwenxi.game1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Menu;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Frame;
import java.awt.MenuBar;
import java.util.Arrays;

import com.duwenxi.log.Level;
import com.duwenxi.log.StaticLog;

public class Game extends Frame{
	
	private static final long serialVersionUID = 1L;
	private MainCanvas c;
	private Graphics g;
	private MenuBar b;
	public GridType[] gameBoard = {};

	public static void main(String[] args) {
		new Game();
	}
	
	private Game() {
		prepare();
		block(c, g);
	}
	
	private void prepare() {
		StaticLog.log(Level.LOG, "Prepareing.");
		gameBoard = Arrays.copyOf(gameBoard, 100);
		for(int i = 0; i < 100; i++) {
			gameBoard[i] = GridType.NOTHING;
		}
		Tool.newBoard(gameBoard);
		Menu templv0;
		Menu templv1;
		b = new MenuBar();
		templv0 = new Menu();
		templv0.setLabel("游戏");
		templv1 = new Menu();
		templv1.setLabel("重新开始");
		templv1.addActionListener(new Restarter(this));
		templv0.add(templv1);
		b.add(templv0);
		this.setMenuBar(b);
		c = new MainCanvas(gameBoard);
		c.setSize(512, 512);
		c.setBackground(new Color(255, 255, 255));
		this.setLocation(400, 300);
		this.setSize(512, 552);
		this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
		this.add(c);
		this.setVisible(true);
		this.setResizable(false);
		g = c.getGraphics();
		StaticLog.log(Level.LOG, "Prepared.");
	}
	
	public void reset() {
		for(int i = 0; i < 100; i++) {
			gameBoard[i] = GridType.NOTHING;
		}
		Tool.newBoard(gameBoard);
		c.reset();
		c.paint(g);
	}
	
	private void block(MainCanvas c, Graphics g) {
		c.board(g);
	}
}
