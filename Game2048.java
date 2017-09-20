package main;

import java.util.Random;

public class Game2048 {

	public static void main(String[] args) {
		int[][] board;
		board = innitialize();
		while(true) {
			play(board);
		}
	}

	private static void play(int[][] board) {
		if(isplace(board)) {
			board=addtile(board);
			move(board);
		}
	}

	private static void move(int[][] board) {
		int wheremove = selectmove();
		switch(wheremove) {
		case 1:
		case 2:
		case 3:
		case 4:
		}
		return board;
	}

	private static int[][] addtile(int[][] board) {
		Random generator = new Random();
		int x,y,value;
		value=generator.nextInt(2)+1;
		do {
			x=generator.nextInt(4);
			y=generator.nextInt(4);
		}while(board[x][y]!=0);
		board[x][y]=value;
		return board;
	}

	private static boolean isplace(int[][] board) {
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[i].length;j++) {
				if(board[i][j]==0) return true;
			}
		}
		return false;
	}

	private static int[][] innitialize() {
		int[][] board = new int[4][4];
		return board;
	}
}
