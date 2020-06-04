package chess.Pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece {

	public Pawn(Board board, Color color) {
		super(board, color);
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		Position p1 = new Position(0, 0);
		Position p2 = new Position(0, 0);
		Position p3 = new Position(0, 0);
		Position p4 = new Position(0, 0);

		if (getColor() == Color.WHITE) {
			p1.setValues(position.getRow() - 1, position.getColumn()); // 1 pos forward
			p2.setValues(position.getRow() - 2, position.getColumn()); // 2 pos forward
			p3.setValues(position.getRow() - 1, position.getColumn() - 1); // capture left diagonal
			p4.setValues(position.getRow() - 1, position.getColumn() + 1);
		} // capture right diagonal
		else {
			if (getColor() == Color.BLACK) {
				p1.setValues(position.getRow() + 1, position.getColumn()); // 1 pos forward
				p2.setValues(position.getRow() + 2, position.getColumn()); // 2 pos forward
				p3.setValues(position.getRow() + 1, position.getColumn() - 1); // capture left diagonal
				p4.setValues(position.getRow() + 1, position.getColumn() + 1); // capture right diagonal }
			}
		}

		// Test 1 position forward
		if (getBoard().positionExists(p1) && !getBoard().thereIsAPiece(p1)) {
			mat[p1.getRow()][p1.getColumn()] = true;
		}
		// Test 2 position2 forward if first move
		if (getMoveCount() == 0 && getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2)
				&& mat[p1.getRow()][p1.getColumn()]) {
			mat[p2.getRow()][p2.getColumn()] = true;
		}
		// Test 1 position left diagonal
		if (getBoard().positionExists(p3) && isThereOpponentPiece(p3)) {
			mat[p3.getRow()][p3.getColumn()] = true;
		}
		// Test 1 position right diagonal
		if (getBoard().positionExists(p4) && isThereOpponentPiece(p4)) {
			mat[p4.getRow()][p4.getColumn()] = true;
		}
		return mat;
	}

	@Override
	public String toString() {
		return "p";
	}
}
