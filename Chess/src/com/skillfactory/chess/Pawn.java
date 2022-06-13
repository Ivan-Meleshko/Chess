package com.skillfactory.chess;

public class Pawn extends ChessPiece {

	public Pawn(String color) {
		super(color);
	}

	@Override
	public String getColor() {
		return color;
	}

	@Override
	public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
		
		if (checkPos(line) && checkPos(column) && checkPos(toLine) && checkPos(toColumn) && chessBoard.board[line][column] != null) {
			
			int dirCoef;
			int startPos;
		}
			return false;
	
		
	}

	@Override
	public String getSymbol() {
		// TODO Auto-generated method stub
		return "P";
	}

	public boolean checkPos(int x) {
		return (x >= 0 && x <= 7);
	}

}
