package chess.Pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Bishop extends ChessPiece {

	public Bishop(Board board, Color color) {
		super(board, color);

	}

	@Override

	public String toString() {
		return "B";
	}

	@Override
	public boolean[][] possibleMoves() {

		ChessMoves b = new ChessMoves(getBoard(), getColor(), position);
		boolean[][] matb = b.bishopMoves();
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

		for (int i = 0; i < getBoard().getRows(); i++) {
			for (int j = 0; j < getBoard().getColumns(); j++) {
				if (matb[i][j]) {
					mat[i][j] = true;
				}
			}

		}

		return mat;

	}
}
