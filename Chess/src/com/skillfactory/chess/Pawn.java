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
	        if (checkPos(line) && checkPos(column) && checkPos(toLine) && checkPos(toColumn) && chessBoard.board[line][column] != null) { // check that position in board
	            if (column == toColumn) { 
	                int dir;
	                int start;

	                if (color.equals("White")) {  
	                    dir = 1;
	                    start = 1;
	                } else { 
	                    dir = -1;
	                    start = 6;
	                }

	                if (line + dir == toLine) {  
	                    return chessBoard.board[toLine][toColumn] == null;
	                }

	                if (line == start && line + 2 * dir == toLine) {
	                    return chessBoard.board[toLine][toColumn] == null && chessBoard.board[line + dir][column] == null; // check that positions is null
	                }

	            } else { // want to eat piece

	                if ((column - toColumn == 1 || column - toColumn == -1) && (line - toLine == 1 || line - toLine == -1) && // check that piece another color
	                        chessBoard.board[toLine][toColumn] != null) {
	                    return !chessBoard.board[toLine][toColumn].getColor().equals(color);
	                } else return false;
	            }
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
