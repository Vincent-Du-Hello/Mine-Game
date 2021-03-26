package com.duwenxi.game1;

import java.util.Random;

import com.duwenxi.log.Level;
import com.duwenxi.log.StaticLog;

public class Tool {
	public static void newBoard(GridType[] gameBoard) {
		int num = 0;
		for(int i = 0; i < 100; i++) {
			if(new Random().nextInt() % 10 == 0) {
				gameBoard[i] = GridType.BOOM;
				num++;
			}
			if(num == 10) {
				break;
			}
		}
		if(num != 10) {
			again(10 - num, gameBoard);
		}
	}
	
	private static void again(int need, GridType[] gameBoard) {
		int num = 0;
		for(int i = 0; i < 100; i++) {
			if(new Random().nextInt() % (int) 100 / need == 0 && gameBoard[i] != GridType.BOOM) {
				gameBoard[i] = GridType.BOOM;
				num++;
			}
			if(num == need) {
				break;
			}
		}
		if(num != need) {
			again(need - num, gameBoard);
		}
	}
	
	public static boolean isWin(GridType[] gameBoard, GridType[] types) {
		for(int i = 0; i < 100; i++) {
			if(!((types[i] != GridType.EMPTY || gameBoard[i] == GridType.BOOM) && !(gameBoard[i] == GridType.BOOM && types[i] == GridType.BOOM))) {
				return false;
			}
		}
		StaticLog.log(Level.LOG, "Win");
		return true;
	}
	
	public static void clickBoom(GridType[] gameBoard, GridType[] types) {
		for(int i = 0; i < 100; i++) {
			if(gameBoard[i] == GridType.BOOM) {
				types[i] = GridType.BOOM;
			}
		}
		StaticLog.log(Level.LOG, "Lose");
	}
}
