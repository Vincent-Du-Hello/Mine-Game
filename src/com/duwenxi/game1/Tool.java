package com.duwenxi.game1;

import java.awt.FileDialog;
import java.awt.Frame;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Random;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import javax.imageio.ImageIO;

import com.duwenxi.log.Level;
import com.duwenxi.log.StaticLog;

public class Tool {
	public static void newBoard(ArrayList<ArrayList<GridType>> gameBoard) {
		StaticLog.log(Level.INFO, "Generating new board");
		int num = 0;
		gameBoard.clear();
		for(int i = 0; i < Config.WIDTH; i++) {
			ArrayList<GridType> col = new ArrayList<GridType>();
			for(int j = 0; j < Config.HEIGHT; j++) {
				col.add(GridType.NOTHING);
			}
			gameBoard.add(col);
		}
		for(int i = 0; i < Config.WIDTH; i++) {
			for(int j = 0; j < Config.HEIGHT; j++) {
				if(new Random().nextInt() % Config.BOOMCOUNT == 0) {
					gameBoard.get(i).set(j, GridType.BOOM);
					num++;
				}
				if(num == Config.BOOMCOUNT) {
					break;
				}
			}
		}
		if(num != Config.BOOMCOUNT) {
			againNewBoard(Config.BOOMCOUNT - num, gameBoard);
		}
		StaticLog.log(Level.INFO, "Generated");
	}
	
	private static void againNewBoard(int need, ArrayList<ArrayList<GridType>> gameBoard) {
		int num = 0;
		for(int i = 0; i < Config.WIDTH; i++) {
			for(int j = 0; j < Config.HEIGHT; j++) {
				gameBoard.get(i).set(j, GridType.NOTHING);
			}
		}
		for(int i = 0; i < Config.WIDTH; i++) {
			for(int j = 0; j < Config.HEIGHT; j++) {
				if(new Random().nextInt() % Config.BOOMCOUNT == 0) {
					gameBoard.get(i).set(j, GridType.BOOM);
					num++;
				}
				if(num == Config.BOOMCOUNT) {
					break;
				}
			}
		}
		if(num != Config.BOOMCOUNT) {
			againNewBoard(Config.BOOMCOUNT - num, gameBoard);
		}
	}
	
	@SuppressWarnings("deprecation")
	public static boolean isWin(ArrayList<ArrayList<GridType>> gameBoard, ArrayList<ArrayList<GridType>> types) {
		for(int i = 0; i < Config.WIDTH; i++) {
			for(int j = 0; j < Config.HEIGHT; j++) {
				if(!((types.get(i).get(j) != GridType.EMPTY || gameBoard.get(i).get(j) == GridType.BOOM) && !(gameBoard.get(i).get(j) == GridType.BOOM && types.get(i).get(j) == GridType.BOOM))) {
					return false;
				}
			}
		}
		StaticLog.log(Level.INFO, "Win");
		Config.WINSND.play();
		return true;
	}
	
	@SuppressWarnings("deprecation")
	public static void clickBoom(ArrayList<ArrayList<GridType>> gameBoard, ArrayList<ArrayList<GridType>> types) {
		for(int i = 0; i < Config.WIDTH; i++) {
			for(int j = 0; j < Config.HEIGHT; j++) {
				if(gameBoard.get(i).get(j) == GridType.BOOM) {
					types.get(i).set(j, GridType.BOOM);
				}
			}
		}
		StaticLog.log(Level.INFO, "Lose");
		Config.BOOMSND.play();
	}
	
	public static void unZipFiles(File zipFile,String descDir) throws IOException {
        StaticLog.log(Level.INFO, "UNZIPING");
		File pathFile = new File(descDir);
		if(!pathFile.exists()) {
			pathFile.mkdirs();
		}
		ZipFile zip = new ZipFile(zipFile, Charset.forName("UTF-8"));
		for(Enumeration<? extends ZipEntry> entries = zip.entries(); entries.hasMoreElements();) {
	        ZipEntry entry = (ZipEntry)entries.nextElement();
	        String zipEntryName = entry.getName();
	        StaticLog.log(Level.INFO, "UNZIP ENTRY " + zipEntryName);
	        InputStream in = zip.getInputStream(entry);
	        String outPath = (descDir+zipEntryName);//.replaceAll("\\*", "/");
	        File file = new File(outPath.substring(0, outPath.lastIndexOf('/')));
	        if(!file.exists()) {
	          file.mkdirs();
	        }
	        if(new File(outPath).isDirectory()) {
		        StaticLog.log(Level.INFO, "UNZIP DICT " + outPath);
	            continue;
	        }
	        OutputStream out = new FileOutputStream(outPath);
	        byte[] buf1 = new byte[1024];
	        int len;
	        while((len=in.read(buf1))>0) {
	          out.write(buf1,0,len);
	        }
	        in.close();
	        out.close();
	        StaticLog.log(Level.INFO, "UNZIP " + outPath);
        }
        zip.close();
    }
	
	public static void changeTexture() {
		Frame f = new Frame();
		FileDialog fd = new FileDialog(f);
		fd.setVisible(true);
		try {
			unZipFiles(new File(fd.getDirectory() + fd.getFile()), "./config/");
		} catch (IOException e) {
			StaticLog.log(Level.ERROR, "Exception!");
			e.printStackTrace();
		}
		try {
			Config.EMPTYIMG = ImageIO.read(new File("./config/com/duwenxi/img/empty.png"));
			Config.CLICKEDIMG = ImageIO.read(new File("./config/com/duwenxi/img/clicked.png"));
			Config.MARKEDIMG = ImageIO.read(new File("./config/com/duwenxi/img/marked.png"));
			Config.NOTHINGIMG = ImageIO.read(new File("./config/com/duwenxi/img/nothing.png"));
			Config.N1IMG = ImageIO.read(new File("./config/com/duwenxi/img/n1.png"));
			Config.N2IMG = ImageIO.read(new File("./config/com/duwenxi/img/n2.png"));
			Config.N3IMG = ImageIO.read(new File("./config/com/duwenxi/img/n3.png"));
			Config.N4IMG = ImageIO.read(new File("./config/com/duwenxi/img/n4.png"));
			Config.N5IMG = ImageIO.read(new File("./config/com/duwenxi/img/n5.png"));
			Config.N6IMG = ImageIO.read(new File("./config/com/duwenxi/img/n6.png"));
			Config.N7IMG = ImageIO.read(new File("./config/com/duwenxi/img/n7.png"));
			Config.N8IMG = ImageIO.read(new File("./config/com/duwenxi/img/n8.png"));
			Config.BOOMIMG = ImageIO.read(new File("./config/com/duwenxi/img/boom.png"));
			Config.WINIMG = ImageIO.read(new File("./config/com/duwenxi/img/win.png"));
			Config.LOSEIMG = ImageIO.read(new File("./config/com/duwenxi/img/lose.png"));
		} catch (Exception e) {
			StaticLog.log(Level.ERROR, "Exception!");
			e.printStackTrace();
		}
	}
	
	public static void updateConfig() {
		Config.AROUND[0] = -Config.HEIGHT - 1;
		Config.AROUND[1] = -Config.HEIGHT;
		Config.AROUND[2] = -Config.HEIGHT + 1;
		Config.AROUND[3] = -1;
		Config.AROUND[4] = 1;
		Config.AROUND[5] = Config.HEIGHT - 1;
		Config.AROUND[6] = Config.HEIGHT;
		Config.AROUND[7] = Config.HEIGHT + 1;
	}
}
