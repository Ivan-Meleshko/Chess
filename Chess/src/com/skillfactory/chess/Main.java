package com.skillfactory.chess;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ChessBoard myChessboard = new ChessBoard();
		myChessboard.board[0][0] = new Horse("Black");
		myChessboard.board[3][3] = new Horse("Black");
		myChessboard.board[1][1] = new Bishop("White");
		myChessboard.board[4][4] = new King("White");
		
		myChessboard.board[2][6] = new Horse("Black");
		myChessboard.canMoveToPosition(0, 0, 2, 1);
		myChessboard.canMoveToPosition(2, 1, 0, 0);
		myChessboard.canMoveToPosition(1, 1, 5, 5);
		
		
		//myChessboard.canMoveToPosition(4, 4, 5, 4);
		myChessboard.board[4][2] = new Rook("Black");
		
		
		myChessboard.printBoard2();
		
		
	}
	
	

}
