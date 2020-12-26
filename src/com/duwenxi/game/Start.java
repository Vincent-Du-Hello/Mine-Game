package com.duwenxi.game1;

import java.util.Random;

public class Start {
	public Start(int[] gameBoard) {
		int num = 0;
		for(int i = 0; i < 100; i++) {
			if(new Random().nextInt() % 10 == 0) {
				gameBoard[i] = Config.BOOM;
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
	
	private void again(int need, int[] gameBoard) {
		int num = 0;
		for(int i = 0; i < 100; i++) {
			if(new Random().nextInt() % (int) 100 / need == 0 && gameBoard[i] != Config.BOOM) {
				gameBoard[i] = Config.BOOM;
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
}
