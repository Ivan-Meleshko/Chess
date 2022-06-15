package com.skillfactory.chess;

import java.util.Arrays;

public class ChessBoard {

	ChessPiece[][] board = new ChessPiece[8][8];

	protected String nowPlayer;

	public ChessBoard(String nowPlayer) {
        this.nowPlayer = nowPlayer;
    }

	public String nowPlayerColor() {
		return this.nowPlayer;
	}


	public void printBoard() {
		int counterVert = 0;
		

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
		for (int j = 0; j <8; j++) {
			System.out.print(j + "  ");
		}

		System.out.println();
		System.out.println("Whites");
	}

	public boolean checkPos(int pos) {
		return (pos >= 0 && pos <= 7);
	}

	public boolean moveToPosition(int startLine, int startColumn, int toLine, int toColumn) { // !!!
		if ((checkPos(startLine) && checkPos(startColumn))) {
			if (this.board[startLine][startColumn].canMoveToPosition(this, startLine, startColumn, toLine, toColumn)) {
				if ((board[startLine][startColumn].getClass().equals(King.class))
						|| (board[startLine][startColumn].getClass().equals(Rook.class))) {
					board[startLine][startColumn].check = false;
				}
				board[toLine][toColumn] = board[startLine][startColumn]; // piece moving
				board[startLine][startColumn] = null;

				this.nowPlayer = nowPlayerColor().equals("White") ? "Black" : "White"; // player changing
			}
			return true;
		} else
			return false;
	}

	public boolean castling0() {
		if (nowPlayer.equals("White")) {
			if (board[0][0] == null || board[0][4] == null) {
				return false;
			}
			if (board[0][0].getSymbol().equals("R") && board[0][4].getSymbol().equals("K")
					&& (board[0][1] == null && board[0][2] == null && board[0][3] == null)) {
				if ((board[0][0].getColor().equals("White") && board[0][4].getColor().equals("White"))
						&& (board[0][0].check && board[0][4].check) && !new King("White").isUnderAttack(this, 0, 2)) {
					board[0][4] = null;
					board[0][2] = new King("White");
					board[0][2].check = false;
					board[0][0] = null;
					board[0][3] = new Rook("White");
					board[0][3].check = false;
					nowPlayer = "Black";
					return true;
				} else
					return false;
			} else
				return false;
		} else {
			if (board[7][0] == null || board[7][4] == null) {
				return false;
			}
			if (board[7][0].getSymbol().equals("R") && board[7][4].getSymbol().equals("K")
					&& (board[7][1] == null && board[7][2] == null && board[7][3] == null)) {
				if ((board[0][0].getColor().equals("Black") && board[0][4].getColor().equals("Black"))
						&& (board[7][0].check && board[7][4].check) && !new King("Black").isUnderAttack(this, 7, 2)) {
					board[7][4] = null;
					board[7][2] = new King("Black");
					board[7][2].check = false;
					board[7][0] = null;
					board[7][3] = new Rook("Black");
					board[7][3].check = false;
					nowPlayer = "White";
					return true;
				} else
					return false;

			} else
				return false;
		}
	}

	public boolean castling7() {
		if (nowPlayer.equals("White")) {
			if (board[0][7] == null || board[0][4] == null) {
				return false;
			}
			if (board[0][7].getSymbol().equals("R") && board[0][4].getSymbol().equals("K")
					&& (board[0][5] == null && board[0][6] == null)) {
				if ((board[0][7].getColor().equals("White") && board[0][4].getColor().equals("White"))
						&& (board[0][7].check && board[0][4].check) && !new King("White").isUnderAttack(this, 0, 6)) {
					board[0][4] = null;
					board[0][6] = new King("White");
					board[0][6].check = false;
					board[0][7] = null;
					board[0][5] = new Rook("White");
					board[0][5].check = false;
					nowPlayer = "Black";
					return true;
				} else
					return false;
			} else
				return false;
		} else {
			if (board[7][7] == null || board[7][4] == null) {
				return false;
			}
			if (board[7][7].getSymbol().equals("R") && board[7][4].getSymbol().equals("K")
					&& (board[7][5] == null && board[7][6] == null)) {
				if ((board[7][7].getColor().equals("Black") && board[7][4].getColor().equals("Black"))
						&& (board[7][7].check && board[7][4].check) && !new King("Black").isUnderAttack(this, 7, 6)) {
					board[7][4] = null;
					board[7][6] = new King("Black");
					board[7][6].check = false;
					board[7][7] = null;
					board[7][5] = new Rook("Black");
					board[7][5].check = false;
					nowPlayer = "White";
					return true;
				} else
					return false;
			} else
				return false;
		}
	}

}