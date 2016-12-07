import java.util.Scanner;
public class TicTacToe{
	public static String[][] board;
	public static String p1Char;
	public static String p2Char;
	public static Scanner kb = new Scanner(System.in);
	
	/**
	 * This is the main method that the java interpreter calls
	 * @param args This is a command line argument
	 */
	public static void main(String[] args) {
		init();
		boolean b = true;
		while(!checkWinner(p1Char) && !checkWinner(p2Char) && !checkTie()){
			printBoard();
			playTurn(b);
			b = !b;
		}
		if(checkWinner(p1Char)){
			System.out.println("Player 1 wins.");
		}else if(checkWinner(p2Char)){
			System.out.println("Player 2 wins.");
		}else{
			System.out.println("It's a tie.");
		}
		printBoard();
	}
	
	public static boolean checkTie(){
		for(int r=0;r<board.length;r++){
			for(int c=0;c<board.length;c++){
				if(board[r][c]==""){
					return false;
				}
			}
		}
		return true;
	}
	
	/**
	 * This method initializes the variables of player symbols and board
	 * size with user input, populating the board with empty Strings.
	 */
	public static void init(){
		System.out.println("what do you want? (x or o)");
		p1Char = kb.next();
		if(p1Char.equals("x"))
			p2Char = "o";
		else
			p2Char = "x";
		System.out.println("how big should the board be? (int)");
		int i = kb.nextInt();
		board = new String[i][i];
		for(int x = 0; x < board.length; x++){
			for(int y = 0; y < board[0].length; y++){
				board[x][y] =  "";
			}
		}
	}
	
	/**
	 * This method plays a turn by placing the player's character in the
	 * specified square in the grid.
	 * @param t true if it is P1's turn, false for P2's turn
	 */
	public static void playTurn(boolean t){
		int input = kb.nextInt();
		while(board[input/board.length][input%board.length]!=""){
			input = kb.nextInt();
		}
		String p = "";
		if(t){
			p = p1Char;
		}else{
			p = p2Char;
		}
		board[input/board.length][input%board.length] = p;
	}
	
	/**
	 * This method prints out the board on the screen.
	 *
	 */

	public static void printBoard(){
		for(int x = 0; x < board.length * 5 - 2; x++)
			System.out.print("-");
		System.out.print("\n");
		for(String[] row:board){
			System.out.print("|");
			for(String col:row){
				if(col.equals(""))
					System.out.print("   |");
				else
					System.out.print(" " + col + " |");
			}
			System.out.print("\n");
			for(int x = 0; x < board.length * 5 - 2; x++)
				System.out.print("-");
			System.out.println();
		}
	}
	
	
	/**
	 * This method returns whether or not the player has won by checking all
	 * rows, columns, and diagonals for a full row of the player's symbol.
	 * @param piece The player who is being checked for
	 * @return whether or not the game has ended
	 */
	public static boolean checkWinner(String piece){
		int t = 0; //this will be used to count occurrences in row/col/diagonal
		for(int r=0;r<board.length;r++){
			for(int c=0;c<board.length;c++){
				if(board[r][c]==piece){
					t++;
				}else{
					t=0;
					c=board.length;
				}
			}
			if(t==board.length){
				return true;
			}
		}
		for(int c=0;c<board.length;c++){
			for(int r=0;r<board.length;r++){
				if(board[r][c]==piece){
					t++;
				}else{
					t=0;
					r=board.length;
				}
			}
			if(t==board.length){
				return true;
			}
		}
		for(int i=0;i<board.length;i++){
			if(board[i][i]==piece){
				t++;
			}else{
				t=0;
				i=board.length;
			}
		}
		if(t==board.length){
			return true;
		}
		for(int i=0;i<board.length;i++){
			if(board[board.length-1-i][i]==piece){
				t++;
			}else{
				return false;
			}
		}
		if(t==board.length){
			return true;
		}
		return false;
	}
}