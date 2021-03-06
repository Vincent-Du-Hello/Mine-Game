package com.duwenxi.game1;

import com.duwenxi.log.Level;
import com.duwenxi.log.StaticLog;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Image;
import javax.imageio.ImageIO;

@SuppressWarnings("deprecation")
public final class Config {
	
	public static int BOOMCOUNT = 10;
	public static int GRIDSIZE = 20;
	public static int WIDTH = 10;
	public static int HEIGHT = 10;
	
	public static int[] AROUND = {-11, -10, -9, -1, 1, 9, 10, 11};
	
	public static Image EMPTYIMG;
	public static Image CLICKEDIMG;
	public static Image MARKEDIMG;
	public static Image NOTHINGIMG;
	public static Image N1IMG;
	public static Image N2IMG;
	public static Image N3IMG;
	public static Image N4IMG;
	public static Image N5IMG;
	public static Image N6IMG;
	public static Image N7IMG;
	public static Image N8IMG;
	public static Image BOOMIMG;
	public static Image WINIMG;
	public static Image LOSEIMG;

	public static AudioClip CLICKSND;
	public static AudioClip BOOMSND;
	public static AudioClip WINSND;
	static {
		StaticLog.log(Level.INFO, "Start loading images.");
		try {
			EMPTYIMG = ImageIO.read(Config.class.getResource("/com/duwenxi/img/empty.png"));
			CLICKEDIMG = ImageIO.read(Config.class.getResource("/com/duwenxi/img/clicked.png"));
			MARKEDIMG = ImageIO.read(Config.class.getResource("/com/duwenxi/img/marked.png"));
			NOTHINGIMG = ImageIO.read(Config.class.getResource("/com/duwenxi/img/nothing.png"));
			N1IMG = ImageIO.read(Config.class.getResource("/com/duwenxi/img/n1.png"));
			N2IMG = ImageIO.read(Config.class.getResource("/com/duwenxi/img/n2.png"));
			N3IMG = ImageIO.read(Config.class.getResource("/com/duwenxi/img/n3.png"));
			N4IMG = ImageIO.read(Config.class.getResource("/com/duwenxi/img/n4.png"));
			N5IMG = ImageIO.read(Config.class.getResource("/com/duwenxi/img/n5.png"));
			N6IMG = ImageIO.read(Config.class.getResource("/com/duwenxi/img/n6.png"));
			N7IMG = ImageIO.read(Config.class.getResource("/com/duwenxi/img/n7.png"));
			N8IMG = ImageIO.read(Config.class.getResource("/com/duwenxi/img/n8.png"));
			BOOMIMG = ImageIO.read(Config.class.getResource("/com/duwenxi/img/boom.png"));
			WINIMG = ImageIO.read(Config.class.getResource("/com/duwenxi/img/win.png"));
			LOSEIMG = ImageIO.read(Config.class.getResource("/com/duwenxi/img/lose.png"));
			
			CLICKSND = Applet.newAudioClip(Config.class.getResource("/com/duwenxi/sound/click.wav"));
			BOOMSND = Applet.newAudioClip(Config.class.getResource("/com/duwenxi/sound/boom.wav"));
			WINSND = Applet.newAudioClip(Config.class.getResource("/com/duwenxi/sound/win.wav"));
		} catch (Exception e) {
			StaticLog.log(Level.ERROR, "Exception!");
			e.printStackTrace();
		}
		StaticLog.log(Level.INFO, "End loading images");
	}
}
