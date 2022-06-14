package com.skillfactory.chess;

public class Rook extends ChessPiece {

	public Rook(String color) {
		super(color);
	}

	@Override
	public String getColor() {
		return color;
	}

	@Override
	public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
		boolean result = false;
		if (checkPos(line) && checkPos(column) && checkPos(toLine) && checkPos(toColumn) && 
				chessBoard.board[line][column] != null) {
			for (int i = 1; i < 8; i++) {
				if (((line == toLine) && (toColumn == column - i)) ||  // left
				 ((toLine == line - i) && (column == toColumn)) ||  // top
				 ((line == toLine) && (toColumn == column + i)) ||  // right
				 ((toLine == line + i) && (toColumn == column))) {  // right
					result = true;
				}
			}
			
		}
		return result;
	}

	@Override
	public String getSymbol() {
		return "R";
	}
	
	public boolean checkPos(int x) {
		return (x >= 0 && x <= 7);
	}

}
