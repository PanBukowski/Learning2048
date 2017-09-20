import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

	private static int[][] move(int[][] board) {
		int wheremove = selectmove();
		int[] array1 = new int[4];
		int[] array2 = new int[4];
		int[] array3 = new int[4];
		int[] array4 = new int[4];
		switch(wheremove) {
		case 1:
			for(int k=0;k<array1.length;k++) {
				array1[k]=board[k][0];
				array2[k]=board[k][1];
				array3[k]=board[k][2];
				array4[k]=board[k][3];
			}
			turning(array1);
			turning(array2);
			turning(array3);
			turning(array4);
		case 2:
		case 3:
		case 4:
		}
		return board;
	}

	private static int selectmove() {
		String move = null;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	    while(true) {
	    	System.out.println("Select move W/A/S/D:");
	    	try {
	    		move = reader.readLine();
	    		if(move.equals("w") || move.equals("W")) {
	    			return 1;
	    		}
	    		if(move.equals("a") || move.equals("A")) {
	    			return 2;
	    		}
	    		if(move.equals("s") || move.equals("S")) {
	    			return 3;
	    		}
	    		if(move.equals("d") || move.equals("D")) {
	    			return 4;
	    		}else {
	    			System.out.println("Move is invalid.");
	    		}
	    	} catch (IOException e) {
	    		e.printStackTrace();
	    	}
	    }
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
