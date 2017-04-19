package edu.jsu.mcis;

import java.util.*;

public class TicTacToe {
	
	public enum Mark { EMPTY, X, O};
	public enum Result { PLAY, XWIN, OWIN, TIE };
	private Mark[][] mark;
	public boolean xTurn = true;
	private boolean valid = true;
	int row, col;
	
	Result state = Result.PLAY;
	
	public static Scanner input = new Scanner(System.in);
	
	/*
	 *
	 *
	 */
	public TicTacToe() {
		mark = new Mark[3][3];
		for (int i = 0; i < 3; i++){
			for (int j = 0; j < 3; j++) {
				mark[i][j] = Mark.EMPTY;
			}
		}
		xTurn = true;
	}//End Constructor
	
	/*
	 *
	 *
	 *
	 */
	public Mark getMark (int row, int col) {
		if(mark[row][col] != Mark.O || mark[row][col] != Mark.X){
			return Mark.EMPTY;
		}
		else if (mark[row][col].equals(Mark.X)){
			return Mark.X;
		}
		else if (mark[row][col].equals(Mark.O)){
			return Mark.O;
		}
		return mark[row][col];
	}//End getMark
	
	/*
	 *
	 *
	 */
	public void placeMark(int row, int col){
		if(mark[row][col].equals(Mark.EMPTY)){
			if (xTurn){
				mark[row][col] = Mark.X;
				xTurn = !xTurn;
			}
			else {
				mark[row][col] = Mark.O;
				xTurn = !xTurn;
			}
		}
		else {
			System.out.println("Location: " + row + "," + col + " has already been used. Please select another location.");
		}
	}//End placeMark
	
	/*
	 *
	 *
	 */
	public boolean checkInputs(int row, int col){
		if (row >= 3 || row < 0) {
			System.out.println("The size of the row entered is invalid. Please enter either 1, 2, or 3.");
			valid = false;
		}
		else if (col >= 3 || col < 0) {
			System.out.println("The size of the column entered is invalid. Please enter either 1, 2, or 3.");
			valid = false;
		}
		return valid;
	}//End checkImports
	
	/*
	 *
	 *
	 */
	public Result checkForWin(){
		
		if (mark[0][0] == mark[1][0] && mark[1][0] == mark[2][0] && (mark[0][0].equals(Mark.X) || mark[0][0].equals(Mark.O))) {
            if (mark[0][0].equals(Mark.X)){
				state = Result.XWIN;
			}
			if (mark[0][0].equals(Mark.O)){
				state = Result.OWIN;
			}
        } 
		else if (mark[0][1] == mark[1][1] && mark[1][1] == mark[2][1] && (mark[0][1].equals(Mark.X) || mark[0][1].equals(Mark.O))) {
            if (mark[0][1].equals(Mark.X)){
				state = Result.XWIN;
			}
			if (mark[0][1].equals(Mark.O)){
				state = Result.OWIN;
			}
        } 
		else if (mark[0][2] == mark[1][2] && mark[1][2] == mark[2][2] && (mark[0][2].equals(Mark.X) || mark[0][2].equals(Mark.O))) {
            if (mark[0][2].equals(Mark.X)){
				state = Result.XWIN;
			}
			if (mark[0][2].equals(Mark.O)){
				state = Result.OWIN;
			}
        } 
		else if (mark[0][0] == mark[0][1] && mark[0][1] == mark[0][2] && (mark[0][0].equals(Mark.X) || mark[0][0].equals(Mark.O))) {
            if (mark[0][0].equals(Mark.X)){
				state = Result.XWIN;
			}
			if (mark[0][0].equals(Mark.O)){
				state = Result.OWIN;
			}
        } 
		else if (mark[1][0] == mark[1][1] && mark[1][1] == mark[1][2] && (mark[1][0].equals(Mark.X) || mark[1][0].equals(Mark.O))) {
            if (mark[1][0].equals(Mark.X)){
				state = Result.XWIN;
			}
			if (mark[1][0].equals(Mark.O)){
				state = Result.OWIN;
			}
        } 
		else if (mark[2][0] == mark[2][1] && mark[2][1] == mark[2][2] && (mark[2][0].equals(Mark.X) || mark[2][0].equals(Mark.O))) {
            if (mark[2][0].equals(Mark.X)){
				state = Result.XWIN;
			}
			if (mark[2][0].equals(Mark.O)){
				state = Result.OWIN;
			}
        } 
		else if (mark[0][0] == mark[1][1] && mark[1][1] == mark[2][2] && (mark[0][0].equals(Mark.X) || mark[0][0].equals(Mark.O))) {
            if (mark[0][0].equals(Mark.X)){
				state = Result.XWIN;
			}
			if (mark[0][0].equals(Mark.O)){
				state = Result.OWIN;
			}
        } 
		else if (mark[2][0] == mark[1][1] && mark[1][1] == mark[0][2] && (mark[2][0].equals(Mark.X) || mark[2][0].equals(Mark.O))) {
            if (mark[2][0].equals(Mark.X)){
				state = Result.XWIN;
			}
			if (mark[2][0].equals(Mark.O)){
				state = Result.OWIN;
			}
        } 
		else {
            state = Result.PLAY;
        }
		return state;
	}//End checkForWin
}//End TicTacToe

