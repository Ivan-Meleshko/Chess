package com.skillfactory.chess;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ChessBoard myChessboard = new ChessBoard();
		myChessboard.board[0][0] = new Horse("Black");
		myChessboard.board[3][3] = new Horse("Black");
		
		myChessboard.board[2][6] = new Horse("Black");
		myChessboard.canMoveToPosition(0, 0, 2, 1);
		myChessboard.canMoveToPosition(2, 1, 0, 0);
		myChessboard.printBoard2();
		
	}
	
	

}
