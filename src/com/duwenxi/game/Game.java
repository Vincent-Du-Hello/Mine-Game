package com.duwenxi.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Frame;
import java.util.Arrays;

public class Game extends Frame{
	
	private static final long serialVersionUID = 1L;
	private MainCanvas c;
	public int[] gameBoard = {};

	public static void main(String[] args) {
		new Game();
	}
	
	public Game() {
		gameBoard = Arrays.copyOf(gameBoard, 100);
		for(int i = 0; i < 100; i++) {
			gameBoard[i] = Config.NOTHING;
		}
		new Start(gameBoard);
		c = new MainCanvas(gameBoard);
		c.setSize(512, 512);
		c.setBackground(new Color(255, 255, 255));
		this.setLocation(400, 300);
		this.setSize(512, 532);
		this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
		this.add(c);
		this.setVisible(true);
		this.setResizable(true);
		Graphics g = c.getGraphics();
		block(c, g);
	}
	
	public void block(MainCanvas c, Graphics g) {
		c.board(g);
	}
}
