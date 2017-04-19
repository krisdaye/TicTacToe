package edu.jsu.mcis;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameBoard extends JFrame {
	
	private JButton[][] buttons;
	TicTacToe game = new TicTacToe();
	
	private JFrame board = new JFrame("TicTacToe");
	
	public GameBoard() {
		buttons = new JButton[3][3];
		createBoard();
	}//End Constructor
	
	private void createBoard(){
		board.setSize(300, 300);
		board.setLayout(new GridLayout(3, 3));
		board.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		for(int row = 0; row < 3; row++){
			for (int col = 0; col < 3; col++){
				buttons[row][col] = new JButton("");
				buttons[row][col].setName("Location" + row + col);
				buttons[row][col].addActionListener(new ButtonListener(row, col));
				board.add(buttons[row][col]);
			}
		}
		board.setVisible(true);
	}//End board creation

	private class ButtonListener implements ActionListener {
		private int row, col;
		
		public ButtonListener(int r, int c){
			row = r;
			col = c;
		}
	
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton temp;
			temp = (JButton) e.getSource();
			if(game.xTurn){
				temp.setText("X");
			}
			else{
				temp.setText("O");
			}
			buttonPress(row, col);
		}
	}//End ButtonListener

	public void buttonPress(int row, int col){
		JOptionPane optionPane = new JOptionPane();
		game.placeMark(row, col);
		
		if(game.checkForWin() == TicTacToe.Result.OWIN) {
			optionPane.showMessageDialog(optionPane, "O Wins!", "Game Over", JOptionPane.INFORMATION_MESSAGE);
		}
		else if(game.checkForWin() == TicTacToe.Result.XWIN) {
			optionPane.showMessageDialog(optionPane, "X Wins!", "Game Over", JOptionPane.INFORMATION_MESSAGE);
		}
		else if(game.checkForWin() == TicTacToe.Result.TIE) {
			optionPane.showMessageDialog(optionPane, "The Game Is A Draw.", "Game Over", JOptionPane.INFORMATION_MESSAGE);
		}
	}//End buttonPress
	
	
}//Class End GameBoard


