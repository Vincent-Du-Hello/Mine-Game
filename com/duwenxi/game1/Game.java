package com.duwenxi.game1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Menu;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Frame;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.util.ArrayList;
import com.duwenxi.log.Level;
import com.duwenxi.log.StaticLog;

public class Game extends Frame{
	private static final long serialVersionUID = -5024830007105674946L;
	
	public MainCanvas c;
	public Graphics g;
	public MenuBar b;
	public ArrayList<ArrayList<GridType>> gameBoard = new ArrayList<ArrayList<GridType>>();

	public static void main(String[] args) {
		new Game();
	}
	
	private Game() {
		prepare();
		reset();
	}
	
	private void prepare() {
		StaticLog.log(Level.INFO, "Prepareing.");
		for(int i = 0; i < Config.WIDTH; i++) {
			ArrayList<GridType> col = new ArrayList<GridType>();
			for(int j = 0; j < Config.HEIGHT; j++) {
				col.add(GridType.EMPTY);
			}
			gameBoard.add(col);
		}
		Menu templv0;
		MenuItem templv1i;
		b = new MenuBar();
		templv0 = new Menu();
		templv0.setLabel("游戏");
		templv1i = new MenuItem("", new MenuShortcut(KeyEvent.VK_R));
		templv1i.setLabel("重新开始");
		templv1i.addActionListener(new Restarter(this));
		templv0.add(templv1i);
		templv1i = new Menu();
		templv1i.setLabel("设置雷数（调试功能）");
		templv1i.addActionListener(new BoomSetter(this));
		templv0.add(templv1i);
		b.add(templv0);
		templv0 = new Menu();
		templv0.setLabel("显示");
		templv1i = new Menu();
		templv1i.setLabel("设置材质");
		templv1i.addActionListener(new TextureSetter(this));
		templv0.add(templv1i);
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
		StaticLog.log(Level.INFO, "Prepared.");
	}
	
	public void reset() {
		Tool.newBoard(gameBoard);
		Tool.updateConfig();
		c.reset();
		c.reload();
		this.setSize(Config.WIDTH * Config.GRIDSIZE + 12, Config.HEIGHT * Config.GRIDSIZE + 52);
	}
}
