package com.skillfactory.chess;

public class King extends ChessPiece {

	public King(String color) {
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
			if (((column - toColumn == 1) && (line - toLine == 1)) || // top left
				((column == toColumn) && (line - toLine == 1)) || // top mid 
				((toColumn - column == 1) && (line - toLine == 1)) || // top right
				((toColumn - column == 1) && (line == toLine)) || // right mid
				((toColumn - column == 1) && (toLine - line == 1)) || // right bottom
				((column == toColumn) && (toLine - line == 1)) || // bottom mid
				((column - toColumn == 1) && (toLine - line == 1)) || // bottom left
				((column - toColumn == 1) && (toLine == line))) { // left mid
				result = true;
			}
		}
		return result;
	}

	@Override
	public String getSymbol() {
		return "K";
	}
	
	public boolean checkPos(int x) {
		return (x >= 0 && x <= 7);
	}

}
