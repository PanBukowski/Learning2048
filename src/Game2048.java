import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;

public class Game2048 {
	static int[][] board;
	static boolean still_in_game = true;
	
	public static void main(String[] args) throws IOException {	
		initialize();
		while(still_in_game) {
			//Add random tile to the game 2 or 4.
			addRandomTile();
			print();
			//Select your move via console
			move();
			still_in_game=false;
			check();
		}
		System.out.println("Game Over.");
		//System.out.println("Your score is: ");
	}
	
	private static void initialize() {
		board = new int[4][4];
	}

	private static void move() throws IOException {
		String move = null;
		while(true) {
			//Wraping InputStreamReader with BufferedReader
			BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Select your move W/A/S/D:");
			move = input.readLine();
			if(move.equals("W") || move.equals("w")) {
				moveUP();
				break;
			}
			if(move.equals("A") || move.equals("a")) {
				moveLEFT();
				break;
			}
			if(move.equals("S") || move.equals("s")) {
				moveDOWN();
				break;
			}
			if(move.equals("D") || move.equals("d")) {
				moveRIGHT();
				break;
			}
			else {
				System.out.println("Invalid move");
			}
		}
	}

	private static void moveRIGHT() {
		//sorting board in right direction
		int[] line = new int[4];
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board.length;j++) {
				line[line.length-j-1]=board[i][j];
			}
			line = sort(line);
			for(int j=0;j<board.length;j++) {
				board[i][j]=line[line.length-j-1];
			}
		}
	}

	private static void moveDOWN() {
		//sorting board in dwon direction
		int[] line = new int[4];
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board.length;j++) {
				line[line.length-j-1]=board[j][i];
			}
			line = sort(line);
			for(int j=0;j<board.length;j++) {
				board[j][i]=line[line.length-j-1];
			}
		}
	}

	private static void moveLEFT() {
		//sorting board in left direction
		int[] line = new int[4];
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board.length;j++) {
				line[j]=board[i][j];
			}
			line = sort(line);
			for(int j=0;j<board.length;j++) {
				board[i][j]=line[j];
			}
		}
	}

	private static void moveUP() {
		//sorting board in up direction
		int[] line = new int[4];
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board.length;j++) {
				line[j]=board[j][i];
			}
			line = sort(line);
			for(int j=0;j<board.length;j++) {
				board[j][i]=line[j];
			}
		}
	}
	
	private static int[] sort(int[] line) {
		int[] before = new int[4];
		int[] after = line;
		do {
			for(int i=0;i<after.length;i++) {
				before[i]=after[i];
			}
			for(int i=1;i<after.length;i++) {
				if(before[i-1]==0 && before[i]!=0) {
					after[i-1]=after[i];
					after[i]=0;
				}
				if(before[i-1]==before[i] && before[i]!=0) {
					after[i-1]++;
					after[i]=0;
				}
			}
		}while(!Arrays.equals(after, before));
		return after;
	}

	private static void addRandomTile() {
		//Generate random value then replace random 0 on board with that
		Random rand = new Random();
		int x,y,val;
		val=rand.nextInt(2)+1;
		do{
			x=rand.nextInt(4);
			y=rand.nextInt(4);
		}
		while(board[x][y]!=0);
		board[x][y]=val;
	}

	private static void check() {
		//Check for available place to set next tile
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[i].length;j++) {
				if(board[i][j]==0) {
					still_in_game=true;
				}
			}
		}
	}
	
	private static void print() {
		String line = "";
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[i].length;j++) {
				if(board[i][j]==0) {
					line = line + board[i][j] + "\t";
				}else {
					line = line + (int) Math.pow(2, board[i][j]) + "\t";
				}
			}
			line = line + "\n";
		}
		System.out.println(line);
	}
}
