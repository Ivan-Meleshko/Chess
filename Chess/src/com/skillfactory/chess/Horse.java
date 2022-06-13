package com.skillfactory.chess;

public class Horse extends ChessPiece {

	public Horse(String color) {
		super(color);
	}

	@Override
	public String getColor() {
		return color;
	}

	@Override
	public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
		boolean result = false;
		if (chessBoard.checkPos(toLine) && chessBoard.checkPos(toColumn)) { // destination check
			if (chessBoard.board[line][column].equals(this)) { // make sure the figure is right
				if ((line != toLine) && (column != toColumn)) {
					if ((((line - toLine == 1) && (column - toColumn == 2)) || // horse left bottom
							((line - toLine == 1) && (column - toColumn == 2)) || // h left top
							((toLine - line == 2) && (column - toColumn == 1)) || // h top left
							((toLine - line == 2) && (toColumn - column == 1)) || // h top right
							((toLine - line == 1) && (toColumn - column == 2)) || // h right top
							((line - toLine == 1) && (toColumn - column == 2)) || // h right bottom
							((line - toLine == 2) && (toColumn - column == 1)) || // h bottom right
							((line - toLine == 2) && (column - toColumn == 1)))) // h bottom left
					{
						result = true;
					}
					result = true;
				}
				result = true;
			}
			result = true;
		}
		return result;

	}

	@Override
	public String getSymbol() {
		return "H";
	}

}
