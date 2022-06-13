package com.skillfactory.chess;

import java.util.Arrays;

public class ChessBoard {

	ChessPiece[][] board = new ChessPiece[8][8];

	protected String nowPlayer = "White";

	public ChessBoard() {

	}

	public String nowPlayerColor() {
		return this.nowPlayer;
	}

	public void printBoard() {
		// System.out.println(Arrays.toString(board));
		for (int i = 0; i < 8; i++) {
			// System.out.println(board[i]);
			for (int j = 0; j < 8; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

	public void printBoard2() {
		int counterVert = 1;
		int counterHor = 1;
		
		System.out.println("Blacks");

		for (int i = 0; i < 8; i++) {
			System.out.print(counterVert + "   ");
			counterVert++;
			for (int j = 0; j < 8; j++) {
				if (board[i][j] == null) {
					System.out.print(" - ");
				} else {
					System.out.print(
							board[i][j].getSymbol() + board[i][j].getColor().substring(0, 1).toLowerCase() + " ");
				}
			}
			System.out.println();
		}

		System.out.print("     ");
		for (int j = 1; j < 9; j++) {
			System.out.print(j + "  ");
		}
		
		System.out.println();
		System.out.println("Whites");
	}

	public boolean checkPos(int pos) {
		return (pos >= 0 && pos <= 7);
	}
	
	public boolean canMoveToPosition(int startLine, int startColumn, int toLine, int toColumn) { // !!!
		if ((checkPos(startLine) && checkPos(startColumn))) {
			if (this.board[startLine][startColumn].canMoveToPosition(this, startLine, startColumn, toLine, toColumn)) {
				board[toLine][toColumn] = board[startLine][startColumn]; // piece moving
				board[startLine][startColumn] = null;
				this.nowPlayer = nowPlayerColor().equals("White") ? "Black" : "White"; // player changing
			}
			return true;
		} else return false;
	}

}
